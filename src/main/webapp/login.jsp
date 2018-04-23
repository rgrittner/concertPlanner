<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: reneegrittner
  Date: 3/6/18
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">


    <title>All Template Needs</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="../css/custom-styles.css" rel="stylesheet">
    <link href="../css/image-effects.css" rel="stylesheet">

    <link href="../css/component.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/font-awesome.css">
    <link rel="stylesheet" href="../css/font-awesome-ie7.css">

    <script src="../js/html5shiv.js"></script>
    <script src="../js/respond.min.js"></script>
    <script src="../js/modernizr.custom.js"></script>

</head>
<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Login</h1>
        </div>
    </div>
    <div class="menu">
        <div class="navbar">

            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav ">
                    <li><a href="/concertPlanner/index.jsp">Home</a></li>

                    <li><a href="#">Log in</a></li>
                    <li><a href="/concertPlanner/signUp">Sign Up</a></li>

                </ul>

            </div><!--/.navbar-collapse -->
        </div>
    </div>
<div class="form-horizontal">
<FORM ACTION="j_security_check" METHOD="POST">
    <div class="form-group">
        <label for="userName" class="col-sm-2 control-label">Username</label>
        <div class="col-sm-10">
            <INPUT TYPE="TEXT" NAME="j_username" id="userName">
        </div>
    </div>
    <div class="form-group">
        <label for="pass" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
         <INPUT TYPE="PASSWORD" NAME="j_password" id="pass"><br/><br/>
            <div class="form-group">

                <div class="col-sm-10">
        <INPUT TYPE="SUBMIT" VALUE="Log In">
                </div>
            </div>
        </div>
    </div>

</FORM>

</div>

    </div>
</body>
</html>
