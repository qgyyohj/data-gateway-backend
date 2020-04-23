package com.gateway.controller;

import com.gateway.service.DataSourceService;
import com.gateway.utils.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Z
 */
@RestController
@RequestMapping("/ds")
public class DataSourceController {

    @Autowired
    DataSourceService dataSourceService;

    @ResponseBody
    @PostMapping("/addDataSource")
    public Map<String,Object> addDataSource(Datasource datasource){
        try {
            dataSourceService.addDataSource(datasource);
            return CommonResponse.commonSuccess(null);
        }catch (Exception e){
            return CommonResponse.commonFail("添加数据源失败");
        }

    }



}
