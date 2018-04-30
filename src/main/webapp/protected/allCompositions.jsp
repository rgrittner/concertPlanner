
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
            <h1>Compositions  </h1>
        </div>
        <jsp:include page="nav.jsp" />
        <div class="lines">
            <div class="more-btn">
                <button type="button" class="btn" data-toggle="modal" data-target="#AddCompositionModal">Add Composition</button>
            </div>
        </div>


            <div>
                <table id="resultTable" class="table table-sm">
                    <thead>
                    <tr>
                        <th scope="col">Title</th>
                        <th scope="col">Composer</th>
                        <th scope="col">Arranger</th>
                        <th scope="col">Duration (minutes)</th>
                        <th scope="col">Year of Composition</th>
                        <th scope="col">Number of Players</th>
                        <th scope="col">Clocks commission?</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${compositions}" var="current">
                        <tr>
                            <td><a name="compositionId" value="${current.id}" href="/concertPlanner/ensemble/singleComposition?param=${current.id}">${current.title}</a></td>
                            <td>${current.composer.lastName}, ${current.composer.firstName}</td>
                            <td>${current.arranger}</td>
                            <td>${current.duration}</td>
                            <td>${current.yearComposed}</td>
                            <td>${current.numberOfPlayers}</td>
                            <td><c:if test="${current.clocksCommission}">Yes</c:if><c:if test="${current.clocksCommission == false}">No</c:if></td>
                            <td>
                                <button type="button" class="btn btn-danger btn-sm" data-toggle="modal"
                                        data-target="#${current.id}-Modal"><span class="glyphicon glyphicon-pencil"></span>
                                </button>
                            </td>
                            <td>
                                <form action="/concertPlanner/ensemble/deleteComposition" method="get"><input type="hidden"
                                                                                                           value="${current.id}"
                                                                                                           name="idOfCompositionToBeDeleted">
                                    <button type="submit" class="btn"><span class="glyphicon glyphicon-trash"></span>
                                    </button>
                                </form>
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <c:forEach items="${compositions}" var="current">
                    <!-- EDIT COMPOSITION MODAL -->
                    <div class="modal fade" id="${current.id}-Modal" role="dialog">
                        <div class="modal-dialog">

                                <%--<!-- Modal content-->--%>
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Edit ${current.title}</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-horizontal">
                                        <form action="/concertPlanner/ensemble/addComposition" method="post">
                                            <div class="form-group">
                                                <label for="title" class="col-sm-2 control-label">Title</label>
                                                <div class="col-sm-10">
                                                    <input type="text" id="title" name="title" value="${current.title}"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="composer" class="col-sm-2 control-label">Composer</label>
                                                <div class="col-sm-10">
                                                    <select id="composer" name="composer">
                                                            <option value="${current.composer.id}" selected>${current.composer.lastName}, ${current.composer.firstName}</option>
                                                        <c:forEach items="${composers}" var="current2">
                                                            <option value="${current2.id}">${current2.lastName}, ${current2.firstName}</option>
                                                        </c:forEach>
                                                    </select>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="arranger" class="col-sm-2 control-label">Arranged By (optional) </label>
                                                <div class="col-sm-10">
                                                    <input type="text" id="arranger" name="arranger" value="${current.arranger}"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="year" class="col-sm-2 control-label">Year Composed </label>
                                                <div class="col-sm-10">
                                                    <input type="number" id="year" name="year" value="${current.yearComposed}"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="numberOfPlayers" class="col-sm-2 control-label">Number of Players </label>
                                                <div class="col-sm-10">
                                                    <input type="number" id="numberOfPlayers" name="numberOfPlayers" value="${current.numberOfPlayers}"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="duration" class="col-sm-2 control-label">Duration </label>
                                                <div class="col-sm-10">
                                                    <input type="text" id="duration" name="duration" value="${current.duration}"/> minutes
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="clocksCommission" class="col-sm-2 control-label">Commissioned by Ensemble? </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="clocksCommission" id="clocksCommission" value="0" <c:if test="${current.clocksCommission == false}">checked</c:if>> No
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="clocksCommission" id="inlineRadio2" value="1" <c:if test="${current.clocksCommission}">checked</c:if>> Yes
                                                </label>
                                            </div>

                                            <div class="form-group">
                                                <label for="notes" class="col-sm-2 control-label">Notes (optional) </label>
                                                <div class="col-sm-10">
                                                    <textarea name="notes" id="notes" class="form-control" rows="2" value="${current.notes}"></textarea>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-2"></div>
                                                <div class="col-sm-offset-2 col-sm-10 more-btn">
                                                    <input type="hidden" name="compositionId" value="${current.id}">
                                                    <input type="hidden" name="CompositionAddOrUpdate" value="2">
                                                    <button type="submit" class="btn">Edit ${current.title}</button>
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

                <!-- ADD COMPOSITION MODAL -->
                <div class="modal fade" id="AddCompositionModal" role="dialog">
                    <div class="modal-dialog">

                        <%--<!-- Modal content-->--%>
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Add Composer</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-horizontal">
                                    <form action="/concertPlanner/ensemble/addComposition" method="post">
                                        <div class="form-group">
                                            <label for="titleNew" class="col-sm-2 control-label">Title</label>
                                            <div class="col-sm-10">
                                                <input type="text" id="titleNew" name="title"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="composerNew" class="col-sm-2 control-label">Composer</label>
                                            <div class="col-sm-10">
                                                <select id="composerNew" name="composer">
                                                    <c:forEach items="${composers}" var="current">
                                                        <option value="${current.id}">${current.lastName}, ${current.firstName}</option>
                                                    </c:forEach>
                                                </select>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="arrangerNew" class="col-sm-2 control-label">Arranged By (optional) </label>
                                            <div class="col-sm-10">
                                                <input type="text" id="arrangerNew" name="arranger"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="yearNew" class="col-sm-2 control-label">Year Composed </label>
                                            <div class="col-sm-10">
                                                <input type="number" id="yearNew" name="year"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="numberOfPlayersNew" class="col-sm-2 control-label">Number of Players </label>
                                            <div class="col-sm-10">
                                                <input type="number" id="numberOfPlayersNew" name="numberOfPlayers"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="durationNew" class="col-sm-2 control-label">Duration </label>
                                            <div class="col-sm-10">
                                                <input type="text" id="durationNew" name="duration"/> minutes
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="clocksCommissionNew" class="col-sm-2 control-label">Commissioned by Ensemble? </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="clocksCommission" id="clocksCommissionNew" value="0" checked> No
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="clocksCommission" id="inlineRadio2New" value="1"> Yes
                                            </label>
                                        </div>

                                        <div class="form-group">
                                            <label for="notesNew" class="col-sm-2 control-label">Notes (optional) </label>
                                            <div class="col-sm-10">
                                                <textarea name="notes" id="notesNew" class="form-control" rows="2"></textarea>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-2"></div>
                                            <div class="col-sm-offset-2 col-sm-10 more-btn">
                                                <input type="hidden" name="CompositionAddOrUpdate" value="1">
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

    </div>
</div>
<jsp:include page="scripts.jsp" />

</body>
</html>
