package by.instagram.web.servlet.user;

import by.instagram.entity.User;
import by.instagram.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/changePassword", name = "ChangePasswordUSerServlet")
public class ChangePasswordUserServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/user/changePasswordUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newPassword = req.getParameter("NewPassword");
        User user = (User) req.getSession().getAttribute("user");
        long id = user.getId();
        userService.updatePasswordUser(id, newPassword);
        resp.sendRedirect("/pages/user/profile");
    }
}
