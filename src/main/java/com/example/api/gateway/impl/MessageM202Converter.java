package com.example.api.gateway.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.api.gateway.MessageConverter;
import com.example.api.gateway.dto.NativeMessage;
import com.example.api.queue.SwiftQueue;
import com.example.api.strategy.MessageStrategy;
import com.example.api.strategy.MessageType;

@MessageStrategy(type = MessageType.MT202)
public class MessageM202Converter implements MessageConverter<NativeMessage> {

	@Autowired
	private SwiftQueue queue;
	
	@Override
	public void convert(NativeMessage nativeMessage) {
		queue.publish(nativeMessage.toString());
	}

}
