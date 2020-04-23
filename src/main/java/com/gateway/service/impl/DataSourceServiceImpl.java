package com.gateway.service.impl;

import com.alibaba.druid.pool.DruidDataSource;
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
    public void addDataSource(Datasource datasource) {
        datasourceDao.insert(datasource);
    }

    @Override
    public void removeDataSource(Integer id) {
        datasourceDao.deleteById(id);
    }

    @Override
    public List<Datasource> queryAllDataSource() {
        return datasourceDao.queryAll(null);
    }

    @Override
    public void updateDataSource(Datasource datasource) {
        datasourceDao.update(datasource);
    }

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
    public List<String> getCol(Integer id) throws SQLException {
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
    public List<String> getTableData(Integer id) throws SQLException {
        Datasource datasource = datasourceDao.queryById(id);
        List<String> cols = getCol(id);
        String sql = sqlService.query(datasource.getDbName(),cols);
        DruidDataSource druidDataSource =getDataSource(id);
        ResultSet rs = druidDataSource.getConnection().getConnection().createStatement().executeQuery(sql);
        while(rs.next()){
            //cols.stream().
        }
        return null;
    }
}
