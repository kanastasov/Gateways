package com.kirilanastasov.gateways.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.kirilanastasov.gateways.model.enums.Status;
import com.kirilanastasov.gateways.service.GatewayService;

@RunWith(SpringRunner.class)
@SpringBootTest
class PeripheralDevicesTest {

	private PeripheralDevices device;

	@Test
	void testPeripheralDevices() {

		device = new PeripheralDevices();
		device.setDateCreated(new Date());
		device.setStatus(Status.ONLINE);
		device.setVendor("vendor");


		assertEquals(device.getDateCreated(), new Date());
	}

}
