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
    public Map<String, Object> logIn(@RequestBody Map<String, String> user) {
        log.info("登陆,?,?" + user);
        User u = userService.logIn(user.get("username"), user.get("password"));
        if (null != u) {
            u.setPassword(null);
            return Response.commonSuccess(u);
        } else {
            return Response.commonFail("登陆失败");
        }
    }

    @PostMapping("/addUser")
    public Map<String, Object> addUser(@RequestBody Map<String, String> user) {
        try {
            log.info("添加用户,?,?" + user);
            userService.addUser(User.builder().username(user.get("username")).password(user.get("password")).build());
            return Response.commonSuccess("添加用户成功");
        } catch (Exception e) {
            return Response.commonFail("添加用户失败");
        }

    }

    @PostMapping("/updatePwd")
    public Map<String, Object> updatePwd(@RequestBody Map<String, String> params) {
        try {
            log.info("更新密码?,?,?" + params);
            if (userService.updatePwd(Integer.parseInt(params.get("id")), params.get("password1"), params.get("password2"))) {
                return Response.commonSuccess("修改密码成功");
            }
            return Response.commonFail("原始密码不正确");
        } catch (Exception e) {
            return Response.commonFail("修改密码失败");
        }
    }

    @GetMapping("/delete")
    @ResponseBody
    public Map<String, Object> removeUser(Integer id) {
        try {
            log.info("删除用户:", id);
            userService.deleteUser(id);
            return Response.commonSuccess("删除用户成功");
        } catch (Exception e) {
            return Response.commonFail("删除用户失败");
        }
    }

    @GetMapping("/query")
    @ResponseBody
    public Map<String, Object> query() {
        try {
            log.info("查询所有用户数据");
            return Response.commonSuccess(userService.queryAll());
        } catch (Exception e) {
            log.info("");
            return Response.commonFail("查询失败");
        }
    }
}
