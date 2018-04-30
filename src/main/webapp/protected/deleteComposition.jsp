<%--
  Created by IntelliJ IDEA.
  User: reneegrittner
  Date: 4/28/18
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>
<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Delete Composer</h1>
        </div>
    </div>
    <jsp:include page="nav.jsp" />
    <div class="content-wrap centering">
        <c:if test="${okToDelete}">
            <div class="form-horizontal">
                <form action="/concertPlanner/ensemble/deleteComposition" method="post">
                    Are you sure you want to delete: <br>
                    Title: ${composition.title} <br>

                    <div class="form-group">
                        <input type="hidden" name="idOfCompositionToBeDeleted" value="${composition.id}" />
                        <div class="col-sm-2"></div>
                        <div class="col-sm-offset-2 col-sm-10 more-btn">
                            <a href="/concertPlanner/ensemble/compositions"><button type="button" class="btn btn-danger">Return To Composition</button></a>
                            <button type="submit" class="btn">Delete</button>
                        </div>

                    </div>

            </div>
        </c:if>
        <c:if test="${not okToDelete}">
            <p>
                    ${composition.title} has the following instruments assigned to it and cannot be deleted:
            <ul>
                <c:forEach items="${instruments}" var="current">
                    <li>${current.instrument.name}</li>
                </c:forEach>
            </ul>
            </p>
            <a href="/concertPlanner/ensemble/compositions"><button type="button" class="btn btn-danger">Return To Compositions</button></a>
        </c:if>
    </div>

</body>
</html>
