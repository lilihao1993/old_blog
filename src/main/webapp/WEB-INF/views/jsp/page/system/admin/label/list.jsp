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
<!--响应式表格-->
<div class="table-responsive">
    <table class="table table-bordered table-hover">
        <table>
            <thead>
                <tr>
                    <th>类别名称</th>
                    <th>创建时间</th>
                    <th>操作时间</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${pageInfo.list}" var="label">
                   <tr>
                       <td>${label.name}</td>
                       <td>${label.createTime}</td>
                       <td>${label.createTime}</td>
                       <td>
                           <a href="#">删除</a>
                           <a href="#">修改</a>
                       </td>
                   </tr>
                </c:forEach>
            </tbody>
        </table>
    </table>
</div>
</body>
<script>
    layui.config({
        base: '/js/' //你的模块目录
    }).use('test/controller/testcontroller'); //加载入口
</script>
</html>
