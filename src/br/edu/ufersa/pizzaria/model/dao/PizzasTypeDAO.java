package br.edu.ufersa.pizzaria.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.pizzaria.model.entities.PizzasType;

public class PizzasTypeDAO extends BaseDAO<PizzasType> {
	
	public boolean addPizza(PizzasType p) {
		String sql = "INSERT INTO /*TABLE NAME HERE*/  (type,value) VALUES (?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, p.getType());
			pst.setDouble(2, p.getValue());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deletePizza(PizzasType p) {
		String sql = "DELETE FROM /*TABLE NAME HERE*/ WHERE type=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, p.getType());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean editPizza(PizzasType p) {
		String sql = "UPDATE *TABLE NAME HERE*/ SET value=? WHERE type=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, p.getType());
			pst.setDouble(2, p.getValue());
			pst.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public PizzasType findByType(PizzasType p) {
		String sql = "SELECT * FROM /*TABLE NAME HERE*/ WHERE type=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, p.getType());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				PizzasType pp = new PizzasType();
				pp.setType(rs.getString("type"));
				pp.setValue(rs.getDouble("value"));
				return pp;
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
	public ResultSet findBySpecifiedField(PizzasType p, String field) {
		String sql = "SELECT * FROM /*TABLE NAME HERE*/ WHERE " + field +"=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "value":
				pst.setDouble(1, p.getValue());
				break;
			
			default: 
				pst.setString(1, p.getType());
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
}