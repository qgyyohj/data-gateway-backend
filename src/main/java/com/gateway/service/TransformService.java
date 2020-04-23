package com.gateway.service;

import com.gateway.entity.Scheme;
import com.gateway.entity.TransScheme;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Z
 */
public interface TransformService {

    /**
     * 添加一个数据库转换方案
     * @param scheme
     */
    void addTransScheme(Scheme scheme);

    /**
     * 执行转换方案
     * @param transScheme
     */
    void invokeScheme(Scheme transScheme) throws SQLException;

    /**
     * 移除转换方案
     * @param id
     */
    void removeScheme(Integer id);

    /**
     * 查询所有的呃转换方案
     * @return
     */
    List<Scheme> queryScheme();


}
