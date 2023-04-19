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
</head>
<body>
    <h1>Pls Enter Feedback</h1>
    <form action="userf" method="post">
        <h2>Add Feedback Details</h2>
        <input type="text" name="id" placeholder="UserID">
        <input type="text" name="feeb" placeholder="Feedback">
        <button type="submit">Add Details</button>
    </form>
    <h2>Display Feedback Details</h2>
    <table id="myTable" style="display: none; border: 1px solid black; border-collapse: collapse;">
        <tr style="border: 1px solid black; border-collapse: collapse;">
            <th style="border: 1px solid black; border-collapse: collapse;">UserID</th>
            <th style="border: 1px solid black; border-collapse: collapse;">Feedback</th>
        </tr>
        <c:forEach items="${userFeeds}" var="userFeed">
            <tr style="border: 1px solid black; border-collapse: collapse;">
                <td style="border: 1px solid black; border-collapse: collapse;">${userFeed.id}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${userFeed.feeb}</td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="myDisplayFunc()">Get Details</button>
    <button onclick="myDisplayHide()">Close View</button>
</html>