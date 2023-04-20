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
        body {
            background-color: #aff0fa;
            font-family: Arial, sans-serif;
            font-size: 16px;
        }
        h1, h2 {
            text-align: center;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-bottom: 20px;
        }
        input[type="text"] {
            padding: 10px;
            margin: 5px;
            width: 250px;
            border-radius: 5px;
            border: none;
        }
        button[type="submit"] {
            padding: 10px;
            margin: 5px;
            width: 150px;
            border-radius: 5px;
            border: none;
            background-color: #4CAF50;
            color: white;
            font-weight: bold;
        }
        table {
            border: 1px solid black;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
        button {
            padding: 10px;
            margin: 5px;
            border-radius: 5px;
            border: none;
            background-color: #4CAF50;
            color: white;
            font-weight: bold;
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
    <table id="myTable" style="display: none;">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Blood Group</th>
            <th>Amount Donated</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.bg}</td>
                <td>${user.donation}</td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="myDisplayFunc()">Get Details</button>
    <button onclick="myDisplayHide()">Close View</button>

</body>
</html>
