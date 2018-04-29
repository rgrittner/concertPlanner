<%--
  Created by IntelliJ IDEA.
  User: reneegrittner
  Date: 2/24/18
  Time: 3:56 AM
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
            <h1>Composers  </h1>
        </div>
<jsp:include page="nav.jsp" />
    </div>


    <div class="dataTables_wrapper">
        <table id="resultTable" class="table table-sm">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Birth Year</th>
                <th scope="col">Death Year</th>
                <th scope="col">Nationality</th>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${composers}" var="current">
                <tr>
                    <td><a name="composerId" value="${current.id}" href="/concertPlanner/ensemble/compositionsByComposer?param=${current.id}">${current.lastName}, ${current.firstName}</a></td>
                    <td>${current.birthYear}</td>
                    <td>${current.deathYear}</td>
                    <td>${current.nationality.nationality}</td>
                    <td>
                        <button type="button" class="btn btn-danger btn-sm" data-toggle="modal"
                                data-target="#${current.id}-Modal"><span class="glyphicon glyphicon-pencil"></span>
                        </button>
                    </td>
                    <td>
                        <form action="/concertPlanner/ensemble/deleteComposer" method="get"><input type="hidden"
                                                                                                     value="${current.id}"
                                                                                                     name="idOfComposerToBeDeleted">
                            <button type="submit" class="btn"><span class="glyphicon glyphicon-trash"></span>
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <c:forEach items="${composers}" var="current">
            <!-- EDIT COMPOSER MODAL -->
            <div class="modal fade" id="${current.id}-Modal" role="dialog">
                <div class="modal-dialog">

                    <%--<!-- Modal content-->--%>
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Edit ${current.lastName}, ${current.firstName}</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-horizontal">
                                <form action="addComposer" method="post">
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
                                        <label for="nationality" class="col-sm-2 control-label">Nationality </label>
                                        <div class="col-sm-10">
                                            <select name="nationality" id="nationality">
                                                    <option value="${current.nationality.id}" selected>${current.nationality.nationality}</option>
                                                <c:forEach items="${nationality}" var="currentNat">
                                                    <option value="${currentNat.id}">${currentNat.nationality}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="birthYear" class="col-sm-2 control-label">Birth Year</label>
                                        <div class="col-sm-10">
                                            <input type="number" id="birthYear" name="birthYear" value="${current.birthYear}"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="deathYear" class="col-sm-2 control-label">Death Year</label>
                                        <div class="col-sm-10">
                                            <input type="number" id="deathYear" name="deathYear" value="${current.deathYear}"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-2"></div>
                                        <input type="hidden" name="ComposerAddOrUpdate" value="2">
                                        <input type="hidden" name="composerId" value="${current.id}">
                                        <div class="col-sm-offset-2 col-sm-10 more-btn">
                                            <button type="submit" class="btn">Edit</button>
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
        </c:forEach>

    </div>
</div>

<jsp:include page="scripts.jsp" />

</body>
</html>
