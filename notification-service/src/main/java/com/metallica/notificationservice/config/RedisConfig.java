package com.metallica.notificationservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.metallica.notificationservice.subscriber.RedisMessageSubscriber;
import com.metallica.notificationservice.service.NotificationDBService;


@Configuration
public class RedisConfig {
	@Autowired
	private NotificationDBService notificationDBService;
	
	 @Bean
	    JedisConnectionFactory jedisConnectionFactory() {
	        return new JedisConnectionFactory();
	    }

	    @Bean
	    public RedisTemplate<String, Object> redisTemplate() {
	        final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
	        template.setConnectionFactory(jedisConnectionFactory());
	       // template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
	        template.setKeySerializer(new StringRedisSerializer());                                           
	        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
	        return template;
	    }

	    //not needed here 
	    //need to add on listener
	
	  @Bean MessageListenerAdapter messageListener() {
		  return new MessageListenerAdapter(new RedisMessageSubscriber(notificationDBService)); 
		  }
	  
	  
	  @Bean RedisMessageListenerContainer redisContainer() { final
	  RedisMessageListenerContainer container = new
	  RedisMessageListenerContainer();
	  container.setConnectionFactory(jedisConnectionFactory());
	  container.addMessageListener(messageListener(), topic()); return container; }
	 


	    @Bean
	    ChannelTopic topic() {
	        return new ChannelTopic("pubsub:queue");
	    }
}
