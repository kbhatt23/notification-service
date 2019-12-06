package com.metallica.notificationservice.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metallica.notificationservice.repository.dao.TradeDAO;
import com.metallica.notificationservice.service.NotificationDBService;
import com.metallica.notificationservice.subscriber.bean.Trade;

import java.io.IOException;
@Service
public class RedisMessageSubscriber implements MessageListener {
	Logger logger = LoggerFactory.getLogger(RedisMessageSubscriber.class);
	
	
	private final NotificationDBService notificationDBService;
	
	
	
	public RedisMessageSubscriber(final NotificationDBService notificationDBService) {
		this.notificationDBService = notificationDBService;
	}

    public void onMessage(final Message message, final byte[] pattern) {
    	logger.debug("onMessage: Message received: " + message.toString());
        
        ObjectMapper objectMapper = new ObjectMapper();
        Trade trade =null;
        try {
        	trade = objectMapper.readValue(message.toString(), Trade.class);
        	 System.out.println(trade);
        	 
        	TradeDAO tradeDao = notificationDBService.saveTradeNotification(trade);
        	logger.debug("Notification sent and saved to DB");
        	
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
    
}
