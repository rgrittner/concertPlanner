<%--
  Created by IntelliJ IDEA.
  User: reneegrittner
  Date: 3/29/18
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>
<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Instruments </h1>
        </div>
        <jsp:include page="nav.jsp"/>

        <div class="lines">
            <div class="more-btn">
                <button type="button" class="btn" data-toggle="modal" data-target="#CategoryModal">Add Category</button>
            </div>
            <div class="more-btn">
                <button type="button" class="btn" data-toggle="modal" data-target="#InstrumentModal">Add Instrument</button>
            </div>
        </div>

        <div class="content-wrap">
            <div class="main-title spacing-bt">


        <div>
            <table id="resultTable" class="table table-sm">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Category</th>

                </tr>
                </thead>
                <tbody>
                <tr>
                    <c:forEach items="${instruments}" var="current">
                <tr>
                    <td>${current.name}</td>
                    <td>${current.instrumentCategory.category}</td>
                </tr>
                </c:forEach>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
        </div>
</div>

<!-- Modal -->
<div class="modal fade" id="CategoryModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add New Instrument Category</h4>
            </div>
            <div class="modal-body">
                <div class="form-horizontal">
                    <form action="/concertPlanner/ensemble/addInstrumentCategory" method="post">
                        <div class="form-group">
                            <label for="category" class="col-sm-2 control-label">Category</label>
                            <div class="col-sm-10">
                                <input type="text" id="category" name="category" />
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-offset-2 col-sm-10 ">
                                <button type="submit" class="btn">Add</button>
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
<!-- Modal -->
<div class="modal fade" id="InstrumentModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add New Instrument Category</h4>
            </div>
            <div class="modal-body">
                <div class="form-horizontal">
                    <form action="/concertPlanner/ensemble/addInstrument" method="post">
                        <div class="form-group">
                            <label for="instrument" class="col-sm-2 control-label">Instrument Name</label>
                            <div class="col-sm-10">
                                <input type="text" id="instrument" name="instrument" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="newInstrumentCategory" class="col-sm-2 control-label">Category </label>
                            <div class="col-sm-10">
                                <select name="newInstrumentCategory" id="newInstrumentCategory">
                                    <c:forEach items="${categories}" var="current2">
                                        <option value="${current2.id}">${current2.category}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-offset-2 col-sm-10 ">
                                <button type="submit" class="btn">Add</button>
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
<jsp:include page="scripts.jsp"/>


<!-- js for jquery -->
