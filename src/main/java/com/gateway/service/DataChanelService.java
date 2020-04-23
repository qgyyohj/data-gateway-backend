package com.gateway.service;

import com.gateway.entity.Scheme;
import com.gateway.entity.Task;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Z
 */
public interface DataChanelService {

    /**
     * 执行方案
     * 从task表中取task，然后执行，相关参数都在task里
     * @param id
     */
    void invokeScheme(Integer id) throws SQLException;

    /**
     * 移除一个任务
     * @param id
     */
    void removeTask(Integer id);

    /**
     * 添加一个task
     * @param task
     */
    void addTask(Task task);

    /**
     * 得到该用户的执行列表
     * @param id
     * @return
     */
    List<Task> queryTask(Integer id);



    //---------------------------------------------------------------

    /**
     * 添加方案
     * @param scheme
     */
    void addScheme(Scheme scheme);

    /**
     * 更新方案
     * @param scheme
     */
    void updateScheme(Scheme scheme);

    /**
     * 移除方案
     * @param id
     */
    void removeScheme(Integer id);

    /**
     * 查询方案，需要提供用户id
     * @param id
     * @return
     */
    List<Scheme> queryScheme(Integer id);
}
