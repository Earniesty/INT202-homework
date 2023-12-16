<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 16/11/2566
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Office</title>
</head>
<body>
<h2>Updating Office ::</h2>
<div class="container">
    <div id="update-office">
        <div class="container">
            <form action="update-office" method="post" class="border p-4 rounded">
                <div class="row mb-3">
                    <h2>Office code ${officeData.officeCode}</h2>
                </div>
                <input type="hidden" id="office-code" name="currentOfficeCode" value="${officeData.officeCode}" class="form-control">
                <div class="row mb-3">
                    <label for="office-city" class="col-sm-3 col-form-label">City</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-city" name="newOfficeCity" value="${officeData.city}"
                               class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-phone" class="col-sm-3 col-form-label">Phone</label>
                    <div class="col-sm-9">
                        <input type="tel" id="office-phone" name="newOfficePhone" value="${officeData.phone}"
                               class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-address1" class="col-sm-3 col-form-label">Address line 1</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-address1" name="newOfficeAddress1" value="${officeData.addressLine1}"
                               class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-address2" class="col-sm-3 col-form-label">Address line 2</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-address2" name="newOfficeAddress2" value="${officeData.addressLine2}"
                               class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-state" class="col-sm-3 col-form-label">State</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-state" name="newOfficeState" value="${officeData.state}"
                               class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-country" class="col-sm-3 col-form-label">Country</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-country" name="newOfficeCountry" value="${officeData.country}"
                               class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-postalCode" class="col-sm-3 col-form-label">Postal Code</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-postalCode" name="newOfficePostalCode"
                               value="${officeData.postalCode}" class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-territory" class="col-sm-3 col-form-label">Territory</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-territory" name="newOfficeTerritory"
                               value="${officeData.territory}" class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-9">
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <p>${requestScope.errorUpdatingOffice}</p>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
