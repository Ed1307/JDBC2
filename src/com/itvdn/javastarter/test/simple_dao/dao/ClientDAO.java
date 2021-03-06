package com.itvdn.javastarter.test.simple_dao.dao;

import com.itvdn.javastarter.test.simple_dao.entity.Client;

import java.util.List;

/**
 * Created by Asus on 31.01.2018.
 */
public interface ClientDAO {

    void add(Client client);

    List<Client> getAll();

    Client getById(int id);

    void updateAge(int id);

    void remove(String name);

}
