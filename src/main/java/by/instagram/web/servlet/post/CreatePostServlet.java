package by.instagram.web.servlet.post;

import by.instagram.entity.Category;
import by.instagram.entity.Post;
import by.instagram.entity.User;
import by.instagram.service.CategoryService;
import by.instagram.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/post/create", name = "CreatePostServlet")
public class CreatePostServlet extends HttpServlet {
    private final PostService postService = new PostService();
    private final CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> all = categoryService.getAllCategories();
        req.setAttribute("categories", all);
        req.getRequestDispatcher("/pages/post/createPost.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String idCategory = req.getParameter("categoryId");
        Category category = categoryService.getCategoryById(Long.parseLong(idCategory));
        String urlImages = req.getParameter("url");
        String[] split = urlImages.split(",");
        List<String> urls = new ArrayList<>(Arrays.asList(split));
        User user = (User) req.getSession().getAttribute("user");
        postService.savePost(new Post(0, title, description, user, urls, new ArrayList<>(), new ArrayList<>(), 0L, new Date(), false, category));
        resp.sendRedirect("/");
    }
}
