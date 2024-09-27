package com.jo.order.dto;

import com.jo.order.util.EventProcessEnum;

/**
 * This is the common response for async operations.
 * 
 * Lombok can helps to avoid having getters setters in class
 */
public class CommonAsyncResponse {
	private EventProcessEnum key;
	private String message;
	
	public CommonAsyncResponse(EventProcessEnum key, String message) {
		this.key = key;
		this.message = message;
	}

	public EventProcessEnum getKey() {
		return key;
	}

	public void setKey(EventProcessEnum key) {
		this.key = key;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
