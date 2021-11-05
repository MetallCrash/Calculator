package service;

import dao.OperationDAO;
import entity.Operation;

import java.util.List;

public class OperationHistoryService {
    private final OperationDAO operationDAO = new OperationDAO();

    public List<Operation> getOperationHistory(Integer userId) {
        return operationDAO.getOperationHistory(userId);
    }
}
