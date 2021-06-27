package by.instagram.web.servlet.user;

import by.instagram.entity.User;
import by.instagram.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/changeName", name = "ChangeNameUserServlet")
public class ChangeNameUserServlet extends HttpServlet {
    private final UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/user/changeNameUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String newName = req.getParameter("newName");
        if (userService.containsUserByName(newName)) {
            req.setAttribute("message", "Name is occupied");
            req.getRequestDispatcher("/pages/user/changeNameUser.jsp").forward(req, resp);
        } else {
            User user = (User) req.getSession().getAttribute("user");
            long id = user.getId();
            userService.updateNameUser(id, newName);
        }
        resp.sendRedirect("/pages/user/profile");
    }
}
