<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: reneegrittner
  Date: 4/1/18
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp" />
<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Add Player ${playerNumber} Instruments</h1>
        </div>
    </div>
    <jsp:include page="nav.jsp" />

<h1>CompositionId: </h1> ${compositionId}

    <c:forEach items="${instrumentCat}" var="current">
    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-2 centering">
            <form action="/concertPlanner/ensemble/PlayerInstrumentationCategory" method="get">
                <div class="more-btn">
                    <input type="hidden" name="category" value="${current.category}">
                    <input type="hidden" name="compositionId" value="${compositionId}">
                    <input type="hidden" name="playerNumber" value="${playerNumber}">
                    <input type="hidden" name="categoryId" value="${current.id}">
                    <button type="submit" class="btn">${current.category}</button></a>
                </div>
            </form>
        </div>
        <div class="col-sm-5"></div>
    </div>
    <div class="row"><div class="col-sm-12">  <br/> </div></div>

    </c:forEach>

    <div class="lines">
        <div class="more-btn">
            <a href="/concertPlanner/ensemble/singleComposition?param=${composition.id}"><button type="button" class="btn">Return to ${composition.title}</button></a>
        </div>
        <div class="more-btn">
            <button type="button" class="btn" data-toggle="modal" data-target="#InstrumentModal">Add Instruments for player ${nextPlayer}</button>
        </div>
    </div>

</div>
</body>
</html>
<jsp:include page="../scripts.jsp" />