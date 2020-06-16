package com.kirilanastasov.gateways.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.kirilanastasov.gateways.model.Geteway;
import com.kirilanastasov.gateways.model.PeripheralDevices;
import com.kirilanastasov.gateways.model.enums.Status;
import com.kirilanastasov.gateways.repository.GatewayRepository;
import com.kirilanastasov.gateways.repository.PeripheralDevicesRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class PeripheralDevicesServiceTest {
	private PeripheralDevices device = new PeripheralDevices();;

	@TestConfiguration
	static class PeripheralDevicesTestContextConfiguration {
		public PeripheralDevicesService deviceService() {
			return new PeripheralDevicesService();
		}
	}

	@MockBean
	private PeripheralDevicesRepository deviceRepository;

	@org.junit.Before
	void setUP() {

		device.setDateCreated(new Date());
		device.setVendor("vendor");
		device.setStatus(Status.OFFLINE);

		Mockito.when(deviceRepository.findByVendor(device.getVendor())).thenReturn(device);
	}

	@Test
	void testValidNames() {
		String name = "another";
		assertNotEquals(name, device.getVendor());
	}

}
