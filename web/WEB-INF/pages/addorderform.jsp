<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加联系人</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
</head>
<script>

</script>
<body>
<div class="container">
    <h3 align="center">添加订单</h3>
    <form action="AddOrderForm" method="post" onsubmit="">
        <div class="form-group">
            <label for="username">姓名:</label>
            <input type="text" class="form-control" required="required" id="username" name="username" placeholder="请输入姓名"/>
        </div>

        <div class="form-group">
            <label for="number">电话号码</label>
            <input type="text" class="form-control" required="required" id="number" name="number" placeholder="请输入电话号码"/>
        </div>

        <div class="form-group">
            <label for="address">地址</label>
            <input type="text" class="form-control" required="required"  id="address" name="address" placeholder="请输入地址"/>
        </div>

        <div class="form-group" style="">
            <input class="btn btn-primary" type="submit" value="提交">
            <a class="btn btn-primary" href="addorderformJSP">重置</a>
            <a class="btn btn-primary" href="ReturnListJSP">返回</a>
        </div>
    </form>
</div>
</body>
</html>
