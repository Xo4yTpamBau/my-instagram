package by.instagram.web.servlet.like;

import by.instagram.entity.User;
import by.instagram.service.LikeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/like/likeCommentServlet", name = "LikeCommentServlet")
public class LikeCommentServlet extends HttpServlet {

    private final LikeService likeService = new LikeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idComment = req.getParameter("idComment");
        String idPost = req.getParameter("idPost");
        User user = (User) req.getSession().getAttribute("user");
        likeService.saveLikeToComment(Long.parseLong(idComment), user);
        resp.sendRedirect("/post/soloPost?id=" + idPost);

    }
}