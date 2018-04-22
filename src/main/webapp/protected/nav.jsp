<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>
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
                <c:if test='<%=request.isUserInRole("admin")%>'>
                    <li><a href="/concertPlanner/ensemble/admin">Admin</a></li>

                </c:if>
                <li><a href="/concertPlanner/ensemble/home">Ensemble Home</a></li>
                <li class="dropdown ">
                    <a href="#" class="dropdown-toggle active" data-toggle="dropdown">Add <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/concertPlanner/ensemble/addMusician">Add a Musician</a></li>
                        <li><a href="/concertPlanner/ensemble/addComposer">Add a Composer</a></li>
                        <li><a href="/concertPlanner/ensemble/addComposition">Add a Composition</a></li>
                        <li><a href="/concertPlanner/ensemble/instruments">Add Instruments</a></li>
                    </ul>
                </li>
                <li class="dropdown ">
                    <a href="#" class="dropdown-toggle active" data-toggle="dropdown">View <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/concertPlanner/ensemble/musicians">View Musicians</a></li>
                        <li><a href="/concertPlanner/ensemble/composers">View Composers</a></li>
                        <li><a href="/concertPlanner/ensemble/compositions">View Compositions</a></li>
                        <li><a href="/concertPlanner/ensemble/instruments">View Instruments</a></li>
                    </ul>
                </li>

                    <li><a href="/concertPlanner/logout">Logout</a></li>
                    <%--<li><a href="#">Portfolio</a></li>--%>
                    <%--<li><a href="#">Contact</a></li>--%>



            </ul>

        </div><!--/.navbar-collapse -->

    </div>

</div>
</nav>