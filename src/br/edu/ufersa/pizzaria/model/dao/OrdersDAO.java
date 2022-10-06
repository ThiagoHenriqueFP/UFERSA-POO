package br.edu.ufersa.pizzaria.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.pizzaria.model.entities.Additionals;
import br.edu.ufersa.pizzaria.model.entities.Client;
import br.edu.ufersa.pizzaria.model.entities.Orders;
import br.edu.ufersa.pizzaria.model.entities.PizzasType;

public class OrdersDAO extends BaseDAO<Orders>{
	
	public boolean addOrder(Orders o) {
		String sql = "INSERT INTO /*TABLE NAME HERE*/ (client,pizza,additional,size,state) VALUES (?,?,?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setObject(1, o.getClient());
			pst.setObject(2, o.getPizza());
			pst.setObject(3, o.getAdditional());
			pst.setString(4, o.getSize());
			pst.setString(5, o.getState());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteOrder(Orders o) {
		String sql = "DELETE FROM /*TABLE NAME HERE*/ WHERE id=?;";
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
	
	public boolean editOrder(Orders o) {
		String sql = "UPDATE /*TABLE NAME HERE*/ SET client=?,pizza=?,additional=?,size=?,state=? WHERE id=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setObject(1, o.getClient());
			pst.setObject(2, o.getPizza());
			pst.setObject(3, o.getAdditional());
			pst.setString(4, o.getSize());
			pst.setString(5, o.getState());
			pst.setInt(6, o.getId());
			pst.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Orders findById(Orders o) {
		String sql = "SELECT * FROM /*TABLE NAME HERE*/ WHERE id=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, o.getId());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Orders oo = new Orders();
				oo.setClient((Client) rs.getObject("client"));
				oo.setPizza((PizzasType) rs.getObject("pizza"));
				oo.setAdditional((Additionals) rs.getObject("additional"));
				oo.setSize(rs.getString("size"));
				oo.setState(rs.getString("state"));
				return oo;
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
	public ResultSet findBySpecifiedField(Orders o, String field) {
		String sql = "SELECT * FROM /*TABLE NAME HERE*/ WHERE " + field +"=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "client":
				pst.setObject(1, o.getClient());
				break;
				
			case "pizza":
				pst.setObject(1, o.getPizza());
				break;
				
			case "additional":
				pst.setObject(1, o.getAdditional());
				break;
				
			case "size":
				pst.setString(1, o.getSize());
				break;
			
			case "state":
				pst.setString(1, o.getState());
			
			default: 
				pst.setInt(1, o.getId());
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
