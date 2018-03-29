<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: reneegrittner
  Date: 2/25/18
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>
<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Delete Musician</h1>
        </div>
    </div>
    <jsp:include page="nav.jsp" />
    <div class="content-wrap centering">
        <div class="form-horizontal">
            <form action="/concertPlanner/ensemble/deleteMusician" method="post">
                Are you sure you want to delete: <br>
                First Name: ${musician.firstName}<br>
                Last Name: ${musician.lastName}<br>
                Email: ${musician.email}<br>
                Phone: ${musician.phoneNumber}<br>
                Status: ${musician.status}
                <div class="form-group">
                    <input type="hidden" name="idOfMusicianToBeDeleted" value="${musician.id}" />
                    <div class="col-sm-2"></div>
                    <div class="col-sm-offset-2 col-sm-10 more-btn">
                        <button type="submit" class="btn">Delete</button>
                    </div>

                </div>

    </div>
</div>

</body>
</html>
<script src="../js/jquery-1.9.1.js"></script>
<script src="../js/bootstrap.js"></script>
<script src="../js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script src="../js/masonry.pkgd.min.js"></script>
<script src="../js/imagesloaded.js"></script>
<script src="../js/classie.js"></script>
<script src="../js/AnimOnScroll.js"></script>