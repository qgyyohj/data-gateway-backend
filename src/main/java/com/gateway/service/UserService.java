package com.gateway.service;

import com.gateway.entity.User;

import java.util.List;

/**
 * @author z
 */
public interface UserService {
    /**
     * 用户登录函数
     * @param username
     * @param password
     * @return
     */
    String logIn(String username,String password);

    /**
     * 仅仅允许管理员增加用户并且设置修改用户密码
     * @param user
     * @return
     */
    void addUser(User user);

    /**
     * 仅仅允许管理员增加用户并且设置修改用户密码
     * @param id
     * @param pwd
     * @param newPwd
     * @return
     */
    boolean updatePwd(Integer id,String pwd,String newPwd);

    /**
     * 删除用户仅仅允许管理员操作
     * @param id
     * @return
     */
    void deleteUser(int id);

    List<User> queryAll();

}
