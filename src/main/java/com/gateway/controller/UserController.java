package com.gateway.controller;

import com.gateway.entity.User;
import com.gateway.entity.UserMsgEnum;
import com.gateway.utils.Response;
import com.gateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author z
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/logIn")
    @ResponseBody
    public Map<String,Object> logIn(String username,String password){
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
            if(userService.updatePwd(id,pwd,newPwd)){
                return Response.commonSuccess("修改密码成功");
            }
            return Response.commonFail("原始密码不正确");
        }catch (Exception e){
            return Response.commonFail("修改密码失败");
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String,Object> removeUser(Integer id){
        try{
            userService.deleteUser(id);
            return Response.commonSuccess("删除用户成功");
        }catch (Exception e){
            return Response.commonFail("删除用户失败");
        }
    }

}
