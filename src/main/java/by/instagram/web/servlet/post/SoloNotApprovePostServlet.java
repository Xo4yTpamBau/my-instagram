package by.instagram.web.servlet.post;

import by.instagram.entity.Post;
import by.instagram.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/post/soloNotApprovePost")
public class SoloNotApprovePostServlet extends HttpServlet {
    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Post byId = postService.getPostById(Long.parseLong(id));
        req.setAttribute("post", byId);
        req.getRequestDispatcher("/pages/post/soloNotApprovePost.jsp").forward(req, resp);
    }
}
