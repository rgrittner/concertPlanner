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
    <c:forEach items="${instrumentCat}" var="current">
    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-2 centering">

                <div class="more-btn">
                    <a href="/concertPlanner/ensemble/addPlayerInstrumentation/category?categoryId=${current.id}"><button type="button" class="btn">${current.category}</button></a>
                </div>

        </div>
        <div class="col-sm-5"></div>

    </div>
    <div class="row"><div class="col-sm-12">  <br/> </div></div>
    </c:forEach>
</body>
</html>
<jsp:include page="../scripts.jsp" />