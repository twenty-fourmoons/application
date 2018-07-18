package com.zwzf.service.impl;

import com.zwzf.dao.UserDao;
import com.zwzf.pojo.UserBean;
import com.zwzf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
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
        if(!username.equals("") && !password.equals("")){
            //创建  Cookie
            Cookie usernameCookie = new Cookie("username",username);
            Cookie passwordCookie = new Cookie("password",password);
            //设置Cookie的父路经
            usernameCookie.setPath(request.getContextPath()+"/");
            passwordCookie.setPath(request.getContextPath()+"/");
            //获取是否保存Cookie（例如：复选框的值）
            String rememberMe = request.getParameter("rememberMe");
            if( rememberMe==null || rememberMe.equals(false) ){
                //不保存Cookie
                usernameCookie.setMaxAge(0);
                passwordCookie.setMaxAge(0);
            }else{
                //保存Cookie的时间长度，单位为秒
                usernameCookie.setMaxAge(7*24*60*60);
                passwordCookie.setMaxAge(7*24*60*60);
            }
            //加入Cookie到响应头
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
        }
    }

    @Override
    public UserBean checkLogin(UserBean user) {
        return userDao.checkLogin(user);
    }
}
