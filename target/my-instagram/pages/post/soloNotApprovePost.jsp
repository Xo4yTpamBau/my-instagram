<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Solo post</title>
</head>
<body>
<jsp:include page="../fragment/_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-6">
            <div class="card mt-5 mb-5 shadow-sm rounded-0">
                <div class="row">
                    <div class="col-sm-10">
                        <a style="text-decoration: none; color: black"
                           href="/user/view?id=${post.user.id}"
                           class="card-title btn-link">
                            ${post.user.name}
                        </a>
                    </div>
                    <div class="col-sm-2">
                        <div class="btn-group">
                            <button class="btn btn-light btn-sm dropdown-toggle" type="button"
                                    data-bs-toggle="dropdown" aria-expanded="false">
                                · · ·
                            </button>
                            <ul class="dropdown-menu">

                            </ul>
                            
                        </div>
                    </div>
                </div>
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
                        <div class="col-sm-3">
                            <h5 class="card-title">${post.title}</h5>
                        </div>
                        <div class="col-sm-6">
                            <h6 class="card-title">${post.time}</h6>
                        </div>
                        <div class="col-sm-3  ">
                            <h5><span class="badge bg-dark w-100">Views: ${post.views}</span></h5>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 ">
                            <p class="card-text text-truncate">${post.description}</p>
                        </div>
                        <div class="col-sm-3  "></div>
                        <div class="col-sm-3">
                            <span class="badge bg-secondary w-100">Likes: ${post.likes.size()}</span>

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-8">
                            <form action="/post/approvePost" method="post">
                                <input type="hidden" name="id" value="${post.id}">
                                <button class="btn btn-outline-primary w-100">Approve</button>
                            </form>
                        </div>
                        <div class="col-sm-2"></div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>