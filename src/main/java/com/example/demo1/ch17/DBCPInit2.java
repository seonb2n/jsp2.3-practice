package com.example.demo1.ch17;

import java.sql.DriverManager;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInit2 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    private void loadJDBCDriver() {
       String driverClass = getInitParameter("jdbcdriver");
       try {
           Class.forName(driverClass);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException("fail to load JDBC Driver", e);
       }
    }

    private void initConnectionPool() {
        try {
            String jdbcURL = getInitParameter("jdbcUrl");
            String username = getInitParameter("dbUser");
            String pw = getInitParameter("dbPass");

            ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(jdbcURL, username, pw);

            PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);
            poolableConnectionFactory.setValidationQuery("select 1");

            GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
            poolConfig.setTimeBetweenEvictionRuns(Duration.of(1000L * 60L * 5L, ChronoUnit.SECONDS));
            poolConfig.setTestWhileIdle(true);
            poolConfig.setMinIdle(4);
            poolConfig.setMaxTotal(50);

            GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnectionFactory, poolConfig);
            poolableConnectionFactory.setPool(connectionPool);
            Class.forName("org.apache.commons.dbcp2.PoolingDriver");
            PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
            String poolName = getInitParameter("poolName");
            driver.registerPool(poolName, connectionPool);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
