package com.projectsByAman.ChatClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

public class ChatClientApplication {
	private static String url = "ws://localhost:8080/chat";
	@Autowired
	private static WebSocketStompClient webSocketStompClient;
	public static void main(String[] args) {
		WebSocketClient webSocketClient = new StandardWebSocketClient();
		WebSocketStompClient webSocketStompClient = new WebSocketStompClient(webSocketClient);

		webSocketStompClient.setMessageConverter(new MappingJackson2MessageConverter());
		StompSessionHandler sessionHandler = new CustomStompSessionHandler();
		//StompSession stompSession =  webSocketStompClient.connect(loggerServerQueueUrl, sessionHandler).get();
		webSocketStompClient.connect(url, sessionHandler);
		new Scanner(System.in).nextLine();

	}

}
