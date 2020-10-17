<%--
  Created by IntelliJ IDEA.
  User: George
  Date: 10/8/2020
  Time: 12:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <h1>HI ${userInfo.userName}</h1>
    <h2>Send Result To Your Email</h2>
    <form:form action="process-email" method="get" modelAttribute="emailDTO">
        <label> Enter Your Email</label>
        <form:input path="userEmail"/>
        <input type="submit" value="send">
    </form:form>

</body>
</html>
