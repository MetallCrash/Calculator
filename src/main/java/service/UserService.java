package service;

import dao.UserDAO;
import entity.User;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public void createUser(String login, String password) {
        userDAO.create(login, password);
    }

    public Optional<User> findUser(String login, String password) {
        return userDAO.find(login, password);
    }

    public Optional<User> findUser(String login) {
        return userDAO.findByLogin(login);
    }

    public List<User> showUserList() {
        return userDAO.showUserList();
    }

    public void editUser(User user) {
        userDAO.editUser(user);
    }
}
