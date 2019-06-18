<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<!DOCTYPE HTML>
<html>
<jsp:include page="head_tag.jsp"/>
<body style="background: #15264C; background-size: cover; ">
<div class="">
    <div class="sign-up col-lg-4" style="color: white; margin:100px auto auto auto">
        <c:if test="${param.userExist == false}">
            <p style="color: white">There is no such user! Please, sign up first.</p>
        </c:if>
        <c:if test="${param.emailExist == true}">
            <p style="color: white">Email already exists! Enter another email.</p>
        </c:if>
        <form action="${pageContext.request.contextPath}/eden-cruises/sign-up-user" method="post">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
            </div>
            <div class="form-group">
                <label for="first-name">First Name:</label>
                <input type="text" class="form-control" id="first-name" placeholder="Enter First Name" name="first_name"
                       required>
            </div>
            <div class="form-group">
                <label for="last-name">Last Name:</label>
                <input type="text" class="form-control" id="last-name" placeholder="Enter Last Name" name="last_name"
                       required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" placeholder="Enter password" name="password"
                       required>
            </div>
            <button type="submit" class="btn btn-warning">Sign Up</button>
        </form>
    </div>
</div>
</body>
</html>
