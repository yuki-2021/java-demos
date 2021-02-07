<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.yuki.el.Girl" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <!-- 1. 不写作用域，默认是 page -> request -> session ->application -> null -->
        <h1>${title}</h1>
        <tr>
            <th>姓名</th><th>年龄</th><th>城市</th><th>爱好</th>
        </tr>

        <!-- 3. 对于代码块声明的变量，el表达式无法使用 -->
        <%
            List<Girl> girls = (List<Girl>) request.getAttribute("girlList");
            if(girls != null) {
                for (int i = 0; i < girls.size(); i++) {
                    Girl girl = girls.get(i);                                      %>
                    <tr>
                        <td>${girl.name}</td>
                    </tr>
        <%      }
            }
        %>


        <!-- 2. 访问param、header、cookie、initParam 要显示指定作用域-->
        <hr>
        <!-- param - 访问请求参数 -->
        <p>${param.name}</p>
        <!-- paramValues - 访问请求参数 -->
        <p>${paramValues.hobby[1]}</p>
        <p>${paramValues.hobby[2]}</p>
        <!-- 访问header -->
        <p>${header["host"]}</p>
        <p>${header["accept"]}</p>
        <!-- cookie -->
        <p>${cookie.JSESSIONID.name} - ${cookie.JSESSIONID.value}</p>
        <!-- 访问context-param-->
        <p>${initParam.cp}</p>

    </body>
</html>
