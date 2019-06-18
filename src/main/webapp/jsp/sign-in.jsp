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
        <c:if test="${param.emailExist == false}">
            <p style="color: white">Successful registration! Now sign in to your account.</p>
        </c:if>
        <form action="${pageContext.request.contextPath}/eden-cruises/sign-in-user" method="post">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
            </div>
            <button type="submit" class="btn btn-warning">Sign In</button>
        </form>
    </div>
</div>
</body>
</html>
