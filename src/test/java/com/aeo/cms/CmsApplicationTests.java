package com.aeo.cms;

import java.net.URI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = com.aeo.cms.CmsApplication.class)
@ActiveProfiles(profiles = "test")
class CmsApplicationTests {

	@LocalServerPort
	int randomServerPort;

	private RestTemplate restTemplate = new RestTemplate();

	private URI uri;

	@Test
	void healthPage() {
		uri = URI.create("http://localhost:" + randomServerPort + "/actuator/health/ping");
		Assertions.assertTrue(restTemplate.getForEntity(uri, String.class).getBody().contains("UP"));
	}

	@Test
	void contextLoads() {
	}

}
