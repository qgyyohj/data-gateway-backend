package com.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (DgUser)实体类
 *
 * @author makejava
 * @since 2020-02-18 22:14:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -63980882430883674L;
    /**
    * 用户的主键id
    */
    private Integer id;
    /**
    * 用户名
    */
    private String username;
    /**
    * 用户密码
    */
    private String password;

}