package com.example.api.gateway.dto;

import com.example.api.strategy.MessageType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

import lombok.Data;

@Data
@JsonTypeInfo(use = NAME, include = PROPERTY, property = "messageType", visible = true)
@JsonSubTypes({ 
	@JsonSubTypes.Type(value = MT103.class, name = "MT103"),	
	@JsonSubTypes.Type(value = MT102.class, name = "MT102"),
	@JsonSubTypes.Type(value = MT202.class, name = "MT202"),
})
public abstract class NativeMessage {

	protected MessageType messageType;
}
