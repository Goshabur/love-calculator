<%--
  Created by IntelliJ IDEA.
  User: George
  Date: 8/12/2020
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RegPage</title>

    <style>
        .errors {
            color: red;
            position: fixed;
            text-align: left;
            margin-left: 30px;
        }
    </style>

</head>
<body>
<h1 align="center">Please register here</h1>
<form:form action="registration-success" modelAttribute="registerInfo">
    <div align="center">
        <label>User : </label>
        <form:input path="name"/>
        <form:errors path="name" cssClass="errors"/>

        <br/>
        <label>UserName : </label>
        <form:input path="userName"/>
        <form:errors path="userName" cssClass="errors"/>

        <br/>
        <label>Password : </label>
        <form:password path="password"/>

        <br/>
        <label>Country : </label>
        <form:select path="countryName">
            <form:option value="Rus" label="Russia"/>
            <form:option value="Ind" label="India"/>
            <form:option value="Usa" label="America"/>
            <form:option value="Can" label="Canada"/>
        </form:select>

        <br/>
        <label>Hobbies : </label>
        Cricket : <form:checkbox path="hobbies" value="cricket"/>
        Football : <form:checkbox path="hobbies" value="football"/>
        Reading : <form:checkbox path="hobbies" value="reading"/>
        Athletics : <form:checkbox path="hobbies" value="athletics"/>

        <br/>
        <label>Gender : </label>
        Male<form:radiobutton path="gender" value="male"/>
        Female<form:radiobutton path="gender" value="female"/>

        <br/>
        <label>Age : </label>
        <form:input path="age"/>
        <form:errors path="age" cssClass="errors"/>


    </div>
    <div align="center">
        <h3>Communication</h3>
        <label>Email</label>
        <form:input path="communicationDTO.email"/>
        <form:errors path="communicationDTO.email" cssClass="errors"/>
        <br/>
        <label>Phone</label>
        <form:input path="communicationDTO.phone"/>

        <br/>
        <input type="submit" value="register">

    </div>
</form:form>

</body>
</html>
