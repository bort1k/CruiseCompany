<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<!DOCTYPE html>
<html lang="${locale}">
<jsp:include page="head_tag.jsp"/>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>

<div class="main_button_and_image">
    <div class="main_menu">
        <jsp:include page="menu.jsp"/>
    </div>
    <div class="container search_button">
        <div class="inside_search_button col-3">
            <div class="button">
                <a href="${pageContext.request.contextPath}/eden-cruises/our-cruises"><fmt:message key="home.button.find.cruises"/></a>
            </div>
        </div>
    </div>
</div>

<div class="container container_main_cruises">
    <div class=phrase>
        <h2><fmt:message key="home.container.hot.offers"/> </h2>
        <P><fmt:message key="home.container.advert"/> </P>
    </div>
    <div class="cards d-flex">
        <div class="card col-lg-4 p-0">
            <img class="card-img-top" src="${pageContext.request.contextPath}/images/kayak-barcelona-1.jpg"
                 alt="Card image"
                 style="width:100%; height: 230px">
            <div class="card-body">
                <h4 class="card-title">4 NIGHT KEY WEST &
                    NASSAU CRUISE</h4>
                <p class="card-text">Departs from Fort Lauderdale, Florida
                    Onboard Majesty of the Seas</p>
                <nobr class="card-text">From USD</nobr>
                <p class="number">$210</p>
                <a href="#" class="btn btn-warning btn-block"><b><fmt:message key="home.container.button.make.offer"/> </b></a>
            </div>
        </div>
        <div class="card card_center col-lg-4 p-0">
            <img class="card-img-top"
                 src="${pageContext.request.contextPath}/images/Mussandam-Sea-Safari-With-Lunch-from-Dubai-10-13616.png"
                 alt="Card image" style="width:100% ; height: 230px">
            <div class="card-body">
                <h4 class="card-title">4 NIGHT KEY WEST &
                    NASSAU CRUISE</h4>
                <p class="card-text">Departs from Fort Lauderdale, Florida
                    Onboard Majesty of the Seas</p>
                <nobr class="card-text">From USD</nobr>
                <p class="number">$210</p>
                <a href="#" class="btn btn-warning btn-block"><b><fmt:message key="home.container.button.make.offer"/> </b></a>
            </div>
        </div>
        <div class="card col-lg-4 p-0">
            <img class="card-img-top" src="${pageContext.request.contextPath}/images/photo_2019-06-10_01-35-45.jpg"
                 alt="Card image"
                 style="width:100%; height: 230px">
            <div class="card-body">
                <h4 class="card-title">4 NIGHT KEY WEST &
                    NASSAU CRUISE</h4>
                <p class="card-text">Departs from Fort Lauderdale, Florida
                    Onboard Majesty of the Seas</p>
                <nobr class="card-text">From USD</nobr>
                <p class="number">$210</p>
                <a href="#" class="btn btn-warning btn-block"><b><fmt:message key="home.container.button.make.offer"/> </b></a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>