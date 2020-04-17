package com.gateway.service;

import java.util.List;

/**
 * @author Z
 */
public interface SqlService{

    /**
     * 输入表名和栏目查询数据项
     * @param table
     * @param cols
     * @return
     */
    String query(String table, List<String> cols);

    /**
     * 输入表名，栏目和参数，向指定表中插入数据
     * @param table
     * @param cols
     * @param params
     * @return
     */
    String insertItem(String table, List<String> cols, List<String> params);
}
