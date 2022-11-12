package br.edu.ufersa.pizzaria.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.api.dto.PizzaTypeDTO;
import br.edu.ufersa.pizzaria.model.dao.BaseInterDAO;
import br.edu.ufersa.pizzaria.model.dao.PizzasTypeDAO;
import br.edu.ufersa.pizzaria.model.entities.PizzasType;

public class PizzasTypeService {
	BaseInterDAO<PizzasType> dao = new PizzasTypeDAO();
	
	public boolean addPizza(PizzaTypeDTO p) {
		PizzasType pp = PizzasType.convertDTO(p);
		ResultSet rs = dao.findBySpecifiedField(pp, "name");
		try {
			if(rs == null || !rs.next()) {
				if(dao.add(pp) == true) {
					JOptionPane.showMessageDialog(null, "Pizza Cadastrada com Sucesso!");
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
	
	public List<PizzaTypeDTO> getAllPizza(){
		List<PizzaTypeDTO> pts = new ArrayList<PizzaTypeDTO>();
		ResultSet rs = dao.getAll();
		try {
			while(rs.next()) {
				PizzaTypeDTO pt = new PizzaTypeDTO();
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
	
	public boolean editPizza(PizzaTypeDTO p) {
		PizzasType pp = PizzasType.convertDTO(p);
		ResultSet rs = dao.findBySpecifiedField(pp, "type");
		try {
			if(rs!=null && rs.next()) {
				if(dao.edit(pp) == true) {
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
	
	public boolean deletePizza(PizzaTypeDTO p) {
		PizzasType pp = PizzasType.convertDTO(p);
		ResultSet rs = dao.findBySpecifiedField(pp, "type");
		try {
			if(rs!=null && rs.next()) {
				if(dao.delete(pp) == true) {
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
