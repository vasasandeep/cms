package com.aeo.config;

import java.util.concurrent.TimeUnit;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.util.TimeValue;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Primary
	@Bean
	HttpClientConnectionManager connectionManager() {
		SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(12, TimeUnit.SECONDS).setTcpNoDelay(true)
				.setSoKeepAlive(true).build();

		return PoolingHttpClientConnectionManagerBuilder.create().setDefaultSocketConfig(socketConfig)
				.setMaxConnTotal(40) // default is 20
				.setMaxConnPerRoute(10) // default is 2 per host
				.setValidateAfterInactivity(TimeValue.ofMinutes(1)) // off by default
				.build();
	}

	@Primary
	@Bean
	HttpClient httpClient(HttpClientConnectionManager connectionManager) {
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5, TimeUnit.SECONDS)
				// hc5 DefaultConnectionKeepAliveStrategy defaults to connection keep alive if
				// keep-alive header is not returned
				.setConnectionKeepAlive(TimeValue.ofMinutes(1)).build();
		return HttpClientBuilder.create().disableAutomaticRetries().disableCookieManagement()
				.setConnectionManager(connectionManager).setDefaultRequestConfig(requestConfig).build();
	}

	@Primary
	@Bean
	RestTemplate restTemplate(HttpClient httpClient) {
		RestTemplate rt = new RestTemplateBuilder().setBufferRequestBody(false)
				.errorHandler(new RestTemplateErrorHandler()).build();
		rt.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
		return rt;
	}

}
