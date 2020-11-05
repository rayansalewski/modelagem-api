package com.example.api.gateway.dto;

import lombok.Data;

@Data
public class MT103 extends NativeMessage {
	private String valor;
	private String recebedor;
	private String pagador;
}
