<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/18
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>java</title>
    <link rel="stylesheet" href="/css/style.css"/>
</head><body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            买家你好，<span class="name"></span>！<a href="/logout">[退出]</a>
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
        <thead>
        <tr><th>内容图片</th><th>内容名称</th><th>购买时间</th><th>购买数量</th><th>购买价格</th></tr>
        </thead>
        <tbody>
        <tr>
            <td><a href="/show?id=1"><img src="http://img3.redocn.com/tupian/20150430/mantenghuawenmodianshiliangbeijing_3924704.jpg" alt=""></a></td>
            <td><h4><a href="/show?id=1">Java编程思想（第4版</a></h4></td>
            <td><span class="v-time">2016-07-07 15:14</span></td>
            <td><span class="v-num">0</span></td>
            <td><span class="v-unit">¥</span><span class="value">1</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=3"><img src="http://img0.imgtn.bdimg.com/it/u=439703642,1976553916&fm=23&gp=0.jpg" alt=""></a></td>
            <td><h4><a href="/show?id=3">bbbb</a></h4></td>
            <td><span class="v-time">2017-02-07 05:31</span></td>
            <td><span class="v-num">1</span></td>
            <td><span class="v-unit">¥</span><span class="value">1</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=2"><img src="http://www.chachaba.com/news/uploads/allimg/140512/4165_140512145433_1.jpg" alt=""></a></td>
            <td><h4><a href="/show?id=2">百度1</a></h4></td>
            <td><span class="v-time">2017-02-07 05:54</span></td>
            <td><span class="v-num">1</span></td>
            <td><span class="v-unit">¥</span><span class="value">113.56</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=4"><img src="http://img3.redocn.com/tupian/20150430/mantenghuawenmodianshiliangbeijing_3924704.jpg" alt=""></a></td>
            <td><h4><a href="/show?id=4">asdasd</a></h4></td>
            <td><span class="v-time">2017-02-07 06:53</span></td>
            <td><span class="v-num">7</span></td>
            <td><span class="v-unit">¥</span><span class="value">100</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=5"><img src="http://pic.weifengke.com/attachments/1/1441/74c5afcb1b549cd8ab68184b57280d07.jpg" alt=""></a></td>
            <td><h4><a href="/show?id=5">sdasda</a></h4></td>
            <td><span class="v-time">2017-02-07 09:24</span></td>
            <td><span class="v-num">38</span></td>
            <td><span class="v-unit">¥</span><span class="value">100</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=6"><img src="http://img1.selfimg.com.cn/uedselfcms/2015/04/15/1429096246_wagmrK.jpg" alt=""></a></td>
            <td><h4><a href="/show?id=6">asdas</a></h4></td>
            <td><span class="v-time">2017-02-07 09:52</span></td>
            <td><span class="v-num">43</span></td>
            <td><span class="v-unit">¥</span><span class="value">100</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=8"><img src="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1736635811,2312695723&fm=11&gp=0.jpg" alt=""></a></td>
            <td><h4><a href="/show?id=8">2333</a></h4></td>
            <td><span class="v-time">2017-02-07 12:51</span></td>
            <td><span class="v-num">1</span></td>
            <td><span class="v-unit">¥</span><span class="value">9999</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=7"><img src="http://pic.weifengke.com/attachments/1/1441/74c5afcb1b549cd8ab68184b57280d07.jpg" alt=""></a></td>
            <td><h4><a href="/show?id=7">asdasd</a></h4></td>
            <td><span class="v-time">2017-02-07 13:51</span></td>
            <td><span class="v-num">1</span></td>
            <td><span class="v-unit">¥</span><span class="value">100</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=9"><img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1486486847236&di=96fd50b47dd1e827afe175c906e0bb7d&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F15%2F01%2F86%2F60V58PICF8v_1024.jpg" alt=""></a></td>
            <td><h4><a href="/show?id=9">awdawdawd</a></h4></td>
            <td><span class="v-time">2017-02-07 14:14</span></td>
            <td><span class="v-num">5</span></td>
            <td><span class="v-unit">¥</span><span class="value">500</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=11"><img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1486493942407&di=c67fb67a4122538065346b2282d7f44e&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D1438554478%2C3296160551%26fm%3D214%26gp%3D0.jpg" alt=""></a></td>
            <td><h4><a href="/show?id=11">佳洁士牙膏1-编辑更新</a></h4></td>
            <td><span class="v-time">2017-02-07 16:21</span></td>
            <td><span class="v-num">2</span></td>
            <td><span class="v-unit">¥</span><span class="value">11.9</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=10"><img src="http://pic2.cxtuku.com/00/02/31/b945758fd74d.jpg" alt=""></a></td>
            <td><h4><a href="/show?id=10">12</a></h4></td>
            <td><span class="v-time">2017-02-08 09:21</span></td>
            <td><span class="v-num">0</span></td>
            <td><span class="v-unit">¥</span><span class="value">-10</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=12"><img src="http://yanxuan.nosdn.127.net/9c8a9b5d91bfdb770a5a391d7fa89470.png" alt=""></a></td>
            <td><h4><a href="/show?id=12">item</a></h4></td>
            <td><span class="v-time">2017-02-09 11:48</span></td>
            <td><span class="v-num">0</span></td>
            <td><span class="v-unit">¥</span><span class="value">10</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=15"><img src="test" alt=""></a></td>
            <td><h4><a href="/show?id=15">test</a></h4></td>
            <td><span class="v-time">2017-02-09 14:45</span></td>
            <td><span class="v-num">2</span></td>
            <td><span class="v-unit">¥</span><span class="value">1.23</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=14"><img src="http://yanxuan.nosdn.127.net/9c8a9b5d91bfdb770a5a391d7fa89470.png?imageView&quality=90&thumbnail=430x430" alt=""></a></td>
            <td><h4><a href="/show?id=14">ddd</a></h4></td>
            <td><span class="v-time">2017-02-11 05:23</span></td>
            <td><span class="v-num">2</span></td>
            <td><span class="v-unit">¥</span><span class="value">12</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=13"><img src="http://pic.weifengke.com/attachments/1/1441/74c5afcb1b549cd8ab68184b57280d07.jpg" alt=""></a></td>
            <td><h4><a href="/show?id=13">http://pic.weifengke.com/attachments/1/1441/74c5afcb1b549cd8ab68184b57280d07.jpg</a></h4></td>
            <td><span class="v-time">2017-02-11 08:13</span></td>
            <td><span class="v-num">12</span></td>
            <td><span class="v-unit">¥</span><span class="value">1.24</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=16"><img src="https://pimg.dmcdn.cn/perform/project/1169/116951_n.jpg" alt=""></a></td>
            <td><h4><a href="/show?id=16">五月天LiFE世界巡回演唱会</a></h4></td>
            <td><span class="v-time">2017-02-12 03:59</span></td>
            <td><span class="v-num">12</span></td>
            <td><span class="v-unit">¥</span><span class="value">555</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=17"><img src="http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84&step_word=&hs=0&pn=1&spn=0&di=18091821550&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=932966122%2C1720962512&os=80624769%2C1487970879&simid=0%2C0&adpicid=0&lpn=0&ln=1965&fr=&fmq=1487071759148_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fimg10.360buyimg.com%2Fn0%2Fg12%2FM00%2F08%2F00%2FrBEQYFNLdRYIAAAAAAClgfIXdXoAAEY2gPWUm4AAKWZ103.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3B31_z%26e3Bv54AzdH3Fkt2t4w2j_z%26e3Bwfrx%3Ft1%3D88ddbcana9&gsm=0&rpstart=0&rpnum=0" alt=""></a></td>
            <td><h4><a href="/show?id=17">数据结构</a></h4></td>
            <td><span class="v-time">2017-02-14 11:38</span></td>
            <td><span class="v-num">8</span></td>
            <td><span class="v-unit">¥</span><span class="value">10</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=18"><img src="12" alt=""></a></td>
            <td><h4><a href="/show?id=18">123</a></h4></td>
            <td><span class="v-time">2017-02-15 06:39</span></td>
            <td><span class="v-num">5</span></td>
            <td><span class="v-unit">¥</span><span class="value">22</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=19"><img src="333" alt=""></a></td>
            <td><h4><a href="/show?id=19">123</a></h4></td>
            <td><span class="v-time">2017-02-15 09:06</span></td>
            <td><span class="v-num">5</span></td>
            <td><span class="v-unit">¥</span><span class="value">12112</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=20"><img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1486493942407&di=c67fb67a4122538065346b2282d7f44e&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D1438554478%2C3296160551%26fm%3D214%26gp%3D0.jpg" alt=""></a></td>
            <td><h4><a href="/show?id=20">佳洁士牙膏1-编辑更新3333</a></h4></td>
            <td><span class="v-time">2017-02-16 12:30</span></td>
            <td><span class="v-num">0</span></td>
            <td><span class="v-unit">¥</span><span class="value">22</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=21"><img src="11" alt=""></a></td>
            <td><h4><a href="/show?id=21">11</a></h4></td>
            <td><span class="v-time">2017-02-17 08:03</span></td>
            <td><span class="v-num">9</span></td>
            <td><span class="v-unit">¥</span><span class="value">1</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=22"><img src="http://img1.imgtn.bdimg.com/it/u=3144465310,4114570573&fm=23&gp=0.jpg" alt=""></a></td>
            <td><h4><a href="/show?id=22">heiheih</a></h4></td>
            <td><span class="v-time">2017-02-17 14:02</span></td>
            <td><span class="v-num">9</span></td>
            <td><span class="v-unit">¥</span><span class="value">100</span></td>
        </tr>
        <tr>
            <td><a href="/show?id=24"><img src="http://www.chinairn.com/UserFiles/image/20161229/20161229103748_3222.jpg" alt=""></a></td>
            <td><h4><a href="/show?id=24">iphone7</a></h4></td>
            <td><span class="v-time">2017-02-18 10:14</span></td>
            <td><span class="v-num">9</span></td>
            <td><span class="v-unit">¥</span><span class="value">6000</span></td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="4"><div class="total">总计：</div></td>
            <td><span class="v-unit">¥</span><span class="value">29862.93</span></td>
        </tr>
        </tfoot>
    </table>
</div>

</html>
