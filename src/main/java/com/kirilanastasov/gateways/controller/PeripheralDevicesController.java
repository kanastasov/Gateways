package com.kirilanastasov.gateways.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kirilanastasov.gateways.GatewaysApplication;
import com.kirilanastasov.gateways.exception.PeripheralDevicesAlreadyCreatedException;
import com.kirilanastasov.gateways.model.PeripheralDevices;
import com.kirilanastasov.gateways.service.PeripheralDevicesService;

@RestController
@RequestMapping("/devices")
public class PeripheralDevicesController {

	private final org.jboss.logging.Logger log = LoggerFactory.logger(GatewaysApplication.class);

	@Autowired
	private PeripheralDevicesService pheripheralDeviceService;

	// Peripheral Device.
	@PostMapping("/add")
	public ResponseEntity<PeripheralDevices> createPeripheralDevices(@Valid @RequestBody PeripheralDevices device)
			throws URISyntaxException {
		log.debugf("REST createPeripheralDevices :", device);
		if (device.getuID() != null) {
			throw new PeripheralDevicesAlreadyCreatedException(device.getuID());
		}
		PeripheralDevices devicesResult = pheripheralDeviceService.addPeripheralDevices(device);
		return ResponseEntity.created(new URI("/api/gateways/" + devicesResult.getuID())).body(devicesResult);
	}

	@GetMapping("/find/{uid}")
	public PeripheralDevices findPeripheralDevicesByUid(@PathVariable("uid") String uid) {
		log.debugf("findPeripheralDevicesByUid:", uid);
		return pheripheralDeviceService.findPeripheralDevicesById(uid);
	}

	@GetMapping("/getAll")
	public Iterable<PeripheralDevices> getAllPeripheralDevices() {
		log.debugf("getAllGeteways", pheripheralDeviceService.getAllPeripheralDevices().toString());
		return pheripheralDeviceService.getAllPeripheralDevices();
	}

	@DeleteMapping("/delete/{uid}")
	public void deletePeripheralDevices(@PathVariable("uid") String uid) {
		log.debugf("deletePeripheralDevices", uid);
		pheripheralDeviceService.deletePeripheralDevices(uid);

	}
}
