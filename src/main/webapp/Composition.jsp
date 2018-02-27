
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
            <h1>Composition  </h1>
        </div>
<jsp:include page="nav.jsp" />

<div class="container">
    <h1>Compositions</h1>
    <div>
        <table id="resultTable" class="table table-sm">
            <thead>
            <tr>
                <th scope="col">Composer</th>
                <th scope="col">Title</th>
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
                    <td>${current.composer.firstName} ${current.composer.lastName}</td>
                    <td>${current.title}</td>
                    <td>${current.arranger}</td>
                    <td>${current.duration}</td>
                    <td>${current.yearComposed}</td>
                    <td>${current.numberOfPlayers}</td>
                    <td>${current.clocksCommission}</td>
                    <td>${current.notes}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
    </div>
</div>
<jsp:include page="scripts.jsp" />

</body>
</html>
