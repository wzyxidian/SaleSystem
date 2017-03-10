<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/18
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>购物网站</title>
    <link rel="stylesheet" href="/css/style.css"/>
</head><body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div>
<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            请<a href="/login">[登录]</a>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
        </ul>
    </div>
</div>
<div class="g-doc">
    <div class="n-show f-cb" id="showContent">
        <div class="img"><img src="${productDetail.pictureURL}" alt=${productDetail.title} ></div>
        <div class="cnt">
            <h2>${productDetail.title}</h2>
            <p class="summary">${productDetail.abstracts}</p>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value">${productDetail.price}</span>
            </div>
            <div class="num">购买数量：<span id="plusNum" class="lessNum"><a>-</a></span><span class="totalNum" id="allNum">0</span><span id="addNum" class="moreNum"><a>+</a></span></div>
            <div class="oprt f-cb"></div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>

    <div class="n-detail">
        ${productDetail.detail}
    </div>
</div>

<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/pageShow.js"></script>
</body>
</html>
