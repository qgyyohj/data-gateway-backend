package com.gateway.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Z
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataVO {

    List<String> columns;

    List<List<String>> data;

}
