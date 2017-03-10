<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/18
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>java</title>
    <link rel="stylesheet" href="/css/style.css"/>
    <style>
        .n-table th,.n-table td {text-align: center}

    </style>
</head><body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            买家你好，<span class="name">${userName}</span>！<a href="/logout">[退出]</a>
        </div>
        <ul class="nav">
            <li><a href=/"">首页</a></li>
            <li><a href="/account">账务</a></li>
            <li><a href="/settleAccount">购物车</a></li>
        </ul>
    </div>
</div><div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>已购买的内容</h2>
    </div>
    <table class="m-table m-table-row n-table g-b3">
        <colgroup><col class="img"/><col/><col class="time"/><col/><col class="num"/><col/><col class="price"/><col/></colgroup>
        <thead >
        <tr><th>内容图片</th><th >标题</th><th>购买时间</th><th>购买数量</th><th>购买价格</th></tr>
        </thead>
        <tbody>
        <c:forEach items="${buyItems}" var="buyItem">
            <tr>
                <td>  <a href="/productDetail?productId=${buyItem.product.productId}&type=0"><img src="${buyItem.product.pictureURL}" alt="${buyItem.product.title}"></a></td>
                <td><h4><a href="/productDetail?productId=${buyItem.product.productId}&type=0">${buyItem.product.title}</a></h4></td>
                <td><span class="v-time">${buyItem.buyTime}</span></td>
                <td><span class="v-num">${buyItem.number}</span></td>
                <td><span class="v-unit">¥</span><span class="value">${buyItem.oldPrice}</span></td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="4"><div class="total">总计：</div></td>
            <td><span class="v-unit">¥</span><span class="value">${total}</span></td>
        </tr>
        </tfoot>
    </table>
</div>

</html>
