<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<!DOCTYPE html>
<html lang="${locale}">
<jsp:include page="head_tag.jsp"/>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<div class="other_menu">
    <jsp:include page="menu.jsp"/>
</div>
<div class="container about_container">
    <div class="phrase mb-4">
        <h2>Admin Page</h2>
    </div>
    <div>
        <h3>All users orders</h3>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>

