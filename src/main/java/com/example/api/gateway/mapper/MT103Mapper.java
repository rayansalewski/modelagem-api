package com.example.api.gateway.mapper;

import org.springframework.stereotype.Component;

import com.example.api.gateway.dto.MT103;

@Component
public class MT103Mapper {

	public String convertToSting(MT103 mt103) {
		return parseToString(mt103);
	}

	private String parseToString(MT103 mt103) {
		return new StringBuilder().append(mt103.getValor()).append("|").append(mt103.getPagador()).toString();
	}
}
