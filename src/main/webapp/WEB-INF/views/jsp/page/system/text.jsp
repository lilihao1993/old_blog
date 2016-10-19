<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/lib/layui/css/layui.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style/system/test.css'/>">
</head>
<body>
    <p>
        我也是醉了
    </p>

    <h1>1、图标</h1>
    <i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop" style="font-size: 30px; color: #1E9FFF;">&#x1002;</i>
    <button id="btn" class="layui-btn layui-btn-mini">按钮</button>

    <h1>2、辅助</h1>


    <h4>引用区域文字</h4>
    <blockquote class="layui-elem-quote">引用区域的文字</blockquote>
    <blockquote class="layui-elem-quote layui-quote-nm">引用区域的文字</blockquote>

    <h4>字段集区块 风格</h4>
    <fieldset class="layui-elem-field">
        <legend>字段集区块 - 默认风格</legend>
        <div class="layui-field-box">
            内容区域
        </div>
    </fieldset>

    <fieldset class="layui-elem-field layui-field-title">
        <legend>字段集区块 - 横线风格</legend>
        <div class="layui-field-box">
            内容区域
        </div>
    </fieldset>


    <h1>3、表单</h1>
    <form class="layui-form" id="queryForm" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">输入框</label>
            <div class="layui-input-block">
                <input type="text" name="title"   placeholder="请输入标题" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码框</label>
            <div class="layui-input-inline">
                <input type="password" name="password"  placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">选择框</label>
            <div class="layui-input-block">
                <select name="city">
                    <option value=""></option>
                    <option value="0">北京</option>
                    <option value="1">上海</option>
                    <option value="2">广州</option>
                    <option value="3">深圳</option>
                    <option value="4">杭州</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">复选框</label>
            <div class="layui-input-block">
                <input type="checkbox" name="like[write]" title="写作">
                <input type="checkbox" name="like[read]" title="阅读" checked>
                <input type="checkbox" name="like[dai]" title="发呆">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">开关</label>
            <div class="layui-input-block">
                <input type="checkbox" name="switch" lay-skin="switch">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">单选框</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男">
                <input type="radio" name="sex" value="女" title="女" checked>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">文本域</label>
            <div class="layui-input-block">
                <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>


    <h1>4、导航</h1>
    <h6>水平导航</h6>
    <ul class="layui-nav">
        <li class="layui-nav-item"><a href="">最新活动</a></li>
        <li class="layui-nav-item layui-this"><a href="">产品</a></li>
        <li class="layui-nav-item"><a href="">解决方案</a></li>
        <li class="layui-nav-item"><a href="">大数据</a></li>
    </ul>

    <h6>垂直导航</h6>
    <ul class="layui-nav layui-nav-tree">
        <li class="layui-nav-item"><a href="">最新活动</a></li>
        <li class="layui-nav-item layui-this"><a href="">产品</a></li>
        <li class="layui-nav-item"><a href="">解决方案</a></li>
        <li class="layui-nav-item"><a href="">大数据</a></li>
    </ul>
    <a href="http://www.layui.com/doc/element/nav.html" style="color: #3c763d;size: 40px">还有更多</a>


    <h1>时间组件</h1>
    <div class="layui-form-pane"  style="margin-top: 15px;">
        <div class="layui-form-item">
            <label class="layui-form-label">范围选择</label>
            <div class="layui-input-inline">
                <input class="layui-input"  placeholder="开始日" id="LAY_demorange_s">
            </div>
            <div class="layui-input-inline">
                <input class="layui-input" placeholder="截止日" id="LAY_demorange_e">
            </div>
        </div>
    </div>
    <h1>编辑器</h1>
    <div style="border: solid 1px rgba(27, 26, 27, 0.6)">
        <textarea id="Lay_docDemo_layedit" style="display: none;" class="layui-hide"></textarea>
        <div class="layui-layedit">
            <div class="layui-unselect layui-layedit-tool">
                <i class="layui-icon layedit-tool-b" title="加粗" lay-command="Bold" layedit-event="b" ></i><i class="layui-icon layedit-tool-i" title="斜体" lay-command="italic" layedit-event="i" ></i><i class="layui-icon layedit-tool-u" title="下划线" lay-command="underline" layedit-event="u" ></i><i class="layui-icon layedit-tool-d" title="删除线" lay-command="strikeThrough" layedit-event="d" ></i><span class="layedit-tool-mid"></span><i class="layui-icon layedit-tool-left" title="左对齐" lay-command="justifyLeft" layedit-event="left" ></i><i class="layui-icon layedit-tool-center" title="居中对齐" lay-command="justifyCenter" layedit-event="center"></i><i class="layui-icon layedit-tool-right" title="右对齐" lay-command="justifyRight" layedit-event="right" ></i><span class="layedit-tool-mid"></span><i class="layui-icon layedit-tool-link" title="插入链接" layedit-event="link"></i><i class="layui-icon layedit-tool-unlink layui-disabled" title="清除链接" lay-command="unlink" layedit-event="unlink" ></i><i class="layui-icon layedit-tool-face" title="表情" layedit-event="face" ></i><i class="layui-icon layedit-tool-image" title="图片" layedit-event="image"><input type="file" name="file"></i></div><div class="layui-layedit-iframe"><iframe id="LAY_layedit_1" name="LAY_layedit_1" textarea="Lay_docDemo_layedit" frameborder="0" style="height: 180px;"></iframe>
            </div>
        </div>
    </div>

    <br><br>
</body>
<script src="<c:url value='/js/lib/layui/layui.js' />"></script>
<script src="<c:url value='/js/require.js'/>"></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script src="<c:url value='/js/lib/layui/lay/modules/laydate.js' />"></script>
<script>
    layui.config({
        base: '/js/' //你的模块目录
    }).use('test/controller/testcontroller'); //加载入口

</script>
</html>