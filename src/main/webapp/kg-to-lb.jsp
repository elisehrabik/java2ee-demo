<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String kilograms = (String)request.getAttribute("kilograms");
    if(kilograms == null) {
        kilograms = "";
    }

    String pounds = (String)request.getAttribute("pounds");
    if(pounds == null) {
        pounds = "";
    }

    String kilogramsError = (String)request.getAttribute("kilogramsError");
    if(kilogramsError == null) {
        kilogramsError = "";
    }

%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Kilograms to Pounds Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@ include file="main-nav.jsp"%>
<div class="container my-4">
    <div class="row">
        <div class="col-6">
            <h1>Kilograms to Pounds Calculator</h1>
            <p class="lead">Enter kilograms and press submit to return the number of pounds.</p>
            <form action="kg-to-lb" method="post">
                <div class="form-group mb-2">
                    <label for="kilograms">Kilograms:</label>
                    <input type="text" class="form-control" id="kilograms" name="kilograms" value="<%= kilograms %>">
                    <div style="color: red;"><%= kilogramsError %></div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <div style="color: green;"><%= pounds %></div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>