<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: reneegrittner
  Date: 4/1/18
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp" />
<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Add Player ${playerNumber} Instruments</h1>
        </div>
    </div>
    <jsp:include page="nav.jsp" />

    <%-- Keyboard --%>
    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-2 centering">
            <form action="/concertPlanner/ensemble/PlayerInstrumentationCategory" method="get">
                <div class="more-btn">
                    <input type="hidden" name="category" value="Keyboards">
                    <input type="hidden" name="playerNumber" value="${playerNumber}">
                    <button type="button" class="btn">Keyboards</button></a>
                </div>
            </form>
        </div>
        <div class="col-sm-5"></div>
    </div>
    <div class="row"><div class="col-sm-12">  <br/> </div></div>

    <%--Metals--%>

    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-2 centering">
            <form action="/concertPlanner/ensemble/PlayerInstrumentationCategory" method="get">
                <div class="more-btn">
                    <input type="hidden" name="category" value="Metals">
                    <input type="hidden" name="playerNumber" value="${playerNumber}">
                    <button type="submit" class="btn">Metals</button></a>
                </div>
            </form>
        </div>
        <div class="col-sm-5"></div>
    </div>
    <div class="row"><div class="col-sm-12">  <br/> </div></div>

    <%-- Skins --%>

    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-2 centering">
            <form action="/concertPlanner/ensemble/PlayerInstrumentationCategory" method="get">
                <div class="more-btn">
                    <input type="hidden" name="category" value="Skins">
                    <input type="hidden" name="playerNumber" value="${playerNumber}">
                    <button type="button" class="btn">Skins</button></a>
                </div>
            </form>
        </div>
        <div class="col-sm-5"></div>
    </div>
    <div class="row"><div class="col-sm-12">  <br/> </div></div>

<%-- Woods --%>
    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-2 centering">

            <form action="/concertPlanner/ensemble/PlayerInstrumentationCategory" method="get">
                <div class="more-btn">
                    <input type="hidden" name="category" value="Woods">
                    <input type="hidden" name="playerNumber" value="${playerNumber}">
                    <button type="button" class="btn">Woods</button></a>
                </div>
            </form>
        </div>
        <div class="col-sm-5"></div>
    </div>
    <div class="row"><div class="col-sm-12">  <br/> </div></div>

    <%-- Accessory --%>

    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-2 centering">

            <form action="/concertPlanner/ensemble/PlayerInstrumentationCategory" method="get">
                <div class="more-btn">
                    <input type="hidden" name="category" value="Accessory">
                    <input type="hidden" name="playerNumber" value="${playerNumber}">
                    <button type="submit" class="btn">Accessory</button></a>
                </div>
            </form>
        </div>
        <div class="col-sm-5"></div>
    </div>
    <div class="row"><div class="col-sm-12">  <br/> </div></div>

<%-- Other --%>

    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-2 centering">

            <form action="/concertPlanner/ensemble/PlayerInstrumentationCategory" method="get">
                <div class="more-btn">
                    <input type="hidden" name="category" value="Other">
                    <input type="hidden" name="playerNumber" value="${playerNumber}">
                    <button type="button" class="btn">Other</button></a>
                </div>
            </form>
        </div>
        <div class="col-sm-5"></div>
    </div>
    <div class="row"><div class="col-sm-12">  <br/> </div></div>

    <%-- Timpani --%>

    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-2 centering">

            <form action="/concertPlanner/ensemble/PlayerInstrumentationCategory" method="get">
                <div class="more-btn">
                    <input type="hidden" name="category" value="Timpani">
                    <input type="hidden" name="playerNumber" value="${playerNumber}">
                    <button type="button" class="btn">Timpani</button></a>
                </div>
            </form>
        </div>
        <div class="col-sm-5"></div>
    </div>
    <div class="row"><div class="col-sm-12">  <br/> </div></div>

    <%-- END BUTTONS--%>

</body>
</html>
<jsp:include page="../scripts.jsp" />