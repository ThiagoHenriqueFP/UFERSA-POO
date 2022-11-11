package br.edu.ufersa.pizzaria.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.pizzaria.model.entities.Client;

public class ClientDAO extends BaseDAO<Client>{
	
	@Override
	public boolean add(Client client) {
		String sql = "INSERT INTO client (name,address,cpf) VALUES (?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, client.getName());
			pst.setString(2, client.getAddress());
			pst.setString(3, client.getCPF());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean delete(Client client) {
		String sql = "DELETE FROM client WHERE cpf=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, client.getCPF());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean edit(Client client) {
		String sql = "UPDATE client SET name=?,address=? WHERE cpf=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, client.getName());
			pst.setString(2, client.getAddress());
			pst.setString(3, client.getCPF());
			pst.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public ResultSet getAll() {
		String sql = "SELECT * FROM client;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public ResultSet findBySpecifiedField(Client c, String field) {
		String sql = "SELECT * FROM client WHERE " + field +"=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "name":
				pst.setString(1, c.getName());
				break;
				
			case "address":
				pst.setString(1, c.getAddress());
				break;
			
			default: 
				pst.setString(1, c.getCPF());
				break;
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}