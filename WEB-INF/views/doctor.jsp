<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor</title>
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
    <h1>Doctor</h1>

    <form action="doctor" method="post">
        <h2>Add Doctor</h2>
        <input type="text" name="doctorID" placeholder="Doctor ID">
        <input type="text" name="doctorName" placeholder="Doctor Name">
        <input type="text" name="doctorSp" placeholder="Doctor Speciality">
        <button type="submit">Add Details</button>
    </form>
    <h2>Display Payment Details</h2>
    <table id="myTable" style="display: none; border: 1px solid black; border-collapse: collapse;">
        <tr style="border: 1px solid black; border-collapse: collapse;">
            <th style="border: 1px solid black; border-collapse: collapse;">Doctor ID</th>
            <th style="border: 1px solid black; border-collapse: collapse;">Doctor Name</th>
            <th style="border: 1px solid black; border-collapse: collapse;">Doctor Speciality</th>

        </tr>
        <c:forEach items="${doctors}" var="doctor">
            <tr style="border: 1px solid black; border-collapse: collapse;">
                <td style="border: 1px solid black; border-collapse: collapse;">${doctor.doctorID}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${doctor.doctorName}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${doctor.doctorSp}</td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="myDisplayFunc()">Get Details</button>
    <button onclick="myDisplayHide()">Close View</button>

</body>
</html>
