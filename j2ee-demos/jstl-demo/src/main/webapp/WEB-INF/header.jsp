<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <span type="news">新闻</span> |
    <span type="blog">博客</span> |
    <span type="ask">博问</span> |
    <span type="libary"> 知识库</span> |
    <span type="mem">闪存</span>
    <span type="search">个人搜</span> |
    -----------
    <span>${param.active}</span>
    <span>${active}</span>

    <script type="text/javascript">
        //  js中
        //      - `es6模板字符串` 可能和 `el表达式` 冲突
        //      - 最好先赋值给var
        var active = "${param.active}";
        document.querySelector("span[type='"+active+"']").style.color = "red";
    </script>
</body>
</html>
