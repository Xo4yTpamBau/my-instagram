<%--
  Created by IntelliJ IDEA.
  User: xo4y_
  Date: 20.04.2021
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
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
            <form action="/user/changePassword" method="post">
                <div class="mb-3">
                    <div class="form-floating">
                        <input type="password" name="newPassword" class="form-control" id="floatingPassword"
                               placeholder="Password">
                        <label for="floatingPassword">New Password</label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Update</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
