<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: reneegrittner
  Date: 4/1/18
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp" />
<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Add Accessory for Player ${playerNumber}</h1>
        </div>
    </div>
    <jsp:include page="nav.jsp" />
    <h1>Currently working on:</h1>
    <h3>Composition: ${composition.title}</h3>
    <h3>Player: ${playerNumber}</h3>
    <div class="form-horizontal">
    <form action="/concertPlanner/ensemble/PlayerInstrumentationCategory" method="post">
        <input type="hidden" name="playerNumber" value="${playerNumber}"/>
        <input type="hidden" name="compositionId"
    <c:forEach items="${instruments}" var="current">
    <label for="${current.name}">${current.name}</label>
    <input type="number" name="instrumentId${current.id}" id="${current.name}" min="0"/><br>

    </c:forEach>
        <input type="hidden" value="${composition.id}" name="idOfComposition">
        <input type="hidden" value="${playerNumber}" name="playerNumber">
        <input type="hidden" value="${categoryId}" name="categoryId">
        <button type="submit">Add</button>
    </form>
    </div>
</body>
<jsp:include page="scripts.jsp" />
</html>
