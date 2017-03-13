<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html >
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<title>购物网站</title>
	<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div>

<c:choose>

<c:when test="${empty userId}">
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
	<div class="m-tab m-tab-fw m-tab-simple f-cb">
		<div class="tab">
			<ul>
				<li class="z-sel" ><a href="/">所有内容</a></li>

			</ul>
		</div>
	</div>
	<div class="n-plist">
        <ul class="f-cb">
            <c:forEach items="${productList}" var="product">
                <li>
					<a href="/productDetail?productId=${product.productId}&type=0" class="link">
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
</c:when>

<c:when test="${not empty userId}">
<c:if test="${flag eq '0'}">
<div class="n-head">
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
</div>
<div class="g-doc">
	<div class="m-tab m-tab-fw m-tab-simple f-cb">
		<div class="tab">
			<ul id="tags">
				<li class="z-sel"  id="tab1" ><a href="/" >所有内容</a></li>
				<li id="tab2" ><a >未购买的内容</a></li>
			</ul>
		</div>
	</div>
	<div class="n-plist">
		<ul class="f-cb">
			<c:forEach items="${buyProducts}" var="buyProduct">
					<li class="buy">
						<a href="/productDetail?productId=${buyProduct.productId}&type=0" class="link">
							<div class="img">
								<img src="${buyProduct.pictureURL}" alt="${buyProduct.title}">
							</div>
							<h3>${buyProduct.title}</h3>
							<div class="price"><span class="v-unit">¥</span><span class="v-value">${buyProduct.price}</span>
							</div>
							<span class="had"><b>已购买</b></span>
						</a>
					</li>
			</c:forEach>
			<c:forEach items="${unbuyProducts}" var="unbuyProduct">
				<li>
					<a href="/productDetail?productId=${unbuyProduct.productId}&type=1" class="link">
						<div class="img">
							<img src="${unbuyProduct.pictureURL}" alt="${unbuyProduct.title}">
						</div>
						<h3>${unbuyProduct.title}</h3>
						<div class="price"><span class="v-unit">¥</span><span class="v-value">${unbuyProduct.price}</span>
						</div>
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
</c:if>
<c:if test="${flag eq '1'}">
<div class="n-head">
	<div class="g-doc f-cb">
		<div class="user">
			卖家你好，<span class="name">${userName}</span>！<a href="/logout">[退出]</a>
		</div>
		<ul class="nav">
			<li><a href="/">首页</a></li>
			<li><a href="/public">发布</a></li>
		</ul>
	</div>
</div>
<div class="g-doc">
	<div class="m-tab m-tab-fw m-tab-simple f-cb">
		<div class="tab">
			<ul>
				<li class="z-sel" ><a href="/">所有内容</a></li>

			</ul>
		</div>
	</div>
	<div class="n-plist" >
		<ul class="f-cb" id = "plist">
			<c:forEach items="${sellerProductList}" var="sellerProduct">
				<li id="${sellerProduct.productId}">
					<c:if test="${!saleProducts.contains(sellerProduct)}">
						<div class="u-btn u-btn-normal u-btn-xs del " data-del="20" onclick="disp_confirm(${sellerProduct.productId})">删除</div>
					</c:if>
					<a href="/productDetail?productId=${sellerProduct.productId}&type=0" class="link">
						<div class="img">
							<img src="${sellerProduct.pictureURL}" alt="${sellerProduct.title}">
						</div>
						<h3>${sellerProduct.title}</h3>
						<div class="price"><span class="v-unit">¥</span><span class="v-value">${sellerProduct.price}</span>
						</div>
						<h4>已售出${sellerProduct.saleout}件</h4>
						<c:if test="${saleProducts.contains(sellerProduct)}">
							<span class="had"><b>已售出</b></span>
						</c:if>
					</a>
				</li>
			</c:forEach>

		</ul>
	</div>
</div>

</c:if>
</c:when>

</c:choose>
<script type="text/javascript" src="/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/pageIndex.js"></script>
</body>
</html>