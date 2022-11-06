package br.edu.ufersa.pizzaria.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.pizzaria.model.dao.AdditionalsDAO;
import br.edu.ufersa.pizzaria.model.dao.BaseInterDAO;
import br.edu.ufersa.pizzaria.model.entities.Additionals;


public class AdditionalsService {

	BaseInterDAO<Additionals> dao = new AdditionalsDAO();
	
	public boolean addAdditionals(Additionals c) {
		ResultSet rs = dao.findBySpecifiedField(c, "id");
		try {
			if(rs == null || !rs.next()) {
				if(dao.add(c) == true) {
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
	
	public List<Additionals> getAllAdditionals() {
		List<Additionals> additionals = new ArrayList<Additionals>();
		ResultSet rs = dao.getAll();
		try {
			while(rs.next()) {
				Additionals additional = new Additionals();
				additional.setName(rs.getString("name"));
				additional.setValue(rs.getDouble("value"));
				additional.setId(rs.getInt("id"));
				
				additionals.add(additional);
			}
			return additionals;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean editClient(Additionals c) {
		ResultSet rs = dao.findBySpecifiedField(c, "name");
		try {
			if(rs!=null && rs.next()) {
				if(dao.edit(c) == true) {
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
	
	public boolean deleteClient(Additionals c) {
		ResultSet rs = dao.findBySpecifiedField(c, "name");
		try {
			if(rs!=null && rs.next()) {
				if(dao.delete(c) == true) {
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
