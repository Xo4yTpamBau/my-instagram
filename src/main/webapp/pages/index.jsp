<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My instagram</title>
    <link rel="shortcut icon" href="https://newdb.net/static/landing_files/assets/img/instagram.png"
          type="image/x-icon">
</head>
<body>
<jsp:include page="fragment/_header.jsp"/>
<c:if test="${sessionScope.user != null}">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-6">
                <c:forEach items="${requestScope.posts}" var="post">
                    <c:if test="${post.user != sessionScope.user}">
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
                                            <c:if test="${post.user != sessionScope.user}">
                                                <li>
                                                    <button type="button" class="btn btn-light" data-bs-toggle="modal"
                                                            data-bs-target="#exampleModal3">
                                                        Complain
                                                    </button>

                                                </li>
                                            </c:if>
                                        </ul>
                                        <div class="modal fade" id="exampleModal3" tabindex="-1"
                                             aria-labelledby="exampleModalLabel2" aria-hidden="true">
                                            <div class="modal-dialog modal-dialog-centered">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel3">Delete</h5>
                                                        <button type="button" class="btn-close"
                                                                data-bs-dismiss="modal"
                                                                aria-label="Close"></button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <ul class="list-group list-group-flush">
                                                            <li class="list-group-item">This is spam</li>
                                                            <li class="list-group-item">Hostile statements or symbols
                                                            </li>
                                                            <li class="list-group-item">False information</li>
                                                            <li class="list-group-item">Fraud or deception</li>
                                                            <li class="list-group-item">Bulling or harassment</li>
                                                        </ul>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary"
                                                                data-bs-dismiss="modal">Close
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
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
                                        <a href="/post/soloPost?id=${post.id}"
                                           class="btn btn-outline-primary w-100">Open</a>
                                    </div>
                                    <div class="col-sm-2">
                                        <span class="badge rounded-pill bg-light text-dark">${post.category.category}</span>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
</c:if>
</body>
</html>
