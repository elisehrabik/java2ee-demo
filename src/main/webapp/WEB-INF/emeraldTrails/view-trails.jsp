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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.18.0/cdn/themes/light.css"/>
    <script type="module"
            src="https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.18.0/cdn/shoelace-autoloader.js"></script>
</head>

<!-- Start BODY -->
    <body>
    <!-- Nav 1 -->
        <%@include file="../../main-nav.jsp" %>
    <!-- Nav 2 -->

    <nav class="navbar navbar-expand-lg bg-body-tertiary sticky-top shadow">
        <div class="container-fluid">
            <img src="images/emerald-park-green.png" style="width:250px; margin-left: 3rem">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent" style="float:right">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0" style="margin-right: 3rem">
                    <li class="nav-item" style="font-size: 1rem">
                        <a class="nav-link active" aria-current="page" href="view-trails">Home</a>
                    </li>
                    <li class="nav-item"style="font-size: 1rem">
                        <a class="nav-link" href="view-trails">Trails</a>
                    </li>
                    <li class="nav-item"style="font-size: 1rem">
                        <a class="nav-link" href="#">About</a>
                    </li>
                    <li class="nav-item"style="font-size: 1rem">
                        <a class="nav-link" href="#">Contact</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Header -->
    <h2 style="margin: 2rem">Trails</h2>

    <!-- ADD IN SORT BY, with other stored procedures (sort by distance, difficulty, alphabetical) -->
    <!-- ADD IN FILTER BY, with other stored procedures (filter allows bikes, difficulty levels) -->

    <!-- Cards -->
    <div class="card-container">
        <%
            List<Trail> trails = (List<Trail>) request.getAttribute("trails");
            for (Trail trail : trails) {
        %>
        <sl-card class="card-overview">
            <img
                    slot="image"
                    src="<%= trail.getTrailImage() %>"
                    alt="Hiking trail at Emerald Park."
            />
            <strong><%= trail.getTrailName() %> Trail</strong><br/>
            <small style="color:gray"><%= trail.getTrailDistance() %> miles | <%= trail.getTrailDifficulty() %></small><br/>
            <p><%= trail.getTrailDescription() %></p>
        </sl-card>
        <% } %>
    </div>

<!-- Styles for cards -->
<style>
    .card-container {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
        gap: 1rem;
        margin: 0 10rem ;
        align-items: stretch;

    }
    .card-overview {
        margin: auto;
        display: flex;
        flex-direction: column;
        min-height: 400px;
    }
    .card-overview img {
        max-width: 100%;
        height: auto;
    }
    </style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
