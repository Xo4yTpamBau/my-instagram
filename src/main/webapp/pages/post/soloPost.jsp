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
                                <c:if test="${post.user == sessionScope.user}">
                                    <li>
                                        <button type="button" class="btn btn-light" data-bs-toggle="modal"
                                                data-bs-target="#exampleModal">
                                            Delete
                                        </button>

                                    </li>
                                </c:if>
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
                                                <li class="list-group-item">Hostile statements or symbols</li>
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
                            <div class="modal fade" id="exampleModal" tabindex="-1"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                                            <button type="button" class="btn-close"
                                                    data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            Are you sure you want to delete the post?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary"
                                                    data-bs-dismiss="modal">Close
                                            </button>
                                            <form action="/post/deletePost" method="post">
                                                <input type="hidden" name="id" value="${post.id}">
                                                <button type="submit" class="btn btn-primary">Delete
                                                </button>
                                            </form>
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
                        <div class="col-sm-9 ">
                            <p class="card-text">${post.description}</p>
                        </div>
                        <form action="/like/likePostServlet" method="post">
                            <input type="hidden" name="idPost" value="${post.id}">
                            <div class="col-sm-3">

                                <button type="submit" class="btn btn-outline-success w-100 ">Like <span
                                        class="badge bg-secondary">${post.likes.size()} </span></button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
            <ol class="list-group">
                <c:forEach items="${post.comments}" var="comment">
                    <li class="list-group-item d-flex justify-content-between align-items-start">
                        <div class="ms-2 me-auto">
                            <div class="fw-bold">${comment.user.name}</div>
                                ${comment.comment}
                        </div>
                        <form action="/like/likeCommentServlet" method="post">
                            <input type="hidden" name="idComment" value="${comment.id}">
                            <input type="hidden" name="idPost" value="${post.id}">
                            <div class="col-sm-3">

                                <button type="submit" class="btn btn-light  "> <span
                                        class="badge bg-primary rounded-pill">${comment.likes.size()} </span></button>
                            </div>
                        </form>
                        <div class="btn-group">
                            <button class="btn btn-light btn-sm dropdown-toggle" type="button"
                                    data-bs-toggle="dropdown" aria-expanded="false">
                                · · ·
                            </button>
                            <ul class="dropdown-menu">
                                <c:if test="${comment.user == sessionScope.user}">
                                    <li>
                                        <button type="button" class="btn btn-light" data-bs-toggle="modal"
                                                data-bs-target="#exampleModal2">
                                            Delete comment
                                        </button>

                                    </li>
                                </c:if>
                            </ul>
                            <div class="modal fade" id="exampleModal2" tabindex="-1"
                                 aria-labelledby="exampleModalLabel2" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel2">Delete</h5>
                                            <button type="button" class="btn-close"
                                                    data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            Are you sure you want to delete the comment?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary"
                                                    data-bs-dismiss="modal">Close
                                            </button>
                                            <form action="/comment/deleteComment" method="post">
                                                <input type="hidden" name="idComment" value="${comment.id}">
                                                <input type="hidden" name="idPost" value="${post.id}">
                                                <button type="submit" class="btn btn-primary">Delete
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>


                    </li>
                </c:forEach>
            </ol>
            <form action="/comment/createComment" method="post">
                <input type="hidden" name="id" value="${post.id}">
                <div class="mb-3">
                    <textarea class="form-control" name="comment" id="exampleFormControlTextarea1" rows="1"
                              placeholder="Add a comment"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Comment</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>