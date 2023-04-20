<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Feedback</title>
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
    <h1>Please Enter Feedback</h1>
    <form action="userf" method="post">
        <h2>Add Feedback Details</h2>
        <input type="text" name="id" placeholder="UserID">
        <input type="text" name="feeb" placeholder="Feedback">
        <button type="submit">Add Details</button>
    </form>
    <!-- <h2>Display Feedback Details</h2> -->
    <table id="myTable" style="display: none;">
        <tr>
            <th>UserID</th>
            <th>Feedback</th>
        </tr>
        <c:forEach items="${userFeeds}" var="userFeed">
            <tr>
                <td>${userFeed.id}</td>
                <td>${userFeed.feeb}</td>
            </tr>
        </c:forEach>
    </table>
    <!-- <button onclick="myDisplayFunc()">Get Details</button>
    <button onclick="myDisplayHide()">Close View</button> -->
</html>