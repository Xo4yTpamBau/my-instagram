package by.instagram.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"CreateCommentServlet", "CreatePostServlet", "LikeServlet",
        "SoloPostServlet", "ChangeNameUserServlet", "ChangePasswordUSerServlet",
        "LogoutServlet", "ProfileUserServlet", "ViewProfileServlet",})
public class AuthorizedUserFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getSession().getAttribute("user") != null) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect("/");
        }
    }
}
