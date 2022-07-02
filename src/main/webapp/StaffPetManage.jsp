<%--职工宠物管理--%>
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
                    <form role="form" class="form-inline" action="<%= request.getContextPath()%>/PetManage?method=search" method="post">
                        <div class="form-group">
                            <label for="name">字段：</label>
                            <select name="key" class="form-control">
                                <option value="id">宠物编号</option>
                                <option value="petName">宠物姓名</option>
                                <option value="staffName">负责职工姓名</option>
                                <option value="isCure">治疗状态</option>
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
											<i class="fa fa-user-plus">添加宠物信息</i>
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
                        <th>年龄</th>
                        <th>品种</th>
                        <th>症状</th>
                        <th>治疗状况</th>
                        <th>主人姓名</th>
                        <th>主治医师</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="pet">
                        <tr>
                            <td>${pet.id}</td>
                            <td>${pet.name}</td>
                            <td>${pet.gender}</td>
                            <td>${pet.age}</td>
                            <td>${pet.varieties}</td>
                            <td>${pet.symptom}</td>
                            <td>${pet.isCure}</td>
                            <td>${pet.clientName}</td>
                            <td>${pet.doctorName}</td>
                            <td>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default "
                                            data-id="${pet.id}"
                                            data-name="${pet.name}"
                                            data-gender="${pet.gender}"
                                            data-age="${pet.age}"
                                            data-varieties = "${pet.varieties}"
                                            data-symptom = "${pet.symptom}"
                                            data-isCure = "${pet.isCure}"
                                            data-clientName = "${pet.clientName}"
                                            data-doctorName = "${pet.doctorName}"
                                            data-toggle="modal"
                                            data-target="#updateUserModal">
                                        <i class="fa fa-user-o">修改</i>
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <!-- 新增宠物信息 -->
                <form method="post" action="<%= request.getContextPath()%>/PetManage?method=save" class="form-horizontal" style="margin-top: 0px" role="form"
                      id="form_data" style="margin: 20px;">
                    <div class="modal fade" id="addUserModal" tabindex="-1"
                         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">x</button>
                                    <h4 class="modal-title" id="myModalLabel">添加宠物信息</h4>
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
                                                <input type="radio" checked value="公" class="gender"
                                                       name="gender"> 公
                                                &nbsp;&nbsp;&nbsp;<input type="radio" value="母" class="gender"
                                                                         name="gender"> 母
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">年龄</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="age"
                                                       name="age" value="" placeholder="请输入年龄">
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
                                            <label for="user_id" class="col-sm-3 control-label">症状</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="symptom"
                                                       name="symptom" value="" placeholder="请输入症状">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">治疗情况</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="isCure"
                                                       name="isCure" value="" placeholder="请输入治疗情况">
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">主人姓名</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="clientName"
                                                       name="clientName" value="" placeholder="请输入主人姓名">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">主治医师</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="doctorName"
                                                       name="doctorName" value="" placeholder="请输入主治医师">
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
                <form method="post" action="<%= request.getContextPath()%>/PetManage?method=update" class="form-horizontal" style="margin-top: 0px" role="form"
                      id="form_data" style="margin: 20px;">
                    <div class="modal fade" id="updateUserModal" tabindex="-1"
                         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">x</button>
                                    <h4 class="modal-title" id="myModalLabel">宠物信息</h4>
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
                                                <input type="radio" checked value="公" class="gender"
                                                       name="gender"> 公
                                                &nbsp;&nbsp;&nbsp;<input type="radio" value="母" class="gender"
                                                                         name="gender"> 母
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">年龄</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="age"
                                                       name="age" value="" placeholder="请输入联系方式">
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
                                            <label for="user_id" class="col-sm-3 control-label">症状</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="symptom"
                                                       name="symptom" value="" placeholder="请输入症状">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">治疗情况</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="iscure"
                                                       name="iscure" value="" placeholder="请输入治疗情况">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">主人姓名</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="clientname"
                                                       name="clientname" value="" placeholder="请输入主人姓名">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">主治医师</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="doctorname"
                                                       name="doctorname" value="" placeholder="请输入主治医师">
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


            </div>
        </div>
    </div>
</div>

<script>
    $('#updateUserModal').on('show.bs.modal', function(event) {
        //bootstrap语法,数据回填
        var button = $(event.relatedTarget)

        <%--data-id="${pet.id}"--%>
        <%--data-name="${pet.name}"--%>
        <%--data-gender="${pet.gender}"--%>
        <%--data-age="${pet.age}"--%>
        <%--data-varieties = "${pet.varieties}"--%>
        <%--data-symptom = "${pet.symptom}"--%>
        <%--data-isCure = "${pet.isCure}"--%>
        <%--data-clientName = "${pet.clientName}"--%>
        <%--data-doctorName = "${pet.doctorName}"--%>

        var id = button.data('id')
        var name = button.data('name')
        var gender = button.data('gender')
        var age = button.data('age')
        var varieties = button.data('varieties')
        var symptom = button.data('symptom')
        var clientName = button.data('clientname')
        var doctorName = button.data('doctorname')
        var isCure = button.data('iscure')
        var modal = $(this)

        modal.find('.modal-title').text('宠物信息')
        modal.find('#id').val(id)
        modal.find('#name').val(name)
        modal.find('#age').val(age)
        modal.find('#varieties').val(varieties)
        modal.find('#symptom').val(symptom)
        modal.find('#clientname').val(clientName)
        modal.find('#doctorname').val(doctorName)
        modal.find('#iscure').val(isCure)
        
        var genderList = modal.find('.gender')
        // jquery匹配，哪个单元框值和数据相当
        for(var i=0;i<genderList.length;i++){
            if(gender == $(genderList.get(i)).val()){
                $(genderList.get(i)).prop('checked',true)
            }
        }


    })

</script>

</body>

</html>