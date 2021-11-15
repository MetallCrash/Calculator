package service;

import dao.OperationDAO;
import entity.Operation;

import java.util.Optional;

public class CalculatorService {
    Operation operation;
    OperationDAO operationDAO = new OperationDAO();

    public Optional<Double> calculate(String num1, String num2, String action, Integer userId) {
        Optional<Double> result;
        int operationId;
        switch (action) {
            case ("+"):
                result = Optional.of(Double.parseDouble(num1) + Double.parseDouble(num2));
                operationId = operationDAO.writeOperation(
                        operation = new Operation(num1, num2, "+", result.get().toString()));
                operationDAO.writeUser(userId, operationId);
                return result;
            case ("-"):
                result = Optional.of(Double.parseDouble(num1) - Double.parseDouble(num2));
                operationId = operationDAO.writeOperation(
                        operation = new Operation(num1, num2, "-", result.get().toString()));
                operationDAO.writeUser(userId, operationId);
                return result;
            case ("*"):
                result = Optional.of(Double.parseDouble(num1) * Double.parseDouble(num2));
                operationId = operationDAO.writeOperation(
                        operation = new Operation(num1, num2, "*", result.get().toString()));
                operationDAO.writeUser(userId, operationId);
                return result;
            case ("/"):
                result = Optional.of(Double.parseDouble(num1) / Double.parseDouble(num2));
                operationId = operationDAO.writeOperation(
                        operation = new Operation(num1, num2, "/", result.get().toString()));
                operationDAO.writeUser(userId, operationId);
                return result;
            default:
                return Optional.empty();
        }
    }
}
