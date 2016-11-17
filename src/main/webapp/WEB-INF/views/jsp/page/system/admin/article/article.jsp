<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/simplemde.min.css'/>">
    <script src="/js/simplemde.min.js"></script>
</head>
<body>
<h1>文章页</h1>
    <textarea id="demo1">

    </textarea>
</body>
    <script>
        new SimpleMDE({
            element: document.getElementById("demo1"),
            spellChecker: false,
        });
    </script>
</html>
