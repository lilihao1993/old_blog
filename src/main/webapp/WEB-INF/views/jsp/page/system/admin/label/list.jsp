<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Power-豪</title>
    <link rel="shortcut icon" href="<c:url value='/img/ico/lastfm.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/lib/layui/css/layui.css'/>">
</head>
<body>
<!--响应式表格-->
<div class="table-responsive">
    <button class="layui-btn layui-btn-big"><a href="/page/system/admin/label/add">新增类别</a></button>
    <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>类别名称</th>
                    <th>创建时间</th>
                    <th>操作时间</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody class="js-tbody">
                <c:forEach items="${pageInfo.list}" var="label">
                   <tr>
                       <td>${label.name}</td>
                       <td><fmt:formatDate value="${label.createTime}" pattern="yyyy-MM-dd"/></td>
                       <td><fmt:formatDate value="${label.operateTime}" pattern="yyyy-MM-dd"/></td>
                       <td>
                           <%--<a href="#">删除</a>--%>
                           <%--<a href="#">修改</a>--%>
                           <button class="layui-btn layui-btn-small js-del" label-id="${label.id}">删除</button>
                           <button class="layui-btn layui-btn-small js-edit" ><a href="/admin/label/toedit/${label.id}">修改</a></button>
                       </td>
                   </tr>
                </c:forEach>
            </tbody>
    </table>
</div>
<div id="js-pagination" class="notice-pagination-box clearfix">
            <span class="page-total">共查询到 <em id="itemCount">${pageInfo.total}</em> 条信息，共<em
                    id="pageCount">${pageInfo.pages}</em>页</span>
    <div id="pagination" class="pagination"></div>
</div>
</body>
<script id="listTemplate" type="text/x-handlebars-template">
    {{#each list}}
        <tr>
            <td>{{name}}</td>
            <td>{{prettifyDate createTime}}</td>
            <td>{{prettifyDate operateTime}}</td>
            <td>
                <%--<a href="#">删除</a>--%>
                <%--<a href="#">修改</a>--%>
                <button class="layui-btn layui-btn-small js-del" label-id="{{id}}">删除</button>
                <button class="layui-btn layui-btn-small js-edit" ><a href="/admin/label/toedit/{{id}}">修改</a></button>
            </td>
        </tr>
    {{/each}}
</script>
<script src="<c:url value='/js/lib/layui/layui.js' />"></script>
<script src="<c:url value='/js/require.js'/>"></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script>
    layui.config({
        base: '/js/' //你的模块目录
    }).use('business/admin/label/controller/listController'); //加载入口
</script>
</html>
