package com.example.api.web.errors;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {

	private LocalDateTime timestamp;

	private Integer status;

	private String error;

	@JsonInclude(Include.NON_EMPTY)
	private String code;

	private String message;

	private String path;

	@JsonInclude(Include.NON_EMPTY)
	private Map<String, Object> resources;

	@JsonInclude(Include.NON_EMPTY)
	private Map<String, Object> violations;

	@JsonInclude(Include.NON_EMPTY)
	private Object gatewayDetails;

	public void addViolation(String key, Object value) {
		if (violations == null) {
			violations = new HashMap<>();
		}
		violations.put(key, value);
	}

}
