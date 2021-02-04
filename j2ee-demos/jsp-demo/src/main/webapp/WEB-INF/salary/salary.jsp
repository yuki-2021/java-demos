<!-- 4. jsp指令@Page contentType/pageEncoding/language -->
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!-- 4. jsp指令@Page import -->
<%@ page import="java.util.*" %>
<!-- 4. jsp指定 @taglib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <!-- 4. jsp指令 @inlcude -->
        <%@ include file="header.jsp"%>

        <!-- 01. 输出语法 -->
        <h1><%= request.getAttribute("title")%></h1>
        <tr><th>年份</th><th>工资</th></tr>
        <!-- 03. java代码块语法 -->
        <%
            List<Double> salList = (List)request.getAttribute("salList");
            for (int i = 0; i < salList.size(); i++) { %>
        <tr><td><%= i%></td><td><%= salList.get(i)%></td></tr>
        <%  } %>

        <!-- 4. jsp指令 @inlcude -->
        <%@ include file="footer.jsp"%>
    </body>
</html>
