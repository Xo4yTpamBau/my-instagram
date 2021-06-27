<%--
  Created by IntelliJ IDEA.
  User: xo4y_
  Date: 20.04.2021
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../fragment/_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-24">
            <div class="row row-cols-1 row-cols-md-3 g-2">
                <c:forEach items="${postUser}" var="post">
                    <div class="col">
                        <div class="card mt-5 mb-5 shadow-sm rounded-0">
                            <div id="carouselExampleIndicators-${post.id}" class="carousel slide carousel-fade"
                                 data-bs-ride="carousel">
                                <div class="carousel-indicators">
                                    <c:forEach items="${post.urls}" var="url" varStatus="counter">
                                        <c:if test="${counter.index == 0}">
                                            <button type="button" data-bs-target="#carouselExampleIndicators-${post.id}"
                                                    data-bs-slide-to="0"
                                                    class="active" aria-current="true" aria-label="Slide 1"></button>
                                        </c:if>
                                        <c:if test="${counter.index != 0}">
                                            <button type="button" data-bs-target="#carouselExampleIndicators-${post.id}"
                                                    data-bs-slide-to="${counter.index}"
                                                    aria-label="Slide ${counter.index + 1}"></button>
                                        </c:if>
                                    </c:forEach>
                                </div>
                                <div class="carousel-inner">
                                    <c:forEach items="${post.urls}" var="url" varStatus="counter">
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
                                        data-bs-target="#carouselExampleIndicators-${post.id}"
                                        data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button"
                                        data-bs-target="#carouselExampleIndicators-${post.id}"
                                        data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </button>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-2"></div>
                                    <div class="col-sm-8">
                                        <a href="/post/soloPost?id=${post.id}"
                                           class="btn btn-outline-primary w-100">Open</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>
