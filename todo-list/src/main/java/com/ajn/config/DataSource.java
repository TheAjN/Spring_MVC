package com.ajn.config;


import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;

import java.sql.ConnectionBuilder;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.ShardingKeyBuilder;
import java.util.logging.Logger;

@Component
public class DataSource extends BasicDataSource {

    private static final String USERNAME = "${jdbc.username}";
    private static final String PASSWORD = "${jdbc.password}";
    private static final String CLASSNAME = "${jdbc.driverClassName}";
    private static final String URL = "${jdbc.url}";

    private final BasicDataSource bs = new BasicDataSource();

    private DataSource(){
        bs.setUsername(USERNAME);
        bs.setPassword(PASSWORD);
        bs.setDriverClassName(CLASSNAME);
        bs.setUrl(URL);
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public ShardingKeyBuilder createShardingKeyBuilder() throws SQLException {
        return super.createShardingKeyBuilder();
    }

    @Override
    public ConnectionBuilder createConnectionBuilder() throws SQLException {
        return super.createConnectionBuilder();
    }
}
