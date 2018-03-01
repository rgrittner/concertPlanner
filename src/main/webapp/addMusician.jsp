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
            <h1>Add Musician</h1>
        </div>
    </div>
    <jsp:include page="nav.jsp" />
    <div class="form-horizontal">
        <form action="addMusician" method="post">
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
                <label for="phone" class="col-sm-2 control-label">Phone Number </label>
                <div class="col-sm-10">
                    <input type="text" id="phone" name="phone"/>
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
<jsp:include page="scripts.jsp" />
</body>
</html>
