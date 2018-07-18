package com.zwzf.service;

import com.zwzf.pojo.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public interface UserService {
    /**
     * 登录检查账号，密码
     * @param user
     * @return
     */
    UserBean checkLogin(UserBean user);

    /**
     * 查找加密密码
     * @param passwd
     * @return
     */
    String findPasswdByUserName(String passwd);

    /**
     * 注册用户
     * @param user
     * @return
     */
    void registerUser(UserBean user);

    /**
     * 添加cookie
     * @param loginAccount
     * @param loginPassword
     * @param response
     * @param request
     * @throws UnsupportedEncodingException
     */
    void addCookie(String username, String password, HttpServletResponse response, HttpServletRequest request)
            throws UnsupportedEncodingException;

}
