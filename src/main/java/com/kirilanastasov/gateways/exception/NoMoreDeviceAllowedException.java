package com.kirilanastasov.gateways.exception;

public class NoMoreDeviceAllowedException extends RuntimeException {

    public NoMoreDeviceAllowedException() {
        super("No more that 10 peripheral devices are allowed for a gateway.");
    }
}