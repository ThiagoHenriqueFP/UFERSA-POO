package br.edu.ufersa.pizzaria.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.pizzaria.model.entities.Additionals;

public class AdditionalsDAO extends BaseDAO<Additionals>{
	
	public boolean addAdditional(Additionals a) {
		String sql = "INSERT INTO /*TABLE NAME HERE*/ (name,value) VALUES (?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, a.getName());
			pst.setDouble(2, a.getValue());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteAdditional(Additionals a) {
		String sql = "DELETE FROM /*TABLE NAME HERE*/ WHERE id=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, a.getId());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean editAdditional(Additionals a) {
		String sql = "UPDATE /*TABLE NAME HERE*/ SET name=?,value=? WHERE id=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, a.getName());
			pst.setDouble(2, a.getValue());
			pst.setInt(3, a.getId());
			pst.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Additionals findById(Additionals a) {
		String sql = "SELECT * FROM /*TABLE NAME HERE*/ WHERE id=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, a.getId());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Additionals aa = new Additionals();
				aa.setName(rs.getString("name"));
				aa.setValue(rs.getDouble("value"));
				return aa;
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
	public ResultSet findBySpecifiedField(Additionals a, String field) {
		String sql = "SELECT * FROM /*TABLE NAME HERE*/ WHERE " + field +"=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "name":
				pst.setString(1, a.getName());
				break;
				
			case "value":
				pst.setDouble(1, a.getValue());
				break;
			
			default: 
				pst.setInt(1, a.getId());
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
}
