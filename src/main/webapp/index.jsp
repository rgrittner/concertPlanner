<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp" />

<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Percussion Concert Planner</h1>
        </div>
        <jsp:include page="nav.jsp" />
        <jsp:include page="banner.jsp" />
    <div class="content-wrap">
        <div class="main-title">
            <ul class="grid effect-8" id="grid">
                <li ><h1>Lorem ipsum</h1>
                    <h4>Donec nec justo eget felis facilisis fermentum.<br>
                        Aliquam porttit or mauris sit amet orci. Aenean dignissim pellentesque felis.</h4></li>
            </ul>
            <ul class="grid effect-8" id="grid">
                <li><a href="musicians">Get All Musicians</a></li>
                <li><a href="addMusician">Add a Musician</a></li>
                <li><a href="composers">Get All Composers</a></li>
                <li><a href="addComposer">Add a Composer</a></li>
                <li><a href="compositions">Get All Compositions</a></li>
            </ul>

        </div>
    </div>
    <div class="lines">
        <div class="more-btn">
            <a href="#" class="btn">Read More</a>
        </div>
    </div>
    <div class="content-wrap">

        <div class="main-title spacing-bt">
            <ul class="grid effect-8" id="grid">
                <li><h1>Vivamus vest</h1>
                    <h4>Sed adipiscing ornare risus. Morbi est est, blandit sit amet, sagittis vel, euismod vel, velit. <br>
                        Pellentesque egestas sem. Suspendisse commodo ullamcorper magna..</h4></li>
            </ul>

        </div>
        <div class="row">

            <div class="featured-block">

                <div class="col-md-4">
                    <div class="icon-btn">
                        <i class="fw-icon-pencil icon"></i>
                    </div>
                    <div class="block">
                        <h5>Fusce pellentesque<br>suscipit nibh</h5>
                        <p>Sed egestas, ante et vulputate volutpat, eros pede semper est, vitae luctus metus libero eu augue. Morbi purus libero,  id... </p>
                        <a href="#" class="more">more info <i class="fw-icon-chevron-right"></i></a>
                    </div>
                </div>
            </div>
            <div class="featured-block">
                <div class="col-md-4">
                    <div class="icon-btn">
                        <i class="fw-icon-group icon"></i>
                    </div>
                    <div class="block">
                        <h5>Integer vitae libero<br>ac risus egestas</h5>
                        <p>Ced egestas, ante et vulputate volutpat, eros pede semper est, vitae luctus metus libero eu augue. Morbi purus libero... </p>
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
                        <h5>Vestibulum commodo<br>felis quis tort</h5>
                        <p>Tegestas, ante et vulputate volutpat, eros pede semper est, vitae luctus metus libero eu augue. Morbi purus libero, fauc... </p>
                        <a href="#" class="more">more info <i class="fw-icon-chevron-right"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="ruler"></div>
    <div class="content-wrap centering">
        <div class="main-title spacing-bt">
            <ul class="grid effect-8" id="grid">
                <li><h1>Cras iaculis</h1>
                    <h4>Fusce lobortis lorem at ipsum semper sagittis</h4>
                </li>
            </ul>
        </div>
        <div class="featured-items">
            <ul class="grid effect-2" id="grid">
                <li>
                    <div class="item">
                        <h5>Vestibulum commodo<br> felis quis tortor</h5>
                        <div class="grow">
                            <img src="img/img1.jpg" alt="">
                        </div>
                        <p>Mauris nibh felis, adipiscing varius, adipiscing in, lacinia vel, tellus. Suspendisse ac urna. Etiam pellentesque mauris ut lectus.</p>
                        <p><a href="#" class="more">more info <i class="fw-icon-chevron-right"></i></a></p>
                    </div>
                </li>
                <li>
                    <div class="item">
                        <h5>Donec quis dui at<br> dolor</h5>
                        <div class="grow">
                            <img src="img/img2.jpg" alt="">
                        </div>
                        <p>Suspendisse mauris. Fusce accumsan mollis eros. Pellentesque a diam sit amet mi ullamcorper vehicula. Integer adipiscing risus</p>
                        <p><a href="#" class="more">more info <i class="fw-icon-chevron-right"></i></a></p>
                    </div>
                </li>
                <li>
                    <div class="item">
                        <h5>Vestibulum commodo<br> felis quis tortor</h5>
                        <div class="grow">
                            <img src="img/img3.jpg" alt="">
                        </div>
                        <p>Mauris nibh felis, adipiscing varius, adipiscing in, lacinia vel, tellus. Suspendisse ac urna. Etiam pellentesque mauris ut lectus.</p>
                        <p><a href="#" class="more">more info <i class="fw-icon-chevron-right"></i></a></p>
                    </div>
                </li>
            </ul>



        </div>
    </div>
    <div class="ruler"></div>
    <div class="content-wrap centering">
        <div class="main-title">
            <ul class="grid effect-8" id="grid">
                <li>  <h1>Nunc digniss</h1>
                    <h4>Praesent dapibus, neque id cursus faucibus,<br>
                        tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat <br>
                        volutpat. Nam dui mi, tincidunt quis, accumsan porttitor</h4></li>
            </ul>
        </div>
        <div class="tags">
            <h5 class="spacing-bt">lorem ipsum dolor</h5>
            <ul class="grid effect-7" id="grid" >
                <li><a href="#" class="btn">Integer vit ametuno</a></li>
                <li><a href="#" class="btn">donce ametuno </a></li>
                <li><a href="#" class="btn">voluptanin </a></li>
                <li><a href="#" class="btn">tincidun </a></li>
                <li><a href="#" class="btn">porttion souti </a></li>
                <li><a href="#" class="btn">namdui sinosi</a></li>
                <li><a href="#" class="btn">fermnutin </a></li>
            </ul>


        </div>
    </div>
    <div class="lines">
        <div class="more-btn">
            <a href="#" class="btn">View More</a>
        </div>
    </div>

</div><!-- /container -->

<div class="container">
    <div class="copy-rights">
        Copyright(c) website name.<br>
        Designed by:<a href="http://www.alltemplateneeds.com"> www.alltemplateneeds.com</a>  /  Images from:<a href="http://www.wallpaperswide.com"> www.wallpaperswide.com</a>
    </div>
</div>

    <jsp:include page="scripts.jsp" />
</body>
</html>
