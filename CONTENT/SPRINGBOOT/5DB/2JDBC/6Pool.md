1. creating a new connection is like creating a new thread every time

```

        Connection conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/one_database", "tarunmac", "password");
//        However, manually using DriverManager.getConnection(...) is bad practice in Spring Boot for two reasons:
//
//        No Connection Pooling: DriverManager opens a new physical connection every single time the method is called, which is very slow. Spring Boot comes with HikariCP (a high-performance connection pool) by default.
```

TODO: Secure them in a file



```
package com.example.one;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class ConnectDB {
    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.password}")
    private String dbPassword;

    void customConnect() throws SQLException {
        Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

//        However, manually using DriverManager.getConnection(...) is bad practice in Spring Boot for two reasons:
//
//        No Connection Pooling: DriverManager opens a new physical connection every single time the method is called, which is very slow. Spring Boot comes with HikariCP (a high-performance connection pool) by default.

        conn.setAutoCommit(false);


        Statement stmt=conn.createStatement();
        String sql="CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name VARCHAR(100), email VARCHAR(100))";
        stmt.executeUpdate(sql);

//        String sqlInsert="INSERT INTO users (name, email) VALUES \n" +
//                "('Tarun Mac', 'tarun@example.com'),\n" +
//                "('Jane Doe', 'jane@test.io'),\n" +
//                "('John Smith', 'john.smith@gmail.com');";
//        stmt.executeUpdate(sqlInsert);

        Statement stmtUpdate = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE  // <--- This enables rs.updateRow()
        );
        ResultSet rs=stmtUpdate.executeQuery("SELECT * FROM users");
        while(rs.next()){
            if(rs.getString("name").equals("Tarun Mac")){
                rs.updateInt("id", 100+rs.getInt("id"));
                rs.updateRow();
            }
        }

        conn.commit();

        stmt.close();
        stmtUpdate.close();
        conn.close();
    }
}

```

```
spring.application.name=one


# JDBC configuration
db.url=jdbc:postgresql://localhost:5432/one_database
db.username=tarunmac
db.password=password
```



