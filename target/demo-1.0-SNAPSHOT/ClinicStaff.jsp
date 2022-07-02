<%--诊所职工界面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>爱心宠物诊所管理系统-诊所职工</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- 引入 Bootstrap -->
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入 font-awesome -->
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="application/javascript">
        function change(url,index){
            $(".list-group-item").removeClass("active");
            $(".list-group-item").eq(index).addClass("active");
            $("iframe").attr("src",url);
        }
    </script>
</head>
<body>

<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <ul class="nav navbar-nav navbar-left">
            <li>
                <a style="font-size: 26px;">爱心宠物诊所-诊所职工</a>
            </li>
        </ul>
        <span style="color: #CCCCCC;font-size: 26px;position: relative;top: 5px;"></span>


        <ul class="nav navbar-nav navbar-right">
            <li>
                <%--EL表达式--%>
                <a>欢迎您,${clinicStaff.name}</a>
            </li>
            <li>
                <%--安全退出，销毁session--%>
                <a href="<%= request.getContextPath()%>/account?method=logout">安全退出</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-2">

            <a href="javascript:void(0)" class="list-group-item active" onclick="change('<%= request.getContextPath()%>/VeterinarianManage?method=staffList',0)">
						<span class="" aria-hidden="true">
							<i class="fa fa-user-circle-o fa-fw"></i>
						</span>兽医管理
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('<%= request.getContextPath()%>/ClientManage?method=list',1)">
						<span class="" aria-hidden="true">
							<i class="fa fa-user-circle fa-fw"></i>
						</span>客户信息管理
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('<%= request.getContextPath()%>/PetManage?method=list',2)">
						<span class="" aria-hidden="true">
							<i class="fa fa-user-circle fa-fw"></i>
						</span>宠物信息管理
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('<%= request.getContextPath()%>/VisitServlet?method=init',3)">
                        <span class="" aria-hidden="true">
                            <i class="fa fa-home fa-fw"></i>
                        </span>宠物访问登记
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('<%= request.getContextPath()%>/VisitServlet?method=list',4)">
                        <span class="" aria-hidden="true">
                            <i class="fa fa-home fa-fw"></i>
                        </span>宠物访问记录
            </a>
        </div>
        <!--右边内容-->
        <iframe style="width: 81%; height: 600px; border: 0px;" src="<%= request.getContextPath()%>/VeterinarianManage?method=staffList"></iframe>
    </div>
</div>

</body>
</html>
