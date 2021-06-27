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

@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("q");
        List<Post> all = postService.searchPost(q);
        req.setAttribute("posts", all);
        getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }
}

