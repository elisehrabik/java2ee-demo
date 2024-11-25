<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="en-US" />
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin - All Vendors</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@ include file="../../main-nav.jsp"%>
<div class="container py-4">
    <a href="add-vendor" class="btn btn-primary" role="button">Add New Vendor</a>
    <h2>Admin - All Vendors</h2>
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
            </thead>
            <tbody>
            <c:forEach items="${vendors}" var="vendor">
                <tr>
                    <td>
                        <a href="edit-vendor?vend_id=${vendor.vend_id}" class="btn btn-sm btn-outline-primary">Edit</a>
                        <a href="delete-vendor?vend_id=${vendor.vend_id}" class="btn btn-sm btn-outline-danger">Delete</a>
                    </td>
                    <td>${vendor.vend_id}</td>
                    <td><a href="view-vendor?vend_id=${vendor.vend_id}">${vendor.vend_name}</a></td>
                    <td>${vendor.address.address}</td>
                    <td>${vendor.address.city}</td>
                    <td>${vendor.address.state}</td>
                    <td>${vendor.address.zip}</td>
                    <td>${vendor.address.country}</td>
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
