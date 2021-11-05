package servlets.servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet (urlPatterns = "/sign-in", name = "SignInServlet")
public class SignInServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("sign-in.jsp").forward(req, resp);;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Optional<Integer> userId =userService.findUser(login, password);
        if (userId.isPresent()) {
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setAttribute("userId", userId.get());
            session.setAttribute("sessionId", session.getId());
            req.getRequestDispatcher("calc.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "Login or password are incorrect.");
            req.getRequestDispatcher("sign-in.jsp").forward(req, resp);
        }
    }
}
