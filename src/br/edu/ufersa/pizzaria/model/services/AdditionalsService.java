package br.edu.ufersa.pizzaria.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.pizzaria.model.dao.AdditionalsDAO;
import br.edu.ufersa.pizzaria.model.dao.BaseInterDAO;
import br.edu.ufersa.pizzaria.model.entities.Additionals;

public class AdditionalsService {

	BaseInterDAO<Additionals> dao = new AdditionalsDAO();

	public boolean addAdditional(Additionals a) {
		ResultSet rs = dao.findBySpecifiedField(a, "id");
		try {
			if(rs == null || !rs.next()) {
				if(dao.add(a) == true) {
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

	public List<Additionals> getAllAdditionals(){
		List<Additionals> additis = new ArrayList<Additionals>();
		ResultSet rs = dao.getAll();
		try {
			while(rs.next()) {
				Additionals a = new Additionals();
				a.setName(rs.getString("name"));
				a.setValue(rs.getDouble("value"));

				additis.add(a);
			}
			return additis;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean editAdditional(Additionals a) {
		ResultSet rs = dao.findBySpecifiedField(a, "id");
		try {
			if(rs!=null && rs.next()) {
				if(dao.edit(a) == true) {
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

	public boolean deleteAdditional(Additionals a) {
		ResultSet rs = dao.findBySpecifiedField(a, "id");
		try {
			if(rs!=null && rs.next()) {
				if(dao.delete(a) == true) {
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
