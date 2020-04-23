package com.gateway.service;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Z
 */
public interface DataSourceService {

    /**
     * 得到一个数据源
     * @param id
     * @return
     */
    DruidDataSource getDataSource(Integer id);

    /**
     * 得到一个数据源的表
     * @param id
     * @return
     * @throws SQLException
     */
    List<String> getTables(Integer id) throws SQLException;

    /**
     * 得到一个数据源中某个表的列
     * @param id
     * @param tableName
     * @return
     * @throws SQLException
     */
    List<String> getTableCols(Integer id,String tableName) throws SQLException;

    /**
     * 得到一个数据源中某个表的数据
     * @param id
     * @param tableName
     * @return
     * @throws SQLException
     */
    List<List<String>> getTableData(Integer id,String tableName) throws SQLException;
}
