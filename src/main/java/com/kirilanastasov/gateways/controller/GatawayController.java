package com.kirilanastasov.gateways.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kirilanastasov.gateways.GatewaysApplication;
import com.kirilanastasov.gateways.exception.GatewayAlreadyCreatedException;
import com.kirilanastasov.gateways.exception.GatewayNotFoundException;
import com.kirilanastasov.gateways.exception.NoMoreDeviceAllowedException;
import com.kirilanastasov.gateways.model.Geteway;
import com.kirilanastasov.gateways.model.PeripheralDevices;
import com.kirilanastasov.gateways.service.GatewayService;

@RestController
@RequestMapping("/gateway")
public class GatawayController {

	private final org.jboss.logging.Logger log = LoggerFactory.logger(GatewaysApplication.class);

	@Autowired
	private GatewayService gatewayService;

	// POST  : Create a new gateway.
	@PostMapping("/add")
	public ResponseEntity<Geteway> createGateway(@Valid @RequestBody Geteway gateway) throws URISyntaxException {
		log.debugf("REST save Gateway :", gateway);
		if (gateway.getSerialNumber() != null) {
			throw new GatewayAlreadyCreatedException(gateway.getSerialNumber());
		}
		Geteway result = gatewayService.addGeteway(gateway);
		return ResponseEntity.created(new URI("/api/gateways/" + result.getSerialNumber())).body(result);
	}

	@GetMapping("/find/{serialNumber}")
	public Geteway findGatewayBySerialNumber(@PathVariable("serialNumber") String serialNumber) {
		log.debugf("serialNumber Geteway:", serialNumber);
		return gatewayService.findGetewayById(serialNumber);
	}

	@GetMapping("/getAll")
	public Iterable<Geteway> getAllGeteways() {
		log.debugf("getAllGeteways", gatewayService.getAllGeteways().toString());
		return gatewayService.getAllGeteways();
	}

	@DeleteMapping("/delete/{serialNumber}")
	public void deleteGateway(@PathVariable("serialNumber") String serialNumber) {
		log.debugf("deleteGeteway", serialNumber);
		gatewayService.deleteGeteway(serialNumber);
	}

}
