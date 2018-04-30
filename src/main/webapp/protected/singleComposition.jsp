<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>
<body>
<div class="container page-styling">

    <jsp:include page="nav.jsp"/>
    <div class="content-wrap">
        <div class="row">
            <div class="col-sm-12"> <br></div>
        </div>

        <%--Row--%>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-5">
                <table class="table">
                    <tr>
                        <td><h1>${compositionInformation.title}</h1></td>
                        <td><button type="button" class="label label-danger" data-toggle="modal" data-target="#CompositionModal"> <span class="glyphicon glyphicon-pencil"></span></button></td>
                    </tr>

                    <c:if test="${compositionInformation.arranger.length() > 1}">
                        <tr>
                            <td><h5>Arranger:</h5></td>
                            <td>${compositionInformation.arranger}</td>
                        </tr>
                    </c:if>
                    <tr>
                        <td><h4>Year Composed:</h4></td>
                        <td>${compositionInformation.yearComposed}</td>
                    </tr>
                    <tr>
                        <td><h4>Duration:</h4></td>
                        <td>${compositionInformation.duration} minutes</td>
                    </tr>
                    <tr>
                        <td><h4>Players Required:</h4></td>
                        <td>${compositionInformation.numberOfPlayers}</td>
                    </tr>
                    <tr>
                        <td><h4>Notes:</h4></td>
                        <td>${composition.notes}</td>
                    </tr>
                    <tr>
                        <td><span class="label label-default" style="font-size: small; vertical-align: iddle;"><a style="text-decoration: none; color: white;" href="/concertPlanner/ensemble/compositions">Return to Compositions</a></span></td>
                    </tr>



                </table>
            </div>
            <div class="col-sm-5">
                <table class="table" bgcolor="#2f4f4f">
                    <tr></tr>
                    <tr>
                        <td><h4 class="pull-left">Composed By:</h4></td>
                        <td><a name="composerId" value="${composerInformation.id}" href="/concertPlanner/ensemble/compositionsByComposer?param=${composerInformation.id}">${composerInformation.lastName}, ${composerInformation.firstName}</a></td>
                        <td><button type="button" class="label label-danger " data-toggle="modal" data-target="#ComposerModal"> <span class="glyphicon glyphicon-pencil"></span></button></td>

                    </tr>
                    <tr>
                        <td><h4>Year of Birth</h4></td>
                        <td>${composerInformation.birthYear}</td>
                    </tr>
                    <c:if test="${composerInformation.deathYear != null}">
                        <tr>
                            <td><h4>Year of Death:</h4></td>
                            <td>${composerInformation.deathYear}</td>
                        </tr>
                    </c:if>
                    <tr>
                        <td><h4>Nationality</h4></td>
                        <td>${composerInformation.nationality.nationality}</td>
                    </tr>

                </table>
            </div>
            <div class="col-sm-1"></div>

        </div>

        <%--ROW--%>
        <div class="row">
            <div class="col-sm-12"><h3>Instrumentation</h3></div>
        </div>

        <%--ROW--%>
        <div class="row"><br></div>

        <%--ROW--%>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-10">
                <h4 class="pull-left">Player 1</h4>
                    &nbsp;&nbsp;<span class="label label-default" style="font-size: small; vertical-align: iddle;"><a style="text-decoration: none; color: white;" href="/concertPlanner/ensemble/addPlayerInstrumentation?player=1&compositionId=${compositionInformation.id}"><span class="glyphicon glyphicon-plus"></span></a></span>
                    &nbsp;&nbsp;<span class="label label-danger" style="font-size: small; vertical-align: iddle;"> <span class="glyphicon glyphicon-pencil"></span></span>
                <table class="table table-sm">
                    <thead>
                        <tr>
                            <th>Instrument</th>
                            <th>Category</th>
                            <th>Quantity</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${playerOneInstruments}" var="current">
                            <tr>
                                <td>${current.instrument.name}</td>
                                <td>${current.instrument.instrumentCategory.category}</td>
                                <td>${current.instrumentQuantity}</td>
                                <td>
                                    <form action="/concertPlanner/ensemble/deleteInstrumentFromComposition" method="post">

                                        <input type="hidden" value="${current.id}" name="compositionInstrumentId">
                                        <input type="hidden" value="${compositionInformation.id}" name="compositionId">

                                        <button type="submit" class="btn"><span class="glyphicon glyphicon-trash"></span>
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty playerOneInstruments}">
                            <tr>
                                <td><span class="label label-info" style="font-size: small; vertical-align: iddle;"><a style="text-decoration: none; color: white;" href="/concertPlanner/ensemble/addPlayerInstrumentation?player=1&compositionId=${compositionInformation.id}">Add Instruments</a></span></td>
                            </tr>
                        </c:if>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-1"></div>
        </div>
        <%--ROW--%>
        <div class="row"><br></div>
        <%--ROW--%>
        <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-10">
                <h4 class="pull-left">Player 2</h4>
                    &nbsp;&nbsp;<span class="label label-default" style="font-size: small; vertical-align: iddle;"><a style="text-decoration: none; color: white;" href="/concertPlanner/ensemble/addPlayerInstrumentation?player=2&compositionId=${compositionInformation.id}"><span class="glyphicon glyphicon-plus"></span></a></span>
                    &nbsp;&nbsp;<span class="label label-danger" style="font-size: small; vertical-align: iddle;"> <span class="glyphicon glyphicon-pencil"></span></span>
                <table class="table table-sm">
                    <thead>
                    <tr>
                        <td>Instrument</td>
                        <td>Category</td>
                        <td>Quantity</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty playerTwoInstruments}">
                        <c:forEach items="${playerTwoInstruments}" var="current">
                            <tr>
                                <td>${current.instrument.name}</td>
                                <td>${current.instrument.instrumentCategory.category}</td>
                                <td>${current.instrumentQuantity}</td>
                                <td>
                                    <form action="/concertPlanner/ensemble/deleteInstrumentFromComposition" method="post">

                                        <input type="hidden" value="${current.id}" name="compositionInstrumentId">
                                        <input type="hidden" value="${compositionInformation.id}" name="compositionId">

                                        <button type="submit" class="btn"><span class="glyphicon glyphicon-trash"></span>
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty playerTwoInstruments}">
                        <tr>
                            <td><span class="label label-info" style="font-size: small; vertical-align: iddle;"><a style="text-decoration: none; color: white;" href="/concertPlanner/ensemble/addPlayerInstrumentation?player=2&compositionId=${compositionInformation.id}">Add Instruments</a></span></td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-1"></div>
        </div>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-10">
                <h4 class="pull-left">Player 3</h4>
                &nbsp;&nbsp;<span class="label label-default" style="font-size: small; vertical-align: iddle;"><a style="text-decoration: none; color: white;" href="/concertPlanner/ensemble/addPlayerInstrumentation?player=3&compositionId=${compositionInformation.id}"><span class="glyphicon glyphicon-plus"></span></a></span>
                &nbsp;&nbsp;<span class="label label-danger" style="font-size: small; vertical-align: iddle;"> <span class="glyphicon glyphicon-pencil"></span></span>
                <table class="table table-sm">
                    <thead>
                    <tr>
                        <td>Instrument</td>
                        <td>Category</td>
                        <td>Quantity</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${playerThreeInstruments}" var="current">
                        <tr>
                            <td>${current.instrument.name}</td>
                            <td>${current.instrument.instrumentCategory.category}</td>
                            <td>${current.instrumentQuantity}</td>
                            <td>
                                <form action="/concertPlanner/ensemble/deleteInstrumentFromComposition" method="post">

                                    <input type="hidden" value="${current.id}" name="compositionInstrumentId">
                                    <input type="hidden" value="${compositionInformation.id}" name="compositionId">

                                    <button type="submit" class="btn"><span class="glyphicon glyphicon-trash"></span>
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty playerThreeInstruments}">
                        <tr>
                            <td>
                                <span class="label label-info" style="font-size: small; vertical-align: iddle;"><a style="text-decoration: none; color: white;" href="/concertPlanner/ensemble/addPlayerInstrumentation?player=3&compositionId=${compositionInformation.id}">Add Instruments</a></span></td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-1"></div>
        </div>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-10">
                <h4 class="pull-left">Player 4</h4>
                &nbsp;&nbsp;<span class="label label-default" style="font-size: small; vertical-align: iddle;"><a style="text-decoration: none; color: white;" href="/concertPlanner/ensemble/addPlayerInstrumentation?player=4&compositionId=${compositionInformation.id}"><span class="glyphicon glyphicon-plus"></span></a></span>
                &nbsp;&nbsp;<span class="label label-danger" style="font-size: small; vertical-align: iddle;"> <span class="glyphicon glyphicon-pencil"></span></span>
                <table class="table table-sm">
                    <thead>
                    <tr>
                        <td>Instrument</td>
                        <td>Category</td>
                        <td>Quantity</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${playerFourInstruments}" var="current">
                        <tr>
                            <td>${current.instrument.name}</td>
                            <td>${current.instrument.instrumentCategory.category}</td>
                            <td>${current.instrumentQuantity}</td>
                            <td>
                                <form action="/concertPlanner/ensemble/deleteInstrumentFromComposition" method="post">

                                    <input type="hidden" value="${current.id}" name="compositionInstrumentId">
                                    <input type="hidden" value="${compositionInformation.id}" name="compositionId">

                                    <button type="submit" class="btn"><span class="glyphicon glyphicon-trash"></span>
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty playerFourInstruments}">
                        <tr>
                            <td><span class="label label-info" style="font-size: small; vertical-align: iddle;"><a style="text-decoration: none; color: white;" href="/concertPlanner/ensemble/addPlayerInstrumentation?player=4&compositionId=${compositionInformation.id}">Add Instruments</a></span></td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-1"></div>
        </div>
        <div class="row"><br></div>
        <div class="row">
            <div class="col-sm-12"><h3>Attachments</h3></div>
        </div>
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-10">Coming Soon</div>
                <div class="col-sm-1"></div>
            </div>
        </div>
        <br><br>
        <div class="row">
            <div class="col-sm-12 "><h3 class="pull-left">Previous Performances</h3> </div>
        </div>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-10">
                <table class="table table-sm">
                    <thead>
                        <tr>
                            <td>Date</td>
                            <td>Location</td>
                            <td>Player 1</td>
                            <td>Player 2</td>
                            <td>Player 3</td>
                            <td>Player 4</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listOfPerformances}" var="current">
                            <tr>
                                <td>${current.program.date}</td>
                                <td>${current.program.location}: ${current.program.city}, ${current.program.state}</td>

                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-1"></div>

        </div>
    </div>
<!-- EDIT COMPOSITION MODAL -->
<div class="modal fade" id="CompositionModal" role="dialog">
    <div class="modal-dialog">

        <%--<!-- Modal content-->--%>
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Edit ${compositionInformation.title}</h4>
            </div>
            <div class="modal-body">
                <div class="form-horizontal">
                    <form action="/concertPlanner/ensemble/addComposition" method="post">
                        <div class="form-group">
                            <label for="title" class="col-sm-2 control-label">Title</label>
                            <div class="col-sm-10">
                                <input type="text" id="title" name="title" value="${compositionInformation.title}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="composer" class="col-sm-2 control-label">Composer</label>
                            <div class="col-sm-10">
                                <select id="composer" name="composer">
                                    <option value="${compositionInformation.composer.id}" selected>${compositionInformation.composer.lastName}, ${compositionInformation.composer.firstName}</option>
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
                                <input type="text" id="arranger" name="arranger" value="${compositionInformation.arranger}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="year" class="col-sm-2 control-label">Year Composed </label>
                            <div class="col-sm-10">
                                <input type="number" id="year" name="year" value="${compositionInformation.yearComposed}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="numberOfPlayers" class="col-sm-2 control-label">Number of Players </label>
                            <div class="col-sm-10">
                                <input type="number" id="numberOfPlayers" name="numberOfPlayers" value="${compositionInformation.numberOfPlayers}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="duration" class="col-sm-2 control-label">Duration </label>
                            <div class="col-sm-10">
                                <input type="text" id="duration" name="duration" value="${compositionInformation.duration}"/> minutes
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="clocksCommission" class="col-sm-2 control-label">Commissioned by Ensemble? </label>
                            <label class="radio-inline">
                                <input type="radio" name="clocksCommission" id="clocksCommission" value="0" <c:if test="${compositionInformation.clocksCommission == false}">checked</c:if>> No
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="clocksCommission" id="inlineRadio2" value="1" <c:if test="${compositionInformation.clocksCommission}">checked</c:if>> Yes
                            </label>
                        </div>

                        <div class="form-group">
                            <label for="notes" class="col-sm-2 control-label">Notes (optional) </label>
                            <div class="col-sm-10">
                                <textarea name="notes" id="notes" class="form-control" rows="2" value="${compositionInformation.notes}"></textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-offset-2 col-sm-10 more-btn">
                                <input type="hidden" name="CompositionAddOrUpdate" value="2">
                                <input type="hidden" name="compositionId" value="${compositionInformation.id}">
                                <input type="hidden" name="returnToComposition" value="${compositionInformation.id}">
                                <button type="submit" class="btn">Edit ${compositionInformation.title}</button>
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


<!-- EDIT COMPOSER MODAL -->
<div class="modal fade" id="ComposerModal" role="dialog">
    <div class="modal-dialog">

        <%--<!-- Modal content-->--%>
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Edit ${composerInformation.lastName}, ${composerInformation.firstName}</h4>
            </div>
            <div class="modal-body">
                <div class="form-horizontal">
                    <form action="addComposer" method="post">
                        <div class="form-group">
                            <label for="firstName" class="col-sm-2 control-label">First Name</label>
                            <div class="col-sm-10">
                                <input type="text" id="firstName" name="firstName" value="${composerInformation.firstName}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastName" class="col-sm-2 control-label">Last Name</label>
                            <div class="col-sm-10">
                                <input type="text" id="lastName" name="lastName" value="${composerInformation.lastName}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="nationality" class="col-sm-2 control-label">Nationality </label>
                            <div class="col-sm-10">
                                <select name="nationality" id="nationality">
                                    <option value="${composerInformation.nationality.id}" selected>${composerInformation.nationality.nationality}</option>
                                    <c:forEach items="${nationality}" var="currentNat">
                                        <option value="${currentNat.id}">${currentNat.nationality}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="birthYear" class="col-sm-2 control-label">Birth Year</label>
                            <div class="col-sm-10">
                                <input type="number" id="birthYear" name="birthYear" value="${composerInformation.birthYear}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deathYear" class="col-sm-2 control-label">Death Year</label>
                            <div class="col-sm-10">
                                <input type="number" id="deathYear" name="deathYear" value="${composerInformation.deathYear}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-2"></div>
                            <input type="hidden" name="ComposerAddOrUpdate" value="2">
                            <input type="hidden" name="composerId" value="${composerInformation.id}">
                            <input type="hidden" name="returnToComposition" value="${compositionInformation.id}">
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


</div>

</body>
</html>
<jsp:include page="scripts.jsp"/>