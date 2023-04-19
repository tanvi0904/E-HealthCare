<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bed Availability</title>
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
    <h1>Check Bed Availability</h1>

    <form action="room" method="post">
        <h2>Add your details</h2>
        <input type="text" name="RID" placeholder="RID">
        <input type="text" name="PID" placeholder="PID">
        <input type="text" name="NOB" placeholder="NOB">
        <button type="submit">Add Details</button>
    </form>

    <h2>Display All Bed Availability</h2>
    <table id="myTable" style="display: none; border: 1px solid black; border-collapse: collapse;">
        <tr style="border: 1px solid black; border-collapse: collapse;">
            <th style="border: 1px solid black; border-collapse: collapse;">RID</th>
            <th style="border: 1px solid black; border-collapse: collapse;">PID</th>
            <th style="border: 1px solid black; border-collapse: collapse;">Number of Beds</th>
        </tr>
        <c:forEach items="${Rooms}" var="room">
            <tr style="border: 1px solid black; border-collapse: collapse;">
                <td style="border: 1px solid black; border-collapse: collapse;">${room.RID}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${room.PID}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${room.NOB}</td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="myDisplayFunc()">Get Details</button>
    <button onclick="myDisplayHide()">Close View</button>

</body>
</html>
