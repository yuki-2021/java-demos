<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- title -->
    <title>登陆页面</title>
    <!-- css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 让ie8支持 `html5元素` 和 `媒体查询` -->
    <!-- file://协议（直接 html拖拽到浏览器）时 Respond.js 不生效 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        body {
            background-color: #eeeeee;
        }
        .form-login {
            margin-top: 80px;
        }
        .login-alert {
            padding-top: 10px;
            padding-bottom: 10px;
            margin-bottom: 13px;
        }
        .login-alert .close {
            margin-top: -21px;
        }
    </style>
</head>
<body>

    <!-- bg-success、bg-primary-->
    <!-- text-danger-->
    <!-- col-lg-4、col-lg-offset-4、-->
    <!--text-center 文字居中-->
    <!-- form-inline、form-group、[from-control]、[input-group、input-group-add]--->
    <!--form-horizontal、control-label、col-lg-4-->
    <!-- btn、-->

    <!-- alert、alert-danger、alert-link-->
    <!-- close-->
    <!-- data-dismiss="alert" -->
    <div class="container">
        <form class="form-login row form-horizontal" method="post" action="/login" enctype="application/x-www-form-urlencoded">
            <div class="col-xs-10 col-xs-offset-1 col-md-4 col-md-offset-4">

                <h3 class="text-center">欢迎登陆</h3>
                <br>
                <div class="form-group">
                    <div class="alert alert-danger login-alert" role="alert">
                        <p >asdasda</p>
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                    </div>
                    <input class="form-control input-lg" type="text" name="username" placeholder="用户名"/>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control input-lg" name="password" placeholder="密码"/>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-danger form-control input-lg btn-lg" value="提交">
                </div>
                <div class="form-group text-center">
                    <a href="#" class="text-danger h5"><u>注册用户</u></a>
                </div>
            </div>
        </form>
    </div>

    <!-- jquery -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- bootstrap 插件 - all -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>