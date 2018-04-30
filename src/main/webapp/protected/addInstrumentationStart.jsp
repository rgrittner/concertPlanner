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
    <div class="lines">
        <div>
            <a href="/concertPlanner/ensemble/singleComposition?param=${composition.id}"><button type="button" class="btn btn-info">Return to <br><h1>${composition.title}</h1></button></a>
        </div>

    </div>
    <div class="row"><div class="col-sm-12">  <br/> </div></div>
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-2 text-center" style="padding-left: 4%" >
            <c:if test="${previousPlayer != 0}">
                <a href="/concertPlanner/ensemble/addPlayerInstrumentation?player=${previousPlayer}&compositionId=${composition.id}"><h3 class="pull-left"><span class="label label-default" ><i class="glyphicon glyphicon-chevron-left"></i>Player ${previousPlayer} </span></h3></a>
            </c:if>
        </div>
        <div class="col-sm-2 text-center" style="padding-left: 4%">
            <h3 class="pull-left"><span class="label label-danger" >Player ${playerNumber} </span></h3>
        </div>
        <div class="col-sm-2 text-center" style="padding-left: 4%">
            <c:if test="${nextPlayer != 0}">
                <a href="/concertPlanner/ensemble/addPlayerInstrumentation?player=${nextPlayer}&compositionId=${composition.id}"><h3 class="pull-left"><span class="label label-default" >Player ${nextPlayer} <i class="glyphicon glyphicon-chevron-right"></i></span></h3></a>
            </c:if>
        </div>
    <div class="col-sm-3 text-center"></div>
    </div>

    <div class="row"><div class="col-sm-12">  <br/> </div></div>
    <c:forEach items="${instrumentCat}" var="current">
    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-2 centering">
            <form action="/concertPlanner/ensemble/PlayerInstrumentationCategory" method="get">
                <div>
                    <input type="hidden" name="category" value="${current.category}">
                    <input type="hidden" name="compositionId" value="${compositionId}">
                    <input type="hidden" name="playerNumber" value="${playerNumber}">
                    <input type="hidden" name="categoryId" value="${current.id}">
                    <button type="submit" class="btn btn-danger">${current.category}&nbsp;&nbsp;<span class="badge badge-default">0</span></button></a>
                </div>
            </form>
        </div>
        <div class="col-sm-5"></div>
    </div>
    <div class="row"><div class="col-sm-12">  <br/> </div></div>

    </c:forEach>


        <c:if test="${nextPlayer <= maxPlayer}">
    <div class="lines">
            <div>
                <a href="/concertPlanner/ensemble/addPlayerInstrumentation?player=${nextPlayer}&compositionId=${composition.id}"><span class="label label-default">Add Instruments for player ${nextPlayer}</span></a>
            </div>
    </div>
        </c:if>



</div>
</body>
</html>
<script src="../js/jquery-1.9.1.js"></script>
<script src="../js/bootstrap.js"></script>