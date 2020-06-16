package com.kirilanastasov.gateways.exception;

public class PeripheralDevicesNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PeripheralDevicesNotFoundException(String uid) {
		super("Pehripheral Device id not found: " + uid);
	}

}
