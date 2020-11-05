package com.example.api.strategy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

@Component
public class MessageStrategyFactory {

	private ApplicationContext applicationContext;

	@Autowired
	public MessageStrategyFactory(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public <T> T getStrategy(Class<T> strategyType, MessageType gateway) {
		Map<String, T> beans = applicationContext.getBeansOfType(strategyType);

		for (T strategy : beans.values()) {
			MessageStrategy annotation = AnnotationUtils.findAnnotation(strategy.getClass(), MessageStrategy.class);
			if (annotation.type().equals(gateway)) {
				return strategy;
			}
		}

		return null;
	}

}
