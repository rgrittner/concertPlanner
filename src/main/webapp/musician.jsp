<%--
  Created by IntelliJ IDEA.
  User: reneegrittner
  Date: 2/13/18
  Time: 6:36 PM
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
            <h1>Musician  </h1>
        </div>
<jsp:include page="nav.jsp" />


<div>
    <table id="resultTable" class="table table-sm">
       <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Phone</th>
            </tr>
       </thead>
       <tbody>
            <c:forEach items="${musicians}" var="current">
                <tr>
                    <td id="${current.id}">${current.firstName} ${current.lastName}</td>
                    <td>${current.phoneNumber}</td>
                    <td><span class="glyphicon glyphicon-pencil"></span></td>
                    <td><span class="glyphicon glyphicon-trash"></span></td>
                </tr>
            </c:forEach>
       </tbody>
   </table>
</div>
</div>
</div>
<jsp:include page="scripts.jsp" />

</body>
</html>
