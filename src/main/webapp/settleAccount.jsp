<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/10
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>java</title>
    <link rel="stylesheet" href="/css/style.css"/>

</head>
<body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            买家你好，<span class="name">${userName}</span>！<a href="/logout">[退出]</a>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
            <li><a href="/account">账务</a></li>
            <li><a href="/settleAccount">购物车</a></li>
        </ul>
    </div>
</div><div class="g-doc" id="settleAccount">
    <div class="m-tab m-tab-fw m-tab-simple f-cb" >
        <h2>已添加到购物车的内容</h2>
    </div>
    <table id="newTable" class="m-table m-table-row n-table g-b3">
        <thead >
            <tr><th>标题</th><th >数量</th><th>价格</th></tr>
        </thead>
        <tbody>
        <c:forEach items="${cartItems}" var="cartItem">
            <tr>
                <td> ${cartItem.product.title}</td>
                <td><span id="plusNum" class="lessNum"><a>-</a></span><span class="totalNum" id="allNum">${cartItem.keepNumber}</span><span id="addNum" class="moreNum"><a>+</a></span></td>
                <td>${cartItem.product.price}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    <div id="act-btn"><button class="u-btn u-btn-primary" id="back" >退出</button>
        <button class="u-btn u-btn-primary" id="Account" onclick="cart_buy()">购买</button></div>
</div>

<script type="text/javascript" src="/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="js/pageAccount.js"></script>
</body>
</html>