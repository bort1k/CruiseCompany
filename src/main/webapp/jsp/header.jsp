<%@ page contentType="text/html;charset=UTF-8" %>
<div class="my_header d-flex justify-content-between">
    <div class="language mb-auto mt-auto">
        <ul class="languagepicker roundborders">
            <a href="?locale=en">
                <li><img src="${pageContext.request.contextPath}/images/Intersection%201.png"/></li>
            </a>
            <a href="?locale=ua">
                <li><img class="ukraine_icon" src="${pageContext.request.contextPath}/images/ukraine.png"/></li>
            </a>
        </ul>
    </div>
    <div class="telephone_number d-flex mb-auto mt-auto">
        <div class="telephone_icon">
            <img class="telephone_icon_logo" src="${pageContext.request.contextPath}/images/ic_call_24px.png">
        </div>
        <div class="number">(380) 98-765-43-21</div>
    </div>
</div>
