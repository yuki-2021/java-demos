<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>员工列表</title>

    <!-- css 和 ie8支持`html5元素`和`媒体查询` -->
    <!-- css 和 ie8支持`html5元素`和`媒体查询` -->
    <!-- Bootstrap.css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"rel="stylesheet" type="text/css"  >
    <!-- html5shiv、respond  - 让ie8支持 `html5元素`和 `媒体查询` -->
    <!-- 通过file:// 协议访问页面 Respond.js无效 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
    <style>
        .container-margin {
            margin-left: 15px;
            margin-right: 15px;
        }
    </style>
</head>
<body>
    <!-- 居中对齐 text-center -->
    <h3 class="text-center">员工列表 </h3>

    <!-- table -->
    <!-- row 表示栅格 -->
    <div class="container-fluid container-margin">
        <div class="row">
            <table class="table table-striped table-bordered table-hover">
                <tr class="success">
                    <td colspan="6">
                        <button class="btn btn-success" type="button" data-toggle="modal" data-target="#myModal">添加员工</button>
                    </td>
                </tr>
                <tr>
                    <th>id</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>职位</th>
                    <th>工资</th>
                    <th>入职时间</th>
                </tr>
                <c:choose>
                    <c:when test="${empList != null && empList.size() > 0}">
                        <c:forEach items="${empList}" var="emp">
                            <tr>
                                <td>${emp.id}</td>
                                <td>${emp.name}</td>
                                <td>${emp.gender}</td>
                                <td>${emp.job}</td>
                                <td>￥<fmt:formatNumber value="${emp.salary}" pattern="0,000.00"/> </td>
                                <td><fmt:formatDate value="${emp.entryDate}" pattern="yyyy-MM-dd"/> </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empList != null && empList.size() >0}">
                            <tr class="text-right"><td colspan="6">共有 <span class="text-primary">${empList.size()}</span> 条数据。</td></tr>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <tr><td colspan="6" class="text-center"> 没有数据 !!!</td></tr>
                    </c:otherwise>
                </c:choose>


            </table>
        </div>
    </div>


    <!-- 模态框 -->
    <!-- modal、modal-dialog、modal-content、modal-header、modal-body、modal-footer、close(右上角关闭标签)-->
    <!-- data-dismiss="modal" 用来关闭modal-->
    <!-- data-toggle="modal" 切换modal框 data-target="#id" 具体是哪一个-->
    <!-- 表单 -->
    <!-- form-group、form-control、input-group、input-group-addon -->
    <!-- 单选框 radio-inline、checkbox-inline-->
    <div id="myModal" class="modal fade">
        <form class="modal-dialog modal-content" action="/emp" method="post" enctype="application/x-www-form-urlencoded">
            <div class="modal-header">
                <button type="button" class="close empClear" data-dismiss="modal">&times;</button>
                <h4>新增员工</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label>员工id</label>
                    <input class="form-control" type="text" name="id" placeholder="员工编号">
                </div>
                <div class="form-group">
                    <label>名称</label>
                    <input class="form-control" type="text" name="name">
                </div>
                <div class="form-group">
                    <label>性别</label>
                    <div class="form-group">
                        <label class="radio-inline"><input type="radio" name="gender" value="男">男</label>
                        <label class="radio-inline"><input type="radio" name="gender" value="女">女</label>
                    </div>

                </div>
                <div class="form-group">
                    <label>职位</label>
                    <input class="form-control" type="text" name="job">
                </div>
                <div class="form-group">
                    <label>工资</label>
                    <div class="input-group">
                        <div class="input-group-addon">￥</div>
                        <input class="form-control" type="text" name="salary">
                    </div>
                </div>
                <div class="form-group">
                    <label>入职时间</label>
                    <input class="form-control" type="date" name="entryDate" >
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger empClear" data-dismiss="modal">取消</button>
                <input type="submit" class="btn btn-success"  value="提交"/>
            </div>
        </form>
    </div>

    <!-- js-->
    <!-- jquery.js -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- bootstrap.js-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        // 对于document回调 -> 使用function() {}
        $(document).ready( function() {
            // 1. 找到 - 对于事件回调 -> 使用function() {}
            $(".empClear").on("click",function () {
                $("form").find("input").not("[type=submit]").val("");
            })
        });
    </script>
</body>
</html>