package com.metallica.notificationservice.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metallica.notificationservice.repository.TradeNotificationRepository;
import com.metallica.notificationservice.repository.dao.TradeDAO;
import com.metallica.tradeservice.bean.Trade;

@Service
public class NotificationDBService {
	@Autowired
	private TradeNotificationRepository tradeNotificationRepository;
	
	public TradeDAO saveTradeNotification(Trade trade) {
		TradeDAO tradeDAO = new TradeDAO();
		tradeDAO.setCommodity(trade.getCommodity());
		tradeDAO.setCommodityUnitPrice(trade.getCommodityUnitPrice());
		tradeDAO.setCounterParty(trade.getCounterParty());
		tradeDAO.setPrice(trade.getPrice());
		tradeDAO.setQuantity(trade.getQuantity());
		tradeDAO.setSide(trade.getSide());
		//queue might be slow so taking latest date from local JVM instance
		tradeDAO.setTradeDate(new Date());
		tradeDAO.setTradeStatus(trade.getTradeStatus());
		tradeNotificationRepository.save(tradeDAO);
		return tradeDAO;
	}
	

}
