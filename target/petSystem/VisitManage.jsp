<%--职工浏览记录管理--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <!-- 引入 datetimepicker -->
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/moment.js/2.24.0/moment-with-locales.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
    <title>爱心宠物诊所管理系统</title>
</head>
<body>
<div class="container-fluid">
    <form method="post" action="<%= request.getContextPath()%>/VisitServlet?method=save" class="form-horizontal" style="margin-top: 0px" role="form"
          id="form_data" style="margin: 20px;">
        <div role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">添加访问记录信息</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="user_id" class="col-sm-3 control-label">负责职工</label>
                                <div class="col-sm-9">
                                    <select id="staff" required class="form-control" name="staffNumber">
                                        <c:forEach items="${StaffList}" var="staff">
                                            <option value="${staff.number}">${staff.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>



                            <div class="form-group">
                                <label for="user_id" class="col-sm-3 control-label">客人姓名</label>
                                <div class="col-sm-9">
                                    <select id="client" required class="form-control" name="clientId">
                                        <c:forEach items="${ClientList}" var="client">
                                            <option value="${client.id}">${client.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="user_id" class="col-sm-3 control-label">宠物姓名</label>
                                <div class="col-sm-9">
                                    <select id="pet-name" required class="form-control" name="petId">
                                        <c:forEach items="${PetList}" var="pet">
                                            <option value="${pet.id}">${pet.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="user_id" class="col-sm-3 control-label">宠物品种</label>
                                <div class="col-sm-9">
                                    <select id="pet-variety" required class="form-control" name="petId">
                                        <c:forEach items="${PetList}" var="pet">
                                            <option value="${pet.id}">${pet.varieties}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="user_id" class="col-sm-3 control-label">接待职工</label>
                                <div class="col-sm-9">
                                    <select id="staff" required class="form-control" name="receptionStaffNumber">
                                        <c:forEach items="${StaffList}" var="staff">
                                            <option value="${staff.number}">${staff.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>



                            <div class="form-group">
                                <label for="user_id" class="col-sm-3 control-label">访问日期</label>
                                <div class="col-sm-9">
                                    <div class='input-group date' id='datetimepicker'>
                                        <input type='text' name="date" required class="form-control"/>
                                        <span class="input-group-addon">
								    		<span class="glyphicon glyphicon-calendar"></span>
								    	</span>
                                    </div>
                                </div>
                            </div>

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" onclick="return notNull()">提交</button>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function notNull(){
                var staffNumber = document.getElementsByName("staffNumber");
                var clientId = document.getElementsByName("clientId");
                var petId = document.getElementsByName("petId");
                var receptionStaffNumber = document.getElementsByName("receptionStaffNumber");
                if (staffNumber === ""|| clientId === "" || petId === "" || receptionStaffNumber===""){
                    alert("请补全信息！");
                    return false;
                }else{
                    return true;
                }

            }
        </script>
    </form>
</div>
<script>
    $(function(){
        $('#staff').change(function(){
            var id = $(this).val();
            $.ajax({
                url:"<%=request.getContextPath()%>/ClientManage?method=findByStaffNumber&staffNumber="+id,
                type:"post",
                dataType:"json",
                success:function (data) {
                    var clientList = $(data).get(0).clientList
                    var petList = $(data).get(0).petList
                    var str = '';
                    for(var i = 0;i<clientList.length;i++){
                        var client = $(clientList).get(i);
                        str += '<option value="'+client.id+'">'+client.name+'</option>'
                    }
                    $('#client').html(str);
                    // console.log(str)
                    str = '';
                    var strVariety = '';
                    for(var i = 0;i<petList.length;i++){
                        var pet = $(petList).get(i);
                        str += '<option value="'+pet.id+'">'+pet.name+'</option>'
                        strVariety += '<option value="'+pet.id+'">'+pet.varieties+'</option>'
                    }

                    $('#pet-name').html(str);
                    $('#pet-variety').html(strVariety);
                },
                error:function (xhr,excetion) {
                    // alert(xhr.responseText);
                    // alert(xhr.status);
                    if (xhr.status===500){
                        // 未找到数据
                        var str = '<option value=""></option>';
                        $('#client').html(str);
                        $('#pet-name').html(str);
                        $('#pet-variety').html(str);
                    }
                }

            })
        })

        $('#client').change(function(){
            console.log('client'+$(this).val())
            var id = $(this).val();
            $.ajax({
                url:"<%=request.getContextPath()%>/PetManage?method=findByClientId&clientId="+id,
                type:"post",
                dataType:"json",
                success:function (data) {
                    var petList = $(data).get(0).petList
                    // console.log(petList)
                    var str = '';
                    var strVariety = '';
                    if (petList.length == 0){
                        strVariety = '<option value=""></option>';
                        str = '<option value=""></option>';
                    }else{
                        for(var i = 0;i<petList.length;i++){
                            var pet = $(petList).get(i);
                            str += '<option value="'+pet.id+'">'+pet.name+'</option>';
                            strVariety += '<option value="'+pet.id+'">'+pet.varieties+'</option>'
                        }
                    }
                    $('#pet-name').html(str);
                    $('#pet-variety').html(strVariety);
                },
                error:function (xhr,excetion) {
                    if (xhr.status===500){
                        // 未找到数据
                        var str = '<option value=""></option>';
                        $('#pet-name').html(str);
                        $('#pet-variety').html(str);
                    }
                }
            })
        })

        $('#pet-name').change(function(){
            console.log('client'+$(this).val())
            var id = $(this).val();
            $.ajax({
                url:"<%=request.getContextPath()%>/PetManage?method=findByPetId&petId="+id,
                type:"post",
                dataType:"json",
                success:function (data) {
                    var petVariety = $(data).get(0).petVariety
                    // console.log(petVariety)
                    var str = '';
                    if (petVariety === null){
                        str = '<option value=""></option>';
                    }else{
                        str = '<option value="'+petVariety+'">'+ petVariety +'</option>';
                    }
                    $('#pet-variety').html(str);
                },
                error:function (xhr,excetion) {
                    if (xhr.status===500){
                        // 未找到数据
                        var str = '<option value=""></option>';
                        $('#pet-variety').html(str);
                    }
                }
            })
        })

        $('#datetimepicker').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: moment.locale('zh-cn'),
        });
    })
</script>
</body>

</html>