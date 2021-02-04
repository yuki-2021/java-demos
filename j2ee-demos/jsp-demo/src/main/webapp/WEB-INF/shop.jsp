<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- 定义 成员方法/成员变量  -->
    <%! public String name = "shop title";%>
    <%! public int add(int a,int b) {return a+b; }%>

    <!-- 使用 成员变量-->
    <%= add(1,2)%>
    <%= name%>
    <hr>

    <!-- 测试 config内置对象 -->
    <!-- jsp -->
    <%= config.getServletName()%><br />
    <!-- servletContext -->
    <%= config.getServletContext()%><br />
    <!-- init Params-->
    <%= config.getInitParameterNames()%><br />
</body>
</html>
