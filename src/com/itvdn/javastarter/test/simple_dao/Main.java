package com.itvdn.javastarter.test.simple_dao;

import com.itvdn.javastarter.test.simple_dao.dao.CarDAO;
import com.itvdn.javastarter.test.simple_dao.dao.ClientDAO;
import com.itvdn.javastarter.test.simple_dao.dao.DAOFactory;
import com.itvdn.javastarter.test.simple_dao.dao.IDAOFactory;
import com.itvdn.javastarter.test.simple_dao.entity.Car;
import com.itvdn.javastarter.test.simple_dao.entity.Client;

import java.util.List;

/**
 * Created by Asus on 31.01.2018.
 */
public class Main {

    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();
        //CarDAO carDAO = factory.getCarDAO();
        ClientDAO clientDAO = factory.getClientDAO();

//        Client client = new Client();
//        client.setAge(20);
//        client.setName("Vladimir");
//        client.setPhone("0988241522");

        //clientDAO.add(client);
        List<Client> clients = clientDAO.getAll();
        for (Client c : clients) {
            System.out.println(c.getId() + " " + c.getName() + " " + c.getAge() + " " + c.getPhone());}
//        }
//        Client c1 = clientDAO.getById(4);
//        System.out.println(c1.getId() + " " + c1.getName() + " " + c1.getAge() + " " + c1.getPhone());
//          clientDAO.updateAge(4);
           // clientDAO.remove("Vladimir");

//        Car car = carDAO.getById(2);
//
//      //  for (Car car : cars) {
//            System.out.println(car.getId()
//                    + " " + car.getMark() + " " + car.getModel() + " "  + car.getPrice());
     //   }

//        Car car1 = new Car();
//
//        car1.setMark("Audi");
//        car1.setModel("R8");
//        car1.setPrice(150000);
//
//        Car car2 = new Car();
//
//        car2.setMark("Chevrolet");
//        car2.setModel("Aveo");
//        car2.setPrice(9000);
//
//        carDAO.add(car1);
//        carDAO.add(car2);

       // carDAO.remove("Chrysler");

       // for (Car car : cars) {
//        System.out.println(car.getId() + " " + car.getMark()
//                    + " " + car.getModel() + " " + car.getPrice());
       // }


    }

}
