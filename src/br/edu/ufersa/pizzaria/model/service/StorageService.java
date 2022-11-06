package br.edu.ufersa.pizzaria.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.pizzaria.model.dao.BaseInterDAO;
import br.edu.ufersa.pizzaria.model.dao.StorageDAO;
import br.edu.ufersa.pizzaria.model.entities.Storage;

public class StorageService {
	
	BaseInterDAO<Storage> dao = new StorageDAO();
	
	public boolean addItem(Storage s) {
		ResultSet rs = dao.findBySpecifiedField(s, "item");
		try {
			if(rs == null || !rs.next()) {
				if(dao.add(s) == true) {
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
	
	public List<Storage> getAllItens(){
		List<Storage> itens = new ArrayList<Storage>();
		ResultSet rs = dao.getAll();
		try {
			while(rs.next()) {
				Storage s = new Storage();
				s.setItem(rs.getString("item"));
				s.setQuantity(rs.getInt("quantity"));
				
				itens.add(s);
			}
			return itens;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean editItem(Storage s) {
		ResultSet rs = dao.findBySpecifiedField(s, "item");
		try {
			if(rs!=null && rs.next()) {
				if(dao.edit(s) == true) {
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
	
	public boolean deleteItem(Storage s) {
		ResultSet rs = dao.findBySpecifiedField(s, "item");
		try {
			if(rs!=null && rs.next()) {
				if(dao.delete(s) == true) {
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
