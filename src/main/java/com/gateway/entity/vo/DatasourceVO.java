package com.gateway.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Z
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DatasourceVO {

    Integer id;

    String name;

    String dbType;

    String dbName;

    Integer ownerId;

    Boolean isShared;

}
