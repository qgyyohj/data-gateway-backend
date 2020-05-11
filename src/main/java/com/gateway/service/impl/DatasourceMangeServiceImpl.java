package com.gateway.service.impl;

import com.gateway.dao.DatasourceDao;
import com.gateway.entity.Datasource;
import com.gateway.service.DatasourceManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Z
 */
@Service
public class DatasourceMangeServiceImpl implements DatasourceManageService {

    private final static Logger log = LoggerFactory.getLogger(DatasourceMangeServiceImpl.class);

    @Autowired
    DatasourceDao datasourceDao;

    @Override
    public void addDatasource(Datasource datasource) {
        log.info("添加数据源",datasource);
        datasourceDao.insert(datasource);
    }

    @Override
    public void removeDatasource(Integer id) {
        log.info("删除数据源，id为",id);
        datasourceDao.deleteById(id);
    }

    @Override
    public List<Datasource> queryAll(Integer id) {
        log.info("查询本用户?的所有的数据源",id);
        List<Datasource> u = datasourceDao.queryAll(Datasource.builder().ownerId(id).build());
        log.info("查询共享的数据源");
        List<Datasource> s = datasourceDao.queryAll(Datasource.builder().isShared(1).build());
        u.addAll(s);
        return u.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public void updateDatasource(Datasource datasource) {
        log.info("更新数据源，主键为",datasource.getId());
        datasourceDao.update(datasource);
    }
}
