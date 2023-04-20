<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Feedback View</title>
    <style>
        body {
            background-color: #aff0fa;
            font-family: Arial, sans-serif;
        }
        table {
            border: 1px solid #ddd;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin-top: 20px;
            cursor: pointer;
            border-radius: 5px;
        }
        button:hover {
            background-color: #3e8e41;
        }
    </style>
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
</head>
<body>
    <h1>Admin Feedback View</h1>
    <h2>Display Feedback Details</h2>
    <table id="myTable" style="display: none;">
        <tr>
            <th>User ID</th>
            <th>Feedback</th>
        </tr>
        <c:forEach items="${adminFeeds}" var="adminFeed">
            <tr>
                <td>${adminFeed.id}</td>
                <td>${adminFeed.feeb}</td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="myDisplayFunc()">Show Feedback Details</button>
    <button onclick="myDisplayHide()">Hide Feedback Details</button>
</body>
</html>
