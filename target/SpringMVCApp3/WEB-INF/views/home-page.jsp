<%--
  Created by IntelliJ IDEA.
  User: George
  Date: 8/7/2020
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>HomePage</title>

    <style>
        .errors{
            color: #ff0000;
            position: fixed;
            text-align: left;
            margin-left: 30px;
        }
    </style>

    <script>
        
        function validateUserName() {
            var userName = document.getElementById("un").value;
            if(userName.length < 3){
                alert("your name should involve at least 3 letters ");
                return false;
            }else return true;
        }
        
        
    </script>

</head>
<body>
    <h1 align="center">Love Calculator</h1>
    <hr/>

    <form:form action="process-homepage" method="get" modelAttribute="userInfo" onsubmit="return validateUserName()"> <!-onsubmit="return validateUserName()"-->
        <div align="center">
            <p>
                <label for="un">Your Name: </label>
                <form:input id="un"  path="userName"/>
                <form:errors path="userName" cssClass="errors"/>
            </p>
            <p>
                <label for="cn">Crush Name: </label>
                <form:input id="cn" path="crushName"/>
                <form:errors path="crushName" cssClass="errors"/>
            </p>
            <p>
                <form:checkbox path="termAndCondition" id="check"/>
                <label id="check">I am agreeing that this is for fun</label>
                <form:errors path="termAndCondition" cssClass="errors"/>
            </p>
            <input type="submit" value="calculate">
        </div>
    </form:form>

</body>
</html>
