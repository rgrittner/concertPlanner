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
            <h1>Add Composition</h1>
        </div>
    </div>
    <jsp:include page="nav.jsp" />
    <div class="form-horizontal">
        <form action="/concertPlanner/ensemble/addComposition" method="post">
            <div class="form-group">
                <label for="title" class="col-sm-2 control-label">Title</label>
                <div class="col-sm-10">
                    <input type="text" id="title" name="title"/>
                </div>
            </div>
            <div class="form-group">
                <label for="composer" class="col-sm-2 control-label">Composer</label>
                <div class="col-sm-10">
                    <select id="composer">
                        <c:forEach items="${composers}" var="current">
                            <option value="${current.id}">${current.nationality}</option>
                        </c:forEach>
                    </select>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="arranger" class="col-sm-2 control-label">Arranged By (optional) </label>
                <div class="col-sm-10">
                    <input type="text" id="arranger" name="arranger"/>
                </div>
            </div>
            <div class="form-group">
                <label for="year" class="col-sm-2 control-label">Year Composed </label>
                <div class="col-sm-10">
                    <input type="number" id="year" name="year"/>
                </div>
            </div>
            <div class="form-group">
                <label for="numberOfPlayers" class="col-sm-2 control-label">Number of Players </label>
                <div class="col-sm-10">
                    <input type="number" id="numberOfPlayers" name="numberOfPlayers"/>
                </div>
            </div>
            <div class="form-group">
                <label for="clocksCommission" class="col-sm-2 control-label">Number of Players </label>
                <label class="radio-inline">
                    <input type="radio" name="clocksCommission" id="clocksCommission" value="0" checked> No
                </label>
                <label class="radio-inline">
                    <input type="radio" name="clocksCommission" id="inlineRadio2" value="1"> Yes
                </label>
            </div>

            <div class="form-group">
                <label for="notes" class="col-sm-2 control-label">Notes (optional) </label>
                <div class="col-sm-10">
                    <textarea name="notes" id="notes" class="form-control" rows="2"></textarea>
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

</body>
</html>
<script src="../js/jquery-1.9.1.js"></script>
<script src="../js/bootstrap.js"></script>
<script src="../js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script src="../js/masonry.pkgd.min.js"></script>
<script src="../js/imagesloaded.js"></script>
<script src="../js/classie.js"></script>
<script src="../js/AnimOnScroll.js"></script>