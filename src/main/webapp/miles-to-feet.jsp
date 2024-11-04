<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String miles = (String)request.getAttribute("miles");
    if(miles == null) {
        miles = "";
    }

    String feet = (String)request.getAttribute("feet");
    if(feet == null) {
        feet = "";
    }

    String milesError = (String)request.getAttribute("milesError");
    if(milesError == null) {
        milesError = "";
    }

%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Miles to Feet Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@ include file="main-nav.jsp"%>
<div class="container my-4">
    <div class="row">
        <div class="col-6">
            <h1>Miles to Feet Calculator</h1>
            <p class="lead">Enter miles and press submit to return the number of feet.</p>
            <form action="miles-to-feet" method="post">
                <div class="form-group mb-2">
                    <label for="miles">Miles:</label>
                    <input type="text" class="form-control" id="miles" name="miles" value="<%= miles %>">
                    <div style="color: red;"><%= milesError %></div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <div style="color: green;"><%= feet %></div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>