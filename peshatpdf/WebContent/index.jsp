<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>PeshatPDF</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <p>PeshatPDF V0.1</p>
        Please insert the exact ID
        <br>
        <br>
        <form method="post" action="${pageContext.request.contextPath}/create">
            <label for="mycoreid">MyCore-Peshat-ID :</label>
            <input type="text" id="mycoreid" name="mycoreid" size="40" value="peshat_bibliographical-sources_00000002">
            <br><br>
            </form>


        <input type="submit" value="Submit and CreatePDF">
        </form>
    </body>
</html>
