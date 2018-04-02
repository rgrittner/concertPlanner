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
            <h1>Add Player x Instruments</h1>
        </div>
    </div>
    <jsp:include page="nav.jsp" />
    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-2">
            <c:forEach items="${instrumentCat}" var="current">
                <div class="more-btn">
                    <button type="button" class="btn">${instrumentCat.category}</button>
                </div>
            </c:forEach>
        </div>
        <div class="col-sm-5"></div>

    </div>
</body>
</html>
<jsp:include page="../scripts.jsp" />