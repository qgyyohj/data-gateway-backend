package com.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (DgDatasource)实体类
 *
 * @author makejava
 * @since 2020-04-17 21:01:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Datasource implements Serializable {
    private static final long serialVersionUID = 783726412647149218L;
    /**
    * 数据源id
    */
    private Integer id;
    /**
    * 数据库服务器ip
    */
    private String ipAddress;
    /**
    * 连接的用户名
    */
    private String username;
    /**
    * 连接的密码
    */
    private String password;
    /**
    * 数据源端口
    */
    private String port;
    /**
    * 数据源的拥有者
    */
    private Integer ownerId;
    /**
    * 备注
    */
    private String comment;

}