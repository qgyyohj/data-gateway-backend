package com.gateway.service.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.gateway.dao.DatasourceDao;
import com.gateway.dao.SchemeDao;
import com.gateway.entity.Datasource;
import com.gateway.entity.Scheme;
import com.gateway.entity.TransScheme;
import com.gateway.service.SqlService;
import com.gateway.service.TransformService;
import com.gateway.utils.CommonUtil;
import com.gateway.utils.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Z
 */
@Service
public class TransformServiceImpl implements TransformService {

    @Autowired
    DatasourceDao datasourceDao;

    @Autowired
    SchemeDao schemeDao;

    @Autowired
    SqlService sqlService;

    @Override
    public void addTransScheme(TransScheme transScheme) {

    }

    @Override
    public void invokeScheme(Scheme scheme) throws SQLException {
        Scheme s = schemeDao.queryById(scheme.getId());
        List<String> sourceCols = CommonUtil.strToList(s.getSourceCols());
        List<String> targetCols = CommonUtil.strToList(s.getTargetCols());
        // 拿到源数据源的连接
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        DruidDataSource source = connectionPool.getDataSource(s.getSourceId());
        DruidDataSource target = connectionPool.getDataSource(s.getTargetId());
        String querySql = sqlService.query(s.getSourceTable(),sourceCols);
        ResultSet rs = source.getConnection().getConnection().createStatement().executeQuery(querySql);
        rs.
        //得到源数据源的数据

        String insertSql = sqlService.insertItem(s.getTargetTable(),targetCols,data);
        target.getConnection().getConnection().createStatement().execute(insertSql);
        // 拿到目的数据源的连接
        // 构造两个sql语句，然后执行

        //定时执行

    }

    @Override
    public void removeScheme(Integer id) {

    }
}
