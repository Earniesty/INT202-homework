<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 16/11/2566
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Office</title>
</head>
<body>
    <h2>Adding New Office ::</h2>
    <div class="container">
        <form action="adding-office" method = "post" class="border p-4 rounded">
            <div class="row mb-3">
                <label for="office-code" class="col-sm-3 col-form-label">Office Code</label>
                <div class="col-sm-9">
                    <input type="text" id="office-code" name="newOfficeCode" class="form-control">
                </div>
            </div>

            <div class="row mb-3">
                <label for="office-city" class="col-sm-3 col-form-label">City</label>
                <div class="col-sm-9">
                    <input type="text" id="office-city" name="newOfficeCity" class="form-control">
                </div>
            </div>

            <div class="row mb-3">
                <label for="office-phone" class="col-sm-3 col-form-label">Phone</label>
                <div class="col-sm-9">
                    <input type="tel" id="office-phone" name="newOfficePhone" class="form-control">
                </div>
            </div>

            <div class="row mb-3">
                <label for="office-address1" class="col-sm-3 col-form-label">Address line 1</label>
                <div class="col-sm-9">
                    <input type="text" id="office-address1" name="newOfficeAddress1" class="form-control">
                </div>
            </div>

            <div class="row mb-3">
                <label for="office-address2" class="col-sm-3 col-form-label">Address line 2</label>
                <div class="col-sm-9">
                    <input type="text" id="office-address2" name="newOfficeAddress2" class="form-control">
                </div>
            </div>

            <div class="row mb-3">
                <label for="office-state" class="col-sm-3 col-form-label">State</label>
                <div class="col-sm-9">
                    <input type="text" id="office-state" name="newOfficeState" class="form-control">
                </div>
            </div>

            <div class="row mb-3">
                <label for="office-country" class="col-sm-3 col-form-label">Country</label>
                <div class="col-sm-9">
                    <input type="text" id="office-country" name="newOfficeCountry" class="form-control">
                </div>
            </div>

            <div class="row mb-3">
                <label for="office-postalCode" class="col-sm-3 col-form-label">Postal Code</label>
                <div class="col-sm-9">
                    <input type="text" id="office-postalCode" name="newOfficePostalCode" class="form-control">
                </div>
            </div>

            <div class="row mb-3">
                <label for="office-territory" class="col-sm-3 col-form-label">Territory</label>
                <div class="col-sm-9">
                    <input type="text" id="office-territory" name="newOfficeTerritory" class="form-control">
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-sm-3"></div>
                <div class="col-sm-9">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <br>


                    <p>${requestScope.errorAddingOffice}</p>
                </div>
            </div>
        </form>
    </div>
    </div>
</body>
</html>
