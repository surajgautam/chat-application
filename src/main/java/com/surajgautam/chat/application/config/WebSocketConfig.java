package com.surajgautam.chat.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /* there are three types of destinations.
    * 1) Application destinations - our controller
    * 2) Broker destination - directly to brokers like /topic/messages (rabbitmq)
    * 3) User destination - directly to broker with session id */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/initiate-connection")
                .setAllowedOrigins("*").withSockJS();
        //withSockJS for fallback options. If some browsers don't support websocket.
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //in memory message broker for one or more destinations
        registry.enableSimpleBroker("/topic/","/queue/");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
