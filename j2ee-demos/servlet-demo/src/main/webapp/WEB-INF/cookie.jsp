<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <!-- JSTL 循环输出Cookie-->
    <table border="1">
        <tr>
            <td>name</td>
            <td>value</td>
            <td>domain</td>
            <td>path</td>
            <td>maxAge</td>
            <td>secure</td>
            <td>comment</td>
            <td>version</td>
        </tr>
        <c:forEach var="key" items="${cookie.keySet()}">
            <tr>
                <td>${cookie.get(key).name}</td>
                <td>${cookie.get(key).value}</td>
                <td>${cookie.get(key).domain}</td>
                <td>${cookie.get(key).path}</td>
                <td>${cookie.get(key).maxAge}</td>
                <td>${cookie.get(key).secure}</td>
                <td>${cookie.get(key).comment}</td>
                <td>${cookie.get(key).version}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
