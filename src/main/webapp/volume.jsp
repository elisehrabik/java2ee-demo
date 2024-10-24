<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String radius = (String) request.getAttribute("radius");
    if (radius == null) {
        radius = "";
    }
    String height = (String) request.getAttribute("height");
    if (height == null) {
        height = "";
    }

    String result = (String) request.getAttribute("result");
    if (result == null) {
        result = "";
    }

    String radiusError = (String) request.getAttribute("radiusError");
    if (radiusError == null) {
        radiusError = "";
    }
    String heightError = (String) request.getAttribute("heightError");
    if (heightError == null) {
        heightError = "";
    }

    String error = (String) request.getAttribute("error");
    if (error == null) {
        error = "";
    }
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Volume Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="main-nav.jsp"%>
<div class="container my-4">
    <div class="row">
        <div class="col-6">
            <h1>Volume Calculator</h1>
            <p class="lead">Enter radius and height to calculate the volume of the cylinder.</p>
            <form action="volume" method="post">
                <div class="form-group mb-2">
                    <label for="radius">Radius:</label>
                    <input type="text" class="form-control" id="radius" name="radius" value="<%= radius %>">
                    <div style="color: red;"><%= radiusError %></div>
                </div>
                <div class="form-group mb-2">
                    <label for="height">Height:</label>
                    <input type="text" class="form-control" id="height" name="height" value="<%= height %>">
                    <div style="color: red;"><%= heightError %></div>
                </div>
                <button type="submit" class="btn btn-primary">Calculate</button>
            </form>
            <div style="color: green;"><%= result %></div>
            <div style="color: red;"><%= error %></div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
