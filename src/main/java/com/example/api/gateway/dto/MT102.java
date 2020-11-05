package com.example.api.gateway.dto;

import lombok.Data;

@Data
public class MT102 extends NativeMessage {
	private String valor;
	
	private String bancoEmissor;
	
	private String bancoEmitente;
}
