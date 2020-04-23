package com.gateway.service;

import com.gateway.entity.Datasource;

import java.util.List;

/**
 * @author Z
 */
public interface DatasourceManageService {

    /**
     * 添加一个数据源
     * @param datasource
     */
    void addDatasource(Datasource datasource);

    /**
     * 通过id删除数据源
     * @param id
     */
    void removeDatasource(Integer id);

    /**
     * 查询本用户能看到的所有数据源
     * @param id
     * @return
     */
    List<Datasource> queryAll(Integer id);

    /**
     * 修改数据源---状态了 连接了 密码了
     * @param datasource
     */
    void updateDatasource(Datasource datasource);

}
