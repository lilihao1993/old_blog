<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Power-豪</title>
    <link rel="shortcut icon" href="<c:url value='/img/ico/lastfm.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/lib/layui/css/layui.css'/>">
</head>
<body>
  <form class="layui-form" id="label-form">
      <div class="layui-form-item">
          <label class="layui-form-label">类别名称</label>
          <div class="layui-input-block">
              <input type="text" name="name" label-id="${label.id}" value="${label.name}" id="name" placeholder="请输入类别名称" autocomplete="off" class="layui-input">
          </div>
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
    }).use('business/admin/controller/addController'); //加载入口
</script>
</html>
