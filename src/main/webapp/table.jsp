<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="style/css/table.css" rel="stylesheet" type="text/css" />
<div class="table">
    <!-- check table -->
    <table id="check-table" class="table-check">
        <thead>
            <tr>
                <th scope="col">X</th>
                <th scope="col">Y</th>
                <th scope="col">R</th>
                <th scope="col">Результат попадания</th>
                <th scope="col">Время отправки</th>
                <th scope="col">Время исполнения (нс)</th>
            </tr>
        </thead>
        <tbody>
        <jsp:useBean id="history" scope="session" class="com.simeon.lab2.beans.History"/>
        <c:forEach var="row" items="${history.resultList}">
            <tr>
                <td>${row.x}</td>
                <td>${row.y}</td>
                <td>${row.r}</td>
                <td>${row.hit}</td>
                <td>${row.createdAt}</td>
                <td>${row.workingTime}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>