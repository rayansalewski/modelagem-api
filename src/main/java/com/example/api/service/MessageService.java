package com.example.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.gateway.MessageConverter;
import com.example.api.gateway.dto.NativeMessage;
import com.example.api.strategy.MessageStrategyFactory;

@Service
public class MessageService {

	@Autowired
	MessageStrategyFactory strategyFactory;

	public void create(NativeMessage nativeMessage) {
		strategyFactory.getStrategy(MessageConverter.class, nativeMessage.getMessageType()).convert(nativeMessage);
	}
}
