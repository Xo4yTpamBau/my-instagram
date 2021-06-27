package by.instagram.web.servlet.post;

import by.instagram.entity.Post;
import by.instagram.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/post/getAllNotApprove")
public class GetAllNotApprovePostServlet extends HttpServlet {
    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Post> allByNotApprove = postService.getAllPostsByNotApprove();
        req.setAttribute("allPost", allByNotApprove);
        req.getRequestDispatcher("/pages/post/approvePost.jsp").forward(req, resp);
    }
}
