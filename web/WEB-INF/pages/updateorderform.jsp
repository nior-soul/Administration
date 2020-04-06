<%--
  Created by IntelliJ IDEA.
  User: nior
  Date: 2020/3/3
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>修改订单</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3 align="center">修改订单</h3>
    <form action="UpdateOrderForm" method="post">

        <div class="form-group">
            <label for="order_number">单号</label>
            <input type="text" readonly unselectable="on" class="form-control" id="order_number" name="order_number" value="${UOF.order_number}"/>
        </div>

        <div class="form-group">
            <label for="username">姓名:</label>
            <input type="text" class="form-control" required="required" id="username" name="username" value="${UOF.username}"/>
        </div>

        <div class="form-group">
            <label for="order_time">下单时间:</label>
            <input type="text" readonly unselectable="on"class="form-control"id="order_time" name="order_time" value="${UOF.order_time}"/>
        </div>

        <div class="form-group">
            <label for="number">电话号码</label>
            <input type="text" class="form-control" required="required" id="number" name="number" value="${UOF.number}"/>
        </div>

        <div class="form-group">
            <label for="address">地址</label>
            <input type="text" class="form-control" required="required" id="address" name="address" value="${UOF.address}" />
        </div>

        <div class="form-group" style="">
            <input class="btn-primary" type="submit" value="提交">
            <a class="btn btn-primary" href="UpdateOrderFormJSP">重置</a>
            <a class="btn btn-primary" href="ReturnListJSP">返回</a>
        </div>
    </form>
</div>
</body>
</html>
