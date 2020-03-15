package com.gateway.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Z
 */
public class ConnectUtil {

    public static Connection getConnection(){
        Properties props = new Properties();
        props.setProperty("driverClassName","");
        props.setProperty("url","");
        props.setProperty("username","");
        props.setProperty("password","");
        try {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
