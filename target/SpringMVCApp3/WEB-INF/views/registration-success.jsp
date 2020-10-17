<%--
  Created by IntelliJ IDEA.
  User: George
  Date: 8/12/2020
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Your registration is successful</h1>
    <h2>Your details: </h2>
    Name: ${registerInfo.name} <br/>
    User name: ${registerInfo.userName}<br/>
    Password : ${registerInfo.password}<br/>
    Country : ${registerInfo.countryName}<br/>
    Hobbies :

        <c:forEach var="hobby" items="${registerInfo.hobbies}">
            ${hobby}
        </c:forEach>

    <br/>
    Gender : ${registerInfo.gender}<br/>
    Age : ${registerInfo.age}<br/>
    Email : ${registerInfo.communicationDTO.email}<br/>
    Phone : ${registerInfo.communicationDTO.phone}<br/>

</body>
</html>
