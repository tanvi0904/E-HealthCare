<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Report</title>
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
    <h1>Enter Test Results</h1>
    <form action="report" method="post">
        <h2>Generate Report</h2>
        <input type="text" name="pid" placeholder="pid">
        <input type="text" name="did" placeholder="did">
        <input type="text" name="date_time" placeholder="date_time">
        <input type="text" name="report" placeholder="report">
        <button type="submit">Update</button>
    </form>
    <h2>Display Reports</h2>
    <table id="myTable" style="display: none;">
        <tr>
            <th>pid</th>
            <th>did</th>
            <th>date_time</th>
            <th>report</th>
        </tr>
        <c:forEach items="${reports}" var="report">
            <tr>
                <td>${report.pid}</td>
                <td>${report.did}</td>
                <td>${report.date_time}</td>
                <td>${report.report}</td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="myDisplayFunc()">Get Details</button>
    <button onclick="myDisplayHide()">Close View</button>
</html>