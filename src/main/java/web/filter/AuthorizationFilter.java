package web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter (servletNames = {"CalculatorServlet", "OperationHistoryServlet"})
public class AuthorizationFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        String sessionId = (String) httpServletRequest.getSession().getAttribute("sessionId");
        if (sessionId != null) {
            req.setAttribute("sessionId", sessionId);
            chain.doFilter(req, res);
        } else {
            req.setAttribute("message", "Log in system.");
            req.getRequestDispatcher("sign-in.jsp").forward(req, res);
        }
    }
}
