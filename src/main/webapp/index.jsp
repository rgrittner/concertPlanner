<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp"/>

<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Percussion Concert Planner</h1>
        </div>

        <jsp:include page="nav.jsp"/>
        <jsp:include page="banner.jsp"/>
        <div class="content-wrap">
            <div class="main-title">

                    <h1>Spring 2018 Enterprise Java Individual Project</h1>
                        <h4><br></h4>



            </div>
        </div>
        <div class="lines">
            <div class="more-btn">
                <a href="#" class="btn">Read More</a>
            </div>
        </div>
        <div class="content-wrap">

            <div class="main-title spacing-bt">
                <h1>Resources</h1>



            </div>
            <div class="row">

                <div class="featured-block">

                    <div class="col-md-4">
                        <div class="icon-btn">
                            <i class="fw-icon-pencil icon"></i>
                        </div>
                        <div class="block">
                            <h5>View Repository</h5>
                            <p>Concert Planner is open source and avaiable for review on GitHub </p>
                            <a href="https://github.com/rgrittner/concertPlanner" class="more">View on GitHub <i class="fw-icon-chevron-right"></i></a>
                        </div>
                    </div>
                </div>
                <div class="featured-block">
                    <div class="col-md-4">
                        <div class="icon-btn">
                            <i class="fw-icon-group icon"></i>
                        </div>
                        <div class="block">
                            <h5>Watch Demonstration Video</h5>
                            <p></p>
                            <a href="#" class="more">more info <i class="fw-icon-chevron-right"></i></a>
                        </div>
                    </div>
                </div>
                <div class="featured-block">
                    <div class="col-md-4">
                        <div class="icon-btn">
                            <i class="fw-icon-wrench icon"></i>
                        </div>
                        <div class="block">
                            <h5>Contact me</h5>
                            <p> </p>
                            <a href="#" class="more">more info <i class="fw-icon-chevron-right"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="ruler"></div>


    </div><!-- /container -->



    <jsp:include page="scripts.jsp"/>
</body>
</html>
