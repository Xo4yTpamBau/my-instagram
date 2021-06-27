package by.instagram.web.servlet.post;

import by.instagram.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/post/approvePost")
public class ApprovePostServlet extends HttpServlet {
    private final PostService postService = new PostService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        postService.approvePost(Long.parseLong(id));
        resp.sendRedirect("/post/getAllNotApprove");
    }
}
