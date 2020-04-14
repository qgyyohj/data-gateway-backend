package com.gateway.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Z
 */
@Data
@Builder
public class DataBase {

    Integer id;

    String username;

    String password;

    Integer port;

    String dbName;

    String type;

    String serverIp;
}
