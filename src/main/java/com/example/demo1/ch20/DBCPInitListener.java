package com.example.demo1.ch20;

import java.io.StringReader;
import java.sql.DriverManager;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

@WebListener
public class DBCPInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String poolConfig = sce.getServletContext().getInitParameter("poolConfing");
        Properties prop = new Properties();
        try {
            prop.load(new StringReader(poolConfig));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        loadJDBCDriver(prop);
        initConnectionPool(prop);
    }

    private void loadJDBCDriver(Properties properties) {
        String driverClass = properties.getProperty("jdbcdriver");
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void initConnectionPool(Properties properties) {
        try {
            String jdbcUrl = properties.getProperty("jdbcUrl");
            String username = properties.getProperty("dbUser");
            String pw = properties.getProperty("dbPass");

            ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(jdbcUrl, username, pw);

            PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);
            poolableConnectionFactory.setValidationQuery("select 1");

            GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
            poolConfig.setTimeBetweenEvictionRuns(Duration.of(60L * 5L, ChronoUnit.SECONDS));

            GenericObjectPool<PoolableConnection> connectionGenericObjectPool = new GenericObjectPool<>(poolableConnectionFactory, poolConfig);
            poolableConnectionFactory.setPool(connectionGenericObjectPool);

            Class.forName("org.apache.commons.dbcp2.PoolingDriver");
            PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
            String poolName = properties.getProperty("poolName");
            driver.registerPool(poolName, connectionGenericObjectPool);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
