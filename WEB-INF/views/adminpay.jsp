<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment</title>
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
    <h1>Payment</h1>

    <form action="adminpay" method="post">
        <h2>Add Pay Details</h2>
        <input type="text" name="userID" placeholder="User ID">
        <input type="text" name="paymentType" placeholder="Payment Type">
        <input type="text" name="paymentAmount" placeholder="Amount">
        <input type="text" name="paymentDate" placeholder="Date">
        <input type="text" name="transactionID" placeholder="Transaction ID">
        <input type="text" name="verify" placeholder="Status">
        <button type="submit">Add Details</button>
    </form>
    <h2>Display Payment Details</h2>
    <table id="myTable" style="display: none; border: 1px solid black; border-collapse: collapse;">
        <tr style="border: 1px solid black; border-collapse: collapse;">
            <th style="border: 1px solid black; border-collapse: collapse;">User ID</th>
            <th style="border: 1px solid black; border-collapse: collapse;">Payment Type</th>
            <th style="border: 1px solid black; border-collapse: collapse;">Amount</th>
            <th style="border: 1px solid black; border-collapse: collapse;">Date</th>
            <th style="border: 1px solid black; border-collapse: collapse;">Transaction ID</th>
            <th style="border: 1px solid black; border-collapse: collapse;">Status</th>


        </tr>
        <c:forEach items="${adminPays}" var="adminPay">
            <tr style="border: 1px solid black; border-collapse: collapse;">
                <td style="border: 1px solid black; border-collapse: collapse;">${adminPay.userID}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${adminPay.paymentType}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${adminPay.paymentAmount}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${adminPay.paymentDate}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${adminPay.transactionID}</td>
                <td style="border: 1px solid black; border-collapse: collapse;">${adminPay.verify}</td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="myDisplayFunc()">Get Details</button>
    <button onclick="myDisplayHide()">Close View</button>

</body>
</html>
