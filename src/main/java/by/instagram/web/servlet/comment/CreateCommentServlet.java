package by.instagram.web.servlet.comment;

import by.instagram.entity.User;
import by.instagram.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/comment/createComment", name = "CreateCommentServlet")
public class CreateCommentServlet extends HttpServlet {
    private final CommentService commentService = new CommentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String comment = req.getParameter("comment");
        User user = (User) req.getSession().getAttribute("user");
        commentService.saveCommentToPost(Long.parseLong(id), user, comment);
        resp.sendRedirect("/post/soloPost?id=" + id);
    }
}
