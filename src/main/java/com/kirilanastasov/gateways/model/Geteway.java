package com.kirilanastasov.gateways.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GATEWAY_DETAILS")
public class Geteway implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "serialNumber", strategy = "uuid")
	private String serialNumber;
	@Column(name = "name", nullable = false, length = 12, updatable = true)
	private String name;
	@Pattern(regexp = "^(?:[0-9]{1,3}.){3}[0-9]{1,3}$")
	@Column(name = "ip4", nullable = false, length = 12, updatable = true)
	private String ip4;
	@Column(name = "peripheral_devices", updatable = true)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "gateway")
	private Set<PeripheralDevices> peripheralDevices = new HashSet<PeripheralDevices>();

	public Geteway() {
		super();
	}

	public Geteway(String serialNumber, String name, @Pattern(regexp = "^(?:[0-9]{1,3}.){3}[0-9]{1,3}$") String ip4,
			Set<PeripheralDevices> peripheralDevices) {
		super();
		this.serialNumber = serialNumber;
		this.name = name;
		this.ip4 = ip4;
		this.peripheralDevices = peripheralDevices;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp4() {
		return ip4;
	}

	public void setIp4(String ip4) {
		this.ip4 = ip4;
	}

	public Set<PeripheralDevices> getPeripheralDevices() {
		return peripheralDevices;
	}

	public void setPeripheralDevices(Set<PeripheralDevices> peripheralDevices) {
		this.peripheralDevices = peripheralDevices;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Geteway [serialNumber=" + serialNumber + ", name=" + name + ", ip4=" + ip4 + ", peripheralDevices="
				+ peripheralDevices + "]";
	};

}
