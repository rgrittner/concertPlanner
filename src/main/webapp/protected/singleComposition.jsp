<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>
<body>
<div class="container page-styling">

    <jsp:include page="nav.jsp"/>
    <div class="content-wrap">
        <div class="row">

            <div class="col-sm-12"><h1>${compositionInformation.title}</h1><br></div>
        </div>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-3">
                <p>
                    <c:if test="${compositionInformation.arranger != null}">Arranger: ${compositionInformation.arranger}<br/></c:if>
                 Composed: ${compositionInformation.yearComposed} <br>
                 Duration: ${compositionInformation.duration} minutes<br>
                Players: ${compositionInformation.numberOfPlayers}<br>
                </p>
            </div>
            <div class="col-sm-3">
                <p>
                Composer: ${composerInformation.lastName}, ${composerInformation.firstName}<br>
                Born: ${composerInformation.birthYear}<br>
                <c:if test="${composerInformation.deathYear != null}">Death: ${composerInformation.deathYear}<br></c:if>
                Nationality: ${composerInformation.nationality.nationality}
                </p>
            </div>
            <div class="col-sm-5"></div>

        </div>
        <div class="row">
            <div class="col-sm-12"><h3>Instrumentation</h3></div>
        </div>
        <div class="row"><br></div>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-5">
            <h4>Player 1</h4>

                <table class="table table-sm">
                    <thead>
                        <tr>
                            <td>Instrument</td>
                            <td>Quantity</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${playerOneInstruments}" var="current">
                           <c:if test="${playerOneInstruments != null}">
                            <tr>
                                <td>${current.instrument.name}</td>
                                <td>${current.instrumentQuantity}</td>
                            </tr>
                        </c:if>
                            <c:if test="${empty playerOneInstruments}">
                                Add Instruments
                            </c:if>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-5">
                <h4>Player 2</h4>
                <table class="table table-sm">
                    <thead>
                    <tr>
                        <td>Instrument</td>
                        <td>Quantity</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${playerTwoInstruments}" var="current">
                        <tr>
                            <td>${current.instrument.name}</td>
                            <td>${current.instrumentQuantity}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-1"></div>
        </div>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-5">
                <h4>Player 3</h4>
                <table class="table table-sm">
                    <thead>
                    <tr>
                        <td>Instrument</td>
                        <td>Quantity</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${playerThreeInstruments}" var="current">
                        <tr>
                            <td>${current.instrument.name}</td>
                            <td>${current.instrumentQuantity}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-5">
                <h4>Player 4</h4>
                <table class="table table-sm">
                    <thead>
                    <tr>
                        <td>Instrument</td>
                        <td>Quantity</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${playerFourInstruments}" var="current">
                        <tr>
                            <td>${current.instrument.name}</td>
                            <td>${current.instrumentQuantity}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-1"></div>
        </div>
        <div class="row"><br></div>
        <div class="row">
            <div class="col-sm-12"><h3>Attachments</h3></div>
            <div class="row"><div class="col-sm-12">Coming Soon</div></div>
        </div>
        <br><br>
        <div class="row">
            <div class="row"><div class="col-sm-12">Coming Soon</div></div>
            <div class="row">         Coming Soon</div>
        </div>
    </div>

</div>

</body>
</html>
<jsp:include page="scripts.jsp" />