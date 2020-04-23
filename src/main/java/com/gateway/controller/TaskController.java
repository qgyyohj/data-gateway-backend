package com.gateway.controller;

import com.gateway.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Z
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    private final static Logger log = LoggerFactory.getLogger(TaskController.class);

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
