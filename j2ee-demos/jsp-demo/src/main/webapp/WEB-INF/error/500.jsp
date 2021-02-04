
<%@ page contentType="text/html;charset=UTF-8"  isErrorPage="true" %>
<html>
<head>
    <title>错误提示页面</title>
</head>
<body>
500错误<br/>
<h1><%= exception.getMessage()%></h1>
错误码：<%=request.getAttribute("javax.servlet.error.status_code")%> <br>
信息： <%=request.getAttribute("javax.servlet.error.message")%> <br>
异常类型： <%=request.getAttribute("javax.servlet.error.exception_type")%> <br>

</body>
</html>