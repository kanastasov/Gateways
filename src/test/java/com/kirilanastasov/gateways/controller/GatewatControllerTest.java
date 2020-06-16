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
import com.kirilanastasov.gateways.service.GatewayService;

@RunWith(SpringRunner.class)
@WebMvcTest(GatawayController.class)
class GatewatControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private GatewayService service;

	@Test
	void testGetAllGateways() throws Exception {
		mvc.perform(get("/gateway/getAll").contentType(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	void testAddGateways() throws Exception {
		mvc.perform(post("/gateway/add").contentType(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

	}

	@Test
	void testFindGateways() throws Exception {
		mvc.perform(get("/gateway/find/serialNumber").contentType(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	void testDeleteGateways() throws Exception {
		mvc.perform(
				delete("/gateway/delete/serialNumber").contentType(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

}
