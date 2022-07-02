<%--职工浏览记录历史--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- 引入 Bootstrap -->
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入 font-awesome -->
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>爱心宠物诊所管理系统</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-10">
            <!-- 顶部搜索部分 -->
            <div class="panel panel-default">
                <div class="panel-heading">搜索</div>
                <div class="panel-body">
                    <form role="form" class="form-inline" action="<%= request.getContextPath()%>/VisitServlet?method=search" method="post">
                        <div class="form-group">
                            <label for="name">字段：</label>
                            <select name="key" class="form-control">
                                <option value="petName">宠物名</option>
                                <option value="clientName">客户姓名</option>
                                <option value="visitTime">看望日期</option>
                            </select>
                        </div>
                        <div class="form-group" style="margin-left: 20px">
                            <label for="value">值：</label>
                            <input type="text" class="form-control" name="value" placeholder="字段值" maxlength="12" style="width: 130px">
                        </div>
                        <div class="form-group " style="margin-left: 20px">
                            <button type="submit" class="btn btn-info ">
										<span style="margin-right: 5px"
                                              class="glyphicon glyphicon-search" aria-hidden="true">
										</span>开始搜索
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <!-- 列表展示-->
            <div class="table-responsive">
                <table class="table table-hover ">
                    <thead>
                    <tr>
                        <th>负责职员</th>
                        <th>宠物名</th>
                        <th>宠物品种</th>
                        <th>客户姓名</th>
                        <th>访问日期</th>
                        <th>接待职员</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="visit">
                        <tr>
                            <td>${visit.staffName}</td>
                            <td>${visit.petName}</td>
                            <td>${visit.petVariety}</td>
                            <td>${visit.clientName}</td>
                            <td>${visit.visitTime}</td>
                            <td>${visit.receptionStaffName}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

</body>

</html>