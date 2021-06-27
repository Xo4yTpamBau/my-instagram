package by.instagram.web.servlet.comment;

import by.instagram.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/comment/deleteComment")
public class DeleteCommentServlet extends HttpServlet {
   private final CommentService commentService = new CommentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idPost = req.getParameter("idPost");
        String idComment = req.getParameter("idComment");
        commentService.deleteCommentById(Long.parseLong(idComment));
        resp.sendRedirect("/post/soloPost?id=" + idPost);
    }
}