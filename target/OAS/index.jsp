<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logining</title>
    <%@ include file="commons/meta.jsp"%>
</head>
<body background="statics/images/login-bg.jpg"
        style=" background-repeat:no-repeat ;
        background-size:100% 100%;
        background-attachment: fixed;" >
<center>
    <div style="margin:20px 0;">
        <h2>Welcome</h2>
    </div>
    <div class="easyui-panel"  title="zwzfOASystem" style=" width:100%;max-width:400px;padding:30px 60px;">
        <form id="ff" method="post" action="${pageContext.request.contextPath}/doLogin.action">
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="username" style="width:100%"
                       data-options="label:'用户名:',required:true">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-passwordbox" name="password" style="width:100%"
                       data-options="label:'密码:',required:true">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="vcode" style="width:100%"
                       data-options="label:'验证码:',required:true" >
            </div>
            <div style="margin-bottom:20px" align="center">
                <img src="${pageContext.request.contextPath}/doVerificationCode.action"
                     height="50px" id="change_vc"
                     onclick="this.src='${pageContext.request.contextPath}/doVerificationCode.action?d='+Math.random();">
            </div>
            <div style="margin-bottom:20px" align="center">
                <input type="checkbox" checked="checked">
                <span>记住密码</span>
            </div>
            <div style="text-align:center;padding:5px 0 ">
                <button type=" submit" style="background-color:darkgreen; color: white;  width:180px; height: 30px " data-options="iconCls:'icon-ok'">登录</button>
                <a href="${pageContext.request.contextPath}/toRegister.action"> 注册</a>
            </div>

        </form>
    </div>
</center>
</body>
</html>
