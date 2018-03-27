<%--
  Created by IntelliJ IDEA.
  User: reneegrittner
  Date: 2/13/18
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp" />
<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Musician  </h1>
        </div>
<jsp:include page="nav.jsp" />


<div>
    <table id="resultTable" class="table table-sm">
       <thead>
            <tr>
                <th scope="col">Last Name</th>
                <th scope="col">First Name</th>
                <th scope="col">Phone</th>
                <th scope="col">Email</th>
                <th scope="col">Status</th>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
            </tr>
       </thead>
       <tbody>
            <c:forEach items="${musicians}" var="current">
                <tr>
                    <td id="${current.id}">${current.lastName}</td>
                    <td>${current.firstName}</td>
                    <td>${current.phoneNumber}</td>
                    <td>${current.email}</td>
                    <td>${current.status}</td>
                    <td><button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#${current.lastName}Modal"><span class="glyphicon glyphicon-pencil"></span></button>

                        <!-- Modal -->
                        <div class="modal fade" id="${current.lastName}Modal" role="dialog">
                            <div class="modal-dialog">

                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Edit ${current.firstName} ${current.lastName}</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="form-horizontal">
                                            <form action="addMusician" method="post">
                                                <div class="form-group">
                                                    <label for="firstName" class="col-sm-2 control-label">First Name</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" id="firstName" name="firstName" value="${current.firstName}"/>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="lastName" class="col-sm-2 control-label">Last Name</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" id="lastName" name="lastName" value="${current.lastName}"/>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="email" class="col-sm-2 control-label">Email</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" id="email" name="email" value="${current.email}"/>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="phone" class="col-sm-2 control-label">Phone Number </label>
                                                    <div class="col-sm-10">
                                                        <input type="text" id="phone" name="phone" value="${current.phoneNumber}"/>
                                                        <input type="hidden" name="musicianId" value="${current.id}"/>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="status" class="col-sm-2 control-label">Status </label>
                                                    <div class="col-sm-10">
                                                        <select id="status" name="status">
                                                            <option value="Active">Active</option>
                                                            <option value="Substitute">Substitute</option>
                                                            <option value="Inactive">Inactive</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2"></div>
                                                    <div class="col-sm-offset-2 col-sm-10 more-btn">
                                                        <button type="submit" class="btn">Edit ${current.firstName}</button>
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
                    <td><span class="glyphicon glyphicon-trash"></span></td>
                </tr>
            </c:forEach>
       </tbody>
   </table>
</div>
</div>
</div>
<jsp:include page="scripts.jsp" />

</body>
</html>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<!-- js for jquery  -->
<script   src="https://code.jquery.com/jquery-3.2.1.min.js"   integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="   crossorigin="anonymous"></script>
<!-- js for jquery datatables -->
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#resultTable').DataTable();
    } );
</script>
