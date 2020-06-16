package com.kirilanastasov.gateways.exception;


public class GatewayAlreadyCreatedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GatewayAlreadyCreatedException(String serialNumber) {
		super("Gateway alraedy creaded with serial number: " + serialNumber);
	}

}
