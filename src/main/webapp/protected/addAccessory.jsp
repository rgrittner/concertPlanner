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
            <h1>Add ${categoryName} for Player ${playerNumber}</h1>
        </div>
    </div>
    <jsp:include page="nav.jsp" />
    <div class="row">
        <div class="col-sm-4"></div>
    <div class="panel panel-default col-sm-4">
        <div class="panel-heading">
            <h1 class="panel-title" align="center">Composition: ${composition.title} </h1>
            <h3 class="panel-title" align="center">Player: ${playerNumber}</h3>
        </div>
        <div class="panel-body">

            <div class="form-horizontal ">
                <form action="/concertPlanner/ensemble/PlayerInstrumentationCategory" method="post">
                    <c:forEach items="${instruments}" var="current">
                        <div class="form-group">
                            <label for="${current.name}" class="col-sm-2 control-label">${current.name}</label>
                            <div class="col-sm-10">
                                <input type="number" name="instrumentId${current.id}" id="${current.name}" min="0"/>
                            </div>
                        </div>
                    </c:forEach>
                    <input type="hidden" value="${composition.id}" name="idOfComposition">
                    <input type="hidden" value="${playerNumber}" name="playerNumber">
                    <input type="hidden" value="${categoryId}" name="categoryId">
                    <div class="form-group">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-danger">Add</button>
                        </div>

                    </div>
                </form>
            </div>


        </div>
         <div class="panel-footer">
             <a style="text-decoration: none; color: white;" href="/concertPlanner/ensemble/addPlayerInstrumentation?player=${playerNumber}&compositionId=${composition.id}">
                 <h4 align="center"><span  class="label label-info">Return to Player ${playerNumber} Category Selection</span></h4></a>
         </div>
    </div>
        <div class="col-sm-4"></div>
    </div>
</div>
</body>
<script src="../js/jquery-1.9.1.js"></script>
<script src="../js/bootstrap.js"></script>
</html>
