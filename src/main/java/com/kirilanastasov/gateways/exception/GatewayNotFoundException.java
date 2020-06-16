package com.kirilanastasov.gateways.exception;

public class GatewayNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GatewayNotFoundException(String serialNumber) {
		super("Gateway id not found: " + serialNumber);
	}

}
