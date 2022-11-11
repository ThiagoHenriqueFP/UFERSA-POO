package br.edu.ufersa.pizzaria.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.api.dto.StorageDTO;
import br.edu.ufersa.pizzaria.model.dao.BaseInterDAO;
import br.edu.ufersa.pizzaria.model.dao.StorageDAO;
import br.edu.ufersa.pizzaria.model.entities.Storage;

public class StorageService {
	
	BaseInterDAO<Storage> dao = new StorageDAO();
	
	public boolean addItem(StorageDTO s) {
		Storage st = Storage.convertDTO(s);
		ResultSet rs = dao.findBySpecifiedField(st, "name");
		try {
			if(rs == null || !rs.next()) {
				if(dao.add(st) == true) {
					JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
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
	
	public boolean editItem(StorageDTO s) {
		Storage st = Storage.convertDTO(s);
		ResultSet rs = dao.findBySpecifiedField(st, "item");
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
		ResultSet rs = dao.findBySpecifiedField(st, "item");
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
}
