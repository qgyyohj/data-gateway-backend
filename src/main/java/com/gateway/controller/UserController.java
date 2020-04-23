package com.gateway.controller;

import com.gateway.entity.User;
import com.gateway.entity.UserMsgEnum;
import com.gateway.utils.Response;
import com.gateway.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author z
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping("/logIn")
    @ResponseBody
    public Map<String,Object> logIn(String username,String password){
        log.info("登陆,?,?",username,password);
        String msg = userService.logIn(username,password);
        if(msg.equals(UserMsgEnum.SUCCESS.getVar())){
            return Response.commonSuccess(msg);
        }
        return Response.commonFail(msg);
    }

    @PostMapping("/addUser")
    @ResponseBody
    public Map<String,Object> addUser(String username,String password){
        try{
            log.info("添加用户,?,?",username,password);
            userService.addUser(User.builder().username(username).password(password).build());
            return Response.commonSuccess("添加用户成功");
        }catch (Exception e){
            return Response.commonFail("添加用户失败");
        }

    }

    @PostMapping("/updatePwd")
    @ResponseBody
    public Map<String,Object> updatePwd(Integer id,String pwd,String newPwd){
        try{
            log.info("更新密码?,?,?",id,pwd,newPwd);
            if(userService.updatePwd(id,pwd,newPwd)){
                return Response.commonSuccess("修改密码成功");
            }
            return Response.commonFail("原始密码不正确");
        }catch (Exception e){
            return Response.commonFail("修改密码失败");
        }
    }

    @GetMapping("/delete")
    @ResponseBody
    public Map<String,Object> removeUser(Integer id){
        try{
            log.info("删除用户:",id);
            userService.deleteUser(id);
            return Response.commonSuccess("删除用户成功");
        }catch (Exception e){
            return Response.commonFail("删除用户失败");
        }
    }

    @GetMapping("/query")
    @ResponseBody
    public Map<String,Object> query(){
        try{
            log.info("查询所有用户数据");
            return Response.commonSuccess(userService.queryAll());
        }catch (Exception e){
            log.info("");
            return Response.commonFail("查询失败");
        }
    }
}
