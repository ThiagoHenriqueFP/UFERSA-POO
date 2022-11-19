package br.edu.ufersa.pizzaria.model.entities;

import br.edu.ufersa.pizzaria.api.dto.ClientDTO;
import br.edu.ufersa.pizzaria.model.service.ClientService;

public class Client{
	private String name;
	private String cpf;
	private String address;
	private int id; //KEY
	
	private static ClientService cService = new ClientService();
	
	public static Client convertDTO(ClientDTO c) {
		Client cl = new Client();
		cl.setName(c.getName());
		cl.setCPF(c.getCPF());
		cl.setAddress(c.getAddress());
		cl.setId(cService.getBDId(cl));
		return cl;
	}
	
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
	
	public int getId() {return id;}
    
    public void setId(int id) {
		this.id = id;
	}
}