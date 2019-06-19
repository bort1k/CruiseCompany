<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 6/14/2019
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<head>
    <meta charset="UTF-8">
    <title><fmt:message key="label.title"/> </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <%--<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>--%>
</head>