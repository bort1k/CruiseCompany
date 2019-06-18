<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>

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
<div class="container our_ships_container">
    <div class="phrase">
        <h2><fmt:message key="ships.container.title" /></h2>
        <p><fmt:message key="ships.container.advert"/> </p>
    </div>

    <div class="display-ships justify-content-between row">
        <c:forEach var="ship" items="${requestScope.shipList}" >
            <div class="card col-4 p-0 ship_card">
                <img class="card-img-top" src="${pageContext.request.contextPath}${ship.imageUrl}"
                     alt="Card image"
                     style="width:100%; height: 230px">
                <div class="card-body">
                    <h4 class="card-title">
                        <a class="ship_name" href="${pageContext.request.contextPath}/eden-cruises/ship-item?id=${ship.id}">
                        ${ship.name}</a>
                        ${ship.releaseYear}</h4>
                </div>
            </div>
        </c:forEach>
    </div>

</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
