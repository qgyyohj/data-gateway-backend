package com.gateway.dao;

import com.gateway.entity.Scheme;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (DgScheme)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-17 21:16:37
 */
public interface SchemeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Scheme queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Scheme> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dgScheme 实例对象
     * @return 对象列表
     */
    List<Scheme> queryAll(Scheme dgScheme);

    /**
     * 新增数据
     *
     * @param dgScheme 实例对象
     * @return 影响行数
     */
    int insert(Scheme dgScheme);

    /**
     * 修改数据
     *
     * @param dgScheme 实例对象
     * @return 影响行数
     */
    int update(Scheme dgScheme);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}