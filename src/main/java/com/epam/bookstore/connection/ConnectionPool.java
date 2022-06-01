package com.epam.bookstore.connection;

import java.util.ResourceBundle;

public final class ConnectionPool {

    private String dbUrl;
    private String dbUser;
    private String dbPass;
    private String dbDriver;
    private ResourceBundle properties = ResourceBundle.getBundle("database");
    private int maxPoolSize = 5;

    private void setConnectionData() {
        this.dbUrl = properties.getString("dbUrl");
        this.dbUser = properties.getString("dbUser");
        this.dbPass = properties.getString("dbPass");
        this.dbDriver = properties.getString("dbDriver");
    }

}
