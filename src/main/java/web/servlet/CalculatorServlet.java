package web.servlet;

import service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/calc", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private final CalculatorService calculatorService = new CalculatorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String action = req.getParameter("action");
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        String message = num1 + action + num2 + "=";
        req.setAttribute("message", message);

        Optional<Double> result = calculatorService.calculate(num1, num2, action, userId);
        if (result.isPresent()) {
            req.setAttribute("result", result.get());
        } else {
            message = "Operation is invalid";
            req.setAttribute("message", message);
        }
        req.getRequestDispatcher("calc.jsp").forward(req, resp);
    }
}
