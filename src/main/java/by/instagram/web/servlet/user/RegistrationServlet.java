package by.instagram.web.servlet.user;

import by.instagram.entity.Role;
import by.instagram.entity.User;
import by.instagram.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/registration", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/user/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (userService.containsUserByLogin(login)) {
            req.setAttribute("message", "Login is occupied");
            req.getRequestDispatcher("/pages/user/registration.jsp").forward(req, resp);
        } else if (userService.containsUserByName(name)) {
            req.setAttribute("message", "Name is occupied");
            req.getRequestDispatcher("/pages/user/registration.jsp").forward(req, resp);
        } else {
            userService.registration(new User(0, name, login, password, new Role(1, "USER")));
            resp.sendRedirect("/");
        }
    }
}
