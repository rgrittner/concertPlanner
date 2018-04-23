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
    <div class="lines">
        <div class="more-btn">
            <a href="#" class="btn">Read More</a>
        </div>
    </div>
    <div>
        <button type="button" name="button">IPhone X</button>
        <p>
            Testing: <%= request.getRemoteUser()%><br/>
            Is user in role admin? <%= request.isUserInRole("admin")%>

        </p>
    </div>

</div>
<div class="container">
    <div class="copy-rights">
        Copyright(c) website name.<br>
        Designed by:<a href="http://www.alltemplateneeds.com"> www.alltemplateneeds.com</a> / Images from:<a
            href="http://www.wallpaperswide.com"> www.wallpaperswide.com</a>
    </div>
</div>





</body>
</html>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

