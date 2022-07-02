<%--登录界面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>爱心宠物诊所登录界面</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入 font-awesome -->
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <div class="form row" style="height: 450px;">
        <form class="form-horizontal col-md-offset-3" id="login_form" action="<%= request.getContextPath()%>/account?method=login" method="post">
            <h3 class="form-title">爱心宠物诊所管理系统</h3>
            <div class="col-md-9">
                <div class="form-group">
                    <i class="fa fa-user fa-lg"></i>
                    <span style="color: red;font-size: 13px;margin-left: -17px;">${usernameError}</span>
                    <input class="form-control required" required placeholder="请输入用户名" type="text" name="username"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock fa-lg"></i>
                    <span style="color: red;font-size: 13px;margin-left: -17px;">${passwordError}</span>
                    <input class="form-control required" required placeholder="请输入密码" type="password" name="password"/>
                </div>
                <!-- 验证码模块 -->
                <div class="form-group">
                    <i class="fa glyphicon glyphicon-envelope"></i>
                    <input class="form-control required" type="text" required placeholder="请输入验证码" id="Verify" name="verify-input">
                </div>
                <div class="form-group">
                    <div id="checkCode" class="code" onclick="createCode(4)">
                    </div>
                    <style>
                        .code {
                            font-family: Arial;
                            font-style: italic;
                            color: blue;
                            font-size: 30px;
                            border: 0;
                            padding: 2px 3px;
                            margin-top: -2px;
                            letter-spacing: 3px;
                            align-content: center;
                            align-items: center;
                            font-weight: bolder;
                            float: none;
                            cursor: pointer;
                            width: 150px;
                            height: 50px;
                            line-height: 54px;
                            text-align: center;
                            vertical-align: middle;
                            background-color: #D8B7E3;
                        }
                    </style>
                    <script>
                        window.onload = function() {
                            createCode(4);
                        }

                        //生成验证码的方法
                        function createCode(length) {
                            var code = "";
                            var codeLength = parseInt(length); //验证码的长度
                            var checkCode = document.getElementById("checkCode");
                            //所有候选组成验证码的字符，当然也可以用中文的
                            var codeChars = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
                            //循环组成验证码的字符串
                            for (var i = 0; i < codeLength; i++) {
                                //获取随机验证码下标
                                var charNum = Math.floor(Math.random() * 62);
                                //组合成指定字符验证码
                                code += codeChars[charNum];
                            }
                            if (checkCode) {
                                //为验证码区域添加样式名
                                checkCode.className = "code";
                                //将生成验证码赋值到显示区
                                checkCode.innerHTML = code;
                            }
                        }
                        //检查验证码是否正确
                        function validateCode() {
                            //获取显示区生成的验证码
                            var checkCode = document.getElementById("checkCode").innerHTML;
                            //获取输入的验证码
                            var inputCode = document.getElementById("Verify").value;
                            if (inputCode.length <= 0) {
                                alert("请输入验证码！");
                                return false;
                            } else if (inputCode.toUpperCase() != checkCode.toUpperCase()) {
                                alert("验证码输入错误！");
                                createCode(4);
                                return false;
                            } else {
                                return true;
                            }
                        }
                    </script>
                </div>
                <%--身份选择--%>
                <div class="form-group">
                    <label class="radio-inline">
                        <input type="radio" name="type" checked value="clinicStaff" class="radio-inline" > 诊所职员
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="type"  value="systemAdmin" class="radio-inline"> 系统管理员
                    </label>

                </div>



                <div class="form-group col-md-offset-9">
                    <button type="submit" class="btn btn-success pull-left" name="submit" onclick="return validateCode()">登录</button>
                    <button type="reset" class="btn btn-success pull-right" name="submit">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
