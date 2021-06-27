package by.instagram.web.servlet.user;

import by.instagram.entity.Post;
import by.instagram.entity.User;
import by.instagram.service.PostService;
import by.instagram.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user/view", name = "viewProfileUser")
public class ViewProfileUserServlet extends HttpServlet {

    private final PostService postService = new PostService();
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user = userService.getUserById(Long.parseLong(id));
        List<Post> allByUSer = postService.getAllPostsByUser(user);
        req.setAttribute("postUser", allByUSer);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/pages/user/profile.jsp").forward(req, resp);
    }
}