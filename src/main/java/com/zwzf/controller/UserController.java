package com.zwzf.controller;

import com.google.gson.Gson;
import com.zwzf.pojo.UserBean;
import com.zwzf.service.UserService;
import com.zwzf.util.EntryptUtil;
import com.zwzf.util.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录验证密码+验证码
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/doLogin.action")
    public String Login(UserBean user, String vcode, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String passwd = request.getParameter("password");
        String username = request.getParameter("username");
        //添加Cookie
        userService.addCookie(username, passwd, response, request);

        //保存用户名到session
        request.getSession().setAttribute("username", username);
        EntryptUtil entryptUtil = new EntryptUtil();
        //加密后的密码
        String enPasswd = entryptUtil.md5AndSha1(passwd);
        user.setPassword(enPasswd);
        UserBean u = userService.checkLogin(user);
        //验证码图片的值
        String v = (String) request.getSession().getAttribute("codeValidate");
        if (v.equalsIgnoreCase(vcode)) {
            if (u != null) {
                return "redirect:toSuccess.action";
            }
        } else {
            //验证码输入错误时...
            System.out.println("cuocccc");
        }
        return "redirect:toLogin.action";
    }

    /**
     * 前往登录成功页面
     */
    @RequestMapping(value = "/toSuccess.action")
    public String toSuccess() {
        return "main";
    }

    /**
     * 前往登录失败页面
     *
     * @return
     */
    @RequestMapping(value = "/toFail.action")
    public String toFail() {
        return "error";
    }

    /**
     * 前往注册页面
     *
     * @return
     */
    @RequestMapping(value = "/toRegister.action")
    public String toRegister() {
        return "register";
    }

    /**
     * 前往登录页面
     *
     * @return
     */
    @RequestMapping(value = "/toLogin.action")
    public String toLogin() {
        return "redirect:/";
    }

    /**
     * 执行注册
     */
    @RequestMapping(value = "/doRegister.action")
    public String doRegister(UserBean user, HttpServletRequest request) {
        String passwd = request.getParameter("password");
        String enPasswd = null;
        try {
            EntryptUtil entryptUtil = new EntryptUtil();
            enPasswd = entryptUtil.md5AndSha1(passwd);
            user.setPassword(enPasswd);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        userService.registerUser(user);
        return "redirect:toLogin.action";
    }

    /**
     * 验证码
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/doVerificationCode.action")
    public String doVerificationCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerificationCode vc = new VerificationCode();
        vc.getCode(request, response);
        request.setAttribute("vcode", vc);
        return "redirect:index.jsp";
    }

    @RequestMapping(value="/getCookie")
    public String getCookie(UserBean user, HttpServletRequest request)throws IOException{
        String username = "";
        String password = "";
        Cookie[] cookies = request.getCookies();
        if(cookies!=null&&cookies.length>0){
            //遍历Cookie
            for(int i=0;i<cookies.length;i++){
                Cookie cookie = cookies[i];
                //此处类似与Map有
                if("username".equals(cookie.getName())){
                    username = cookie.getValue();
                }
                if("password".equals(cookie.getName())){
                    password = cookie.getValue();
                }
            }
        }
        //自己定义的javabean Cookies
        user.setUsername(username);
        user.setPassword(password);
        Gson gson = new Gson();
        return gson.toJson(user);
    }

}
