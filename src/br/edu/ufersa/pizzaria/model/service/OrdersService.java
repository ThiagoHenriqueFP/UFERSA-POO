package br.edu.ufersa.pizzaria.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.pizzaria.api.dto.OrderDTO;
import br.edu.ufersa.pizzaria.model.dao.BaseInterDAO;
import br.edu.ufersa.pizzaria.model.dao.OrdersDAO;
import br.edu.ufersa.pizzaria.model.entities.Orders;
import br.edu.ufersa.pizzaria.model.entities.Storage;

public class OrdersService {
	
	BaseInterDAO<Orders> dao = new OrdersDAO();
	
	public boolean addOrder(OrderDTO o) {
		Orders oo = Orders.convertDTO(o);
		ResultSet rs = dao.findBySpecifiedField(oo, "id");
		try {
			if(rs == null || !rs.next()) {
				if(dao.add(oo) == true) {
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
	
	public List<OrderDTO> getAllOrders(){
		List<OrderDTO> orders = new ArrayList<OrderDTO>();
		ResultSet rs = dao.getAll();
		try {
			while(rs.next()) {
				OrderDTO o = new OrderDTO();
				o.setClientName(rs.getString("client"));
				o.setPizzaType(rs.getString("pizza"));
				o.setAddiName(rs.getString("additional"));
				o.setSize(rs.getString("size"));
				o.setState(rs.getString("state"));
				o.setDate(rs.getString("created_at"));
				o.setPrice(rs.getDouble("value"));
				
				orders.add(o);
			}
			return orders;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Orders> getAllNoDTO(){
		List<Orders> orders = new ArrayList<Orders>();
		ResultSet rs = dao.getAll();
		try {
			while(rs.next()) {
				Orders o = new Orders();
				o.setClient(rs.getString("client"));
				o.setPizza(rs.getString("pizza"));
				o.setAdditional(rs.getString("additional"));
				o.setSize(rs.getString("size"));
				o.setState(rs.getString("state"));
				o.setPrice(rs.getDouble("value"));
				o.setDate(rs.getString("created_at"));
				o.setId(rs.getInt("id"));
				o.setStorageId(rs.getInt("storage_id"));
				
				orders.add(o);
			}
			return orders;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean editOrder(OrderDTO o) {
		Orders oo = Orders.convertDTO(o);
		ResultSet rs = dao.findBySpecifiedField(oo, "id");
		try {
			if(rs!=null && rs.next()) {
				if(dao.edit(oo) == true) {
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
	
	public boolean deleteOrder(OrderDTO o) {
		Orders oo = Orders.convertDTO(o);
		ResultSet rs = dao.findBySpecifiedField(oo, "id");
		try {
			if(rs!=null && rs.next()) {
				if(dao.delete(oo) == true) {
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
	
	public int getBDId(Orders order) {
		List<Orders> orderList = new ArrayList<Orders>();
		orderList = getAllNoDTO();
		
		for(int i=0;i<orderList.size();i++) {
			if(orderList.get(i).getClient().equals(order.getClient()) && orderList.get(i).getPizza().equals(order.getPizza())) {
				if(orderList.get(i).getPrice() == order.getPrice() && orderList.get(i).getAdditional().equals(order.getAdditional())) {
					if(orderList.get(i).getSize().equals(order.getSize())) {
						order.setId(orderList.get(i).getId());
					}
				}
			}
		}
		
		return order.getId();
	}
	
	public int getStorageId(Orders order) {
		List<Storage> storageList = new ArrayList<Storage>();
		StorageService storageService = new StorageService();
		storageList = storageService.getAllNoDTO();
		
		for(int i=0;i<storageList.size();i++) {
			if(storageList.get(i).getItem().equals(order.getAdditional())) {
				order.setStorageId(storageList.get(i).getId());
			}
		}
		return order.getStorageId();
	}
}
