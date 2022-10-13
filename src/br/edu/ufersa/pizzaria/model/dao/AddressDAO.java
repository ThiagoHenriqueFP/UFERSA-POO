package br.edu.ufersa.pizzaria.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.pizzaria.model.entities.Address;

public class AddressDAO extends BaseDAO<Address>{
	
	public boolean addAddress(Address address) {
		String sql = "INSERT INTO /*TABLE NAME HERE*/ (street,district,number,references) VALUES (?,?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, address.getStreet());
			pst.setString(2, address.getDistrict());
			pst.setString(3, address.getNumber());
			pst.setString(4, address.getReferences());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteAddress(Address address) {
		String sql = "DELETE FROM /*TABLE NAME HERE*/ WHERE id=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, address.getId());
			pst.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean editAddress(Address address) {
		String sql = "UPDATE /*TABLE NAME HERE*/ SET street=?,district=?,number=?,references=? WHERE id=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, address.getStreet());
			pst.setString(2, address.getDistrict());
			pst.setString(3, address.getNumber());
			pst.setString(4, address.getReferences());
			pst.setInt(5, address.getId());
			pst.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Address findById(Address e) {
		String sql = "SELECT * FROM /*TABLE NAME HERE*/ WHERE id=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, e.getId());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Address a = new Address();
				a.setStreet(rs.getString("street"));
				a.setDistrict(rs.getString("district"));
				a.setNumber(rs.getString("number"));
				a.setReferences(rs.getString("references"));
				return a;
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
	public ResultSet findBySpecifiedField(Address e, String field) {
		String sql = "SELECT * FROM /*TABLE NAME HERE*/ WHERE " + field +"=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "street":
				pst.setString(1, e.getStreet());
				break;
				
			case "district":
				pst.setString(1, e.getDistrict());
				break;
				
			case "number":
				pst.setString(1, e.getNumber());
				break;
				
			case "references":
				pst.setString(1, e.getReferences());
				break;
			
			default: 
				pst.setInt(1, e.getId());
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Address findAddress(Address address) {
		String sql = "SELECT * FROM /*TABLE NAME HERE*/ WHERE id=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, address.getId());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return address;
			}
			else return null;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
}
