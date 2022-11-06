package br.edu.ufersa.pizzaria.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.pizzaria.model.dao.BaseInterDAO;
import br.edu.ufersa.pizzaria.model.dao.PizzasTypeDAO;
import br.edu.ufersa.pizzaria.model.entities.PizzasType;

public class PizzasTypeService {
	BaseInterDAO<PizzasType> dao = new PizzasTypeDAO();
	
	public boolean addPizza(PizzasType p) {
		ResultSet rs = dao.findBySpecifiedField(p, "type");
		try {
			if(rs == null || !rs.next()) {
				if(dao.add(p) == true) {
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
	
	public List<PizzasType> getAllPizza(){
		List<PizzasType> pts = new ArrayList<PizzasType>();
		ResultSet rs = dao.getAll();
		try {
			while(rs.next()) {
				PizzasType pt = new PizzasType();
				pt.setType(rs.getString("type"));
				pt.setValue(rs.getDouble("value"));
				
				pts.add(pt);
			}
			return pts;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean editPizza(PizzasType p) {
		ResultSet rs = dao.findBySpecifiedField(p, "type");
		try {
			if(rs!=null && rs.next()) {
				if(dao.edit(p) == true) {
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
	
	public boolean deletePizza(PizzasType p) {
		ResultSet rs = dao.findBySpecifiedField(p, "type");
		try {
			if(rs!=null && rs.next()) {
				if(dao.delete(p) == true) {
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
