<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String toEmailAddress = (String) request.getAttribute("toEmailAddress");
    if (toEmailAddress == null) {
        toEmailAddress = "";
    }
    String subject = (String) request.getAttribute("subject");
    if (subject == null) {
        subject = "";
    }

    String bodyHTML = (String) request.getAttribute("bodyHTML");
    if (bodyHTML == null) {
        bodyHTML = "";
    }

    String emailError = (String) request.getAttribute("emailError");
    if (emailError == null) {
        emailError = "";
    }
    String subjectError = (String) request.getAttribute("subjectError");
    if (subjectError == null) {
        subjectError = "";
    }

    String messageBodyError = (String) request.getAttribute("messageBodyError");
    if (messageBodyError == null) {
        messageBodyError = "";
    }

    String messageSuccess = (String) request.getAttribute("messageSuccess");
    if (messageSuccess == null) {
        messageSuccess = "";
    }
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Contact</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/group-chat.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
    <!-- Load jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"
            integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
    <!-- Load your own JavaScript file -->
    <script src='scripts/contact.js'></script>
</head>
<body>
<%@ include file="main-nav.jsp"%>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2>Contact Us</h2>
            <form class="serverForm" action="contact" method="post">
                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="text" class="form-control" id="email" name= "toEmailAddress" value="<%= toEmailAddress %>">
                </div>
                <div class="form-group">
                    <label for="subject">Subject</label>
                    <input type="text" class="form-control" id="subject" name= "subject" value="<%= subject %>">
                </div>
                <div class="form-group">
                    <label for="message">Message</label>
                    <textarea class="form-control" id="message" name="bodyHTML" rows="5"><%= bodyHTML %></textarea>
                </div>
                <button type="submit" class="btn btn-primary submit-btn mt-2">Send</button>
            </form>
            <!-- Error Notification Placeholder -->
            <div id="errorText" class="alert alert-danger d-none" role="alert"></div>
            <!-- Message Placeholder -->
            <!-- <div id="messages"></div> -->
            <div style="color: red;"><%= emailError %><br><%= subjectError %><br><%= messageBodyError %></div>
            <div style="color: green;"><%= messageSuccess %></div>

        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script src="scripts/group-chat.js"></script>
</body>
</html>
