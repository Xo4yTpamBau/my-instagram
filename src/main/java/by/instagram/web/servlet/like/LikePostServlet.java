package by.instagram.web.servlet.like;

import by.instagram.entity.User;
import by.instagram.service.LikeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/like/likePostServlet", name = "LikePostServlet")
public class LikePostServlet extends HttpServlet {

   private final LikeService likeService = new LikeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idPost");
        User user = (User) req.getSession().getAttribute("user");
        likeService.saveLikeToPost(Long.parseLong(id), user);
        resp.sendRedirect("/post/soloPost?id=" + id);

    }
}
