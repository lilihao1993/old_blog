<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<c:url value='/css/comm/head.css'/> "/>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6">
            <ul id="Navigation" class="navbar-nav sf-menu felink-menu sf-js-enabled sf-arrows" data-type="navbar">
                <li>
                    <a href="./">首页</a>
                </li>
                <li class="dropdown">
                    <a class="sf-with-ul">其他项目</a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="./zm.html">91桌面</a>
                        </li>
                        <li>
                            <a href="./tq.html">黄历天气</a>
                        </li>
                        <li>
                            <a href="./s.html">91锁屏</a>
                        </li>
                        <li>
                            <a href="./xt.html">羞兔</a>
                        </li>
                        <li>
                            <a href="./dxzm.html">点心桌面</a>
                        </li>
                        <li>
                            <a href="./launcher.html">Mobo 桌面</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="./indulged/game.html">文章列表</a>
                </li>
                <li>
                    <a href="./support.html">热门文章</a>
                </li>
                <li>
                    <a href="./about.html">关于</a>
                </li>
            </ul>
        </div>
        <div class="col-md-6">
            <button id="show" class="btn btn-md btn-default col-sm-offset-10" type="button">
                登录
            </button>
        </div>
    </div>
</div>
<div id="form-div" class="hidden">
    <img class="pull-right" src="<c:url value="/img/ico/close.ico"/>"/>
    <form action="/page/system/client/system">
        <div class="row">
            <div class="form-group">
                <img class="col-md-offset-4" src="<c:url value="/img/ico/user.ico"/>"/>
            </div>
            <div id="span" class="form-group">
                <span></span>
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <label for="exampleInputEmail1">用户名</label>
                <input type="username" class="form-control" id="username" placeholder="Email">
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <label for="exampleInputPassword1">密码</label>
                <input type="password" class="form-control" id="password" placeholder="Password">
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <button id="login" type="button" class="btn btn-default">登 录</button>
            </div>
        </div>
    </form>
</div>





