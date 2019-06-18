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

<div class="container our_cruises_container ship_item_container">
    <div class="phrase">
        <h2><fmt:message key="cruise.item.cruise"/> "${cruise.name}"</h2>
    </div>
    <div class="photo_and_image row mb-5">
        <div class="ship_information col-lg-6 border">
            <h3><fmt:message key="ship.item.information"/></h3>
            <div class="card-body">
                <p class="card-text"><fmt:message key="cruise.item.title.ship"/>: ${param.ship_name}</p>
                <p class="card-text"><fmt:message key="cruise.item.days"/>: ${cruise.duration}</p>
                <p class="card-text"><fmt:message key="cruise.item.start.date"/>: ${cruise.startDate}</p>
                <nobr class="card-text"><fmt:message key="cruise.item.from.price"/> USD</nobr>
                <p class="number">$${cruise.price}</p>
            </div>
        </div>
    </div>

    <div class="ports_list col-lg-6 border">
        <h3><fmt:message key="cruise.item.ports" /></h3>
        <ul>
            <c:forEach items="${requestScope.cruise.ports}" var="port">
                <li>
                        ${port.name}
                </li>
            </c:forEach>
        </ul>
    </div>
    <h3 class="mt-5"><fmt:message key="cruise.item.additional.tours"/></h3>
    <table class="table">
        <thead>
        <tr>
            <th scope="col"><fmt:message key="cruise.item.tour.title"/></th>
            <th scope="col"><fmt:message key="cruise.item.tour.title.port"/></th>
            <th scope="col"><fmt:message key="cruise.item.tour.title.price"/>(USD)</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.tours}" var="tour">
            <tr>
                <td>${tour.name}</td>
                <td>${tour.port.name}</td>
                <td>${tour.price}</td>
                <td>
                    <a href="#" class="btn btn-warning btn-block" style="font-size: 18px; font-weight: bold">
                        <fmt:message key="cruise.item.tour.button.add"/>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h2>Total price: ${totalPrice}</h2>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
