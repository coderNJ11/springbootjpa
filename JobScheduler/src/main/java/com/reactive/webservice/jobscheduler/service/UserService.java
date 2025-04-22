package com.reactive.webservice.jobscheduler.service;

import com.reactive.webservice.jobscheduler.DAO.UserDao;
import com.reactive.webservice.jobscheduler.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserDao dao;


    @Scheduled(fixedRate = 5000)
    public void add2DbJob() {
        User user = new User();
        user.setName("User " + java.util.UUID.randomUUID().toString());
        dao.save(user);
        System.out.println("User Saved");
    }

    @Scheduled(fixedRate = 15000)
    public void fetchDbJob() {
        List<User> users = dao.findAll();
        users.stream().forEach(System.out::println);

    }
}
