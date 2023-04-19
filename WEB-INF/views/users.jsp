<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Blood Donation</title>
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
    <h1>Blood Donation Management System</h1>

    <form action="users" method="post">
        <h2>Add Donation Details</h2>
        <input type="text" name="id" placeholder="ID">
        <input type="text" name="name" placeholder="Name">
        <input type="text" name="age" placeholder="Age">
        <input type="text" name="bg" placeholder="Blood Group">
        <input type="text" name="donation" placeholder="Amount Donated">
        <button type="submit">Add Details</button>
    </form>

    <h2>Display All Donations and their details</h2>
    <table id="myTable" style="display: none; border: 1px solid black; border-collapse: collapse;">
        <tr style="border: 1px solid black; border-collapse: collapse;">
            <th style="border: 1px solid black; border-collapse: collapse;">ID</th>
            <th style="border: 1px solid black; border-collapse: collapse;">Name</th>
            <th style="border: 1px solid black; border-collapse: collapse;">Age</th>
            <th style="border: 1px solid black; border-collapse: collapse;">Blood Group</th>
            <th style="border: 1px solid black; border-collapse: collapse;">Amount Donated</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr style="border: 1px solid black; border-collapse: collapse;">
                <td style="border: 1px solid black; border-collapse: collapse;">${user.id}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${user.name}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${user.age}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${user.bg}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${user.donation}</td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="myDisplayFunc()">Get Details</button>
    <button onclick="myDisplayHide()">Close View</button>

</body>
</html>
