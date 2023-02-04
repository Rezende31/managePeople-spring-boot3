package com.managePeople.managePeople.model;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String logradouro;
	private Integer cep;
	private Integer number;
	private String city;
	
	
	public Address() {
		super();
	}

	public Address(Long id, String logradouro, Integer cep, Integer number, String city) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.number = number;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}
	
}
