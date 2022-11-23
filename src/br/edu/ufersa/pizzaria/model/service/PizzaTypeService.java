package br.edu.ufersa.pizzaria.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.pizzaria.api.dto.PizzaTypeDTO;
import br.edu.ufersa.pizzaria.model.dao.BaseInterDAO;
import br.edu.ufersa.pizzaria.model.dao.PizzaTypeDAO;
import br.edu.ufersa.pizzaria.model.entities.PizzaType;
import br.edu.ufersa.pizzaria.model.entities.Storage;

public class PizzaTypeService {
	BaseInterDAO<PizzaType> dao = new PizzaTypeDAO();
	
	public boolean addPizza(PizzaTypeDTO p) {
		PizzaType pp = PizzaType.convertDTO(p);
		ResultSet rs = dao.findBySpecifiedField(pp, "id");
		try {
			if(rs == null || !rs.next()) {
				if(dao.add(pp) == true) {
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
				pt.setType(rs.getString("name"));
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
		PizzaType pp = PizzaType.convertDTO(p);
		ResultSet rs = dao.findBySpecifiedField(pp, "id");
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
		PizzaType pp = PizzaType.convertDTO(p);
		ResultSet rs = dao.findBySpecifiedField(pp, "id");
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
	
	//Método para pegar o ID gerado no banco de dados
	public int getBDId(PizzaType pizza) {
		ResultSet rs = dao.findBySpecifiedField(pizza, "name");
		try {
			if(rs!=null && rs.next()) {
				return rs.getInt("id");
			}
			else {
				return 0;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//Método para pegar o ID estrangeiro gerado no banco de dados
	public int getStorageId(PizzaType pizza) {
		List<Storage> storageList = new ArrayList<Storage>();
		StorageService storageService = new StorageService();
		storageList = storageService.getAllNoDTO();
		
		for(int i=0;i<storageList.size();i++) {
			if(storageList.get(i).getItem().equals(pizza.getType())) {
				pizza.setStorageId(storageList.get(i).getId());
			}
		}
		return pizza.getStorageId();
	}
	
	
	
}
