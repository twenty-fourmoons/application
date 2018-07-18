package com.zwzf.dao;

import com.zwzf.pojo.UserBean;

public interface UserDao {
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
}
