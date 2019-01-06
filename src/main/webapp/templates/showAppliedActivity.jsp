<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../asset/img/favicon.ico">
    <title>学生管理系统——查看已申请活动</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
    <link href="../asset/css/bootstrap.min.css" rel="stylesheet">
    <link href="../asset/css/customized/dashboard.css" rel="stylesheet">
    <link href="../asset/css/MDB/mdb.min.css" rel="stylesheet">
    <link href="../asset/css/MDB/addons/datatables.min.css" rel="stylesheet">
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
                        <a class="nav-link" href="javascript:void(0);" onclick="window.location.href='viewActivity.action'">
                            <span data-feather="sun"></span>
                            活动查询
                            <span class="sr-only">(current)</span>
                        </a>
                        <ul class="list-unstyled ml-4">
                            <li class="nav-item ">
                                <form action="viewActivity.action">
                                    <a class="nav-link" href="javascript:void(0);" onclick="window.location.href='viewActivity.action'">
                                        <span data-feather="list"></span>
                                        浏览活动
                                        <span class="sr-only">(current)</span>
                                    </a>
                                </form>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="javascript:void(0);" onclick="window.location.href='../templates/applyActivity.jsp'">
                                    <span data-feather="clipboard"></span>
                                    申请活动
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="javascript:void(0);" onclick="window.location.href='../templates/showAppliedActivity.jsp'">
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
                                <a class="nav-link" href="javascript:void(0);" onclick="window.location.href='manageStudentAccount.action'">
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
            <h3 class="h3 mt-1">已申请活动</h3>
            <hr>
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="participant-tab" data-toggle="tab" href="#participant" role="tab" aria-controls="home" aria-selected="true">参与者</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="volunteer-tab" data-toggle="tab" href="#volunteer" role="tab" aria-controls="profile" aria-selected="false">志愿者</a>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active mt-2" id="participant" role="tabpanel" aria-labelledby="participant-tab">
                    <table id="participantTable" class="table table-striped table-bordered table-table" cellspacing="0" width="100%">
                        <thead>
                        <tr>
                            <th class="th-sm">活动名称
                            </th>
                            <th class="th-sm">组织
                            </th>
                            <th class="th-sm">开始时间
                            </th>
                            <th class="th-sm">结束时间
                            </th>
                            <th class="th-sm">退申操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <a class="dropdown-toggle text-dark" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    五水共治研讨会
                                </a>
                                <div class="dropdown-menu">
                                    <div class="card-body col-sm-6">
                                        <h6 class="card-title">活动描述</h6>
                                        <p class="card-text"> 无活动描述 </p>
                                    </div>
                                </div>
                            </td>
                            <td>社团联合会</td>
                            <td>2018-01-12  12:24:10</td>
                            <td>2018-02-12  12:24:10</td>
                            <td>
                                <button type="button" class="btn btn-danger btn-sm"><i data-feather="minus-circle"></i>退申</button>
                            </td>
                        </tr>
                        </tbody>
                        <tfoot>
                        <tr>
                            <th>活动名称
                            </th>
                            <th>组织
                            </th>
                            <th>开始时间
                            </th>
                            <th>结束时间
                            </th>
                            <th>退申操作
                            </th>
                        </tr>
                        </tfoot>
                    </table>
                </div>
                <div class="tab-pane fade show mt-2" id="volunteer" role="tabpanel" aria-labelledby="volunteer-tab">
                    <table id="volunteerTable" class="table table-striped table-bordered table-table" cellspacing="0" width="100%">
                        <thead>
                        <tr>
                            <th class="th-sm">活动名称
                            </th>
                            <th class="th-sm">组织
                            </th>
                            <th class="th-sm">开始时间
                            </th>
                            <th class="th-sm">结束时间
                            </th>
                            <th class="th-sm">退申操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <a class="dropdown-toggle text-dark" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Tiger Nixon
                                </a>
                                <div class="dropdown-menu">
                                    <div class="card-body col-sm-6">
                                        <h6 class="card-title">活动描述</h6>
                                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    </div>
                                </div>
                            </td>
                            <td>System Architect</td>
                            <td>Edinburgh</td>
                            <td>61</td>
                            <td>
                                <button type="button" class="btn btn-danger btn-sm"><i data-feather="minus-circle"></i>退申</button>
                            </td>
                        </tr>
                        </tbody>
                        <tfoot>
                        <tr>
                            <th>活动名称
                            </th>
                            <th>组织
                            </th>
                            <th>开始时间
                            </th>
                            <th>结束时间
                            </th>
                            <th>退申操作
                            </th>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </main>
    </div>
</div>

<script type="text/javascript" src="../asset/js/feather.min.js"></script>
<script type="text/javascript" src="../asset/js/jquery.js"></script>

<script type="text/javascript" src="../asset/js/popper.min.js"></script>
<script type="text/javascript" src="../asset/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../asset/js/MDB/mdb.min.js"></script>
<script type="text/javascript" src="../asset/js/MDB/addons/datatables.min.js"></script>
<script>
    feather.replace()
</script>
<script>
    $(document).ready(function () {
        $('#participantTable').DataTable();
        $('#volunteerTable').DataTable();
        $('.dataTables_length').addClass('bs-select');
    });
</script>


</body>
</html>

