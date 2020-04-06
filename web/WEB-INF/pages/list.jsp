<%--
  Created by IntelliJ IDEA.
  User: nior
  Date: 2020/1/4
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户管理系统</title>
    <!-- Bootstrap -->
    <%--<link href="/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->--%>
    <%--<script src="/js/jquery.min.js"></script>--%>
    <%--<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->--%>
    <%--<script src="/js/bootstrap.min.js"></script>--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
    <script>

        window.onload = function () {
            //删除单击事件
            document.getElementById("delSelected").onclick = function () {
                if (confirm("您确定要删除吗")) {
                    //判断是否有选中条目
                    var flag = false;
                    var cbs = document.getElementsByName("uid");
                    for (var i = 0;i < cbs.length; i++){
                        if (cbs[i].checked){
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        //表单提交
                        document.getElementById("DelIdForm").submit();}
                    //表单提交
                }
            }
            //全选 全不选
            document.getElementById("firstCb").onclick = function () {
              var cbs = document.getElementsByName("uid");
              for (var i = 0;i < cbs.length; i++){
                  cbs[i].checked = this.checked;
              }
            }
        }
       
    </script>
</head>

<body>

<div class="container">
    <h3 align="center">用户列表信息</h3>
    <div style="float: left">
        <form class="form-inline" action="FindUserByPage?currentPage=1&rows=10" method="post">
            <div class="form-group">
                <label for="username">用户名</label>
                <input type="text" class="form-control" id="username" name="username">
            </div>
            <button type="submit" class="btn btn-default">查找</button>
        </form>
    </div>

    <div style="float: right;margin:5px">
        <a class="btn btn-primary" href="FindUserByPage?currentPage=1&rows=10">所有订单</a>
        <a class="btn btn-primary" href="addorderformJSP">添加订单</a>
        <a class="btn btn-primary" href="javascript:void(0)" id="delSelected">删除选中</a>
    </div>
    <form id="DelIdForm" action="DelSelected" method="post">
        <table style="text-align: center" border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>订单时间</th>
                <th>订单编号</th>
                <th>名字</th>
                <th>电话</th>
                <th>地址</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${PB.list}" var="LOF" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="uid" value="${LOF.order_number}"></td>
                    <td>${LOF.order_time}</td>
                    <td>${LOF.order_number}</td>
                    <td>${LOF.username}</td>
                    <td>${LOF.number}</td>
                    <td>${LOF.address}</td>
                    <td><a class="btn btn-danger btn-small" href="UpdateOrderFormJSP?id=${LOF.order_number}">修改</a>
                        <a class="btn btn-danger btn-small" href="DelOrderForm?id=${LOF.order_number}">退货</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${PB.currentPage==1}">
                    <li style="pointer-events:none">
                </c:if>
                <c:if test="${PB.currentPage!=1}">
                    <li>
                </c:if>
                        <a href="FindUserByPage?currentPage=${PB.currentPage-1}&rows=10" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
               <c:forEach begin="1" end="${PB.totalPage}" var="i">
                   <c:if test="${PB.currentPage == i}">
                       <li class="active"><a href="FindUserByPage?currentPage=${i}&rows=10">${i}</a></li>
                   </c:if>
                   <c:if test="${PB.currentPage != i}">
                       <li><a href="FindUserByPage?currentPage=${i}&rows=10">${i}</a></li>
                   </c:if>
               </c:forEach>

               <c:if test="${PB.currentPage==PB.totalPage}">
                    <li style="pointer-events:none">
               </c:if>
               <c:if test="${PB.currentPage!=PB.totalPage}">
                    <li>
               </c:if>
                        <a href="FindUserByPage?currentPage=${PB.currentPage+1}&rows=10" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                <span style="font-size: 25px;margin: 5px">共${PB.totalCount}条记录，共${PB.totalPage}页</span>
            </ul>
        </nav>
    </div>
</div>

</body>
</html>