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
<jsp:include page="head.jsp" />
<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Add Composer</h1>
        </div>
    </div>
    <jsp:include page="nav.jsp" />
    <div class="form-horizontal">
        <form action="addComposer" method="post">
            <div class="form-group">
                <label for="firstName" class="col-sm-2 control-label">First Name</label>
                <div class="col-sm-10">
                    <input type="text" id="firstName" name="firstName"/>
                </div>
            </div>
            <div class="form-group">
                <label for="lastName" class="col-sm-2 control-label">Last Name</label>
                <div class="col-sm-10">
                    <input type="text" id="lastName" name="lastName"/>
                </div>
            </div>
            <div class="form-group">
                <label for="nationality" class="col-sm-2 control-label">Nationality </label>
                <div class="col-sm-10">
                    <select name="nationality" id="nationality">
                    <c:forEach items="${nationality}" var="current">
                        <option value="${current.id}">${current.nationality}</option>
                    </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="birthYear" class="col-sm-2 control-label">Birth Year</label>
                <div class="col-sm-10">
                    <input type="number" id="birthYear" name="birthYear"/>
                </div>
            </div>
            <div class="form-group">
                <label for="deathYear" class="col-sm-2 control-label">Death Year</label>
                <div class="col-sm-10">
                    <input type="number" id="deathYear" name="deathYear"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-2"></div>
                <div class="col-sm-offset-2 col-sm-10 more-btn">
                    <button type="submit" class="btn">Add</button>
                </div>

            </div>
        </form>
    </div>
</div>
<script src="../js/jquery-1.9.1.js"></script>
<script src="../js/bootstrap.js"></script>
<script src="../js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script src="../js/masonry.pkgd.min.js"></script>
<script src="../js/imagesloaded.js"></script>
</body>
</html>
