package com.gateway.controller;

import com.gateway.entity.UserMsgEnum;
import com.gateway.response.CommonResponse;
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
            return CommonResponse.commonSuccess(msg);
        }
        return CommonResponse.commonFail(msg);
    }
}
