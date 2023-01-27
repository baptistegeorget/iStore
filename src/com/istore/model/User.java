package com.istore.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User extends AbstractModel {

    public ResultSet select() throws SQLException {
        String sql = "SELECT * FROM user";
        Statement statement = conn.createStatement();
        return statement.executeQuery(sql);
    }

    public ResultSet selectEmployee(int store_id) throws SQLException {
        String sql = "SELECT * FROM user WHERE store_id=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, store_id);
        return statement.executeQuery();
    }

    public void delete(int user_id) throws SQLException {
        String sql = "DELETE FROM user WHERE id=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, user_id);
        statement.executeUpdate();
        notifyObserver(select());
    }

    public void deleteEmployee(int user_id, int store_id) throws SQLException {
        String sql = "DELETE FROM user WHERE id=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, user_id);
        statement.executeUpdate();
        notifyObserver(selectEmployee(store_id));
    }

    public void update(int user_id, String email, String pseudo, String password, int role_id, int store_id) throws SQLException {
        String sql = "UPDATE user SET email=?, pseudo=?, password=?, role_id=?, store_id=? WHERE id=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, pseudo);
        statement.setString(3, password);
        statement.setInt(4, role_id);
        statement.setInt(5, store_id);
        statement.setInt(6, user_id);
        statement.executeUpdate();
        notifyObserver(select());
    }

    public void updateEmployee(int user_id, String email, String pseudo, String password, int role_id, int store_id) throws SQLException {
        String sql = "UPDATE user SET email=?, pseudo=?, password=?, role_id=?, store_id=? WHERE id=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, pseudo);
        statement.setString(3, password);
        statement.setInt(4, role_id);
        statement.setInt(5, store_id);
        statement.setInt(6, user_id);
        statement.executeUpdate();
        notifyObserver(selectEmployee(store_id));
    }

    public void insert(String email, String pseudo, String password, int role_id, int store_id) throws SQLException {
        String sql = "INSERT INTO user (email, pseudo, password, role_id, store_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, pseudo);
        statement.setString(3, password);
        statement.setInt(4, role_id);
        statement.setInt(5, store_id);
        statement.executeUpdate();
        notifyObserver(select());
    }
}