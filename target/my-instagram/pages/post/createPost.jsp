<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Post</title>
</head>
<body>
<jsp:include page="../fragment/_header.jsp"/>
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-sm-6">
            <form action="/post/create" method="post">
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Title</label>
                    <input type="text" name="title" class="form-control" id="exampleFormControlInput1">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput2" class="form-label">URL</label>
                    <input type="text" name="url" class="form-control" id="exampleFormControlInput2"
                           placeholder="https://urlimage.jpg">
                </div>
                <select name="categoryId" class="form-select" aria-label="Default select example">
                    <c:forEach items="${requestScope.categories}" var="category">
                        <option value="${category.id}">${category.category}</option>
                    </c:forEach>
                </select>
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">Description</label>
                    <textarea name="description" class="form-control" id="exampleFormControlTextarea1"
                              rows="3"></textarea>
                </div>

                <button type="submit" class="btn btn-primary w-100">Create</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
