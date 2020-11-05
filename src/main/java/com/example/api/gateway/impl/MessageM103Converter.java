package com.example.api.gateway.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.api.gateway.MessageConverter;
import com.example.api.gateway.dto.MT103;
import com.example.api.gateway.dto.NativeMessage;
import com.example.api.gateway.mapper.MT103Mapper;
import com.example.api.queue.SwiftQueue;
import com.example.api.strategy.MessageStrategy;
import com.example.api.strategy.MessageType;

@MessageStrategy(type = MessageType.MT103)
public class MessageM103Converter implements MessageConverter<NativeMessage> {

	@Autowired
	private SwiftQueue queue;
	
	@Autowired
	private MT103Mapper mapper;
	
	@Override
	public void convert(NativeMessage nativeMessage) {
		String msg = mapper.convertToSting((MT103) nativeMessage);
		
		queue.publish(msg);
	}

}
