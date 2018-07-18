$(function(){
    $.ajax({
        type:"POST",
        url: "/getCookie",
        dataType:"json",
        success:function(data){
            $("#username").val(data.username);
            $("#password").val(data.password);
            $("#rememberMe").attr("checked",true);
        },
        error:function() {
            alert("cookies 信息获取失败！");
        }
    });
});
