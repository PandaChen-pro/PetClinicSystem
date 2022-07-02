<%--职工客户管理--%>
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
                    <form role="form" class="form-inline" action="<%= request.getContextPath()%>/ClientManage?method=search" method="post">
                        <div class="form-group">
                            <label for="name">字段：</label>
                            <select name="key" class="form-control">
                                <option value="id">客户编号</option>
                                <option value="name">客户姓名</option>
                                <option value="petName">宠物姓名</option>
                                <option value="staffName">负责职工姓名</option>
                                <option value="isOk">完成状态</option>
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
                        <div class="form-group " style="margin-left: 48px">
                            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#addUserModal">
										<span style="margin-right: 5px" class="" aria-hidden="true">
											<i class="fa fa-user-plus">添加客户信息</i>
											</span>
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
                        <th>编号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>联系方式</th>
                        <th>宠物姓名</th>
                        <th>宠物品种</th>
                        <th>负责职工姓名</th>
                        <th>是否完成</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="client">
                        <tr>
                            <td>${client.id}</td>
                            <td>${client.name}</td>
                            <td>${client.gender}</td>
                            <td>${client.telephone}</td>
                            <td>${client.petName}</td>
                            <td>${client.varieties}</td>
                            <td>${client.staffName}</td>
                            <td>${client.isOk}</td>
                            <td>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default "
                                            data-id="${client.id}"
                                            data-name="${client.name}"
                                            data-gender="${client.gender}"
                                            data-telephone="${client.telephone}"
                                            data-petname = "${client.petName}"
                                            data-varieties = "${client.varieties}"
                                            data-staffname = "${client.staffName}"
                                            data-isok = "${client.isOk}"
                                            data-toggle="modal"
                                            data-target="#updateUserModal">
                                        <i class="fa fa-user-o">修改</i>
                                    </button>

<%--                                    <button type="button" class="btn btn-danger "--%>
<%--                                            data-id="${client.id}" data-toggle="modal"--%>
<%--                                            onclick="" data-target="#delUserModal">--%>
<%--                                        <i class="fa fa-user-times">删除</i>--%>
<%--                                    </button>--%>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <!-- 新增职工信息 -->
                <form method="post" action="<%= request.getContextPath()%>/ClientManage?method=save" class="form-horizontal" style="margin-top: 0px" role="form"
                      id="form_data" style="margin: 20px;">
                    <div class="modal fade" id="addUserModal" tabindex="-1"
                         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">x</button>
                                    <h4 class="modal-title" id="myModalLabel">添加客户信息</h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">编号</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="id"
                                                       name="id" placeholder="请输入编号">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">姓名</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="name"
                                                       name="name" value="" placeholder="请输入姓名">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">性别</label>
                                            <div class="col-sm-9">
                                                <input type="radio" checked value="男" class="gender"
                                                       name="gender"> 男
                                                &nbsp;&nbsp;&nbsp;<input type="radio" value="女" class="gender"
                                                                         name="gender"> 女
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">联系方式</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="telephone"
                                                       name="telephone" value="" placeholder="请输入联系方式">
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">宠物姓名</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="petName"
                                                       name="petName" value="" placeholder="请输入宠物姓名">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">宠物品种</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="varieties"
                                                       name="varieties" value="" placeholder="请输入宠物品种">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">负责职工姓名</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="staffName"
                                                       name="staffName" value="" placeholder="请输入负责职工姓名">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                    <button type="submit" class="btn btn-primary">提交</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <!-- 修改职工信息 -->
                <form method="post" action="<%= request.getContextPath()%>/ClientManage?method=update" class="form-horizontal" style="margin-top: 0px" role="form"
                      id="form_data" style="margin: 20px;">
                    <div class="modal fade" id="updateUserModal" tabindex="-1"
                         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">x</button>
                                    <h4 class="modal-title" id="myModalLabel">客户信息</h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">编号</label>
                                            <div class="col-sm-9">
                                                <input type="text" readonly required class="form-control" id="id"
                                                       name="id">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">姓名</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="name"
                                                       name="name" value="" placeholder="请输入姓名">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">性别</label>
                                            <div class="col-sm-9">
                                                <input type="radio" checked value="男" class="gender"
                                                       name="gender"> 男
                                                &nbsp;&nbsp;&nbsp;<input type="radio" value="女" class="gender"
                                                                         name="gender"> 女
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">联系方式</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="telephone"
                                                       name="telephone" value="" placeholder="请输入联系方式">
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">宠物姓名</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="petname"
                                                       name="petname" value="" placeholder="请输入宠物姓名">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">宠物品种</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="varieties"
                                                       name="varieties" value="" placeholder="请输入宠物品种">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">负责职工姓名</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="staffname"
                                                       name="staffname" value="" placeholder="请输入负责职工姓名">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">是否完成</label>
                                            <div class="col-sm-9">
                                                <input type="radio" checked value="是" class="isok"
                                                       name="isok"> 是
                                                &nbsp;&nbsp;&nbsp;<input type="radio" value="否" class="isok"
                                                                         name="isok"> 否
                                            </div>
<%--                                                <input type="" required class="form-control" id="isOk"--%>
<%--                                                       name="isOk" value="" placeholder="请输入负责职工姓名">--%>

                                        </div>



                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                    <button type="submit" class="btn btn-primary">提交</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>


            </div>
        </div>
    </div>
</div>

<script>
    $('#updateUserModal').on('show.bs.modal', function(event) {
        //bootstrap语法,数据回填
        var button = $(event.relatedTarget)
        <%--data-id="${client.id}"--%>
        <%--data-name="${client.name}"--%>
        <%--data-gender="${client.gender}"--%>
        <%--data-telephone="${client.telephone}"--%>
        <%--data-petName = "${client.petName}"--%>
        <%--data-varieties = "${client.varieties}"--%>
        <%--data-staffName = "${client.staffName}"--%>
        <%--data-isOk = "${client.isOk}"--%>
        var id = button.data('id')
        var name = button.data('name')
        var gender = button.data('gender')
        var telephone = button.data('telephone')
        var petName = button.data('petname')
        var varieties = button.data('varieties')
        var staffName = button.data('staffname')
        var isOk = button.data('isok')
        var modal = $(this)

        modal.find('.modal-title').text('客户信息')
        modal.find('#id').val(id)
        modal.find('#name').val(name)
        modal.find('#telephone').val(telephone)
        modal.find('#petname').val(petName)
        modal.find('#varieties').val(varieties)
        modal.find('#staffname').val(staffName)
        var genderList = modal.find('.gender')
        // jquery匹配，哪个单元框值和数据相当
        for(var i=0;i<genderList.length;i++){
            if(gender == $(genderList.get(i)).val()){
                $(genderList.get(i)).prop('checked',true)
            }
        }
        var isOkList = modal.find('.isok')
        for (var i=0;i<isOkList.length;i++){
            if(isOk == $(isOkList.get(i)).val()){
                $(isOkList.get(i)).prop('checked',true)
            }
        }

    })

    // $('#delUserModal').on('show.bs.modal', function(event) {
    //     var button = $(event.relatedTarget)
    //     var id = button.data('id')
    //     var modal = $(this)
    //     modal.find('.modal-title').text('删除客户信息')
    //     modal.find('#deleteLabel').text('是否删除编号为  ' + id + ' 的信息')
    //     modal.find('#id').val(id)
    // })
</script>

</body>

</html>