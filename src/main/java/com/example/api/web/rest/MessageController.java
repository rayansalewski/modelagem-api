package com.example.api.web.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.gateway.dto.NativeMessage;
import com.example.api.service.MessageService;

@RestController("/v1/messages")
public class MessageController {

	@Autowired
	private MessageService service;
	
	@PostMapping()
	public void create(@Valid @RequestBody NativeMessage nativeMessage) {
		service.create(nativeMessage);
	}
	
}
