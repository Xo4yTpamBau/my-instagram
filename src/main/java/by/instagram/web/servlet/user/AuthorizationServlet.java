package by.instagram.web.servlet.user;

import by.instagram.entity.User;
import by.instagram.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/authorization", name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/user/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User byLogin = userService.getUserByLogin(login);
        if (!(userService.containsUserByLogin(login))) {
            req.setAttribute("message", "User not found");
            req.getRequestDispatcher("/pages/user/authorization.jsp").forward(req, resp);
        } else if (byLogin.getPassword().equals(password)) {
            req.getSession().setAttribute("user", byLogin);
            resp.sendRedirect("/");

        } else {
            req.setAttribute("message", "Invalid password");
            req.getRequestDispatcher("/pages/user/authorization.jsp").forward(req, resp);
        }


    }
}
