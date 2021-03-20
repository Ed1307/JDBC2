package com.itvdn.javastarter.test.simple_dao.dao;

import com.itvdn.javastarter.test.simple_dao.entity.Car;
import com.itvdn.javastarter.test.simple_dao.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 29.10.2020.
 */
public class ClientJDBCDao implements ClientDAO {

    @Override
    public void add(Client client) {
        Connection connection = null;

        connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO clients(name, age, phone) VALUES (?, ?, ?)");
            statement.setString(1, client.getName());
            statement.setInt(2, client.getAge());
            statement.setString(3, client.getPhone());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<Client> getAll() {
        List<Client> allClients = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT * from clients");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String phone = rs.getString(4);
                Client client = new Client();
                client.setId(id);
                client.setName(name);
                client.setAge(age);
                client.setPhone(phone);
                allClients.add(client);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return allClients;
    }

    @Override
    public Client getById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM clients WHERE clients.id = ? ");

            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String phone = rs.getString(4);
                Client client = new Client();
                client.setId(id);
                client.setName(name);
                client.setAge(age);
                client.setPhone(phone);
                return client;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void updateAge(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement("UPDATE clients SET age = age + 1 WHERE id = ?");

            preparedStatement.setInt(1, id);

            int updatedValues = preparedStatement.executeUpdate();

            System.out.println("Values updated: " + updatedValues);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void remove(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM clients WHERE name = ? ");

            preparedStatement.setString(1, name);

            int deletedValues = preparedStatement.executeUpdate();

            System.out.println("Values deleted: " + deletedValues);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && preparedStatement != null) {
                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                }
        }
    }

    private Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USERNAME, DAOFactory.PASSWORD);
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
