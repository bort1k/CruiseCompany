<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<div class="container d-flex align-items-center menu_sign_in">
    <nav class="navbar navbar-expand-sm col-8 navbar-dark">
        <!-- Brand/logo -->
        <a class="navbar-brand" href="${pageContext.request.contextPath}/eden-cruises/home">
            <img src="${pageContext.request.contextPath}/images/LOGO.png" alt="logo" style="width:200px;">
        </a>

        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/eden-cruises/home"><fmt:message
                        key="label.menu.home"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/eden-cruises/our-ships"><fmt:message
                        key="label.menu.ships"/> </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/eden-cruises/our-cruises"><fmt:message
                        key="label.menu.cruises"/> </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/eden-cruises/about-us"><fmt:message
                        key="label.menu.about"/></a>
            </li>
        </ul>
    </nav>
    <nav class="sign_in d-block navbar navbar-expand-sm navbar-dark col-4">
        <ul class="navbar-nav">
            <li class="nav-item">
                <c:if test="${sessionScope.userSession == null}">
                    <a href="${pageContext.request.contextPath}/eden-cruises/sign-up"
                       class="nav-link float-right"><fmt:message key="label.menu.sign.up"/></a>
                    <span class="float-right mt-2" style="color: rgba(255,255,255,.5)">/</span>
                    <a href="${pageContext.request.contextPath}/eden-cruises/sign-in"
                       class="nav-link float-right"><fmt:message key="label.menu.sign.in"/></a>
                </c:if>
                <c:if test="${sessionScope.userSession != null}">
                    <a href="${pageContext.request.contextPath}/eden-cruises/log-out"
                       class="nav-link float-right"><fmt:message key="label.menu.log.out"/></a>
                    <a href="${pageContext.request.contextPath}/eden-cruises/user-profile"
                    class="nav-link float-right"><fmt:message key="label.menu.profile"/></a>
                </c:if>
            </li>
        </ul>
    </nav>
</div>