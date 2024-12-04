<%@ page import="edu.kirkwood.emeraldTrails.model.Trail" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<!-- HEAD -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Emerald Park</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<!-- Start BODY -->
<body>
<!-- Navigation (main and park) -->
<%@include file="../../main-nav.jsp" %>
<%@include file="park-nav.jsp" %>

<!-- Header -->
<h2 style="margin-left: 4rem; margin-top: 2rem; margin-bottom: 2rem;">Trails</h2>


<!-- Cards -->
<div class="container">
    <div class="row">
        <%
            List<Trail> trails = (List<Trail>) request.getAttribute("trails");
            if (trails == null || trails.isEmpty()) {
        %>
        <div class="col-12">
            <p class="text-center">No trails available.</p>
        </div>
        <%
        } else {
            for (Trail trail : trails) {
        %>
        <div class="col-md-4 mb-4">
            <div class="card h-100">
                <img src="<%= trail.getTrail_image() %>" class="card-img-top" alt="<%=trail.getTrail_name()%> hiking trail at Emerald Park.">
                <div class="card-body">
                    <h5 class="card-title"><%= trail.getTrail_name() %> Trail</h5>
                    <p class="card-text"><small class="text-muted"><%= trail.getTrail_distance() %> miles | <%= trail.getTrail_difficulty() %></small></p>
                    <p class="card-text"><%= trail.getTrail_description() %></p>
                </div>
            </div>
        </div>
        <%
                }
            }
        %>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
