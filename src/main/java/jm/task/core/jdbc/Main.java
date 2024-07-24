package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Пётр", "Чаадаев", (byte) 62);
        userService.saveUser("Николай", "Чернышевский", (byte) 61);
        userService.saveUser("Константин", "Циолковский", (byte) 78);
        userService.saveUser("Владимир", "Вернадский", (byte) 82);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
