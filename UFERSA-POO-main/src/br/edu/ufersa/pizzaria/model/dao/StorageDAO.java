package br.edu.ufersa.pizzaria.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.pizzaria.model.entities.Storage;

public class StorageDAO extends BaseDAO<Storage>{
	
	@Override
	public boolean add(Storage s) {
		String sql = "INSERT INTO storage (name,amount,value) VALUES (?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, s.getItem());
			pst.setInt(2, s.getQuantity());
			pst.setDouble(3, s.getValue());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean delete(Storage s) {
		String sql = "DELETE FROM storage WHERE id=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, s.getId());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean edit(Storage s) {
		String sql = "UPDATE storage SET name=?,amount=?,value=? WHERE id=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, s.getItem());
			pst.setInt(2, s.getQuantity());
			pst.setDouble(3, s.getValue());
			pst.setInt(4, s.getId());
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
		String sql = "SELECT * FROM storage;";
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
	public ResultSet findBySpecifiedField(Storage s, String field) {
		String sql = "SELECT * FROM storage WHERE " + field +"=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "quantity":
				pst.setInt(1, s.getQuantity());
				break;
			case "name":
				pst.setString(1, s.getItem());
				break;
			case "value":
				pst.setDouble(1, s.getValue());
			default: 
				pst.setInt(1, s.getId());
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
