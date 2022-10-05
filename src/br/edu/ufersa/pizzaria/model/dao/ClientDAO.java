package br.edu.ufersa.pizzaria.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.pizzaria.model.entities.Address;
import br.edu.ufersa.pizzaria.model.entities.Client;

public class ClientDAO extends BaseDAO<Client>{
	
	public boolean addClient(Client client) {
		String sql = "INSERT INTO /*TABLE NAME HERE*/  (name,address,cpf) VALUES (?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, client.getName());
			pst.setObject(2, client.getAddress());
			pst.setString(3, client.getCPF());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteClient(Client client) {
		String sql = "DELETE FROM /*TABLE NAME HERE*/ WHERE cpf=?;";
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
	
	public boolean editClient(Client client) {
		String sql = "UPDATE *TABLE NAME HERE*/ SET name=?,address=? WHERE cpf=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, client.getName());
			pst.setObject(2, client.getAddress());
			pst.setString(3, client.getCPF());
			pst.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Client findByCPF(Client c) {
		String sql = "SELECT * FROM /*TABLE NAME HERE*/ WHERE cpf=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, c.getCPF());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Client cc = new Client();
				cc.setName(rs.getString("name"));
				cc.setAddress((Address) rs.getObject("address"));
				cc.setCPF(cc.getCPF());
				return cc;
			}
			else return null;
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public ResultSet getAll() {
		String sql = "SELECT * FROM /*TABLE NAME HERE*/;";
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
		String sql = "SELECT * FROM /*TABLE NAME HERE*/ WHERE " + field +"=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "name":
				pst.setString(1, c.getName());
				break;
				
			case "address":
				pst.setObject(1, c.getAddress());
				break;
			
			default: 
				pst.setString(1, c.getCPF());
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Client findAddress(Client client) {
		String sql = "SELECT * FROM /*TABLE NAME HERE*/ WHERE id=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, client.getCPF());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return client;
			}
			else return null;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}