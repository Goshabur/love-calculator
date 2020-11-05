<%@ page import="ru.gosha.spring.test.api.EmailDTO" %><%--
  Created by IntelliJ IDEA.
  User: George
  Date: 8/8/2020
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 align="center">Love Calculator</h1>
    <hr/>
    <h2>The Love Calculator Predicts:</h2>
    <br/>
    ${userInfo.userName} and ${userInfo.crushName} are
    <br/>
    ${result}
    <br/>
    <a href="/sendEmail">Send Result to Your Email</a>
</body>
</html>
