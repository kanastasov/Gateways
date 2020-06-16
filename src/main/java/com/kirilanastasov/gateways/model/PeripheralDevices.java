package com.kirilanastasov.gateways.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kirilanastasov.gateways.model.Geteway;
import com.kirilanastasov.gateways.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "PERIPHERAL_DIVICES")
public class PeripheralDevices {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "uID", strategy = "uuid")
	private String uID;
	@Column(name = "vendor", nullable = false)
	private String vendor;
	@Column(name = "date_created", nullable = false)
	private Date dateCreated;
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "serialNumber")
	private Geteway gateway;

	public PeripheralDevices() {
		super();
	}

	public PeripheralDevices(String uID, String vendor, Date dateCreated, Status status, Geteway gateway) {
		super();
		this.uID = uID;
		this.vendor = vendor;
		this.dateCreated = dateCreated;
		this.status = status;
		this.gateway = gateway;
	}

	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Geteway getGateway() {
		return gateway;
	}

	public void setGateway(Geteway gateway) {
		this.gateway = gateway;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PeripheralDevices [uID=" + uID + ", vendor=" + vendor + ", dateCreated=" + dateCreated + ", status="
				+ status + ", gateway=" + gateway + "]";
	}

}
