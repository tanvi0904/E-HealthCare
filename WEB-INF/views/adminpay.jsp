<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Payment Verification</title>
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
    <h1>Payment Verification</h1>

    <form action="adminpay" method="post">
        <h2>Update Verification Status</h2>
        <input type="text" name="userID" placeholder="User ID">
        <input type="text" name="paymentType" placeholder="Payment Type">
        <input type="text" name="paymentAmount" placeholder="Amount">
        <input type="text" name="paymentDate" placeholder="Date">
        <input type="text" name="transactionID" placeholder="Transaction ID">
        <input type="text" name="verify" placeholder="Status">
        <button type="submit">Update</button>
    </form>
    <h2>Display All Payment Details</h2>
    <table id="myTable" style="display: none;">
        <tr>
            <th>User ID</th>
            <th>Payment Type</th>
            <th>Amount</th>
            <th>Date</th>
            <th>Transaction ID</th>
            <th>Status</th>
        </tr>
        <c:forEach items="${adminPays}" var="adminPay">
            <tr>
                <td>${adminPay.userID}</td>
                <td>${adminPay.paymentType}</td>
                <td>${adminPay.paymentAmount}</td>
                <td>${adminPay.paymentDate}</td>
                <td>${adminPay.transactionID}</td>
                <td>${adminPay.verify}</td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="myDisplayFunc()">Get Details</button>
    <button onclick="myDisplayHide()">Close View</button>

</body>
</html>
