<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<footer class="my_footer">
    <div class="container">
        <div class="d-flex justify-content-between" style="height: 268px">
            <div class="div_logo_footer mt-auto mb-auto">
                <a class="logo_footer" href="${pageContext.request.contextPath}/eden-cruises/home">
                    <img src="${pageContext.request.contextPath}/images/LOGO.png" alt="logo" style="width:278px;">
                </a>
            </div>
            <div class="social mt-auto mb-auto">
                <h4><fmt:message key="label.footer.subscribe"/> </h4>
                <div class="social_icons d-flex justify-content-between m-auto" style="width: 278px">
                    <div class="social_btn">
                        <a class="social_item" href="https://www.youtube.com/channel/UC-SDXZ7oHaukCpaFbXBKamg">
                            <img src="${pageContext.request.contextPath}/images/Group%2034.png">
                        </a>
                    </div>
                    <div class="social_btn">
                        <a class="social_item" href="https://www.instagram.com/nbortik/">
                            <img src="${pageContext.request.contextPath}/images/Group%2035.png">
                        </a>
                    </div>
                    <div class="social_btn">
                        <a class="social_item" href="https://aboutme.google.com/u/0/?referer=gplus">
                            <img src="${pageContext.request.contextPath}/images/Group%2036.png">
                        </a>
                    </div>
                    <div class="social_btn">
                        <a class="social_item" href="https://twitter.com/nikitka_messi">
                            <img src="${pageContext.request.contextPath}/images/Group%2037.png">
                        </a>
                    </div>
                    <div class="social_btn">
                        <a class="social_item" href="https://www.facebook.com/nikita.bort">
                            <img src="${pageContext.request.contextPath}/images/Group%2040.png">
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="copyright">
        <p><fmt:message key="label.footer.copyright"/></p>
    </div>
</footer>
