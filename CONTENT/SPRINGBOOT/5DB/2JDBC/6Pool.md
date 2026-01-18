1. creating a new connection object is like creating a new thread every time

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



# Creating a connection pool

by default JDBC doesnt offer you a connection pool

but Tomcat JDBC does

```
<dependency>
    <groupId>org.apache.tomcat</groupId>
    <artifactId>tomcat-jdbc</artifactId>
    <version>10.1.0</version>
</dependency> 
```

![image.png](/images/image-293.png)

```
package com.example.one;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
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

    @Value("${db.driver}")
    private String dbDriver;


    public void pool ()throws SQLException{
        PoolProperties p = new PoolProperties();

        p.setUrl(dbUrl);
        p.setDriverClassName(dbDriver);
        p.setUsername(dbUsername);
        p.setPassword(dbPassword);

        //Boilerplate code/
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false); 
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
                "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        //Boilerplate code/


        //Actual Code
        p.setInitialSize(10);
        //size of connection pool when started 
        //Actual Code


        //You can assume the DataSource as your pool
        DataSource dataSource = new DataSource();
        dataSource.setPoolProperties(p);
        Connection conn = null;
        long s = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            try {
                // a different way to create conn from the pool, once the conn is created then normal functions
                conn = dataSource.getConnection();
                Statement stm = conn.createStatement();
//                ResultSet rs = stm.executeQuery("SELECT * FROM pulse_records;");
//                rs.close();
                stm.close();
            } finally {
                if (conn != null)
                    conn.close();
            }
        }
        long e = System.currentTimeMillis();
        System.out.println((e-s));
    }



    void customConnect() throws SQLException {
//        Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        pool();

//        However, manually using DriverManager.getConnection(...) is bad practice in Spring Boot for two reasons:
//
//        No Connection Pooling: DriverManager opens a new physical connection every single time the method is called, which is very slow. Spring Boot comes with HikariCP (a high-performance connection pool) by default.

//        conn.setAutoCommit(false);


//        Statement stmt=conn.createStatement();
//        String sql="CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name VARCHAR(100), email VARCHAR(100))";
//        stmt.executeUpdate(sql);

//        String sqlInsert="INSERT INTO users (name, email) VALUES \n" +
//                "('Tarun Mac', 'tarun@example.com'),\n" +
//                "('Jane Doe', 'jane@test.io'),\n" +
//                "('John Smith', 'john.smith@gmail.com');";
//        stmt.executeUpdate(sqlInsert);

//        Statement stmtUpdate = conn.createStatement(
//                ResultSet.TYPE_SCROLL_INSENSITIVE,
//                ResultSet.CONCUR_UPDATABLE  // <--- This enables rs.updateRow()
//        );
//        ResultSet rs=stmtUpdate.executeQuery("SELECT * FROM users");
//        while(rs.next()){
//            if(rs.getString("name").equals("Tarun Mac")){
//                rs.updateInt("id", 100+rs.getInt("id"));
//                rs.updateRow();
//            }
//        }
//
//        conn.commit();
//
//        stmt.close();
//        stmtUpdate.close();
//        conn.close();
    }
}

```

```
# JDBC configuration
db.url=jdbc:postgresql://localhost:5432/one_database
db.username=tarunmac
db.password=password
db.driver=org.postgresql.Driver
```

```
package com.example.one;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
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

    @Value("${db.driver}")
    private String dbDriver;


    public void pool ()throws SQLException{
        PoolProperties p = new PoolProperties();

        p.setUrl(dbUrl);
        p.setDriverClassName(dbDriver);
        p.setUsername(dbUsername);
        p.setPassword(dbPassword);

        //Boilerplate code/
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
                "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        //Boilerplate code/

        //Actual Code
        p.setInitialSize(10);
        //size of connection pool when started
        //Actual Code

        //You can assume the DataSource as your pool
        DataSource dataSource = new DataSource();
        dataSource.setPoolProperties(p);
        Connection conn = null;
        long s = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            try {
                // a different way to create conn from the pool, once the conn is created then normal functions
                conn = dataSource.getConnection();
                Statement stm = conn.createStatement();
//                ResultSet rs = stm.executeQuery("SELECT * FROM pulse_records;");
//                rs.close();
                stm.close();
            } finally {
                if (conn != null)
                    conn.close();
            }
        }
        long e = System.currentTimeMillis();
        System.out.println("Time taken with Pooling: ");
        System.out.println((e-s));
    }

    public void noPool ()throws SQLException{
        long s = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                Statement stm = conn.createStatement();
                stm.close();
            } finally {
                if (conn != null)
                    conn.close();
            }
        }
        long e = System.currentTimeMillis();
        System.out.println("Time taken without Pooling: ");
        System.out.println((e-s));
    }

    void customConnect() throws SQLException {
//        Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        pool();
        noPool();

//        However, manually using DriverManager.getConnection(...) is bad practice in Spring Boot for two reasons:
//
//        No Connection Pooling: DriverManager opens a new physical connection every single time the method is called, which is very slow. Spring Boot comes with HikariCP (a high-performance connection pool) by default.

//        conn.setAutoCommit(false);


//        Statement stmt=conn.createStatement();
//        String sql="CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name VARCHAR(100), email VARCHAR(100))";
//        stmt.executeUpdate(sql);

//        String sqlInsert="INSERT INTO users (name, email) VALUES \n" +
//                "('Tarun Mac', 'tarun@example.com'),\n" +
//                "('Jane Doe', 'jane@test.io'),\n" +
//                "('John Smith', 'john.smith@gmail.com');";
//        stmt.executeUpdate(sqlInsert);

//        Statement stmtUpdate = conn.createStatement(
//                ResultSet.TYPE_SCROLL_INSENSITIVE,
//                ResultSet.CONCUR_UPDATABLE  // <--- This enables rs.updateRow()
//        );
//        ResultSet rs=stmtUpdate.executeQuery("SELECT * FROM users");
//        while(rs.next()){
//            if(rs.getString("name").equals("Tarun Mac")){
//                rs.updateInt("id", 100+rs.getInt("id"));
//                rs.updateRow();
//            }
//        }
//
//        conn.commit();
//
//        stmt.close();
//        stmtUpdate.close();
//        conn.close();
    }
}

```

![image.png](/images/image-294.png)



