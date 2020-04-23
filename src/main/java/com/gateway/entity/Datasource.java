package com.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Datasource)实体类
 *
 * @author makejava
 * @since 2020-04-23 09:53:08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Datasource implements Serializable {
    private static final long serialVersionUID = -79898055341526103L;
    
    private Integer id;
    
    private String name;
    
    private String ipAddress;
    
    private Integer port;
    
    private String dbName;
    
    private String username;
    
    private String password;
    
    private String dbType;
    
    private Integer ownerId;
    
    private String comment;
}