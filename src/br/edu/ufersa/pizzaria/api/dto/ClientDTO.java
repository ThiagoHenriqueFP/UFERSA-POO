package br.edu.ufersa.pizzaria.api.dto;

public class ClientDTO {
	private String name;
	private String cpf;
	private String address;
	
	public String getName() {
		return name;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public void setCPF(String cpf) {
		if (cpf != null) {
			this.cpf = cpf;
		}else {
			this.cpf = null;				
		}
	}
	
	public void setName(String name) {
		if(name != null) {
			if (name!="")
				this.name = name;
		} else {			
			this.name = null;
		}
	}
	
	public void setAddress(String address) {
		if(address != null) {
			this.address = address;
		}
		else {
			this.address = null;
		}
	}
	public String getAddress() {
		return address;
	}
}
