package com.gateway.service;

import com.gateway.entity.Scheme;
import com.gateway.entity.TransScheme;

/**
 * @author Z
 */
public interface TransformService {

    /**
     * 添加一个数据库转换方案
     * @param transScheme
     */
    void addTransScheme(TransScheme transScheme);

    /**
     * 执行转换方案
     * @param transScheme
     */
    void invokeScheme(Scheme transScheme);

    /**
     * 移除转换方案
     * @param id
     */
    void removeScheme(Integer id);


}
