package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import static jm.task.core.jdbc.util.Util.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement stmt = getConnection().createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id INT NOT NULL AUTO_INCREMENT, " +
                    "name VARCHAR(45) NULL, " +
                    "lastName VARCHAR(45) NULL, " +
                    "age SMALLINT NULL, " +
                    "PRIMARY KEY (id));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement stmt = getConnection().createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS users;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        final String NEW_USER = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(NEW_USER, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.setString(2, lastName);
            stmt.setByte(3, age);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        final String DELETE_USER = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(DELETE_USER)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM users;");
            while (rs.next()) {
                allUsers.add(new User());
                allUsers.get(allUsers.size() - 1).setId(rs.getLong("id"));
                allUsers.get(allUsers.size() - 1).setName(rs.getString("name"));
                allUsers.get(allUsers.size() - 1).setLastName(rs.getString("lastName"));
                allUsers.get(allUsers.size() - 1).setAge(rs.getByte("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    public void cleanUsersTable() {
        try (Statement stmt = getConnection().createStatement()) {
            stmt.executeUpdate("DELETE from users;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
