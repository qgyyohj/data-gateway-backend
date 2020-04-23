package com.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Scheme)实体类
 *
 * @author makejava
 * @since 2020-04-23 09:53:08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Scheme implements Serializable {
    private static final long serialVersionUID = 781025545411393291L;
    
    private Integer id;
    
    private String name;
    
    private String sourceId;
    
    private String sourceTableName;
    
    private String sourceTableCols;
    
    private String targetId;
    
    private String targetTableName;
    
    private String targetTableCols;
    
    private Integer createBy;
}