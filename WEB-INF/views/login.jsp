<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <script>
        function myDisplayFunc() {
            var table = document.getElementById("myTable");
            if (table.style.display === "none") {
                table.style.display = "table";
            }
        }
        function myDisplayHide() {
            var table = document.getElementById("myTable");
            if (table.style.display === "table") {
                table.style.display = "none";
            }
        }
    </script>
    <style>
        body{
            background-color: #aff0fa;
        }
    </style>
</head>
<body>
    <h1>Login</h1>

    <form action="login" method="post">
        <h2>Enter Login Details</h2>
        <input type="text" name="username" placeholder="UserName">
        <input type="text" name="password" placeholder="Password">
        <input type="text" name="role" placeholder="Role">
        <button type="submit">Submit</button>
    </form>
    <!-- <h2>Display Login Details</h2> -->
    <table id="myTable" style="display: none; border: 1px solid black; border-collapse: collapse;">
        <tr style="border: 1px solid black; border-collapse: collapse;">
            <th style="border: 1px solid black; border-collapse: collapse;">USN</th>
            <th style="border: 1px solid black; border-collapse: collapse;">Password</th>
            <th style="border: 1px solid black; border-collapse: collapse;">Role</th>

        </tr>
        <c:forEach items="${logins}" var="login">
            <tr style="border: 1px solid black; border-collapse: collapse;">
                <td style="border: 1px solid black; border-collapse: collapse;">${login.username}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${login.password}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${login.role}</td>
            </tr>
        </c:forEach>
    </table>
    <!-- <button onclick="myDisplayFunc()">Get Details</button>
    <button onclick="myDisplayHide()">Close View</button> -->

</body>
</html>
