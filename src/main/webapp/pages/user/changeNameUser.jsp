<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../fragment/_header.jsp"/>
<div class="container">
    <div class="row mt-5 justify-content-center">
        <div class="col-sm-6">
            <form action="/user/changeName" method="post">
                <div class="mb-3">
                    <c:if test="${message != null}">
                        <div class="alert alert-warning alert-dismissible fade show" role="alert">
                                ${message}
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    </c:if>

                    <div class="form-floating">
                        <input type="text" name="newName" class="form-control" id="floatingPassword2"
                               placeholder="Name">
                        <label for="floatingPassword2">New name</label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Update</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
