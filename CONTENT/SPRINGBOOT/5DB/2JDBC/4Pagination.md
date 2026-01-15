![image.png](/images/image-230.png)

```
Statement stmt = conn.createStatement();

// 1. Set the limit BEFORE executing the query
stmt.setMaxRows(5); 

// 2. Execute the query
ResultSet rs = stmt.executeQuery("SELECT * FROM users");

// 3. Iterate
// Even if "users" has 1000 rows, this loop runs only 5 times.
while (rs.next()) {
    System.out.println(rs.getString("name"));
}
```

![image.png](/images/image-231.png)

0: This is the default. It means Unlimited. The driver will fetch every single row that matches your query.

When should you use it?

You typically use setMaxRows as a protective measure. For example, if you are building a search bar for users, you might setMaxRows(500) just in case a user searches for "a" and accidentally matches 1,000,000 records, which would otherwise crash your Java application with an OutOfMemoryError.

> Why not use LIMIT every time

![image.png](/images/image-232.png)

![image.png](/images/image-233.png)

![image.png](/images/image-234.png)

![image.png](/images/image-229.png)

It will automatically behave like a buffered reader, when the limit reach, a separate network call will be made in which more data will be read

```
Statement stmt = connection.createStatement();
stmt.setMaxRows(100); // Limit ResultSet to 100 rows
ResultSet rs = stmt.executeQuery("SELECT * FROM users");
```

```
int maxRows = stmt.getMaxRows(); // Returns 100
```

![image.png](/images/image-235.png)

# Critical Rule for PostgreSQL Users

This is the most common mistake with setFetchSize in Postgres. It will simply be ignored unless you also turn off AutoCommit.

Postgres requires a transaction to keep the "cursor" open for streaming.

```
Connection conn = DriverManager.getConnection("jdbc:postgresql://...");

// 1. CRITICAL: You MUST disable auto-commit for Postgres streaming to work
conn.setAutoCommit(false); 

Statement stmt = conn.createStatement();

// 2. Set the chunk size (e.g., 50 or 100 is usually a sweet spot)
stmt.setFetchSize(50); 

// 3. Execute
ResultSet rs = stmt.executeQuery("SELECT * FROM heavy_table");

// 4. Iterate
while (rs.next()) {
    // Under the hood: 
    // - The driver has 50 rows in memory.
    // - When you reach row 51, the driver silently pauses and fetches rows 51-100 from the server.
    processRow(rs);
}

stmt.close();
conn.close();
```

![image.png](/images/image-236.png)

![image.png](/images/image-237.png)

