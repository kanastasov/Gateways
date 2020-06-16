package com.kirilanastasov.gateways.model.enums;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
@Table(name = "Status")
public enum Status {
	ONLINE, OFFLINE

}
