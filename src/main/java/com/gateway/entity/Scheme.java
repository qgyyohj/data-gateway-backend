package com.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (DgScheme)实体类
 *
 * @author makejava
 * @since 2020-04-17 21:16:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Scheme implements Serializable {
    private static final long serialVersionUID = 204973421854891863L;
    
    private Integer id;
    
    private Integer sourceId;

    private String sourceTable;
    
    private Integer targetId;

    private String targetTable;
    
    private String sourceCols;

    private String targetCols;
    /**
    * 方案创建人的id
    */
    private Integer createBy;
    
    private Date startAt;
    
    private Date endAt;
    
    private Integer interval;

}