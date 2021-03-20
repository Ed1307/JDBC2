package com.itvdn.javastarter.test.simple_dao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Asus on 31.01.2018.
 */
public class DAOFactory implements IDAOFactory {

    private static IDAOFactory factory;

    public static final String URL = "jdbc:mysql://localhost:3306/carsshop?serverTimezone=UTC";
    public static final  String USERNAME = "root";
    public static final String PASSWORD = "root";

    private DAOFactory() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized IDAOFactory getInstance() {
        if (factory == null) {
            factory = new DAOFactory();
        }
        return factory;
    }

    @Override
    public CarDAO getCarDAO() {
        return new CarJDBCDao();
    }

    @Override
    public ClientDAO getClientDAO() {
        return new ClientJDBCDao();
    }

}
