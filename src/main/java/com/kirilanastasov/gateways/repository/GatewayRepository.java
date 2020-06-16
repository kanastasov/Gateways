package com.kirilanastasov.gateways.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kirilanastasov.gateways.model.Geteway;
@Repository
public interface GatewayRepository extends CrudRepository<Geteway, String> {
	  public Geteway findByName(String name);
}
