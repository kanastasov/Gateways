package com.kirilanastasov.gateways.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.kirilanastasov.gateways.model.Geteway;
import com.kirilanastasov.gateways.repository.GatewayRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class GatewayServiceTest {

	private Geteway gateway = new Geteway();;

	@TestConfiguration
	static class GatewayServiceTestContextConfiguration {
		public GatewayService gatewayService() {
			return new GatewayService();
		}
	}

	@MockBean
	private GatewayRepository gatewayRepository;

	@org.junit.Before
	void setUP() {
	
		gateway.setName("GatewayName");
		gateway.setIp4("1.160.10.240");
		gateway.setSerialNumber("123");

		Mockito.when(gatewayRepository.findByName(gateway.getName())).thenReturn(gateway);
	}

	@Test
	void testValidNames() {
		String name = "GatewayDifferentName";
		assertNotEquals(name, gateway.getName());
	}

}
