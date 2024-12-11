<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="en-US" />
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Movies</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@include file="../../main-nav.jsp" %>
<div class="container">
    <h1>Current Movies</h1>
    <div class="d-flex flex-wrap justify-content-center gap-4">
        <c:forEach items="${movies}" var="movie">
        <div class="card" style="max-width: 600px;">
            <div class="row g-0">

                <div class="col-lg-5">
                    <img src="https://image.tmdb.org/t/p/w600_and_h900_bestv2${movie.poster_path}" class="img-fluid rounded-start" alt="${movie.title}">
                </div>
                <div class="col-lg-7">
                    <div class="card-body">
                        <h5 class="card-title">${movie.title}</h5>
                        <p class="card-text">${movie.overview}</p>
                        <p class="card-text"><small class="text-body-secondary">${movie.release_date}</small></p>
                    </div>
                </div>

            </div>
        </div>
            </c:forEach>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>