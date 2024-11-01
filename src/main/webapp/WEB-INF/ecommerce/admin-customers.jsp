<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="en-US" />
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin - All Customers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@ include file="../../main-nav.jsp"%>
<div class="container py-4">
    <h2>Admin - All Customers</h2>
    <div class="table-responsive small">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th scope="col">Edit/Delete</th>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Address</th>
                <th scope="col">City</th>
                <th scope="col">State</th>
                <th scope="col">Zipcode</th>
                <th scope="col">Country</th>
                <th scope="col">Contact</th>
                <th scope="col">Email</th>
            </thead>
            <tbody>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td>
                        <a href="edit-customer?customer_id=${customer.cust_id}" class="btn btn-sm btn-outline-primary">Edit</a>
                        <a href="delete-customer?customer_id=${customer.cust_id}" class="btn btn-sm btn-outline-danger">Delete</a>
                    </td>
                    <td>${customer.cust_id}</td>
                    <td><a href="view-customer?cust_id=${customer.cust_id}">${customer.cust_name}</a></td>
                    <td>${customer.cust_address}</td>
                    <td>${customer.cust_city}</td>
                    <td>${customer.cust_state}</td>
                    <td>${customer.cust_zip}</td>
                    <td>${customer.cust_country}</td>
                    <td>${customer.cust_contact}</td>
                    <td>${customer.cust_email}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
