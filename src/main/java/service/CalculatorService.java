package service;

import dao.OperationDAO;
import entity.Operation;

public class CalculatorService {
    Operation operation;
    OperationDAO operationDAO = new OperationDAO();

    public double sum(String num1, String num2, Integer userId) {
        double result = Double.parseDouble(num1) + Double.parseDouble(num2);
        int operationId = operationDAO.writeOperation(
                operation = new Operation(num1, num2, "+", Double.toString(result)));
        operationDAO.writeUser(userId, operationId);
        return result;
    }

    public double sub(String num1, String num2, Integer userId) {
        double result = Double.parseDouble(num1) - Double.parseDouble(num2);
        int operationId = operationDAO.writeOperation(
                operation = new Operation(num1, num2, "-", Double.toString(result)));
        operationDAO.writeUser(userId, operationId);
        return result;
    }

    public double mult(String num1, String num2, Integer userId) {
        double result = Double.parseDouble(num1) * Double.parseDouble(num2);
        int operationId = operationDAO.writeOperation(
                operation = new Operation(num1, num2, "*", Double.toString(result)));
        operationDAO.writeUser(userId, operationId);
        return result;
    }

    public double div(String num1, String num2, Integer userId) {
        double result = Double.parseDouble(num1) / Double.parseDouble(num2);
        int operationId = operationDAO.writeOperation(
                operation = new Operation(num1, num2, "/", Double.toString(result)));
        operationDAO.writeUser(userId, operationId);
        return result;
    }
}
