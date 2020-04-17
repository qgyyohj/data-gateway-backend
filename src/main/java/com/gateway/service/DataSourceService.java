package com.gateway.service;

import com.gateway.entity.Datasource;

import java.util.List;

/**
 * @author Z
 */
public interface DataSourceService {

    /**
     * 添加一个数据源
     * @param datasource
     */
    void addDataSource(Datasource datasource);

    /**
     * 通过id删除一个数据源
     * @param id
     */
    void removeDataSource(Integer id);

    /**
     * 查询所有的数据源
     * @return
     */
    List<Datasource> queryAllDataSource();

    /**
     * 更新一个数据源
     * @param datasource
     */
    void updateDataSource(Datasource datasource);
}
