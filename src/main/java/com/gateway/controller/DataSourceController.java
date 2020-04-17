package com.gateway.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Z
 */
@RestController
@RequestMapping("/ds")
public class DataSourceController {

    @PostMapping("/addDataSource")
    public Map<String,Object> addDataSource(){

        return null;
    }

}
