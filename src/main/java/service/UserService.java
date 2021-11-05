package service;

import dao.UserDAO;

import java.util.Optional;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public void createUser(String login, String password) {
        userDAO.create(login, password);
    }

    public Optional<Integer> findUser(String login, String password) {
        return userDAO.find(login, password);
    }
}
