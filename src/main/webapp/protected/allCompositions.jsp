
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
                        <th scope="col">Notes</th>
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
                            <td>${current.notes}</td>

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
