package com.kirilanastasov.gateways.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirilanastasov.gateways.exception.PeripheralDevicesNotFoundException;
import com.kirilanastasov.gateways.model.PeripheralDevices;
import com.kirilanastasov.gateways.repository.PeripheralDevicesRepository;

@Service
public class PeripheralDevicesService {

	@Autowired
	private PeripheralDevicesRepository devicesRepository;

	public Iterable<PeripheralDevices> getAllPeripheralDevices() {

		List<PeripheralDevices> peripheralDevices = (List<PeripheralDevices>) devicesRepository.findAll();

		if (peripheralDevices.size() > 0) {
			return peripheralDevices;
		} else {
			return new ArrayList<PeripheralDevices>();
		}
	}

	public PeripheralDevices addPeripheralDevices(PeripheralDevices peripheralDevices) {
		return devicesRepository.save(peripheralDevices);
	}

	public PeripheralDevices findPeripheralDevicesById(String uID) {
		return devicesRepository.findById(uID).orElseThrow(() -> new PeripheralDevicesNotFoundException(uID));
	}

	public void deletePeripheralDevices(String uID) {
		devicesRepository.deleteById(uID);
	}

}
