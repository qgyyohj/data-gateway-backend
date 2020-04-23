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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public void addTransScheme(Scheme scheme) {
        schemeDao.insert(scheme);
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
        // 源数据源查询
        String querySql = sqlService.query(s.getSourceTable(),sourceCols);
        // 执行查询，得到结果集
        ResultSet rs = source.getConnection().getConnection().createStatement().executeQuery(querySql);
        // 解析某一条数据项
        List<String> item = new ArrayList<>();
        while(rs.next()){
            sourceCols.stream().forEach(x->{
                try {
                    item.add(rs.getString(x));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            // 构造两个sql语句，然后执行
            String insertSql = sqlService.insertItem(s.getTargetTable(),targetCols,item);
            target.getConnection().getConnection().createStatement().execute(insertSql);
            // 执行完一个需要清空这个数据项
            item.clear();
            ////////////////////////////////////////////////////////
            // 如何判断某条数据项是否已经执行过呢---???????????????????
            // 一个个去校验效率一定存在问题---????????????????????????
            ////////////////////////////////////////////////////////
            // 集合a记录当前查询到的东西
            // 集合b记录执行任务结束后的a的状态
            // 集合a记录新的查询到的东西
            // 集合a与b作差集就是新的要执行的任务的数据项 a-b===a.removeAll(b)
        }

    }

    @Override
    public void removeScheme(Integer id) {
        schemeDao.deleteById(id);
    }

    @Override
    public List<Scheme> queryScheme() {
        return schemeDao.queryAll(null);
    }
}
