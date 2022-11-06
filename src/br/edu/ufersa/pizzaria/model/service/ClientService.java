package br.edu.ufersa.pizzaria.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.pizzaria.model.dao.BaseInterDAO;
import br.edu.ufersa.pizzaria.model.dao.ClientDAO;
import br.edu.ufersa.pizzaria.model.entities.Client;

public class ClientService {
	BaseInterDAO<Client> dao = new ClientDAO();
	
	public boolean addClient(Client c) {
		ResultSet rs = dao.findBySpecifiedField(c, "id");
		try {
			if(rs == null || !rs.next()) {
				if(dao.add(c) == true) {
					return true;
				}
				else return false;
			}
			else return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Client> getAllClients() {
		List<Client> clients = new ArrayList<Client>();
		ResultSet rs = dao.getAll();
		try {
			while(rs.next()) {
				Client client = new Client();
				client.setName(rs.getString("name"));
				client.setAddress(rs.getString("address"));
				client.setCPF(rs.getString("cpf"));
				
				clients.add(client);
			}
			return clients;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean editClient(Client c) {
		ResultSet rs = dao.findBySpecifiedField(c, "cpf");
		try {
			if(rs!=null && rs.next()) {
				if(dao.edit(c) == true) {
					return true;
				}
				else return false;
			}
			else return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteClient(Client c) {
		ResultSet rs = dao.findBySpecifiedField(c, "cpf");
		try {
			if(rs!=null && rs.next()) {
				if(dao.delete(c) == true) {
					return true;
				}
				else return false;
			}
			else return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
