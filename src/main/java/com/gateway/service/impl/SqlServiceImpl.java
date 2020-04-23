package com.gateway.service.impl;

import com.gateway.dao.DatasourceDao;
import com.gateway.entity.Datasource;
import com.gateway.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Z
 */
@Service
public class SqlServiceImpl implements SqlService {

    @Autowired
    DatasourceDao datasourceDao;

    @Override
    public String query(String table, List<String> cols){
        return "select "+cols.toString().substring(1,cols.toString().length()-1)+" from "+table;
    }

    @Override
    public String insertItem(String table, List<String> cols, List<String> params) {
        String column = cols.toString().substring(1,cols.toString().length()-1);
        params=params.stream().map(x->"\""+x+"\"").collect(Collectors.toList());
        String parameter = params.toString().substring(1,params.toString().length()-1);
        return "insert into "+table+"("+ column +") values ("+parameter+")";
    }

    @Override
    public String getCol(Integer id) {
        Datasource datasource = datasourceDao.queryById(id);
        String dbName = datasource.getDbName();
        switch (datasource.getType()){
            case "MySql":
                return "show tables from "+dbName+";";
            case "Oracle":
                return "SELECT * FROM USER_TABLES;";
            case "SqlServer":
                return "select name from sysobjects where type = 'U';";
            default:
                return null;

        }

    }
}
