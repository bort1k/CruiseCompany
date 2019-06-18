<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<div class="container our_cruises_container">
    <div class="phrase mb-5">
        <h2><fmt:message key="cruises.container.title"/></h2>
        <p><fmt:message key="cruises.container.advert"/></p>
    </div>

    <div class="ship_item_cruises row">
        <c:forEach items="${requestScope.cruises}" var="cruise">
            <div class="card col-lg-4 mb-4">
                <div class="card-body">
                    <h4 class="card-title">${cruise.name}</h4>
                    <p class="card-text"><fmt:message key="cruise.item.title.ship"/>: ${cruise.ship.name}</p>
                    <p class="card-text"><fmt:message key="cruise.item.days"/>: ${cruise.duration}</p>
                    <p class="card-text"><fmt:message key="cruise.item.start.date"/>: ${cruise.startDate}</p>
                    <nobr class="card-text"><fmt:message key="cruise.item.from.price"/> USD</nobr>
                    <p class="number">$${cruise.price}</p>
                    <form action="${pageContext.request.contextPath}/eden-cruises/cruise-item"
                          method="get" id="form1">
                        <input type="hidden" name="id" value="${cruise.id}">
                        <input type="hidden" name="ship_name" value="${cruise.ship.name}">
                        <input type="submit" class="btn btn-warning btn-block make_offer" style="text-align:center;"
                               value="<fmt:message key="home.container.button.make.offer"/>">
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>

</div>
<jsp:include page="footer.jsp"/>
</body>
</html>

