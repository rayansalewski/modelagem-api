package com.example.api.queue;

import org.springframework.stereotype.Component;

@Component
public class SwiftQueue {

	public void publish(String msg) {
		System.out.println(msg);
	}
}
