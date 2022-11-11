package br.edu.ufersa.pizzaria.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.api.dto.ClientDTO;
import br.edu.ufersa.pizzaria.model.dao.BaseInterDAO;
import br.edu.ufersa.pizzaria.model.dao.ClientDAO;
import br.edu.ufersa.pizzaria.model.entities.Client;

public class ClientService {
	BaseInterDAO<Client> dao = new ClientDAO();
	
	public boolean addClient(ClientDTO c) {
		Client cc = Client.convertDTO(c);
		ResultSet rs = dao.findBySpecifiedField(cc, "id");
		try {
			if(rs == null || !rs.next()) {
				if(dao.add(cc) == true) {
					JOptionPane.showMessageDialog(null, "Cliente Adicionado com Sucesso!");
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
	
	public List<ClientDTO> getAllClients() {
		List<ClientDTO> clients = new ArrayList<ClientDTO>();
		ResultSet rs = dao.getAll();
		try {
			while(rs.next()) {
				ClientDTO client = new ClientDTO();
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
	
	public boolean editClient(ClientDTO c) {
		Client cc = Client.convertDTO(c);
		ResultSet rs = dao.findBySpecifiedField(cc, "cpf");
		try {
			if(rs!=null && rs.next()) {
				if(dao.edit(cc) == true) {
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
	
	public boolean deleteClient(ClientDTO c) {
		Client cc = Client.convertDTO(c);
		ResultSet rs = dao.findBySpecifiedField(cc, "cpf");
		try {
			if(rs!=null && rs.next()) {
				if(dao.delete(cc) == true) {
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
