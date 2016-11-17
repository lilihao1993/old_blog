<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Power-豪</title>
    <link rel="shortcut icon" href="<c:url value='/img/ico/lastfm.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/style/system/system.css'/>">
    <%--<link rel="stylesheet" type="text/css" href="<c:url value='/js/lib/layui/css/layui.css'/>">--%>
</head>
<body>
<jsp:include page="../../../comm/clienthead.jsp"/>
<div class="row left-menu">
    <div class="col-md-2 left">
        <ul class="menu toggle-setting-promotion">
            <c:forEach items="${homeResourceDtos}" var="homeResourceDto">
                <li class="click-menu css-user-menu" >
                    <span class="open cursor" style="padding: 12px 50% 12px 0px">${homeResourceDto.rootName}</span>
                    <ul style="display:none">
                    <c:forEach var="resource" items="${homeResourceDto.list}">
                        <li js-url="${resource.url}" class="cursor"><span>${resource.name}</span></li>
                    </c:forEach>
                    </ul>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div id="iframe-div" style="margin-right: 60px;margin-top: 10px">
        <iframe width="1145px" height="900px" frameborder="0" scrolling="no"   src="${resourceUrl}">

        </iframe>
    </div>
</div>
</body>
<script src="<c:url value='/js/lib/layui/layui.js' />"></script>
<script src="<c:url value='/js/require.js'/>"></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script>
    layui.config({
        base: '/js/' //你的模块目录
    }).use('business/system/controller/systemController'); //加载入口

</script>
</html>