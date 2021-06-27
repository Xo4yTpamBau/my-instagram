<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<div id="carouselExampleIndicators-${pageScope.item.id}" class="carousel slide carousel-fade"
     data-bs-ride="carousel">
    <div class="carousel-indicators">
        <c:forEach items="${pageScope.item.urls}" var="url" varStatus="counter">
            <c:if test="${counter.index == 0}">
                <button type="button" data-bs-target="#carouselExampleIndicators-${pageScope.item.id}"
                        data-bs-slide-to="0"
                        class="active" aria-current="true" aria-label="Slide 1"></button>
            </c:if>
            <c:if test="${counter.index != 0}">
                <button type="button" data-bs-target="#carouselExampleIndicators-${pageScope.item.id}"
                        data-bs-slide-to="${counter.index}"
                        aria-label="Slide ${counter.index + 1}"></button>
            </c:if>
        </c:forEach>
    </div>
    <div class="carousel-inner">
        <c:forEach items="${pageScope.post.urls}" var="url" varStatus="counter">
            <c:if test="${counter.index == 0}">
                <div class="carousel-item active">
                    <img src="${url}" class="d-block w-100" alt="...">
                </div>
            </c:if>
            <c:if test="${counter.index != 0}">
                <div class="carousel-item">
                    <img src="${url}" class="d-block w-100" alt="...">
                </div>
            </c:if>
        </c:forEach>
    </div>
    <button class="carousel-control-prev" type="button"
            data-bs-target="#carouselExampleIndicators-${pageScope.item.id}"
            data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button"
            data-bs-target="#carouselExampleIndicators-${pageScope.item.id}"
            data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
</body>
</html>
