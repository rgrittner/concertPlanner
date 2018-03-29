<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>
<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Percussion Concert Planner</h1>
        </div>
    </div>
    <jsp:include page="nav.jsp"/>
    <jsp:include page="banner.jsp"/>
    <div class="content-wrap">
        <div class="main-title">
            <ul class="grid effect-8" id="grid">
                <li><h1>Lorem ipsum</h1>
                    <h4>Donec nec justo eget felis facilisis fermentum.<br>
                        Aliquam porttit or mauris sit amet orci. Aenean dignissim pellentesque felis.</h4></li>
            </ul>
            <ul class="grid effect-8">
                <li><a href="/concertPlanner/ensemble/home">Log in</a></li>
            </ul>

        </div>
    </div>
    <div class="lines">
        <div class="more-btn">
            <a href="#" class="btn">Read More</a>
        </div>
    </div>

</div>
<div class="container">
    <div class="copy-rights">
        Copyright(c) website name.<br>
        Designed by:<a href="http://www.alltemplateneeds.com"> www.alltemplateneeds.com</a> / Images from:<a
            href="http://www.wallpaperswide.com"> www.wallpaperswide.com</a>
    </div>
</div>




<ul class="grid effect-8">
    <li><a href="/concertPlanner/musicians">Get All Musicians</a></li>
    <li><a href="/concertPlanner/addMusician">Add a Musician</a></li>
    <li><a href="/concertPlanner/composers">Get All Composers</a></li>
    <li><a href="/concertPlanner/addComposer">Add a Composer</a></li>
    <li><a href="/concertPlanner/compositions">Get All Compositions</a></li>
</ul>

</body>
</html>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="../js/jquery-1.9.1.js"></script>
<script src="../js/bootstrap.js"></script>
<script src="../js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script src="../js/masonry.pkgd.min.js"></script>
<script src="../js/imagesloaded.js"></script>
<script src="../js/classie.js"></script>
<script src="../js/AnimOnScroll.js"></script>

<script>
    new AnimOnScroll( document.getElementById( 'grid' ), {
        minDuration : 0.4,
        maxDuration : 0.7,
        viewportFactor : 0.2
    } );
</script>