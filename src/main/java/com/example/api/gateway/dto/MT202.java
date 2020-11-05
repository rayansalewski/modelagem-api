package com.example.api.gateway.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class MT202 extends NativeMessage {
	
	@NotBlank
	private String valor;
	
	private String bancoDestinatario;
}
