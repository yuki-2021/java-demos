<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>oth</title>
</head>
<body>
        
    <!-- c:import 传递参数 -->
    <h3> c:import 传递参数 </h3>
    <c:import url="header.jsp">
        <c:param name="active" value="blog" />
    </c:import>
    <hr>

    <!-- 显示html文本 -->
    <h3>c:out 显示html文本</h3>
    <p><c:out value="${htmlStr}" escapeXml="true" /> </p>


    <!-- c:url 用于生成uri-->
    <h3> 测试 - c:uri</h3>
    <c:url var="header_uri" value="/oth">
        <c:param name="name" value="${name}" />
        <c:param name="hobby" value="${hobby}" />
    </c:url>
    <!-- post -->
    <!-- post请求 - 在url中传参 -->
    <form action="${header_uri}" method="post" enctype="application/x-www-form-urlencoded">
        <p>${header_uri}</p>
        测试c:uri - <input type="submit" value="${header_uri}"/>
    </form>
</body>
</html>