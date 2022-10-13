package br.edu.ufersa.pizzaria.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.pizzaria.model.dao.AddressDAO;
import br.edu.ufersa.pizzaria.model.dao.BaseInterDAO;
import br.edu.ufersa.pizzaria.model.entities.Address;

public class AddressService {

	BaseInterDAO<Address> dao = new AddressDAO();
	
	public boolean addAddress(Address address) {
		ResultSet rs = dao.findBySpecifiedField(address, "id");
		try {
			if(rs == null || !rs.next()) {
				if(dao.add(address) == true) {
					return true;
				}
				else return false;
			}
			else return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Address> getAllAddress(){
		List<Address> addresses = new ArrayList<Address>();
		ResultSet rs = dao.getAll();
		try {
			while(rs.next()) {
				Address address = new Address();
				address.setStreet(rs.getString("street"));
				address.setDistrict(rs.getString("district"));
				address.setNumber(rs.getString("number"));
				
				addresses.add(address);
			}
			return addresses;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean editAddress(Address address) {
		ResultSet rs = dao.findBySpecifiedField(address, "id");
		try {
			if(rs!=null && rs.next()) {
				if(dao.edit(address) == true) {
					return true;
				}
				else return false;
			}
			else return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteAddress(Address address) {
		ResultSet rs = dao.findBySpecifiedField(address, "id");
		try {
			if(rs!=null && rs.next()) {
				if(dao.delete(address) == true) {
					return true;
				}
				else return false;
			}
			else return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
