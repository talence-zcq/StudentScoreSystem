<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="">
<head>
    <% String path=request.getContextPath(); %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Login Page</title>
    <script src="<%=path%>/js/login_code1.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/my-login.css">
</head>
<body class="my-login-page">
<%
    String mess=(String)session.getAttribute("message");
    if("".equals(mess)  || mess==null){

    }
    else{%>
<script type="text/javascript">
    alert("<%=mess%>");
</script>
<% session.setAttribute("message", "");}%>
<section class="h-100">
    <div class="container h-100 disappear">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <div class="brand">
                    <img src="<%=path%>/img/cridet.png" alt="logo">
                </div>
                <div class="card fat">
                    <div class="card-body">
                        <h4 class="card-title">学生成绩管理系统</h4>
                        <form method="POST" class="my-login-validation" novalidate="" action="/final_database_war_exploded/loginServlet">
                            <div class="form-group">
                                <label for="name">用户类型：</label>
                                <select id="kind" type="kind" class="form-control" name="kind">
                                    <option value="student" selected="selected">学生</option>
                                    <option value="teacher">教师</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="name">用户名：</label>
                                <input id="name" type="email" class="form-control" name="username" value="">
                            </div>

                            <div class="form-group">
                                <input id="pwd" type="password" class="form-control" name="password">
                            </div>

                            <div class="form-group">
                                <div class="custom-checkbox custom-control">
                                    <input type="checkbox" name="remember" id="remember" class="custom-control-input">
                                    <label for="remember" class="custom-control-label">记住我</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>验证码:</label>
                                <input type="text" id="inputCode" required="" class="form-control" style="width: 180px">
                                <div id="checkCode" class="code"  onclick="createCode(4)" ></div>
                                <div class="change" onclick="createCode(4)">换一张</div>
                            </div>
                            <div class="form-group m-0">
                                <button type="submit" class="btn btn-primary btn-block" onclick="return check_code(this.form);">
                                    登录
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="footer">
                    Copyright &copy; 2021 zjut 数据库课程设计 by 张成强
                </div>
            </div>
        </div>
    </div>
</section>
<script src="<%=path%>/js/pointandline.js" type="text/javascript"></script>
</body>
</html>
