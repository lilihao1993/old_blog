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
        <div class="row">
            <div id="tree" class="col-md-2 col-md-offset-1"></div>
            <div class="col-md-1">
                <a class="layui-btn layui-btn-primary layui-btn-big" href="<c:url value="/admin/resource/addoredit"/>">新增资源</a>
            </div>
        </div>

        <div id="resource"></div>
    </form>
</body>
<script id="listTemplate" type="text/x-handlebars-template">
    <div class="layui-form-item">
        <label class="layui-form-label">资源名称</label>
        <div class="layui-input-block">
            <input type="text" name="name" autocomplete="off" value="{{name}}" placeholder="请输入资源名称" class="layui-input" readonly/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">资源地址</label>
        <div class="layui-input-block">
            <input type="text" name="url" autocomplete="off" value="{{url}}" placeholder="请输入资源地址" class="layui-input" readonly/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">状态：</label>
        <div class="layui-input-block">
            {{#ifCond status '==' 0}}
                <input type="text" value="显示" class="layui-input" readonly/>
            {{else}}
                <input type="text" value="隐藏" class="layui-input" readonly/>
            {{/ifCond}}
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">层级：</label>
        <div class="layui-input-block">
            {{#ifCond level '==' 0}}
              <input type="text" value="顶级" class="layui-input" readonly/>
            {{else}}
              <input type="text" value="子级" class="layui-input" readonly/>
            {{/ifCond}}
        </div>
    </div>
    <div class="layui-form-item col-md-offset-2">
        <a class="layui-btn layui-btn-primary layui-btn-big" href="<c:url value="/admin/resource/addoredit?id={{id}}"/>">修改资源</a>
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
