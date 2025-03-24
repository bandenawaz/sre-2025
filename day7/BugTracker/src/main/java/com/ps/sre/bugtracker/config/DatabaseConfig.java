package com.ps.sre.bugtracker.config;



import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConfig {

    private static final String URL = "jdbc:mysql://localhost:3306/bugtracker_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    //Loggger for logging purpose
   private  static final Logger logger = Logger.getLogger(DatabaseConfig.class.getName());

    //lets create a private constructor for security
    private DatabaseConfig() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                //lets establish connection
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                logger.info("Connected to the database successfully");
            } catch (SQLException e) {
                throw new RuntimeException("Failed to connect to the database", e);
            }
        }

        return connection;

    }

}
