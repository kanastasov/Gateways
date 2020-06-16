package com.kirilanastasov.gateways.exception;


public class PeripheralDevicesAlreadyCreatedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PeripheralDevicesAlreadyCreatedException(String uid) {
		super("PeripheralDevices alraedy creaded with uid: " + uid);
	}

}
