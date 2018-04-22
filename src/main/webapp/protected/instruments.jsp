
<%--
  Created by IntelliJ IDEA.
  User: reneegrittner
  Date: 2/24/18
  Time: 3:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp" />

<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Instruments</h1>
        </div>
        <jsp:include page="nav.jsp" />

        <div class="lines">
        <div class="more-btn">
        <button type="button" class="btn" data-toggle="modal" data-target="#CategoryModal">Add Category</button>
        </div>
        <div class="more-btn">
        <button type="button" class="btn" data-toggle="modal" data-target="#InstrumentModal">Add Instrument</button>
        </div>
        </div>

        <div>
            <table id="resultTable" class="table table-sm">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Category</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${instruments}" var="current">
                    <tr>
                        <td>${current.name}</td>
                        <td>${current.instrumentCategory.category}</td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
    <!-- ADD CATEGORY MODAL -->
    <div class="modal fade" id="CategoryModal" role="dialog">
    <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
    <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">&times;</button>
    <h4 class="modal-title">Add New Instrument Category</h4>
    </div>
    <div class="modal-body">
    <div class="form-horizontal">
        <form action="/concertPlanner/ensemble/addInstrumentCategory" method="post">
    <div class="form-group">
    <label for="category" class="col-sm-2 control-label">Category</label>
    <div class="col-sm-10">
    <input type="text" id="category" name="category" />
    </div>
    </div>

    <div class="form-group">
    <div class="col-sm-2"></div>
    <div class="col-sm-offset-2 col-sm-10 ">
    <button type="submit" class="btn">Add</button>
    </div>

    </div>
    </form>
    </div>
    </div>
    <div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
    </div>
    </div>

    </div>
    </div>


    <!-- ADD INSTRUMENT MODAL -->
    <div class="modal fade" id="InstrumentModal" role="dialog">
    <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
    <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">&times;</button>
    <h4 class="modal-title">Add New Instrument Category</h4>
    </div>
    <div class="modal-body">
    <div class="form-horizontal">
    <form action="/concertPlanner/ensemble/addInstrument" method="post">
    <div class="form-group">
    <label for="instrument" class="col-sm-2 control-label">Instrument Name</label>
    <div class="col-sm-10">
    <input type="text" id="instrument" name="instrument" />
    </div>
    </div>
    <div class="form-group">
    <label for="newInstrumentCategory" class="col-sm-2 control-label">Category </label>
    <div class="col-sm-10">
    <select name="newInstrumentCategory" id="newInstrumentCategory">
    <c:forEach items="${categories}" var="current2">
    <option value="${current2.id}">${current2.category}</option>
    </c:forEach>
    </select>
    </div>
    </div>

    <div class="form-group">
    <div class="col-sm-2"></div>
    <input type="hidden" name="addOrEdit" value="1"/>
    <div class="col-sm-offset-2 col-sm-10 ">
    <button type="submit" class="btn btn-danger">Add</button>
    </div>

    </div>
    </form>
    </div>
    </div>
    <div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
    </div>
    </div>

    </div>
    </div>



</div>
<jsp:include page="scripts.jsp" />

</body>
</html>





<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: reneegrittner--%>
  <%--Date: 3/29/18--%>
  <%--Time: 3:31 PM--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>

    <%--<title>All Template Needs</title>--%>

    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>
    <%--<link href="../css/custom-styles.css" rel="stylesheet">--%>
    <%--<link href="../css/image-effects.css" rel="stylesheet">--%>

    <%--<link href="../css/component.css" rel="stylesheet">--%>
    <%--<link rel="stylesheet" href="../css/font-awesome.css">--%>
    <%--<link rel="stylesheet" href="../css/font-awesome-ie7.css">--%>

    <%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>--%>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>--%>
    <%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>--%>

    <%--<!-- css for jquery datatables -->--%>
    <%--<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">--%>
    <%--<!-- js for jquery  -->--%>
    <%--<script   src="https://code.jquery.com/jquery-3.2.1.min.js"   integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="   crossorigin="anonymous"></script>--%>
    <%--<!-- js for jquery datatables -->--%>
    <%--<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>--%>
<%--<script>--%>
    <%--$(document).ready( function () {--%>
    <%--$('#myTable').DataTable();--%>
    <%--} );--%>

<%--</script>--%>



<%--</head>--%>
<%--<body>--%>
<%--<div class="container page-styling">--%>
    <%--<div class="header-wrapper">--%>
        <%--<div class="site-name">--%>
            <%--<h1>Instruments </h1>--%>
        <%--</div>--%>
        <%--<jsp:include page="nav.jsp"/>--%>
    <%--</div>--%>
        <%--<div class="lines">--%>
            <%--<div class="more-btn">--%>
                <%--<button type="button" class="btn" data-toggle="modal" data-target="#CategoryModal">Add Category</button>--%>
            <%--</div>--%>
            <%--<div class="more-btn">--%>
                <%--<button type="button" class="btn" data-toggle="modal" data-target="#InstrumentModal">Add Instrument</button>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="content-wrap">--%>
            <%--<div class="main-title spacing-bt"></div>--%>
        <%--</div>--%>


                <%--<div id="example_wrapper" class="dataTables_wrapper">--%>


            <%--<table id="myTable" class="display nowrap dataTable dtr-inline collapsed" style="width: 100%;" role="grid" aria-describedby="example_info">--%>
                <%--<thead>--%>
                <%--<tr role="row">--%>
                    <%--<th >Name</th>--%>
                    <%--<th >Category</th>--%>
                    <%--<th>Edit</th>--%>
                    <%--<th>Delete</th>--%>

                <%--</tr>--%>
                <%--</thead>--%>
                <%--<tbody>--%>
                <%--<tr>--%>
                    <%--<c:forEach items="${instruments}" var="current">--%>
                <%--<tr role="row">--%>
                    <%--<td>${current.name}</td>--%>
                    <%--<td>${current.instrumentCategory.category}</td>--%>
                    <%--<td><button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#${current.id}-Modal"><span class="glyphicon glyphicon-pencil"></span></button></td>--%>
                    <%--<td><form action="/concertPlanner/ensemble/deleteInstrument" method="get"><input type="hidden" value="${current.id}" name="idOfInstrumentToBeDeleted"><button type="submit" class="btn"><span class="glyphicon glyphicon-trash"></span></button></form></td>--%>
                <%--</tr>--%>
                <%--</c:forEach>--%>
                <%--</tr>--%>
                <%--</tbody>--%>
            <%--</table>--%>
        <%--</div>--%>
    <%--</div>--%>

<%--<c:forEach items="${instruments}" var="current">--%>
    <%--<!-- EDIT INSTRUMENT MODAL -->--%>
    <%--<div class="modal fade" id="${current.id}-Modal" role="dialog">--%>
        <%--<div class="modal-dialog">--%>

            <%--<!-- Modal content-->--%>
            <%--<div class="modal-content">--%>
                <%--<div class="modal-header">--%>
                    <%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
                    <%--<h4 class="modal-title">Edit ${current.name}</h4>--%>
                <%--</div>--%>
                <%--<div class="modal-body">--%>
                    <%--<div class="form-horizontal">--%>
                        <%--<form action="/concertPlanner/ensemble/addInstrument" method="post">--%>
                            <%--<div class="form-group">--%>
                                <%--<label for="instrumentEdit" class="col-sm-2 control-label">Instrument Name</label>--%>
                                <%--<div class="col-sm-10">--%>
                                    <%--<input type="text" id="instrumentEdit" name="instrumentEdit" value="${current.name}" />--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<label for="editInstrumentCategory" class="col-sm-2 control-label">Category </label>--%>
                                <%--<div class="col-sm-10">--%>
                                    <%--<select name="editInstrumentCategory" id="editInstrumentCategory">--%>
                                            <%--<option selected value="${current.instrumentCategory.category}">${current.instrumentCategory.category}</option>--%>
                                        <%--<c:forEach items="${categories}" var="current2">--%>
                                            <%--<option value="${current2.id}">${current2.category}</option>--%>
                                        <%--</c:forEach>--%>
                                    <%--</select>--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <%--<div class="form-group">--%>
                                <%--<div class="col-sm-2"></div>--%>
                                <%--<input type="hidden" name="instrumentId" value="${current.id}">--%>
                                <%--<input type="hidden" name="addOrEdit" value="2"/>--%>
                                <%--<div class="col-sm-offset-2 col-sm-10 ">--%>
                                    <%--<button type="submit" class="btn btn-danger">Edit</button>--%>
                                <%--</div>--%>

                            <%--</div>--%>
                        <%--</form>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="modal-footer">--%>
                    <%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
                <%--</div>--%>
            <%--</div>--%>

        <%--</div>--%>
    <%--</div>--%>
<%--</c:forEach>--%>







<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
<%--<jsp:include page="scripts.jsp"/>--%>



<%--<!-- js for jquery -->--%>
<%----%>