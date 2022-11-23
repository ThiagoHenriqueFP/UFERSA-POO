package br.edu.ufersa.pizzaria.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.pizzaria.api.dto.StorageDTO;
import br.edu.ufersa.pizzaria.model.dao.BaseInterDAO;
import br.edu.ufersa.pizzaria.model.dao.StorageDAO;
import br.edu.ufersa.pizzaria.model.entities.Storage;

public class StorageService {
	
	BaseInterDAO<Storage> dao = new StorageDAO();
	
	public boolean addItem(StorageDTO s) {
		Storage st = Storage.convertDTO(s);
		ResultSet rs = dao.findBySpecifiedField(st, "id");
		try {
			if(rs == null || !rs.next()) {
				if(dao.add(st) == true) {
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
	
	public List<StorageDTO> getAllItens(){
		List<StorageDTO> itens = new ArrayList<StorageDTO>();
		ResultSet rs = dao.getAll();
		try {
			while(rs.next()) {
				StorageDTO s = new StorageDTO();
				s.setItem(rs.getString("name"));
				s.setQuantity(rs.getInt("amount"));
				s.setValue(rs.getDouble("value"));
			
				itens.add(s);
			}
			return itens;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Método para pegar todas as informações no Banco de Dados
	public List<Storage> getAllNoDTO(){
		List<Storage> itens = new ArrayList<Storage>();
		ResultSet rs = dao.getAll();
		try {
			while(rs.next()) {
				Storage s = new Storage();
				s.setItem(rs.getString("name"));
				s.setQuantity(rs.getInt("amount"));
				s.setValue(rs.getDouble("value"));
				s.setId(rs.getInt("id"));
			
				itens.add(s);
			}
			return itens;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean editItem(StorageDTO s) {
		Storage st = Storage.convertDTO(s);
		ResultSet rs = dao.findBySpecifiedField(st, "id");
		try {
			if(rs!=null && rs.next()) {
				if(dao.edit(st) == true) {
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
	
	public boolean deleteItem(StorageDTO s) {
		Storage st = Storage.convertDTO(s);
		ResultSet rs = dao.findBySpecifiedField(st, "id");
		try {
			if(rs!=null && rs.next()) {
				if(dao.delete(st) == true) {
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
	public int getBDId(Storage s) {
		ResultSet rs = dao.findBySpecifiedField(s, "name");
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
}