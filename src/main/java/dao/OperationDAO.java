package dao;

import entity.Operation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperationDAO {
    private static final String DATABASE = "jdbc:mysql://localhost:3306/user_registration";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Integer writeOperation(Operation operation) {
        final String sql = "INSERT INTO operation (num1, action, num2, result) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, operation.getNum1());
            statement.setString(2, operation.getAction());
            statement.setString(3, operation.getNum2());
            statement.setString(4, operation.getResult());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating operation failed, no ID obtained.");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void writeUser(Integer userId, Integer operationId) {
        final String sql = "INSERT INTO user_operation (user_id, operation_id) VALUES (?,?)";

        try (Connection connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setInt(2, operationId);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Operation> getOperationHistory(Integer userId) {
        final List<Operation> operationList = new ArrayList<>();
        final String sql = "SELECT * FROM operation " +
                "JOIN user_registration.user_operation uo ON operation.id = uo.operation_id WHERE user_id=?";

        try (Connection connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                operationList.add(new Operation(
                        resultSet.getString("num1"),
                        resultSet.getString("num2"),
                        resultSet.getString("action"),
                        resultSet.getString("result")));
            }
            return operationList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
