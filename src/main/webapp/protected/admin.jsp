<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: reneegrittner
  Date: 4/21/18
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp" />
<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Admin</h1>
        </div>
    </div>
    <jsp:include page="nav.jsp" />
<body>
<c:if test="${errorMessage.length() > 1}">
<div class="alert alert-warning alert-dismissible" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <strong>Warning!</strong> ${errorMessage}
</div>
</c:if>
<h1>Edit User Information</h1>
<div>
    <table id="resultTable2" class="table table-sm">
        <thead>
        <tr>
            <th scope="col">Username</th>
            <th scope="col">Ensemble</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="current">
            <tr>
                <td id="${current.id}">${current.userName}</td>
                <td>${current.ensembleName}</td>

                <td><button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#${current.userName}Modal"><span class="glyphicon glyphicon-pencil"></span></button>

                    <!-- USER INFO MODAL CASE 1 -->
                    <div class="modal fade" id="${current.userName}Modal" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Edit ${current.userName} </h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-horizontal">
                                        <form action="admin" method="post">
                                            <div class="form-group">
                                                <label for="userName" class="col-sm-2 control-label">Username</label>
                                                <div class="col-sm-10">
                                                    <input type="text" id="userName" name="userName" value="${current.userName}"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="ensembleName" class="col-sm-2 control-label">Ensemble Name</label>
                                                <div class="col-sm-10">
                                                    <input type="text" id="ensembleName" name="ensembleName" value="${current.ensembleName}"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-2"></div>
                                                <div class="col-sm-offset-2 col-sm-10 more-btn">
                                                    <input type="hidden" name="userId" value="${current.id}"/>
                                                    <input type="hidden" name="userPassword" value="${current.userPassword}">
                                                    <input type="hidden" name="submissionType" value="1">
                                                    <button type="submit" class="btn">Edit ${current.userName}</button>
                                                </div>

                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>

                        </div>
                    </div>


                </td>
                <td><form action="admin" method="get">
                    <input type="hidden" value="${current.id}" name="idOfUserToBeDeleted">
                    <input type="hidden" value="4" name="submissionType">
                    <button type="submit" class="btn"><span class="glyphicon glyphicon-trash"></span></button></form></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<h1>Edit User Roles</h1><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#add-new-role-modal">Add Role</button>
<div>
    <table id="resultTable" class="table table-sm">
        <thead>
        <tr>
            <th scope="col">Username</th>
            <th scope="col">Role</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userRoles}" var="current">
            <tr>
                <td id="${current.id}">${current.userName}</td>
                <td>${current.userRole}</td>

                <td><button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#role-${current.userName}-${current.userRole}Modal"><span class="glyphicon glyphicon-pencil"></span></button>

                    <!-- USER ROLE UPDATE MODAL CASE 2 -->
                    <div class="modal fade" id="role-${current.userName}-${current.userRole}Modal" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Edit ${current.userName} </h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-horizontal">
                                        <form action="admin" method="post">
                                            <div class="form-group">
                                                <label for="update-role-userName" class="col-sm-2 control-label">Username</label>
                                                <div class="col-sm-10">
                                                    <input type="text" id="update-role-userName" name="update-role-userName" value="${current.userName}"/>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="update-role-userRole" class="col-sm-2 control-label">Status </label>
                                                <div class="col-sm-10">
                                                    <select id="update-role-userRole" name="update-role-userRole">
                                                        <option value="none">Verify User Role</option>
                                                        <option value="admin">Admin</option>
                                                        <option value="ensemble">Ensemble</option>
                                                        <option value="other">Other</option>

                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-2"></div>
                                                <div class="col-sm-offset-2 col-sm-10 more-btn">
                                                    <input type="hidden" name="update-role-userRoleId" value="${current.id}"/>
                                                    <input type="hidden" name="submissionType" value="2">
                                                    <button type="submit" class="btn">Edit ${current.userName}</button>
                                                </div>

                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>

                        </div>
                    </div>


                </td>
                <td><form action="/concertPlanner/deleteUserRole" method="get"><input type="hidden" value="${current.id}" name="idOfUserToBeDeleted"><button type="submit" class="btn"><span class="glyphicon glyphicon-trash"></span></button></form></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- ADD NEW ROLE MODAL -->
    <div class="modal fade" id="add-new-role-modal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Add New Role </h4>
                </div>
                <div class="modal-body">
                    <div class="form-horizontal">
                        <form action="admin" method="post">
                            <div class="form-group">
                                <label for="new-role-userName" class="col-sm-2 control-label">User </label>
                                <div class="col-sm-10">
                                    <select id="new-role-userName" name="new-role-userName">
                                        <option value="0"></option>
                                        <c:forEach items="${users}" var="current">
                                            <option value="${current.userName}">${current.userName}</option>
                                        </c:forEach>


                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="new-role-userRole" class="col-sm-2 control-label">Role </label>
                                <div class="col-sm-10">
                                    <select id="new-role-userRole" name="new-role-userRole">
                                        <option value="none">Verify User Role</option>
                                        <option value="admin">Admin</option>
                                        <option value="ensemble">Ensemble</option>
                                        <option value="guest">Guest</option>
                                        <option value="other">Other</option>

                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2"></div>
                                <div class="col-sm-offset-2 col-sm-10 more-btn">
                                    <input type="hidden" name="userRoleId" value="${current.id}"/>
                                    <input type="hidden" name="submissionType" value="3">
                                    <button type="submit" class="btn">Edit ${current.userName}</button>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>
<jsp:include page="scripts.jsp" />
<!-- js for jquery  -->
<script   src="https://code.jquery.com/jquery-3.2.1.min.js"   integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="   crossorigin="anonymous"></script>
<!-- js for jquery datatables -->
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
