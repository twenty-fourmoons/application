package com.zwzf.service.impl;

import com.zwzf.dao.UserDao;
import com.zwzf.pojo.UserBean;
import com.zwzf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void registerUser(UserBean user) {
        userDao.registerUser(user);
    }

    @Override
    public String findPasswdByUserName(String passwd) {
        return userDao.findPasswdByUserName(passwd);
    }

    @Override
    public void addCookie(String username, String password, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {

    }

    @Override
    public UserBean checkLogin(UserBean user) {
        return userDao.checkLogin(user);
    }
}
