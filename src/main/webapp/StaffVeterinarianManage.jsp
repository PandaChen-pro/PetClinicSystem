<%--职员兽医管理--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%
  request.setCharacterEncoding("utf-8");
%>
<div class="container-fluid">
  <div class="row">

    <div class="col-sm-10">
      <!-- 顶部搜索部分 -->
      <div class="panel panel-default">
        <div class="panel-heading">搜索</div>
        <div class="panel-body">
          <form role="form" class="form-inline" action="<%= request.getContextPath()%>/VeterinarianManage?method=search" method="post">
            <div class="form-group">
              <label for="name">字段：</label>
              <select name="key" class="form-control">
                <option value="worknumber">兽医工号</option>
                <option value="name">兽医姓名</option>
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
            <th>工号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>联系方式</th>
            <th>专业特长</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${list}" var="veterinarian">
            <tr>
              <td>${veterinarian.workNumber}</td>
              <td>${veterinarian.name}</td>
              <td>${veterinarian.gender}</td>
              <td>${veterinarian.telephone}</td>
              <td>${veterinarian.speciality}</td>
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