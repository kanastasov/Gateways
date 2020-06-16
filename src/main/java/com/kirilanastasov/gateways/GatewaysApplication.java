package com.kirilanastasov.gateways;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kirilanastasov.gateways.model.Geteway;
import com.kirilanastasov.gateways.model.PeripheralDevices;
import com.kirilanastasov.gateways.model.enums.Status;
import com.kirilanastasov.gateways.repository.GatewayRepository;
import com.kirilanastasov.gateways.repository.PeripheralDevicesRepository;

@SpringBootApplication
public class GatewaysApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewaysApplication.class, args);
	}

}
