package com.gml.Dao;

import com.gml.Client.Contact;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    private Connection connection;

    public ContactDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/address_book?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8",
                    "root", // 替换为你的数据库用户名
                    "26229899"  // 替换为你的数据库密码
            );
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 驱动程序未找到: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("数据库连接失败: " + e.getMessage());
        }
    }

    public void saveContact(Contact contact) {
        String sql = "INSERT INTO contacts (name, phone, address) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, contact.getName());
            statement.setString(2, contact.getPhone());
            statement.setString(3, contact.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contacts";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Contact contact = new Contact(
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("address")
                );
                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public void deleteContact(String name) {
        String sql = "DELETE FROM contacts WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println("联系人删除成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateContact(String name, Contact updatedContact) {
        String sql = "UPDATE contacts SET phone = ?, address = ? WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, updatedContact.getPhone());
            statement.setString(2, updatedContact.getAddress());
            statement.setString(3, name);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("联系人更新成功！");
            } else {
                System.out.println("未找到联系人，更新失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
