package br.edu.ufersa.pizzaria.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.pizzaria.model.entities.Address;
import br.edu.ufersa.pizzaria.model.entities.Storage;

public class StorageDAO extends BaseDAO<Storage>{
	
	public boolean addItem(Storage s) {
		String sql = "INSERT INTO /*TABLE NAME HERE*/ (item,quantity) VALUES (?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, s.getItem());
			pst.setInt(2, s.getQuantity());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteItem(Storage s) {
		String sql = "DELETE FROM /*TABLE NAME HERE*/ WHERE item=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, s.getItem());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean editItem(Storage s) {
		String sql = "UPDATE /*TABLE NAME HERE*/ SET type=?,quantity=? WHERE type=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, s.getItem());
			pst.setInt(2, s.getQuantity());
			pst.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Storage findByItem(Storage s) {
		String sql = "SELECT * FROM /*TABLE NAME HERE*/ WHERE item=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, s.getItem());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Storage ss = new Storage();
				ss.setItem(rs.getString("item"));
				ss.setQuantity(rs.getInt("quantity"));
				return ss;
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
	public ResultSet findBySpecifiedField(Storage s, String field) {
		String sql = "SELECT * FROM /*TABLE NAME HERE*/ WHERE " + field +"=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "quantity":
				pst.setInt(1, s.getQuantity());
				break;
			
			default: 
				pst.setString(1, s.getItem());
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
