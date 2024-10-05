<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String fahrenheit = (String) request.getAttribute("fahrenheit");
    if (fahrenheit == null) {
        fahrenheit = "";
    }

    String result = (String) request.getAttribute("result");
    if (result == null) {
        result = "";
    }

    String fahrenheitError = (String) request.getAttribute("fahrenheitError");
    if (fahrenheitError == null) {
        fahrenheitError = "";
    }
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Temperature Converter</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Temperature Converter</h1>
<div class="container my-4">
    <div class="row">
        <div class="col-6">
            <h2>Fahrenheit to Celsius</h2>
            <p class="lead">Enter the temperature in Fahrenheit:</p>
            <form action="temp-converter" method="post">
                <div class="form-group mb-2">
                    <label for="fahrenheit">Fahrenheit:</label>
                    <input type="text" class="form-control" id="fahrenheit" name="fahrenheit" value="<%= fahrenheit %>">
                    <div style="color: red;"><%= fahrenheitError %></div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <div style="color: green;"><%= result %></div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
