package com.gateway.entity;

import lombok.Data;

/**
 * @author Z
 */
@Data
public class DataBase {

    Integer id;

    String username;

    String password;

    String port;

    String dbName;

    String type;

    String serverIp;
}
