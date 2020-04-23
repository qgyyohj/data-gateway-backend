package com.gateway.service.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.gateway.dao.SchemeDao;
import com.gateway.dao.TaskDao;
import com.gateway.entity.Scheme;
import com.gateway.entity.Task;
import com.gateway.service.DataChanelService;
import com.gateway.service.SqlService;
import com.gateway.utils.CommonUtil;
import com.gateway.utils.ConnectionPool;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Z
 */
@Service
public class DataChanelServiceImpl implements DataChanelService {

    private final static Logger log = LoggerFactory.getLogger(DataChanelServiceImpl.class);

    @Autowired
    TaskDao taskDao;

    @Autowired
    SchemeDao schemeDao;

    @Autowired
    SqlService sqlService;


    @Override
    public void invokeScheme(Integer id) {
        Task task = taskDao.queryById(id);
        Scheme scheme = schemeDao.queryById(task.getSchemeId());
        Date start = task.getStartAt();
        Integer interval = task.getInterval();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @SneakyThrows
            @Override
            public void run() {
                invoke(scheme);
            }
        }, start, interval);
    }

    void invoke(Scheme scheme) throws SQLException {
        // 拿到方案中数据源的相关参数
        List<String> sourceCols = CommonUtil.strToList(scheme.getSourceTableCols());
        List<String> targetCols = CommonUtil.strToList(scheme.getTargetTableCols());
        String sourceTable = scheme.getSourceTableName();
        String targetTable = scheme.getTargetTableName();
        // 拿到源数据源的连接
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        DruidDataSource source = connectionPool.getDataSource(scheme.getSourceId());
        DruidDataSource target = connectionPool.getDataSource(scheme.getTargetId());
        // 源数据源查询
        String querySql = sqlService.query(sourceTable, sourceCols);
        // 执行查询，得到结果集
        ResultSet rs = source.getConnection().getConnection().createStatement().executeQuery(querySql);
        // 解析某一条数据项
        List<List<String>> items = new ArrayList<>();
        List<String> item = new ArrayList<>();
        while (rs.next()) {
            // 查询到一条数据，构造一个item
            sourceCols.stream().forEach(x -> {
                try {
                    item.add(rs.getString(x));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            // 将item存放到items，然后清空item，准备下一次的添加
            items.add(item);
            // 放进去就可以清空了
            item.clear();
        }
        ////////////////////////////////////////////////////////
        // 如何判断某条数据项是否已经执行过呢---???????????????????
        // 一个个去校验效率一定存在问题---????????????????????????
        ////////////////////////////////////////////////////////
        // 集合a记录当前查询到的东西
        // 集合b记录执行任务结束后的a的状态
        // 集合a记录新的查询到的东西
        // 集合a与b作差集就是新的要执行的任务的数据项 a-b===a.removeAll(b)
        ////////////////////////////////////////////////////////
        List<List<String>> data = new ArrayList<>();
        items.removeAll(data);
        items.stream().forEach(x -> {
            String insertSQL = sqlService.insertItem(targetTable, targetCols, x);
            try {
                // 执行插入
                target.getConnection().getConnection().createStatement().executeQuery(insertSQL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        data.addAll(items);
    }

    @Override
    public void removeTask(Integer id) {
        log.info("删除任务");
        taskDao.deleteById(id);
    }

    @Override
    public void updateTask(Task task) {
        log.info("更新task");
        taskDao.update(task);
    }

    @Override
    public void addTask(Task task) {
        log.info("添加task");
        taskDao.insert(task);
    }

    @Override
    public List<Task> queryTask(Integer id) {
        log.info("查询当前用户的任务");
        return taskDao
                .queryAll(null)
                .stream()
                .filter(x ->
                        id.equals(schemeDao.queryById(x.getSchemeId()).getCreateBy()))
                .collect(Collectors.toList());
    }

    @Override
    public void addScheme(Scheme scheme) {
        log.info("添加一个方案");
        schemeDao.insert(scheme);
    }

    @Override
    public void updateScheme(Scheme scheme) {
        log.info("更新方案");
        schemeDao.update(scheme);
    }

    @Override
    public void removeScheme(Integer id) {
        log.info("移除方案");
        schemeDao.deleteById(id);
    }

    @Override
    public List<Scheme> queryScheme(Integer id) {
        return schemeDao.queryAll(Scheme.builder().createBy(id).build());
    }
}
