<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/29
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath %>">
    <title>订单详情</title>
    <!--网页标题左侧显示-->
    <link rel="icon" href="images/computer.png" rel="icon">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link rel="stylesheet" href="css/icon/iconfont.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $(".dropdown img.flag").addClass("flagvisibility");

            $(".dropdown dt a").click(function() {
                $(".dropdown dd ul").toggle();
            });

            $(".dropdown dd ul li a").click(function() {
                var text = $(this).html();
                $(".dropdown dt a span").html(text);
                $(".dropdown dd ul").hide();
                $("#result").html("Selected value is: " + getSelectedValue("sample"));
            });

            function getSelectedValue(id) {
                return $("#" + id).find("dt a span.value").html();
            }

            $(document).bind('click', function(e) {
                var $clicked = $(e.target);
                if (! $clicked.parents().hasClass("dropdown"))
                    $(".dropdown dd ul").hide();
            });


            $("#flagSwitcher").click(function() {
                $(".dropdown img.flag").toggleClass("flagvisibility");
            });

            $("#search-text").focus(function () {
                $("#hot-words").hide();
            });
            $("#search-text").blur(function () {
                if ($("#search-text").val() == "" || $("#search-text").val().length == 0 ){
                    $("#hot-words").show();
                }else{
                    $("#hot-words").hide();
                }
            });

        });
    </script>
    <!-- start menu -->
    <link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="js/megamenu.js"></script>
    <script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
    <!-- end menu -->
    <!-- top scrolling -->
    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
            $(".scroll").click(function(event){
                event.preventDefault();
                $('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
            });
        });
    </script>
</head>
<body>
<div class="header-top">
    <div class="wrap">
        <div class="logo">
            <a href="">网上购物商城</a>
        </div>
        <div class="cssmenu">
            <ul>
                <c:if test="${!empty sessionScope.user}">
                    <li class="active"><a href="user/showUserInfo">${sessionScope.user.userName}</a></li>
                </c:if>
                <c:if test="${empty sessionScope.user}">
                    <li class="active"><a href="user/registerPrompt">注册</a></li>
                </c:if>
                <c:if test="${empty sessionScope.user}">
                    <li class="active"><a href="user/loginPrompt">登录</a></li>
                </c:if>
                <c:if test="${!empty sessionScope.user}">
                    <li class="active"><a href="user/logout">退出登录</a></li>
                </c:if>
                <li><a href="cart/user/myCart">购物车</a></li>
                <li><a href="order/user/myOrder">我的订单</a></li>
            </ul>
        </div>
        <div class="header-search">
            <form id="search-form" action="goods/searchGoods"  method="get">
                <input id="search-text" class="search-text" type="search" id="search" name="goodsName">
                <div class="hot_words" id="hot-words">
                    <a href="goods/searchGoods?goodsName=手机" id="hot_1">手机</a>
                    <a href="goods/searchGoods?goodsName=笔记本"  id="hot_2">笔记本电脑</a>
                </div>
                <input class="search-btn iconfont"  type="submit" name="" value="&#xe60b;">
            </form>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="header-bottom">
    <div class="wrap">
        <!-- start header menu -->
        <ul class="megamenu skyblue">
            <li><a class="color1" href="">主 页</a></li>
            <li class="grid"><a class="color2" href="goods/searchGoods?goodsName=手机">手机</a>
                <div class="megapanel">
                    <div class="row">
                        <div class="col1">
                            <div class="h_nav">
                                <h4>iphone手机</h4>
                                <ul>
                                    <li><a href="goods/showDetails/11" target="_blank">iPhone Xs</a></li>
                                    <li><a href="goods/showDetails/13" target="_blank">iPhone X</a></li>
                                    <li><a href="goods/showDetails/14" target="_blank">iPhone 8</a></li>
                                </ul>
                            </div>
                            <div class="h_nav">
                                <h4 class="top">华为手机</h4>
                                <ul>
                                    <li><a href="goods/showDetails/16" target="_blank">华为畅玩</a></li>
                                    <li><a href="goods/showDetails/17" target="_blank">华为麦芒</a></li>
                                    <li><a href="goods/showDetails/15" target="_blank">华为荣耀系列</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col1">
                            <div class="h_nav">
                                <h4>小米手机</h4>
                                <ul>
                                    <li><a href="goods/showDetails/1" target="_blank">小米 8</a></li>
                                    <li><a href="goods/showDetails/2" target="_blank">小米Mix</a></li>
                                    <li><a href="goods/showDetails/8" target="_blank">小米Max</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col1"></div>
                        <div class="col1"></div>
                        <div class="col1"></div>
                        <div class="col1"></div>
                        <img src="images/IPhone_XS.png" alt=""/>
                    </div>
                </div>
            </li>
            <li class="active grid"><a class="color4" href="goods/searchGoods?goodsName=电视">电视</a>
                <div class="megapanel">
                    <div class="row">
                        <div class="col1">
                            <div class="h_nav">
                                <h4>小米电视</h4>
                                <ul>
                                    <li><a href="goods/showDetails/3" target="_blank">小米电视4A 43英寸青春版</a></li>
                                    <li><a href="goods/showDetails/9" target="_blank">小米电视4C 50英寸</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col1">
                            <div class="h_nav">
                                <h4>索尼电视</h4>
                                <ul>
                                    <li><a href="goods/showDetails/23" target="_blank">索尼KD-55A9F</a></li>
                                    <li><a href="goods/showDetails/21" target="_blank">索尼KD-65Z9F</a></li>
                                    <li><a href="goods/showDetails/22" target="_blank">索尼KDL-32W600D</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col1">
                            <div class="h_nav">
                                <h4>飞利浦电视</h4>
                                <ul>
                                    <li><a href="goods/showDetails/29" target="_blank">飞利浦电视50PUF6152/T3 50英寸</a></li>
                                    <li><a href="goods/showDetails/30" target="_blank">飞利浦电视49PUF6031/T3 49英寸</a></li>
                                    <li><a href="goods/showDetails/31" target="_blank">飞利浦电视65PUF6372/T3 65英寸</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col1">
                            <div class="h_nav">
                                <img src="images/samsung.jpg" alt=""/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col2"></div>
                        <div class="col1"></div>
                        <div class="col1"></div>
                        <div class="col1"></div>
                        <div class="col1"></div>
                    </div>
                </div>
            </li>
            <li><a class="color5" href="goods/searchGoods?goodsName=笔记本">笔记本</a>
                <div class="megapanel">
                    <div class="row">
                        <div class="col1">
                            <div class="h_nav">
                                <h4>Mac笔记本</h4>
                                <ul>
                                    <li><a href="goods/showDetails/71" target="_blank">MacBook</a></li>
                                    <li><a href="goods/showDetails/71" target="_blank">MacBook Air (13 英寸)</a></li>
                                    <li><a href="goods/showDetails/71" target="_blank">MacBook Pro (13 英寸)</a></li>
                                    <li><a href="goods/showDetails/71" target="_blank">iMac (21.5 英寸)</a></li>
                                    <li><a href="goods/showDetails/71" target="_blank">Mac mini</a></li>
                                </ul>
                            </div>
                            <div class="h_nav">
                                <h4 class="top">戴尔笔记本</h4>
                                <ul>
                                    <li><a href="goods/showDetails/33" target="_blank">Dell/戴尔笔记本 G3 GTX1050</a></li>
                                    <li><a href="goods/showDetails/35" target="_blank">Dell/戴尔笔记本inspiron灵越14E-3476</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col1">
                            <div class="h_nav">
                                <h4>华硕笔记本</h4>
                                <ul>
                                    <li><a href="goods/showDetails/36" target="_blank">华硕笔记本顽石(ASUS) 五代FL8000UF</a></li>
                                    <li><a href="goods/showDetails/37" target="_blank">华硕笔记本(ASUS) 灵耀S</a></li>
                                    <li><a href="goods/showDetails/38" target="_blank">华硕笔记本(ASUS) 飞行堡垒5</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col1"></div>
                        <div class="col1"></div>
                        <div class="col1"></div>
                        <div class="col1"></div>
                        <img src="images/MaxBook.jpg" alt=""/>
                    </div>
                </div>
            </li>
            <li><a class="color6" href="goods/searchGoods?goodsName=空调">空调</a>
                <div class="megapanel">
                    <div class="row">
                        <div class="col1">
                            <div class="h_nav">
                                <h4>海尔空调</h4>
                                <ul>
                                    <li><a href="goods/showDetails/42" target="_blank">帝樽CB系列3匹变频柜式空调</a></li>
                                    <li><a href="goods/showDetails/43" target="_blank">智享系列2匹变频柜式空调</a></li>
                                    <li><a href="goods/showDetails/44" target="_blank">天樽3匹变频柜式空调</a></li>
                                </ul>
                            </div>
                            <div class="h_nav">
                                <h4 class="top">格力空调</h4>
                                <ul>
                                    <li><a href="goods/showDetails/45" target="_blank">格力(GREE)正1.5匹  壁挂式空调</a></li>
                                    <li><a href="goods/showDetails/46" target="_blank">格力(GREE)立式定频单冷静音空调</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col1">
                            <div class="h_nav">
                                <h4>美的空调</h4>
                                <ul>
                                    <li><a href="goods/showDetails/47" target="_blank">美的(Midea)1.5匹 静音壁挂式空调</a></li>
                                    <li><a href="goods/showDetails/48" target="_blank">美的(Midea)3匹立式空调柜机</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col1">
                            <div class="h_nav">
                                <h4>三菱电机</h4>
                                <ul>
                                    <li><a href="goods/showDetails/49" target="_blank">三菱电机 1.5匹 壁挂式空调</a></li>
                                    <li><a href="goods/showDetails/50" target="_blank">三菱电机 3匹 立柜式空调</a></li>
                                </ul>
                            </div>
                        </div>
                        <img src="images/air_conditioner.jpg" style="float: right; display: inline-block;top: 0;" alt=""/>
                    </div>
                    <div class="row">
                        <div class="col2"></div>
                        <div class="col1"></div>
                        <div class="col1"></div>
                        <div class="col1"></div>
                        <div class="col1"></div>
                    </div>
                </div>
            </li>
            <li><a class="color7" href="#">新品</a>
            </li>
            <li><a class="color8" href="goods/searchGoods?goodsName=路由器">路由器</a>
            </li>
            <li><a class="color9" href="#">智能硬件</a>
            </li>
            <li><a class="color10" href="#">服务</a></li>
            <li><a class="color11" href="#">社区</a></li>
        </ul>
        <div class="clear"></div>
    </div>
</div>
<div class="login">
    <div class="wrap">
        <h4 class="title">订单详情</h4>
        <div style="margin-bottom: 10px;">
            <p style="float: left;margin-left: 10px; margin-right: 20px;">订单号 : ${sessionScope.orderNumber}</p>
            <p style="float: left;margin-left: 20px; margin-right: 20px;">订单创建时间 : <fmt:formatDate value="${sessionScope.orderCreateTime}" pattern="yyyy/MM/dd hh:mm:ss aa" /></p>
            <p style="float: left;margin-left: 10px; margin-right: 20px;">收货地址 : ${sessionScope.user.address}</p>
            <div class="clear"></div>
        </div>
        <c:forEach items="${sessionScope.orderItemBodyLists}" var="orderItem">
            <div style="border:1px solid #000;">
                    <img  src="${orderItem.goods.goodsImage}" style="width: 220px;height: 220px;float: left;"></img>
                    <p style="float: left;margin-left: 20px; margin-right: 20px;margin-top: 98px;"><a href="goods/showDetails/${orderItem.goods.goodsId}" target="_blank">${orderItem.goods.goodsName}</a> </p>
                    <p class="price" style="float: left;margin-left: 20px; margin-right: 10px;margin-top: 98px;">价格:      <span class="priceDetail">${orderItem.goods.goodsPrice}</span>元</p>
                    <p style="float: left;margin-left: 20px;margin-top: 98px;">商品数量 :</p>
                    <p style="float: left;margin-left: 20px;margin-top: 98px;">${orderItem.goodsSum}件</p>
                <p style="float: left;margin-left: 60px;margin-top: 98px;color: red;">单项商品总金额:   <span>${orderItem.singleGoodsPrice}元</span></p>
                    <div class="clear"></div>
            </div>
        </c:forEach>
        <div class="clear"></div>
        <div>
            <p class="totalPrice" style="float: right;margin-left: 20px; margin-right: 10px;color: #bd081c;font-size: 18px;margin-top:15px;">商品总价:        ${totalPrice}元</p>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="footer">
    <div class="footer-top">
        <div class="wrap">
            <div class="col_1_of_footer-top span_1_of_footer-top">
                <ul class="f_list">
                    <li><img src="images/f_icon.png" alt=""/><span class="delivery">购买超过100元商品免运费</span></li>
                </ul>
            </div>
            <div class="col_1_of_footer-top span_1_of_footer-top">
                <ul class="f_list">
                    <li><img src="images/f_icon1.png" alt=""/><span class="delivery">顾客服务 :<span class="orange"> (800) 000-2587 (freephone)</span></span></li>
                </ul>
            </div>
            <div class="col_1_of_footer-top span_1_of_footer-top">
                <ul class="f_list">
                    <li><img src="images/f_icon2.png" alt=""/><span class="delivery">快速送达</span></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="footer-middle">
        <div class="wrap">
            <div class="section group">
                <div class="col_1_of_middle span_1_of_middle">

                </div>
                <div class="col_1_of_middle span_1_of_middle">
                    <ul class="f_list1">
                        <div id="response"> </div>
                </div><div class="clear"></div>
                </li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<div class="footer-bottom">
    <div class="wrap">
        <div class="section group">
            <div class="col_1_of_5 span_1_of_5">
                <h3 class="m_9">手机</h3>
                <ul class="sub_list">
                    <h4 class="m_10">EMUI</h4>
                    <li><a href="goods/searchGoods?goodsName=手机">华为手机</a></li>
                </ul>
                <ul class="sub_list">
                    <h4 class="m_10">MIUI</h4>
                    <li><a href="goods/searchGoods?goodsName=手机">小米手机</a></li>
                </ul>
                <ul class="sub_list">
                    <h4 class="m_10">ios</h4>
                    <li><a href="goods/searchGoods?goodsName=手机">苹果手机</a></li>
                </ul>
            </div>
            <div class="col_1_of_5 span_1_of_5">
                <h3 class="m_9">电脑</h3>
                <ul class="list1">
                    <li><a href="goods/searchGoods?goodsName=电脑">笔记本电脑</a></li>
                    <li><a href="goods/searchGoods?goodsName=电脑">台式电脑</a></li>
                </ul>
            </div>
            <div class="col_1_of_5 span_1_of_5">
                <h3 class="m_9">电视</h3>
                <ul class="list1">
                    <li><a href="goods/searchGoods?goodsName=电视">液晶电视</a></li>
                    <li><a href="goods/searchGoods?goodsName=电视">普通电视</a></li>

                </ul>
            </div>
            <div class="col_1_of_5 span_1_of_5">
                <h3 class="m_9">其他产品</h3>
                <ul class="list1">
                    <li><a href="goods/searchGoods?goodsName=空调">空调</a></li>
                    <li><a href="goods/searchGoods?goodsName=路由器">路由器</a></li>
                </ul>
            </div>
            <div class="col_1_of_5 span_1_of_5">
                <h3 class="m_9">支持</h3>
                <ul class="list1">
                    <li><a href="#">客户服务</a></li>
                </ul>
                <ul class="sub_list2">
                    <h4 class="m_10">公司信息</h4>
                    <li><a href="#">关于我们</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<div class="copy">
    <div class="wrap">
        <p>Copyright &copy; 2018.Company name All rights reserved. <a href="#" target="_blank" title="网上商城管理系统">网上商城管理系统</a>
    </div>
</div>
</div>
<script type="text/javascript">
    $(document).ready(function() {

        var defaults = {
            containerID: 'toTop', // fading element id
            containerHoverID: 'toTopHover', // fading element hover id
            scrollSpeed: 1200,
            easingType: 'linear'
        };

        $().UItoTop({easingType: 'easeOutQuart'});

        $("#cancelSubmit").click(function () {
            $("#cancelForm").submit();
        });

        $("#confirmSubmit").click(function () {
            $("#confirmForm").submit();
        });

    });
</script>
<a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>

</body>
</html>
