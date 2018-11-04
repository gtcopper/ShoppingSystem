<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/29
  Time: 18:43
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set value="<%=path%>" var="path" />
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath %>">
    <title>网上购物商城</title>
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
            // $("#cartForm").click(function(){
            //     $("#btnSubmit").submit();
            // });

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
            <li><a class="color8"  href="goods/searchGoods?goodsName=路由器">路由器</a>
            </li>
            <li><a class="color9" href="#">智能硬件</a>
            </li>
            <li><a class="color10" href="#">服务</a></li>
            <li><a class="color11" href="#">社区</a></li>
        </ul>
        <div class="clear"></div>
    </div>
</div>
<div class="index-banner">
    <div class="wmuSlider example1" style="height: 560px;">
        <div class="wmuSliderWrapper">
            <article style="position: relative; width: 100%; opacity: 1;">
                <div class="banner-wrap">
                    <div class="slider-left">
                        <img src="images/ipad.jpg" alt="荣耀畅玩平板"/>
                    </div>
                    <div class="slider-right">
                        <h1>Honour</h1>
                        <h2>Black</h2>
                        <p>荣耀畅玩平板2 9.6英寸WiFi版（苍穹灰）</p>
                        <div class="btn"><a href="goods/showDetails/7" target="_blank">Shop Now</a></div>
                    </div>
                    <div class="clear"></div>
                </div>
            </article>
            <article style="position: absolute; width: 100%; opacity: 0;">
                <div class="banner-wrap">
                    <div class="slider-left">
                        <img src="images/max2.jpg" style="height: 430px;" alt="小米Max2"/>
                    </div>
                    <div class="slider-right">
                        <h1>Max2</h1>
                        <h2>White</h2>
                        <p>6.44''大屏 / 5300mAh 充电宝级的大电量 / 大像素相机 / 轻薄全金属 / ​4GB 大内存 / 骁龙八核处理器</p>
                        <div class="btn"><a href="goods/showDetails/8" target="_blank">Shop Now</a></div>
                    </div>
                    <div class="clear"></div>
                </div>
            </article>
            <article style="position: absolute; width: 100%; opacity: 0;">
                <div class="banner-wrap">
                    <div class="slider-left">
                        <img src="images/miTV.jpg" style="width: 622px;height: 430px;" alt="小米TV"/>
                    </div>
                    <div class="slider-right">
                        <h1>Mi4c</h1>
                        <h2>Gray</h2>
                        <p>小米电视4C 50英寸</p>
                        <div class="btn"><a href="goods/showDetails/9" target="_blank">Shop Now</a></div>
                    </div>
                    <div class="clear"></div>
                </div>
            </article>
            <article style="position: absolute; width: 100%; opacity: 0;">
                <div class="banner-wrap">
                    <div class="slider-left">
                        <img src="images/air_conditioner.jpg" style="height: 430px;" alt="格力空调"/>
                    </div>
                    <div class="slider-right">
                        <h1>Gree</h1>
                        <h2>White</h2>
                        <p>美的（Midea）省电星大1匹二级能效冷暖壁挂式</p>
                        <div class="btn"><a href="goods/showDetails/10" target="_blank">Shop Now</a></div>
                    </div>
                    <div class="clear"></div>
                </div>
            </article>
            <article style="position: absolute; width: 100%; opacity: 0;">
                <div class="banner-wrap">
                    <div class="slider-left">
                        <img src="images/router.png" style="width: 622px;height: 430px;" alt="路由器"/>
                    </div>
                    <div class="slider-right">
                        <h1>Classic</h1>
                        <h2>Black</h2>
                        <p>WIFI 路由器| 网络| 产品| 家用| NETGEAR</p>
                        <div class="btn"><a href="goods/showDetails/12" target="_blank">Shop Now</a></div>
                    </div>
                    <div class="clear"></div>
                </div>
            </article>
        </div>
        <a class="wmuSliderPrev">Previous</a><a class="wmuSliderNext">Next</a>
        <ul class="wmuSliderPagination">
            <li><a href="#" class="">0</a></li>
            <li><a href="#" class="">1</a></li>
            <li><a href="#" class="wmuActive">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
        </ul>
        <a class="wmuSliderPrev">Previous</a><a class="wmuSliderNext">Next</a><ul class="wmuSliderPagination"><li><a href="#" class="wmuActive">0</a></li><li><a href="#" class="">1</a></li><li><a href="#" class="">2</a></li><li><a href="#" class="">3</a></li><li><a href="#" class="">4</a></li></ul></div>
    <script src="js/jquery.wmuSlider.js"></script>
    <%--<script type="text/javascript" src="js/modernizr.custom.min.js"></script>--%>
    <script>
        $('.example1').wmuSlider();
    </script>
</div>
<div class="main">
    <div class="wrap">
        <div class="content-top">
            <div class="lsidebar span_1_of_c1">
                <p>您可以分享您感兴趣的商品给朋友</p>
            </div>
            <div class="cont span_2_of_c1">
                <div class="social">
                    <ul>
                        <li class="facebook"><a href="javascript:void(0);"><span> </span></a><div class="radius"> <img src="images/radius.png"><a href="#"> </a></div><div class="border hide"><p class="num">1.51K</p></div></li>
                    </ul>
                </div>
                <div class="social">
                    <ul>
                        <li class="twitter"><a href="javascript:void(0);"><span> </span></a><div class="radius"> <img src="images/radius.png"></div><div class="border hide"><p class="num">1.51K</p></div></li>
                    </ul>
                </div>
                <div class="social">
                    <ul>
                        <li class="google"><a href="javascript:void(0);"><span> </span></a><div class="radius"> <img src="images/radius.png"></div><div class="border hide"><p class="num">1.51K</p></div></li>
                    </ul>
                </div>
                <div class="social">
                    <ul>
                        <li class="dot"><a href="javascript:void(0);"><span> </span></a><div class="radius"> <img src="images/radius.png"></div><div class="border hide"><p class="num">1.51K</p></div></li>
                    </ul>
                </div>
                <div class="clear"> </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="content-bottom">
            <div class="box1">
                <div class="col_1_of_3 span_1_of_3">
                    <div class="view view-fifth">
                        <div class="top_box">
                            <h3 class="m_1">小米8 青春版</h3>
                            <p class="m_2"> 4GB+6</p>
                            <a href="goods/showDetails/1" target="_blank">
                            <div class="grid_img">
                                <div class="css3"><img src="images/mi8_youth.jpg" alt=""/></div>
                                <div class="mask">
                                    <div class="info">Quick View</div>
                                </div>
                            </div>
                            </a>
                            <div class="price">1399元</div>
                        </div>
                    </div>
                    <span class="rating">
				        <input type="radio" class="rating-input" id="rating-input-1-5" name="rating-input-1">
				        <label for="rating-input-1-5" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-4" name="rating-input-1">
				        <label for="rating-input-1-4" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-3" name="rating-input-1">
				        <label for="rating-input-1-3" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-2" name="rating-input-1">
				        <label for="rating-input-1-2" class="rating-star"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-1" name="rating-input-1">
				        <label for="rating-input-1-1" class="rating-star"></label>&nbsp;
		        	  (45)
		    	      </span>
                        <ul class="list">
                            <li>
                                <ul class="icon1 sub-icon1 profile_img">
                                    <li>
                                        <form id="cartForm1" style="margin-left: 33px;" action="cart/addToCart" method="post">
                                            <input type="hidden" name="goodsSum" value="1"/>
                                            <input type="hidden" name="goodsId" value="1">
                                            <button id="btnSubmit1" type="button" class="grey2">
                                                加入购物车
                                            </button>
                                        </form>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    <div class="clear"></div>
                </div>
                <div class="col_1_of_3 span_1_of_3">
                    <div class="view view-fifth">
                        <div class="top_box">
                            <h3 class="m_1">小米MIX 2 </h3>
                            <p class="m_2">全陶瓷尊享版</p>
                            <a href="goods/showDetails/2" target="_blank">
                            <div class="grid_img">
                                <div class="css3"><img src="images/mi_mix2.jpg" alt=""/></div>
                                <div class="mask">
                                    <div class="info">Quick View</div>
                                </div>
                            </div>
                            </a>
                            <div class="price">2699元</div>
                        </div>
                    </div>
                    <span class="rating">
				        <input type="radio" class="rating-input" id="rating-input-1-5" name="rating-input-1">
				        <label for="rating-input-1-5" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-4" name="rating-input-1">
				        <label for="rating-input-1-4" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-3" name="rating-input-1">
				        <label for="rating-input-1-3" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-2" name="rating-input-1">
				        <label for="rating-input-1-2" class="rating-star"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-1" name="rating-input-1">
				        <label for="rating-input-1-1" class="rating-star"></label>&nbsp;
		        	  (45)
		    	      </span>
                    <ul class="list">
                        <li>
                            <ul class="icon1 sub-icon1 profile_img">
                                <li>
                                    <form id="cartForm2"  style="margin-left: 33px;" action="cart/addToCart" method="post">
                                        <input type="hidden" name="goodsSum" value="1"/>
                                        <input type="hidden" name="goodsId" value="2">
                                        <button id="btnSubmit2" type="button" class="grey2">
                                        加入购物车
                                        </button>
                                    </form>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <div class="clear"></div>
                </div>
                <div class="col_1_of_3 span_1_of_3">
                    <div class="view view-fifth">
                        <div class="top_box">
                            <h3 class="m_1">小米电视4A </h3>
                            <p class="m_2">43英寸青春版</p>
                            <a href="goods/showDetails/3" target="_blank">
                            <div class="grid_img">
                                <div class="css3"><img src="images/mi_4a.jpg" alt=""/></div>
                                <div class="mask">
                                    <div class="info">Quick View</div>
                                </div>
                            </div>
                            </a>
                            <div class="price">1499元</div>
                        </div>
                    </div>
                    <span class="rating">
				        <input type="radio" class="rating-input" id="rating-input-1-5" name="rating-input-1">
				        <label for="rating-input-1-5" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-4" name="rating-input-1">
				        <label for="rating-input-1-4" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-3" name="rating-input-1">
				        <label for="rating-input-1-3" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-2" name="rating-input-1">
				        <label for="rating-input-1-2" class="rating-star"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-1" name="rating-input-1">
				        <label for="rating-input-1-1" class="rating-star"></label>&nbsp;
		        	  (45)
		    	      </span>
                    <ul class="list">
                        <li>
                            <ul class="icon1 sub-icon1 profile_img">
                                <li>
                                    <form id="cartForm3"  style="margin-left: 33px;" action="cart/addToCart" method="post">
                                        <input type="hidden" name="goodsSum" value="1"/>
                                        <input type="hidden" name="goodsId" value="3">
                                        <button id="btnSubmit3" type="button" class="grey2">
                                        加入购物车
                                        </button>
                                </form>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="box1">
                <div class="col_1_of_3 span_1_of_3">
                    <div class="view view-fifth">
                        <div class="top_box">
                            <h3 class="m_1">Apple iPad</h3>
                            <p class="m_2">5th Generation</p>
                            <a href="goods/showDetails/4" target="_blank">
                            <div class="grid_img">
                                <div class="css3"><img src="images/ipad2.jpg" style="height: 220px;width: 220px;" alt=""/></div>
                                <div class="mask">
                                    <div class="info">Quick View</div>
                                </div>
                            </div>
                            </a>
                            <div class="price">2499元</div>
                        </div>
                    </div>
                    <span class="rating">
				        <input type="radio" class="rating-input" id="rating-input-1-5" name="rating-input-1">
				        <label for="rating-input-1-5" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-4" name="rating-input-1">
				        <label for="rating-input-1-4" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-3" name="rating-input-1">
				        <label for="rating-input-1-3" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-2" name="rating-input-1">
				        <label for="rating-input-1-2" class="rating-star"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-1" name="rating-input-1">
				        <label for="rating-input-1-1" class="rating-star"></label>&nbsp;
		        	  (45)
		    	      </span>
                    <ul class="list">
                        <li>
                            <ul class="icon1 sub-icon1 profile_img">
                                <li>
                                    <form  id="cartForm4"  style="margin-left: 33px;" action="cart/addToCart" method="post">
                                        <input type="hidden" name="goodsSum" value="1"/>
                                        <input type="hidden" name="goodsId" value="4">
                                        <button id="btnSubmit4" type="button" class="grey2">
                                        加入购物车
                                        </button>
                                    </form>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <div class="clear"></div>
                </div>
                <div class="col_1_of_3 span_1_of_3">
                    <div class="view view-fifth">
                        <div class="top_box">
                            <h3 class="m_1">润慧空调</h3>
                            <p class="m_2">家用版</p>
                            <a href="goods/showDetails/5" target="_blank">
                            <div class="grid_img">
                                <div class="css3"><img src="images/gree.png" style="height: 220px;width: 220px;" alt=""/></div>
                                <div class="mask">
                                    <div class="info">Quick View</div>
                                </div>
                            </div>
                            </a>
                            <div class="price">6999元</div>
                        </div>
                    </div>
                    <span class="rating">
				        <input type="radio" class="rating-input" id="rating-input-1-5" name="rating-input-1">
				        <label for="rating-input-1-5" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-4" name="rating-input-1">
				        <label for="rating-input-1-4" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-3" name="rating-input-1">
				        <label for="rating-input-1-3" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-2" name="rating-input-1">
				        <label for="rating-input-1-2" class="rating-star"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-1" name="rating-input-1">
				        <label for="rating-input-1-1" class="rating-star"></label>&nbsp;
		        	  (45)
		    	      </span>
                    <ul class="list">
                        <li>
                            <ul class="icon1 sub-icon1 profile_img">
                                <li>
                                    <form id="cartForm5"  style="margin-left: 33px;"  action="cart/addToCart" method="post">
                                        <input type="hidden" name="goodsSum" value="1"/>
                                        <input type="hidden" name="goodsId" value="5">
                                        <button id="btnSubmit5" type="button" class="grey2">
                                        加入购物车
                                        </button>
                                    </form>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <div class="clear"></div>
                </a></div>
                <div class="col_1_of_3 span_1_of_3">
                    <div class="view view-fifth">
                        <div class="top_box">
                            <h3 class="m_1">TP-Link路由器 </h3>
                            <p class="m_2">Archer C9</p>
                            <a href="goods/showDetails/6" target="_blank">
                            <div class="grid_img">
                                <div class="css3"><img src="images/tp_router.jpg" style="height: 220px;width: 220px;" alt=""/></div>
                                <div class="mask">
                                    <div class="info">Quick View</div>
                                </div>
                            </div>
                            </a>
                            <div class="price">588元</div>
                        </div>
                    </div>
                    <span class="rating">
				        <input type="radio" class="rating-input" id="rating-input-1-5" name="rating-input-1">
				        <label for="rating-input-1-5" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-4" name="rating-input-1">
				        <label for="rating-input-1-4" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-3" name="rating-input-1">
				        <label for="rating-input-1-3" class="rating-star1"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-2" name="rating-input-1">
				        <label for="rating-input-1-2" class="rating-star"></label>
				        <input type="radio" class="rating-input" id="rating-input-1-1" name="rating-input-1">
				        <label for="rating-input-1-1" class="rating-star"></label>&nbsp;
		        	  (45)
		    	      </span>
                    <ul class="list">
                        <li>
                            <ul class="icon1 sub-icon1 profile_img">
                                <li>
                                    <form id="cartForm6"  style="margin-left: 33px;" action="cart/addToCart" method="post" content="application/json">
                                        <input type="hidden" name="goodsSum" value="1"/>
                                        <input type="hidden" name="goodsId" value="6">
                                        <button id="btnSubmit6" type="button" class="grey2">
                                        加入购物车
                                        </button>
                                    </form>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
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


        $().UItoTop({ easingType: 'easeOutQuart' });

        function getFormData($form) {
            var unindexed_array = $form.serializeArray();
            var indexed_array = {};

            $.map(unindexed_array, function (n, i) {
                indexed_array[n['name']] = n['value'];
            });

            return indexed_array;
        }

        $("#btnSubmit1").click(function () {
            $.ajax({
                url:"cart/addToCart",
                type:"post",
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(getFormData($("#cartForm1"))),
                success: function (result) {
                    console.log(result);
                    alert("加入购物车成功")
                },
                error: function (data) {
                    //错误处理
                    window.location.replace("/shoppingsystem/cart/user/myCart");
                }
            });
        });

        $("#btnSubmit2").click(function () {
            $.ajax({
                url:"cart/addToCart",
                type:"post",
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(getFormData($("#cartForm2"))),
                success: function (result) {
                    alert("加入购物车成功")
                },
                error: function () {
                    //错误处理
                    window.location.replace("/shoppingsystem/cart/user/myCart");
                }
            });
        });

        $("#btnSubmit3").click(function () {
            $.ajax({
                url:"cart/addToCart",
                type:"post",
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(getFormData($("#cartForm3"))),
                success: function (result) {
                    alert("加入购物车成功")
                },
                error: function () {
                    //错误处理
                    window.location.replace("/shoppingsystem/cart/user/myCart");
                }
            });
        });

        $("#btnSubmit4").click(function () {
            $.ajax({
                url:"cart/addToCart",
                type:"post",
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(getFormData($("#cartForm4"))),
                success: function (result) {
                    alert("加入购物车成功")
                },
                error: function () {
                    //错误处理
                    window.location.replace("/shoppingsystem/cart/user/myCart");
                }
            });
        });

        $("#btnSubmit5").click(function () {
            $.ajax({
                url:"cart/addToCart",
                type:"post",
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(getFormData($("#cartForm5"))),
                success: function (result) {
                    alert("加入购物车成功")
                },
                error: function () {
                    //错误处理
                    window.location.replace("/shoppingsystem/cart/user/myCart");
                }
            });
        });

        $("#btnSubmit6").click(function () {
            $.ajax({
                url:"cart/addToCart",
                type:"post",
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(getFormData($("#cartForm6"))),
                success: function (result) {
                    alert("加入购物车成功")
                },
                error: function () {
                    //错误处理
                    window.location.replace("/shoppingsystem/cart/user/myCart");
                }
            });
        });

    });
</script>
<a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>

</body>
</html>
