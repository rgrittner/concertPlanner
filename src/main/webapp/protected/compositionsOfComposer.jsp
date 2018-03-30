
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

        <jsp:include page="nav.jsp" />
    </div>
    <div class="content-wrap">
        <div class="container">
        <h1>Composer Name</h1>
            <div>
                <table id="resultTable" class="table table-sm">
                    <thead>
                    <tr>
                        <th scope="col">Title</th>
                        <th scope="col">Duration (minutes)</th>
                        <th scope="col">Year</th>
                        <th scope="col">Number of Players</th>
                        <th scope="col">Clocks commission?</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><a href="/concertPlanner/protected/composition.jsp">Title</a></td>
                        <td>10 </td>
                        <td>1345</td>
                        <td>4</td>
                        <td>Yes</td>

                    </tr>
                    <c:forEach items="${composerCompositions}" var="current">
                        <tr>
                            <td>${current.title}</td>
                            <td>${current.duration}</td>
                            <td>${current.yearComposed}</td>
                            <td>${current.numberOfPlayers}</td>
                            <td>${current.clocksCommission}</td>

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
