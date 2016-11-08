<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/7
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Power-豪</title>
    <link rel="shortcut icon" href="<c:url value='/img/ico/lastfm.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/lib/layui/css/layui.css'/>">
</head>
<body>
    <form class="layui-form" id="label-form">
        <div id="tree"></div>
        <div id="resource"></div>
    </form>
</body>
<script id="listTemplate" type="text/x-handlebars-template">
    <div class="layui-form-item">
        <label class="layui-form-label">资源名称</label>
        <div class="layui-input-block">
            <input type="text" name="iname" autocomplete="off" value="{{iname}}" placeholder="请输入资源名称" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">资源地址</label>
        <div class="layui-input-block">
            <input type="text" name="iurl" autocomplete="off" value="{{iurl}}" placeholder="请输入资源地址" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">状态：</label>
        <div class="layui-input-block" id="status">
            <input type="radio" name="status" value="0" title="显示"checked>
            <input type="radio" name="status" value="1" title="影藏" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">层级：</label>
        <div class="layui-input-block" id="level">
            <input type="radio" name="level" value="0" title="顶级"checked>
            <input type="radio" name="level" value="1" title="子级" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">父级</label>
        <div class="layui-input-block">
            <select name="interest" lay-filter="aihao">
                <option value=""></option>
                {{#each list}}
                    <option value="{{id}}">{{name}}</option>
                {{/each}}
            </select>
        </div>
    </div>
</script>
<script src="<c:url value='/js/lib/layui/layui.js' />"></script>
<script src="<c:url value='/js/require.js'/>"></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script>
    layui.config({
        base: '/js/' //你的模块目录
    }).use(['business/admin/resources/controller/listController',tree]); //加载入口
</script>
</html>
