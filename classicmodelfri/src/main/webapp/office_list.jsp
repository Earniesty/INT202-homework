<%--
  Created by IntelliJ IDEA.
  User: natnarinchaisiripanich
  Date: 3/11/2023 AD
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Office List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row bg-primary">
        <h2>classic Model Offices ::</h2>
    </div>
    <div class="col-md-6">
        <br>
        <form action="office-list" method="post" class="d-inline p-2 justify-self-center">
            <label for="filter">Find Office Country/City</label>
            <select name="filterValue" id="filter">
                <option value="all">All</option>
                <optgroup label="Countries">
                    <c:forEach items="${allCountry}" var="country" varStatus="count">
                        <option value="${country}" ${selectedFilterValue == country ? 'selected' : ''}>${country}</option>
                    </c:forEach>
                </optgroup>
                <optgroup label="City">
                    <c:forEach items="${allCity}" var="city" varStatus="count">
                        <option value="${city}" ${selectedFilterValue == city ? 'selected' : ''}>${city}</option>
                    </c:forEach>
                </optgroup>
            </select>
            <input type="submit" value="Filter" class="btn btn-primary">
        </form>
        <br>
    </div>

    <div class="col-md-6 text-right">
        <form action="adding-office" method="get" class="d-inline m-3">
            <input type="submit" class="btn btn-primary" value="Add new office">
        </form>
        <form action="remove-office" method="get" class="d-inline m-3">
            <input type="submit" class="btn btn-primary" value="Remove office">
        </form>
        <br>
    </div>

    <div class="row">
        <c:forEach items="${offices}" var="office">
            <div class="col-2 border border-secondary p-2 m-2"${office.officeCode == selectedOffice.officeCode ? 'bg-warning' : ''}">
                <div>
                    <a href="office-list?officeCode=${office.officeCode}">
                            ${office.city}</a>,${office.country}
                </div>
                <div> ${office.phone}</div>
            <div class="justify-self-end p-2">
                <form action="update-office" method="get" class="container d-flex flex-wrap">
                <button type="submit" name="editOffice" value="${office.officeCode}">Edit</button>
                </form>
            </div>
            </div>
        </c:forEach>
        <br>
        <div class="row bg-light">
            <b>Employee ::</b>
        </div>
        <div class="row">
            <c:forEach items="${selectedOffice.employeeList}" var="employee">
                <div class="col-2 pl-2 m-2 border border-secondary rounded-pill">
                    <div> ${employee.firstName}
                            ${employee.lastName} - ${employee.jobTitle}
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
