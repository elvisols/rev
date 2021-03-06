package com.bank.rev.util;

import com.bank.rev.App;
import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Config {
    private static final String PROPERTY_FILE_NAME = "/rev.properties";

    private Config() {}

    public static Config getInstance() {
        return Factory.instance;
    }


    public Configuration getConfiguration() throws SQLException  {
        return Factory.instanceConfig;
    }

    private static Connection getConn() {
        System.out.println("creating Connection object...");
        Connection c = null;
        try(InputStream is = App.class.getResourceAsStream(PROPERTY_FILE_NAME)) {
            Properties props = new Properties();
            props.load(is);
            c = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.user"), props.getProperty("db.pass"));
            return c;
        } catch (SQLException | IOException se) {
            se.printStackTrace();
        }
        return c;
    }

    // thread safe java class loader
    private static class Factory {
        static final Config instance = new Config();
        static Configuration instanceConfig = new DefaultConfiguration().set(getConn()).set(SQLDialect.H2);
    }
}
