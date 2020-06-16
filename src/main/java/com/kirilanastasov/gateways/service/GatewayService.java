package com.kirilanastasov.gateways.service;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirilanastasov.gateways.exception.GatewayNotFoundException;
import com.kirilanastasov.gateways.model.Geteway;
import com.kirilanastasov.gateways.model.PeripheralDevices;
import com.kirilanastasov.gateways.repository.GatewayRepository;
import com.kirilanastasov.gateways.repository.PeripheralDevicesRepository;

@Service
public class GatewayService {

	@Autowired
	private GatewayRepository getewayRepository;
	

	public Iterable<Geteway> getAllGeteways() {

		List<Geteway> gatewayList = (List<Geteway>) getewayRepository.findAll();

		if (gatewayList.size() > 0) {
			return gatewayList;
		} else {
			return new ArrayList<Geteway>();
		}
	}

	public Geteway addGeteway(Geteway gateway) {
		return getewayRepository.save(gateway);
	}

	public Geteway findGetewayById(String serialNumber) {
		return getewayRepository.findById(serialNumber).orElseThrow(() -> new GatewayNotFoundException(serialNumber));
	}

	public void deleteGeteway(String serialNumber) {
		getewayRepository.deleteById(serialNumber);
	}


	public static Boolean isIPv4Address(String address) {
		if (address.isEmpty()) {
			return false;
		}
		try {
			Object res = InetAddress.getByName(address);
			return res instanceof Inet4Address;
		} catch (final UnknownHostException ex) {
			return false;
		}
	}
}
