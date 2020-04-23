package com.gateway.controller;

import com.gateway.service.DataChanelService;
import com.gateway.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Z
 */
@RestController
@RequestMapping("/dataChanel")
public class DataChanelController {

    private final static Logger log = LoggerFactory.getLogger(DataChanelController.class);

    @Autowired
    DataChanelService dataChanelService;

//    @GetMapping
//    @ResponseBody
//    public Map<String,Object> a(){
//        try{
//            return Response.commonSuccess("");
//        }catch (Exception e){
//            log.error(e.getMessage());
//            return Response.commonFail("");
//        }
//    }
//
//    @GetMapping
//    @ResponseBody
//    public Map<String,Object> b(){
//        try{
//            return Response.commonSuccess("");
//        }catch (Exception e){
//            log.error(e.getMessage());
//            return Response.commonFail("");
//        }
//    }
//
//    @GetMapping
//    @ResponseBody
//    public Map<String,Object> c(){
//        try{
//            return Response.commonSuccess("");
//        }catch (Exception e){
//            log.error(e.getMessage());
//            return Response.commonFail("");
//        }
//    }
//
//    @GetMapping
//    @ResponseBody
//    public Map<String,Object> d(){
//        try{
//            return Response.commonSuccess("");
//        }catch (Exception e){
//            log.error(e.getMessage());
//            return Response.commonFail("");
//        }
//    }
}
