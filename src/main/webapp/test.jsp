<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>购物网站</title>
    <link rel="stylesheet" href="/css/style.css"/>
</head><body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            请<a href="/api/login">[登录]</a>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
        </ul>
    </div>
</div><div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
                <li class="z-sel" ><a href="/">所有内容</a></li>

            </ul>
        </div>
    </div>
    <div class="n-plist">
        <%--<ul class="f-cb" >
            <li id="p-1">
                <a href="/show?id=1" class="link">
                    <div class="img"><img src="http://www.chachaba.com/news/uploads/allimg/140512/4165_140512145433_1.jpg" alt="Java编程思想（第4版"></div>
                    <h3>Java编程思想（第4版</h3>
                    <div class="price"><span class="v-unit">¥</span><span class="v-value">1000</span></div>
                </a>

            </li>

        </ul>--%>
        <ul class="f-cb" id="plist">
            <c:forEach items="${productList}" var="product">
                <li>
                    <a href="/api/product/productDetail?id=${product.productId}" class="link">
                        <div class="img">
                            <img src="${product.pictureURL}" alt="${product.title}">
                        </div>
                        <h3>${product.title}</h3>
                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${product.price}</span>
                        </div>
                    </a>
                </li>
            </c:forEach>
        </ul>

    </div>
</div>

<script type="text/javascript" src="/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/pageIndex.js"></script>
<script type="text/javascript" src="js/preload.js"></script>
</body>
</html>