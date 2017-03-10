<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <title>购物网站</title>
    <link rel="stylesheet" href="/css/style.css"/>
    <script type="text/javascript">
        var url = location.href;
        var param = url.split("?");
        var errorCode = (param[1].split("="))[1];
        if(errorCode == "passwordError"){
            alert("用户名或密码错误");
            location.href = "login";
        }

        //添加用户
        function loginCheck() {
            var form = $("#loginForm")[0];
            //同var form = document.forms[0]; 获得dom对象
            form.action = "/loginCheck";
            form.method = "post";
            var pwd = form["userPassword"].value;

            form["userPassword"].value = md5(pwd) ;

            form.submit();
        }
    </script>
    <%--<script type="text/javascript">

        $(document).ready(function(){
            $("#login").click(function(){
                var name = $("#userName").val();
                var pass = md5($("#password").val());
                alert(name);
                alert(pass);
                $.ajax({
                    type:"POST",
                    url:"/loginCheck",
                    data:{userName:name,userPassword:pass},
                    success:function(data){
                        alert("成功");
                    },
                    error:function(e) {
                        alert("出错："+e);
                    }
                });
            });
            });
    </script>--%>
</head>
<body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            请<a href="/login">[登录]</a>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
        </ul>
    </div>
</div><form class="m-form m-form-ht n-login" id="loginForm" autocomplete="off" >
    <div class="fmitem">
        <label class="fmlab">用户名：</label>
        <div class="fmipt">
            <input class="u-ipt" name="userName" autofocus/>
        </div>
    </div>
    <div class="fmitem">
        <label class="fmlab">密码：</label>
        <div class="fmipt">
            <input class="u-ipt" type="password" name="userPassword" />
        </div>
    </div>
    <div class="fmitem fmitem-nolab fmitem-btn">
        <div class="fmipt">
            <button type="submit" class="u-btn u-btn-primary u-btn-lg u-btn-block" onclick="loginCheck()">登 录</button>
        </div>
    </div>
</form>


<script type="text/javascript" src="/js/md5.js"></script>
<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/pageLogin.js"></script>
</body>
</html>