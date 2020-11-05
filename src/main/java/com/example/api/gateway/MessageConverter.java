package com.example.api.gateway;

import com.example.api.gateway.dto.NativeMessage;

public interface MessageConverter<T extends NativeMessage> {
	
	void convert(T nativeMessage);

}
