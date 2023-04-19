<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Appointment</title>
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
<!-- table has only pid and did date_time and report -->
<body>
    <h1>Make an Appointment</h1>
    <form action="appo" method="post">
        <h2>Enter Details</h2>
        <input type="text" name="pid" placeholder="pid">
        <input type="text" name="did" placeholder="did">
        <input type="text" name="date_time" placeholder="date_time">
        <!-- <input type="text" name="report" placeholder="report"> -->
        <button type="submit">Confirm</button>
    </form>
    <h2>Display Appointment Details</h2>
    <table id="myTable" style="display: none; border: 1px solid black; border-collapse: collapse;">
        <tr style="border: 1px solid black; border-collapse: collapse;">
            <th style="border: 1px solid black; border-collapse: collapse;">pid</th>
            <th style="border: 1px solid black; border-collapse: collapse;">did</th>
            <th style="border: 1px solid black; border-collapse: collapse;">date_time</th>
            <th style="border: 1px solid black; border-collapse: collapse;">report</th>
        </tr>
        <c:forEach items="${appos}" var="appo">
            <tr style="border: 1px solid black; border-collapse: collapse;">
                <td style="border: 1px solid black; border-collapse: collapse;">${appo.pid}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${appo.did}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${appo.date_time}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${appo.report}</td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="myDisplayFunc()">Get Details</button>
    <button onclick="myDisplayHide()">Close View</button>
</html>