<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 16/11/2566
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove Office</title>
</head>
<body>
    <h2>Removing Office ::</h2>
    <div class="container">
        <div class="row justify-content-center">
            <div class="d-block border m-2 p-2">
                <form action="remove-office" method="post">
                    <label for="removeId"></label>Remove By Id :
                    <input type="text" name="removeId" id="removeId">
                    <input type="submit" value="Remove">
                    <p>${errorRemove}</p>
                </form>
                <div>
                    <p>${removeStatus}</p>
                </div>
            </div>
        </div>
        <div class="row justify-content-center m-2 p-2 border">
            <form action="remove-office" method="post">


            </form>
        </div>
    </div>
</body>
</html>
