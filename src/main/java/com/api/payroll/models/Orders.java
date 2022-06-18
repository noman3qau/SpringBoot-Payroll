package com.api.payroll.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.api.payroll.common.Status;

@Entity
public class Orders {

	private @Id @GeneratedValue Long id;
	private String description;
	private Status status;

	Orders() {
	}

	public Orders(String description, Status status) {
		this.description = description;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id) && status == other.status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", description=" + description + ", status=" + status + "]";
	}

}
