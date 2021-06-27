<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<jsp:include page="../fragment/_header.jsp"/>
<div class="container">
    <div class="row mt-5 justify-content-center">
        <div class="col-sm-6">
            <c:if test="${message != null}">
                <div class="alert alert-warning alert-dismissible fade show" role="alert">
                        ${message}
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <form action="/user/authorization" method="post">
                <div class="mb-3">
                    <div class="form-floating">
                        <input type="text" name="login" class="form-control" id="floatingPassword3" placeholder="Login">
                        <label for="floatingPassword3">Login</label>
                    </div>
                </div>
                <div class="mb-3">
                    <div class="form-floating">
                        <input type="password" name="password" class="form-control" id="floatingPassword"
                               placeholder="Password">
                        <label for="floatingPassword">Password</label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Authorization</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
