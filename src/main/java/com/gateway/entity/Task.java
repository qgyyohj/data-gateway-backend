package com.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Task)实体类
 *
 * @author makejava
 * @since 2020-04-23 09:53:08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Serializable {
    private static final long serialVersionUID = 175719057562821738L;
    
    private Integer id;
    
    private Integer schemeId;
    
    private Date startAt;
    
    private String endAt;
    
    private Integer interval;
}