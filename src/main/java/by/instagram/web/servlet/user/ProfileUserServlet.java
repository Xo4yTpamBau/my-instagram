package by.instagram.web.servlet.user;

import by.instagram.entity.Post;
import by.instagram.entity.User;
import by.instagram.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user/profile", name = "ProfileUserServlet")
public class ProfileUserServlet extends HttpServlet {

    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Post> allByUSer = postService.getAllPostsByUser(user);
        req.setAttribute("postUser", allByUSer);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/pages/user/profile.jsp").forward(req, resp);
    }
}
