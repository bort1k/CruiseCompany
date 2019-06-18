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
<div class="other_menu" >
    <jsp:include page="menu.jsp"/>
</div>

<div class="container our_cruises_container ship_item_container">
    <div class="phrase">
        <h2><fmt:message key="ship.item.ship"/> "${ship_item.name}"</h2>
    </div>
    <div class="photo_and_image d-flex row mb-5">
        <div class="col-lg-6">
            <img class="ship_item_img" src="${pageContext.request.contextPath}${ship_item.imageUrl}"></div>
        <div class="ship_information col-lg-6 border">
            <h3><fmt:message key="ship.item.information"/></h3>
            <ul>
                <li>
                    <fmt:message key="ship.item.release.year"/>: ${ship_item.releaseYear}
                </li>
                <li>
                    <fmt:message key="ship.item.passenger.capacity" />: ${ship_item.passengerCapacity}
                </li>
                <li>
                    <fmt:message key="ship.item.captain" />: ${ship_item.personal.captainFirstName} ${ship_item.personal.captainLastName}
                </li>
                <li>
                    <fmt:message key="ship.item.workers.technical"/>: ${ship_item.personal.numberOfTechnicalWorkers}
                </li>
                <li>
                    <fmt:message key="ship.item.workers.hotel"/>: ${ship_item.personal.numberOfHotelWorkers}
                </li>
                <li>
                    <fmt:message key="ship.item.workers.shop"/>: ${ship_item.personal.numberOfShopWorkers}
                </li>
            </ul>
        </div>
    </div>
    <div class = "cruise_list_by_ship">
        <h2 class=""><fmt:message key="ship.item.title.cruises" /></h2>
        <div class="ship_item_cruises row d-flex">
            <c:forEach items="${requestScope.ship_item.cruises}" var="cruise">
                <div class="card col-lg-4 p-0 mr-3">
                    <div class="card-body">
                        <h4 class="card-title">${cruise.name}</h4>
                        <p class="card-text"><fmt:message key="cruise.item.days"/>: ${cruise.duration}</p>
                        <p class="card-text"><fmt:message key="cruise.item.start.date"/>: ${cruise.startDate}</p>
                        <nobr class="card-text"><fmt:message key="cruise.item.from.price"/> USD</nobr>
                        <p class="number">$${cruise.price}</p>
                        <a href="#" class="btn btn-warning btn-block"><b><fmt:message key="home.container.button.make.offer"/> </b></a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>