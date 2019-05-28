package com.bortni.dao.connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConnectionHolder {
    private static volatile BasicDataSource dataSource;
    private static final Logger LOGGER = Logger.getLogger(ConnectionHolder.class);

    public static BasicDataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionHolder.class) {
                if (dataSource == null) {
                    LOGGER.debug("DataSource: " + dataSource);
                    BasicDataSource ds = new BasicDataSource();
                    Properties properties = new Properties();
                    String fileName = "database.properties";
                    try (InputStream inputStream = Thread.currentThread()
                            .getContextClassLoader()
                            .getResourceAsStream(fileName)) {
                        LOGGER.debug("InputStream: " + inputStream);
                        if(inputStream != null){
                            LOGGER.info("inputStream is not null");
                            properties.load(inputStream);
                        }
                        else{
                            LOGGER.debug("file *.properties: " + fileName + "does not exist!");
                            throw new FileNotFoundException();
                        }
                        String driver = properties.getProperty("db.connection.driver");
                        String url = properties.getProperty("db.connection.url");
                        String user = properties.getProperty("db.connection.username");
                        String password = properties.getProperty("db.connection.password");

                        ds.setDriverClassName(driver);
                        ds.setUrl(url);
                        ds.setUsername(user);
                        ds.setPassword(password);

                        dataSource = ds;
                    } catch (IOException e) {
                        System.out.println("Error! Properties file doesn't exist");
                    }
                }
            }
        }
        return dataSource;
    }
}

