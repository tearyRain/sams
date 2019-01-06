<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../asset/img/favicon.ico">
    <title>Dashboard Template for Bootstrap</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
    <link href="../asset/css/bootstrap.min.css" rel="stylesheet">
    <link href="../asset/css/customized/dashboard.css" rel="stylesheet">
    <link href="../asset/css/MDB/mdb.min.css" rel="stylesheet">
    <link href="../asset/css/MDB/addons/datatables.min.css" rel="stylesheet">
    <link href="../asset/css/datepicker/datepicker.css" rel="stylesheet">
    <link href="../asset/css/form-validation.css" rel="stylesheet">
</head>

<body>
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
        <span class="navbar-brand col-sm-3 col-md-2 text-center bg-transparent" href="#">学生活动管理系统</span>
        <button class="btn btn-grey" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="window.location.href='studentLogout.action'">
            <span data-feather="log-out" aria-hidden="true">
            </span>
            Log out
        </button>
    </nav>

    <div class="container-fluid">
        <div class="row">
            <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                <div class="sidebar-sticky navbar-collapse">
                    <ul class="nav flex-column mt-3 ml-2">
                        <li class="nav-item show">
                            <a class="nav-link" href="javascript:void(0);" onclick="window.location.href='../templates/viewActivity.action'">
                                <span data-feather="sun"></span>
                                活动查询
                                <span class="sr-only">(current)</span>
                            </a>
                            <ul class="list-unstyled ml-4">
                                <li class="nav-item ">
                                    <a class="nav-link" href="javascript:void(0);" onclick="window.location.href='../templates/viewActivity.action'">
                                        <span data-feather="list"></span>
                                        浏览活动
                                        <span class="sr-only">(current)</span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="javascript:void(0);" onclick="window.location.href='../templates/applyActivity.jsp'">
                                        <span data-feather="clipboard"></span>
                                        申请活动
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="javascript:void(0);" onclick="window.location.href='../templates/showAppliedActivity.jsp'">
                                        <span data-feather="file-text"></span>
                                        查看已申请活动
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="javascript:void(0);" onclick="window.location.href='../templates/markActivity.jsp'">
                                        <span data-feather="star"></span>
                                        待评价活动
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0);" onclick="window.location.href='studentInfo.action'">
                                <span data-feather="user"></span>
                                信息维护
                            </a>
                            <ul class="list-unstyled ml-4">
                                <li class="nav-item">
                                    <a class="nav-link active" href="javascript:void(0);" onclick="window.location.href='studentInfo.action'">
                                        <span data-feather="smile"></span>
                                        修改个人信息
                                        <span class="sr-only">(current)</span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="javascript:void(0);" onclick="window.location.href='../templates/studentAccount.jsp'">
                                        <span data-feather="settings"></span>
                                        修改密码
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>

            </nav>

            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
                <h3 class="h3 mt-1">修改个人信息</h3>
                <hr>
                <form class="needs-validation" novalidate id="info-form" action="manageStudentAccount.action" method="post">
                    <div class="row">
                        <div class="col-md-6 mb-2">
                            <div class="">
                                <label for="name" class="text-muted h6">姓名</label>
                                <input type="text" class="form-control disabled" id="name" placeholder="" value="${name}" readonly>
                            </div>
                        </div>
                        <div class="col-md-6 mb-2">
                            <label for="gender" class="text-muted h6">性别</label>
                            <input type="text" class="form-control disabled" id="gender" name="gender" placeholder="" value="${gender}" readonly>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-6 mb-2">
                            <label for="phone" class="text-muted h6">电话</label>
                            <input type="text" class="form-control" id="phone" name="phone" placeholder="" value="${phone}" required>
                            <%--<% if (!first && phone.equals("")) {%>--%>
                            <%--<label class="text-danger">--%>
                                <%--请填写电话--%>
                            <%--</label>--%>
                            <%--<% } %>--%>
                        </div>
                        <div class="col-md-6 mb-2">
                            <label for="birthday" class="text-muted h6">生日</label>
                            <input type="text" class="form-control" id="birthday" name="birthday" placeholder="" value="${birthday}" readonly>
                        </div>
                    </div>

                    <div class="mb-2">
                        <label for="admittedYear" class="text-muted h6">入学日期</label>
                        <input type="text" class="form-control" id="admittedYear" name="admittedYear"  value="${enrollmentDate}" placeholder="" readonly>
                    </div>

                    <hr class="mb-3">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">保存</button>
                </form>

            </main>
        </div>
    </div>

    <script type="text/javascript" src="../asset/js/feather.min.js"></script>
    <script type="text/javascript" src="../asset/js/jquery.js"></script>

    <script type="text/javascript" src="../asset/js/popper.min.js"></script>
    <script type="text/javascript" src="../asset/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../asset/js/datepicker/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="../asset/js/holder.min.js"></script>

    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function() {
            'use strict';

            window.addEventListener('load', function() {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');

                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function(form) {
                    form.addEventListener('submit', function(event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>
    <script>
        feather.replace();
    </script>

</body>
</html>
