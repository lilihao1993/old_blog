<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Power-豪</title>
    <link rel="shortcut icon" href="<c:url value='/img/ico/lastfm.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/lib/layui/css/layui.css'/>">
    <script src="<c:url value='/js/lib/ueditor/ueditor.config.js'/>"></script>
    <script src="<c:url value='/js/lib/ueditor/ueditor.all.min.js'/>"></script>
</head>
    <body>
        <form action="/admin/article/addorEdit" method="post" id="label-form" class="layui-form col-md-10" style="margin-left: 50px;margin-top: 30px">
            <div class="layui-form-item">
                <label class="layui-form-label">标题：</label>
                <div class="layui-input-block">
                    <input type="text" id="title" name="title" placeholder="请输入标题" value="${title}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">摘要：</label>
                <div class="layui-input-block">
                    <input type="text" name="summary" placeholder="请输入摘要" value="${summary}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item" style="margin-left: 23px" >
                <label >内容：</label>
                <script id="container" name="content" type="text/plain"></script>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">热门：</label>
                <div class="layui-input-block" id="hot">
                    <input type="radio" name="hot" value="0" title="热门"<c:if test="${resource.level == '0'||resource.status == null}">checked</c:if>/>
                    <input type="radio" name="hot" value="1" title="非热门" <c:if test="${resource.level == '1'}">checked</c:if>/>
                </div>
            </div>
                <label class="layui-form-label">类别：</label>
                <div class="layui-input-block">
                    <select name="labelId" class="form-control ipt-txt">
                        <option value="">请选择</option>
                        <c:forEach var="label" items="${labels}">
                            <option value="${label.id}">${label.name}</option>
                        </c:forEach>
                    </select>
                </div>
            <div class="col-md-offset-5">
                <input type="button" id="add"  class="layui-btn layui-btn-big layui-btn-normal" value="确认"/>
                <input type="button" id="cancel" class="layui-btn layui-btn-big layui-btn-normal" value="取消"/>
            </div>
        </form>
    </body>
<script src="<c:url value='/js/lib/layui/layui.js' />"></script>
<script src="<c:url value='/js/require.js'/>"></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script>
    layui.config({
        base: '/js/' //你的模块目录
    }).use('business/admin/article/controller/addController'); //加载入口
</script>
</html>
