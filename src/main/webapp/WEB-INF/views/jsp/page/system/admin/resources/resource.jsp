<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <div class="layui-form-item">
            <label class="layui-form-label">资源名称：</label>
            <div class="layui-input-block">
                <input type="text" name="name" resource-id="${resource.id}" value="${resource.name}" id="name" placeholder="请输入资源名称" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">资源地址：</label>
            <div class="layui-input-block">
                <input type="text" name="url" value="${resource.url}" id="url" placeholder="请输入资地址" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态：</label>
            <div class="layui-input-block" id="status">
                <input type="radio" name="status" value="0" title="显示" <c:if test="${resource.status == '0'||resource.status == null}">checked</c:if>/>
                <input type="radio" name="status" value="1" title="影藏" <c:if test="${resource.status == '1'}">checked</c:if>/>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">层级：</label>
            <div class="layui-input-block" id="level">
                <input type="radio" name="level" value="0" title="顶级"<c:if test="${resource.level == '0'||resource.status == null}">checked</c:if>/>
                <input type="radio" name="level" value="1" title="子级" <c:if test="${resource.level == '1'}">checked</c:if>/>
            </div>
        </div>
        <div class="layui-form-item">
            <select lay-verify="">

                <option value="#"  <c:if test="${resource.parentId == '#'}">selected="selected"</c:if>>无父级</option>
                <c:forEach var="reso" items="${list}">
                    <option value="${reso.id}"<c:if test="${resource.parentId == reso.id}">selected="selected"</c:if>>${reso.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <input type="button" class="layui-btn" id="add" lay-submit lay-filter="formDemo" value="保存" />
            </div>
        </div>
    </form>
</body>
<script src="<c:url value='/js/lib/layui/layui.js' />"></script>
<script src="<c:url value='/js/require.js'/>"></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script>
    layui.config({
        base: '/js/' //你的模块目录
    }).use('business/admin/resources/controller/addController'); //加载入口
</script>
</html>
