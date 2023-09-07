package com.aeo.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 6357050184559233199L;
	
	public CustomObjectMapper() {
		super();
		this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

}
