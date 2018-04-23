<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: reneegrittner
  Date: 4/21/18
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
            <h1>Sign Up</h1>
        </div>
    </div>
    <jsp:include page="nav.jsp" />
<span></span>
    <c:if test="${messages.success != null}">
        <p>Sign up SUCCESS!!! Please Log in using link above</p>
        <br/></c:if>
    <div class="form-horizontal">
        <form action="signUp" method="post">
            <div class="form-group">
                <label for="userName" class="col-sm-2 control-label">User Name</label>
                <div class="col-sm-10">
                    <input type="text" id="userName" name="userName"/>
                    <span>${messages.userName}</span>
                </div>

            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" id="password" name="password"/>
                    <span>${messages.password}</span>
                </div>
            </div>
            <div class="form-group">
                <label for="password2" class="col-sm-2 control-label">Re-Type Password</label>
                <div class="col-sm-10">
                    <input type="password" id="password2" name="password2"/>
                </div>
            </div>

            <div class="form-group">
                <label for="ensembleName" class="col-sm-2 control-label">Ensemble Name</label>
                <div class="col-sm-10">
                    <input type="text" id="ensembleName" name="ensembleName"/>
                    <span>${messages.ensembleName}</span>
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
<script src="js/jquery-1.9.1.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
