<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/css/comm/clienthead.css'/> "/>
</head>
<body>
<div class="row clienthead">
    <div class="col-md-8">
        <span>
            <a href="<c:url value='/admin/resource/addoredit'/>">新增资源</a>
        </span>
    </div>
    <div class="col-md-4 prt">

            <span>
                帮助
            </span>
            <span>
                个人用户
            </span>
            <span>
                <a href="/client/singout">退出</a>
            </span>
    </div>
</div>
</body>
</html>

