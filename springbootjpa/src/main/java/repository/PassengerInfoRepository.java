package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.PassengerInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo , Long>{
    

}