package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import jm.task.core.jdbc.service.UserViaHibernateServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService hibernatUserService = new UserViaHibernateServiceImpl();
        hibernatUserService.createUsersTable();
        hibernatUserService.saveUser("Кант", "Иммануил", (byte) 80);
        hibernatUserService.saveUser("Дени", "Дидро", (byte) 71);
        hibernatUserService.saveUser("Томас", "Джефферсон", (byte) 83);
        hibernatUserService.saveUser("Алан", "Тьюринг", (byte) 42);
        System.out.println(hibernatUserService.getAllUsers());
        hibernatUserService.cleanUsersTable();
        hibernatUserService.dropUsersTable();

    }
}
