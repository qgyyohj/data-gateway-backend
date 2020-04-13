package com.gateway.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.gateway.entity.DataBase;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Z
 */
public class ConnectionPool {

    /**
     * 数据源s
     */
    Map<Integer, DruidDataSource> dataSourceMap = new HashMap<>();

    /**
     * 单例模型
     */
    private static ConnectionPool connectionPool;

    /**
     * 通用配置
     */
    private Properties commonProps;

    /**
     * 初始化公共配置
     */
    private ConnectionPool(){
        // 连接池初始化大小
        commonProps.setProperty("initialSize","3");
        // 连接池最小
        commonProps.setProperty("minIdle","1");
        // 连接池的最大数据库连接数 设为0表示无限制
        commonProps.setProperty("maxActive","10");
        // 配置获取连接等待超时的时间：ms
        commonProps.setProperty("maxWait","60000");
        // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接：ms
        commonProps.setProperty("timeBetweenEvictionRunsMillis","60000");
        // 配置一个连接在池中最小生存的时间:ms
        commonProps.setProperty("minEvictableIdleTimeMillis","300000");
        // 配置一个连接在池中最大生存的时间:ms
        commonProps.setProperty("maxEvictableIdleTimeMillis","600000");
        // 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
        commonProps.setProperty("filters","stat,wall,logback");
        // 不知道啥意思，官网都是这么给的，先抄下来吧，等出错了估计就知道这两条啥意思了
        commonProps.setProperty("keepAlive","true");
        commonProps.setProperty("phyMaxUseCount","1000");

    }

    public void addDataBase(DataBase dataBase){
        Properties dbProps = new Properties(commonProps);
        switch (dataBase.getType()){
            case "MySql":
                dbProps.setProperty("driver","com.mysql.jdbc.Driver");
                dbProps.setProperty("url","jdbc:mysql://"+dataBase.getServerIp()+":"+dataBase.getPort()+"/"+dataBase.getDbName());
                dbProps.setProperty("connectionProperties","useUnicode=true;characterEncoding=UTF8");
                break;
            case "Oracle":
                dbProps.setProperty("driver","oracle.jdbc.driver.OracleDriver");
                dbProps.setProperty("url","jdbc:oracle:thin:@"+dataBase.getServerIp()+":"+dataBase.getPort()+":"+dataBase.getDbName());
                System.out.println("Oracle");
                break;
            case "SqlServer":
                System.out.println("SqlServer");
                break;
            case "Excel":
                System.out.println("Excel");
                break;
            default:
                break;
        }

        try{
            DruidDataSource druidDataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(dbProps);
            this.dataSourceMap.put(dataBase.getId(),druidDataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 移除数据源
     * @param id
     */
    public void removeDataSource(Integer id){
        if(dataSourceMap.containsKey(id)){
            dataSourceMap.get(id).close();
            dataSourceMap.remove(id);
        }
    }

    /**
     * 获取单例
     * @return
     */
    public static ConnectionPool getInstance(){
        if(connectionPool==null){
            synchronized (ConnectionPool.class){
                connectionPool = new ConnectionPool();
            }
        }
        return connectionPool;
    }
}
