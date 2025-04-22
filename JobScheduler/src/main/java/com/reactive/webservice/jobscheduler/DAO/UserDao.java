package com.reactive.webservice.jobscheduler.DAO;

import com.reactive.webservice.jobscheduler.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
