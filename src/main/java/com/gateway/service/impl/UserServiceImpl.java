package com.gateway.service.impl;

import com.gateway.dao.UserDao;
import com.gateway.entity.User;
import com.gateway.entity.UserMsgEnum;
import com.gateway.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author z
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public String logIn(String username, String password) {

        List<User> user = userDao.queryAll(null).stream()
                .filter(x->x.getUsername().equals(username))
                .collect(Collectors.toList());

        switch(user.size()){
            case 0:
                return UserMsgEnum.USER_IS_NOT_EXISTS.getVar();
            case 1:
                return user.get(0).getPassword().equals(password)?UserMsgEnum.SUCCESS.getVar():UserMsgEnum.WRONG_USERNAME_OR_PASSWORD.getVar();
            default:
                return UserMsgEnum.OTHERS.getVar();
        }
    }

    @Override
    public int addUser(User user) {
        return userDao.insert(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.update(user);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteById(id);
    }

    @Override
    public int setUserAuthority() {
        return 0;
    }
}
