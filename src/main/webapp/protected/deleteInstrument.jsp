<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
  Created by IntelliJ IDEA.
  User: reneegrittner
  Date: 4/22/18
  Time: 12:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>
<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Delete Instrument</h1>
        </div>
    </div>
    <jsp:include page="nav.jsp" />
    <div class="content-wrap centering">
        <c:if test="${okToDelete}">
            <div class="form-horizontal">
                <form action="/concertPlanner/ensemble/deleteInstrument" method="post">
                    Are you sure you want to delete: <br>
                    Name: ${instrument.name}<br>

                    <div class="form-group">
                        <input type="hidden" name="idOfInstrumentToBeDeleted" value="${instrument.id}" />
                        <div class="col-sm-2"></div>
                        <div class="col-sm-offset-2 col-sm-10 more-btn">
                            <button type="submit" class="btn">Delete</button>
                        </div>

                    </div>

            </div>
        </c:if>
        <c:if test="${not okToDelete}">
            <p>
                    ${instrument.name} is listed in the following compositions and cannot be deleted:
            <ul>
                <c:forEach items="${compositions}" var="current">
                    <li>${current.composition.title}, player ${current.playerNumber}</li>
                </c:forEach>
            </ul>
            </p>
            <a href="/concertPlanner/ensemble/instruments"><button type="button" class="btn btn-danger">Return To Instruments</button></a>
        </c:if>
    </div>

</body>
</html>

