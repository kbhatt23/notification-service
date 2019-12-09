package com.metallica.notificationservice.subscriber;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metallica.notificationservice.config.RabbitMQConfiguration;
import com.metallica.notificationservice.service.NotificationDBService;
import com.metallica.tradeservice.bean.Trade;

import org.springframework.amqp.core.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class RabbitMqMessageSubscriber {
	private static final Logger log = LoggerFactory.getLogger(RabbitMqMessageSubscriber.class);
	
	@Autowired
	private  NotificationDBService notificationDBService;

	/*
	 * @RabbitListener(queues = RabbitMQConfiguration.QUEUE_GENERIC_NAME) public
	 * void receiveMessage(final Message message) {
	 * log.info("Received message as generic: {}", message.toString()); }
	 */

    @RabbitListener(queues = RabbitMQConfiguration.QUEUE_SPECIFIC_NAME)
    public void receiveMessage(final Trade customMessage) {
    	log.info("Received message as specific class: "+ customMessage.toString());
    	notificationDBService.saveTradeNotification(customMessage);
    	
    }
}
