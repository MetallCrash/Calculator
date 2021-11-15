package web.servlet;

import service.OperationHistoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/operation", name = "OperationHistoryServlet")
public class OperationHistoryServlet extends HttpServlet {
    private final OperationHistoryService historyService = new OperationHistoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        req.setAttribute("operationList" , historyService.getOperationHistory(userId));
        req.getRequestDispatcher("operation.jsp").forward(req, resp);
    }
}
