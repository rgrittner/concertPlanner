<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>
<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Percussion Concert Planner</h1>
        </div>
    </div>
    <jsp:include page="nav.jsp"/>
    <jsp:include page="banner.jsp"/>
    <div class="content-wrap">
        <div class="main-title">
            <ul class="grid effect-8" id="grid">
                <li><h1>Upcoming Performances</h1>
            </ul>
        </div>
        <div>
            <table class="table table-sm">
                <thead>
                    <tr>
                        <td>Date</td>
                        <td>Location</td>
                        <td>Program Status</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${programs}" var="current">
                        <tr>
                            <td>${current.date}</td>
                            <td>${current.location}: ${current.city}, ${current.state}</td>
                            <td>${current.status}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


</div>






</body>
</html>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

