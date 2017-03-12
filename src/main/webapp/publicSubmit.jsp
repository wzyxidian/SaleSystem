<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/12
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物网站</title>
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            卖家你好，<span class="name">${userName}</span>！<a href="/logout">[退出]</a>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
            <li><a href="/public">发布</a></li>
        </ul>
    </div>
</div><div class="g-doc">
    <div class="n-result">
        <h3>发布成功！</h3>
        <p><a href="/productDetail?productId=${productId}&type=0">[查看内容]</a><a href="/">[返回首页]</a></p>
    </div>
</div>
</body>
</html>
