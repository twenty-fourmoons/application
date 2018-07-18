<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <%@ include file="/commons/meta.jsp" %>
    <script type="text/javascript">
        $.extend($.fn.validatebox.defaults.rules, {
            confirmPass: {
                validator: function (value, param) {
                    var pass = $(param[0]).passwordbox('getValue');
                    return value == pass;
                },
                message: '两次密码不一样!'
            }
        });
    </script>
</head>
<body background="statics/images/login-bg.jpg"
      style=" background-repeat:no-repeat ;
              background-size:100% 100%;
              background-attachment: fixed;">
<center>
    <div style="margin:20px 0;">
        <h3>欢迎注册</h3>
    </div>
        <form id="ff" method="post" action="${pageContext.request.contextPath}/doRegister.action">
            <div style="margin-bottom:20px; width:350px">
                <input class="easyui-textbox" name="username" iconWidth="28"
                       style="width:100%;height:34px;padding:10px;"
                       data-options="label:'用户名:',required:true">
            </div>
            <div style="margin-bottom:20px; width:350px">
                <input id="pass" class="easyui-passwordbox" name="password" iconWidth="28"
                       style="width:100%;height:34px;padding:10px"
                       data-options="label:'密码:',required:true">
            </div>
            <div style="margin-bottom:20px; width:350px">
                <input class="easyui-passwordbox" iconWidth="28"
                       validType="confirmPass['#pass']"
                       style="width:100%;height:34px;padding:10px"
                       data-options="label:'确认密码:',required:true">
            </div>
            <div style="text-align:center;padding:5px 0 ">
                <button type=" submit" style="background-color:darkgreen; color: white;  width:180px; height: 30px ">
                    注册
                </button>
            </div>
        </form>
</center>
</body>
</html>
