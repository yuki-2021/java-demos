<!--
    errorPage 显示指定错误页面位置

    错误页面优先级
        1. errorPage指定的
        2. web.xml配置的errorPage
        3. tomcat默认错误页
-->
<%@ page errorPage="../error/error.jsp" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <!-- 这里出现了错误 -->
    <!-- JSP`定义语句` 不能使用`九大对象`-->
    <!-- 本来会调到错误页面，isErrorPage 表示这个就是错误页面，可以获取到`exception内置对象` -->

    <%=1/0%>

    <!-- 错误信息-->
    <h1>错误页面自身</h1>

</body>
</html>
