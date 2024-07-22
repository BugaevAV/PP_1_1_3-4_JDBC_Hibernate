package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import jm.task.core.jdbc.service.UserViaHibernateServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Пётр", "Чаадаев", (byte) 62);
        userService.saveUser("Николай", "Чернышевский", (byte) 61);
        userService.saveUser("Константин", "Циолковский", (byte) 78);
        userService.saveUser("Владимир", "Вернадский", (byte) 82);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();

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
