<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Power-豪</title>
    <link rel="shortcut icon" href="<c:url value='/img/ico/lastfm.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/lib/layui/css/layui.css'/>">
</head>
<body>
    <a class="btn btn-info" style="margin-left: 100px" href="/admin/article/toaddoredit"> 新建文章</a>
    <div class="container" >
        <table class="table" style="font-size: 14px">
            <thead>
                <tr>
                   <th class="col-md-6">标题</th>
                   <th class="col-md-2">创建时间</th>
                   <th class="col-md-2">操作时间</th>
                    <th class="col-md-2">操作</th>
                </tr>
            </thead>
            <tbody id="js-tbody">
                <c:forEach items="${page.list}" var="article">
                    <tr>
                        <td class="col-md-6">${article.title}</td>
                        <td class="col-md-2"><fmt:formatDate value="${article.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                        <td class="col-md-2"><fmt:formatDate value="${article.operateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td class="col-md-2"><a href="/admin/article/toaddoredit?id=${article.id}" style="cursor:pointer">修改</a> <a class="delete" article-id="${article.id}" style="cursor:pointer">删除</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="js-pagination" class="notice-pagination-box clearfix" style="margin-right: 30px">
            <span class="page-total">共查询到 <em id="itemCount">${page.total}</em> 条信息，共<em
                    id="pageCount">${page.pages}</em>页</span>
        <div id="pagination" class="pagination"></div>
    </div>
</body>
<script id="listTemplate" type="text/x-handlebars-template">
    {{#each list}}
        <tr>
            <td class="col-md-6">{{title}}</td>
            <td class="col-md-2">{{prettifyDate createTime}}</td>
            <td class="col-md-2">{{prettifyDate operateTime}}</td>
            <td class="col-md-2"><a href="/admin/article/toaddoredit?id={{id}}" style="cursor:pointer">修改</a> <a class="delete" article-id="{{article.id}}" style="cursor:pointer">删除</a></td>
        </tr>
    {{/each}}
</script>
<script src="<c:url value='/js/lib/layui/layui.js' />"></script>
<script src="<c:url value='/js/require.js'/>"></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script>
    layui.config({
        base: '/js/' //你的模块目录
    }).use('business/admin/article/controller/listController'); //加载入口
</script>
</html>
