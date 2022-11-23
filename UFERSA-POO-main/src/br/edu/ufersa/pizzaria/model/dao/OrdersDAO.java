package br.edu.ufersa.pizzaria.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.pizzaria.model.entities.Orders;

public class OrdersDAO extends BaseDAO<Orders>{
	
	@Override
	public boolean add(Orders o) {
		String sql = "INSERT INTO solicitation (client,pizza,storage_id,size,state,value,additional) VALUES (?,?,?,?,?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, o.getClient());
			pst.setString(2, o.getPizza());
			pst.setInt(3, o.getStorageId());
			pst.setString(4, o.getSize());
			pst.setString(5, o.getState());
			pst.setDouble(6, o.getPrice());
			pst.setString(7, o.getAdditional());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean delete(Orders o) {
		String sql = "DELETE FROM solicitation WHERE id=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, o.getId());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean edit(Orders o) {
		String sql = "UPDATE solicitation SET state=? WHERE id=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, o.getState());
			pst.setInt(2, o.getId());
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
		String sql = "SELECT * FROM solicitation;";
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
	public ResultSet findBySpecifiedField(Orders o, String field) {
		String sql = "SELECT * FROM solicitation WHERE " + field +"=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "client":
				pst.setString(1, o.getClient());
				break;
				
			case "pizza":
				pst.setString(1, o.getPizza());
				break;
			
			case "additional":
				pst.setString(1, o.getAdditional());
				break;
				
			case "storage_id":
				pst.setString(1, o.getAdditional());
				break;
				
			case "size":
				pst.setString(1, o.getSize());
				break;
			
			case "state":
				pst.setString(1, o.getState());
				break;
				
			case "value":
				pst.setDouble(1, o.getPrice());
				break;
				
			default: 
				pst.setInt(1, o.getId());
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
