package dao;

import java.sql.*;
import java.util.Optional;

public class UserDAO {
    private static final String DATABASE = "jdbc:mysql://localhost:3306/user_registration";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public void create(String login, String password) {
        final String sql = "INSERT INTO user (login, password) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Optional<Integer> find(String login, String password) {
        final String sql = "SELECT id FROM user WHERE login=? AND password=?";

        try (Connection connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(resultSet.getInt("id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }
}
