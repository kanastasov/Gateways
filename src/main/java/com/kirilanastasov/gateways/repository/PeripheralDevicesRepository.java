package com.kirilanastasov.gateways.repository;

import org.springframework.data.repository.CrudRepository;

import com.kirilanastasov.gateways.model.PeripheralDevices;

public interface PeripheralDevicesRepository extends CrudRepository<PeripheralDevices, String> {
	 public PeripheralDevices findByVendor(String vendor);
}
