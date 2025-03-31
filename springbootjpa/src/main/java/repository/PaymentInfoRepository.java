package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo , String>{

    
}
