package hiber.service;

import hiber.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User findByCar(String model, int series) throws SQLException;
}
