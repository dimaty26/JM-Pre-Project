package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService service = new UserServiceImpl();

        // Delete table
        service.dropUsersTable();

        // Creating user's table
        service.createUsersTable();

        // Persisting users to user's table
        service.saveUser("Adam", "Bobrov", (byte) 28);
        service.saveUser("Bill", "Murray", (byte) 68);
        service.saveUser("Will", "Smith", (byte) 48);
        service.saveUser("Ben", "Button", (byte) 35);

        // Retrieve all users from DB
        List<User> users = service.getAllUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }

        // Clear table
        service.cleanUsersTable();

        // Delete table
        service.dropUsersTable();

        System.out.println(service.getAllUsers().size());
    }
}
