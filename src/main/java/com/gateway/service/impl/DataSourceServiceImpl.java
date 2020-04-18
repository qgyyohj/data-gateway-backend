package com.gateway.service.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.gateway.dao.DatasourceDao;
import com.gateway.entity.Datasource;
import com.gateway.service.DataSourceService;
import com.gateway.utils.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Z
 */
@Service
public class DataSourceServiceImpl implements DataSourceService {

    @Autowired
    DatasourceDao datasourceDao;

    @Override
    public void addDataSource(Datasource datasource) {

    }

    @Override
    public void removeDataSource(Integer id) {

    }

    @Override
    public List<Datasource> queryAllDataSource() {
        return null;
    }

    @Override
    public void updateDataSource(Datasource datasource) {

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
}
