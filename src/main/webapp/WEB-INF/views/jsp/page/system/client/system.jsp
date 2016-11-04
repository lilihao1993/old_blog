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
                    <span class="open" style="padding: 12px 120px 12px 0px">${homeResourceDto.rootName}</span>
                    <ul style="display:none">
                    <c:forEach var="resource" items="${homeResourceDto.list}">
                        <li js-url="${resource.url}"><span>${resource.name}</span></li>
                    </c:forEach>
                    </ul>
                </li>
            </c:forEach>


            <%--<ul class="layui-nav layui-nav-tree layui-nav-side">--%>
                <%--<c:forEach items="${homeResourceDtos}" var="homeResourceDto">--%>
                    <%--<li class="layui-nav-item">--%>
                        <%--<span class="open" >${homeResourceDto.rootName}</span>--%>
                        <%--<ul style="display:none">--%>
                            <%--<c:forEach var="resource" items="${homeResourceDto.list}">--%>
                                <%--<li js-url="${resource.url}"><span>${resource.name}</span></li>--%>
                            <%--</c:forEach>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                <%--</c:forEach>--%>

            <%--<li class="click-menu css-user-menu open">--%>
                <%--<span>用户管理</span>--%>
                <%--<ul style="display:none">--%>
                    <%--<li><span><a >账户管理</a></span></li>--%>
                    <%--<li><span>个人资料</span></li>--%>
                    <%--<li><span>账户中心</span></li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li class="click-menu css-user-menu open">--%>
                <%--<span>应用管理</span>--%>
                <%--<ul style="display: none">--%>
                    <%--<li><span>账户管理</span></li>--%>
                    <%--<li><span>个人资料</span></li>--%>
                    <%--<li  id="lt" js-url="http://www.baidu.com"><span>账户中心</span></li>--%>
                    <%--<li><span><a href="/admin/label/tolist?pageNum=0&pageSize=5">类别</a></span></li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li class="click-menu css-user-menu open">--%>
                <%--<span>配置管理</span>--%>
                <%--<ul style="display: none">--%>
                    <%--<li><span>账户管理</span></li>--%>
                    <%--<li><span>个人资料</span></li>--%>
                    <%--<li><span>账户中心</span></li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li class="click-menu css-user-menu open">--%>
                <%--<span>业务统计</span>--%>
                <%--<ul style="display: none">--%>
                    <%--<li><span><a href="/page/system/text">账户管理</a></span></li>--%>
                    <%--<a href="/editor"><li><span> 个人资料</span></li></a>--%>
                    <%--<li><span>账户中心</span></li>--%>
                <%--</ul>--%>
            <%--</li>--%>
        </ul>
    </div>
    <div id="iframe-div">
        <iframe width="1210" height="900" frameborder="0" scrolling="no"  src="<c:url value='/admin/label/tolist?pageNum=0&pageSize=5'/>">

        </iframe>
    </div>
</div>


<h1>进入后端管理页面</h1>
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