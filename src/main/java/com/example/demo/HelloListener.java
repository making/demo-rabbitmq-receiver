package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

@Configuration
public class HelloListener {
	private final Logger log = LoggerFactory.getLogger(HelloListener.class);

	@RabbitListener(queues = "hello.demo")
	public void receive(Message<Hello> message) throws Exception {
		log.info("payload={}\theaders={}", message.getPayload(), message.getHeaders());
	}
}
