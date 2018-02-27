<%--
  Created by IntelliJ IDEA.
  User: reneegrittner
  Date: 2/24/18
  Time: 3:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp" />

<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Composers  </h1>
        </div>
<jsp:include page="nav.jsp" />

<div class="container">
    <h1>Composers</h1>
    <div>
        <table id="resultTable" class="table table-sm">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Birth Year</th>
                <th scope="col">Death Year</th>
                <th scope="col">Nationality</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${composers}" var="current">
                <tr>
                    <td>${current.firstName} ${current.lastName}</td>
                    <td>${current.birthYear}</td>
                    <td>${current.deathYear}</td>
                    <td>${current.nationality.nationality}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
    </div>
</div>
<jsp:include page="scripts.jsp" />

</body>
</html>
