package com.gateway.service.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.gateway.dao.DatasourceDao;
import com.gateway.entity.Datasource;
import com.gateway.service.DataSourceService;
import com.gateway.service.SqlService;
import com.gateway.utils.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Z
 */
@Service
public class DataSourceServiceImpl implements DataSourceService {

    @Autowired
    DatasourceDao datasourceDao;

    @Autowired
    SqlService sqlService;


    @Override
    public DruidDataSource getDataSource(Integer id) {
        Datasource datasource = datasourceDao.queryById(id);
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        if(datasource!=null&& connectionPool.getDataSource(id)!=null){
            connectionPool.addDataBase(datasource);
        }
        return connectionPool.getDataSource(id);
    }

    @Override
    public List<String> getTables(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<String> getTableCols(Integer id, String tableName) throws SQLException {
        DruidDataSource druidDataSource = getDataSource(id);
        String sql = sqlService.getCol(id);
        ResultSet rs = druidDataSource.getConnection().getConnection().createStatement().executeQuery(sql);
        List<String> cols = new ArrayList<>();
        while (rs.next()){
            cols.add(rs.getString(0));
        }
        return cols;
    }

    @Override
    public List<List<String>> getTableData(Integer id, String tableName) throws SQLException {
        Datasource datasource = datasourceDao.queryById(id);
        List<String> cols = getTableCols(id,"");
        String sql = sqlService.query(datasource.getDbName(),cols);
        DruidDataSource druidDataSource =getDataSource(id);
        ResultSet rs = druidDataSource.getConnection().getConnection().createStatement().executeQuery(sql);
        while(rs.next()){
            //cols.stream().
        }
        return null;
    }
}
