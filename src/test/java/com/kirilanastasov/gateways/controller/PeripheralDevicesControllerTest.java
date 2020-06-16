package com.kirilanastasov.gateways.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.kirilanastasov.gateways.service.PeripheralDevicesService;

@RunWith(SpringRunner.class)
@WebMvcTest(PeripheralDevicesController.class)
class PeripheralDevicesControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PeripheralDevicesService service;

	@Test
	void testGetAllGateways() throws Exception {
		mvc.perform(get("/devices/getAll").contentType(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	void testAddGateways() throws Exception {
		mvc.perform(post("/devices/add").contentType(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

	}

	@Test
	void testFindGateways() throws Exception {
		mvc.perform(get("/devices/find/uid").contentType(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	void testDeleteGateways() throws Exception {
		mvc.perform(delete("/devices/delete/uid").contentType(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

}
