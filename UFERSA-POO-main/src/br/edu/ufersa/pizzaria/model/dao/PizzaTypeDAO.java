package br.edu.ufersa.pizzaria.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.pizzaria.model.entities.PizzaType;

public class PizzaTypeDAO extends BaseDAO<PizzaType> {
	
	@Override
	public boolean add(PizzaType p) {
		String sql = "INSERT INTO pizza (name,value,storage_id) VALUES (?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, p.getType());
			pst.setDouble(2, p.getValue());
			pst.setInt(3, p.getStorageId());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean delete(PizzaType p) {
		String sql = "DELETE FROM pizza WHERE id=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, p.getId());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean edit(PizzaType p) {
		String sql = "UPDATE pizza SET name=?,value=?,storage_id=? WHERE id=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, p.getType());
			pst.setDouble(2, p.getValue());
			pst.setInt(3, p.getStorageId());
			pst.setInt(4, p.getId());
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
		String sql = "SELECT * FROM pizza;";
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
	public ResultSet findBySpecifiedField(PizzaType p, String field) {
		String sql = "SELECT * FROM pizza WHERE " + field +"=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "value":
				pst.setDouble(1, p.getValue());
				break;
			case "name":
				pst.setString(1, p.getType());
				break;
			case "storage_id":
				pst.setInt(1, p.getStorageId());
				break;
			default: 
				pst.setInt(1, p.getId());
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
}
