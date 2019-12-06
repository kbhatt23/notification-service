package com.metallica.notificationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metallica.notificationservice.repository.dao.TradeDAO;

@Repository
public interface TradeNotificationRepository extends JpaRepository<TradeDAO, Long>{

}
