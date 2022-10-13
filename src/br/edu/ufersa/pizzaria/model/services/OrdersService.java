package br.edu.ufersa.pizzaria.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.pizzaria.model.dao.BaseInterDAO;
import br.edu.ufersa.pizzaria.model.dao.OrdersDAO;
import br.edu.ufersa.pizzaria.model.entities.Additionals;
import br.edu.ufersa.pizzaria.model.entities.Client;
import br.edu.ufersa.pizzaria.model.entities.Orders;
import br.edu.ufersa.pizzaria.model.entities.PizzasType;

public class OrdersService {
	
	BaseInterDAO<Orders> dao = new OrdersDAO();
	
	public boolean addOrder(Orders o) {
		ResultSet rs = dao.findBySpecifiedField(o, "id");
		try {
			if(rs == null || !rs.next()) {
				if(dao.add(o) == true) {
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
	
	public List<Orders> getAllOrders(){
		List<Orders> orders = new ArrayList<Orders>();
		ResultSet rs = dao.getAll();
		try {
			while(rs.next()) {
				Orders o = new Orders();
				o.setClient((Client) rs.getObject("client"));
				o.setPizza((PizzasType) rs.getObject("pizza"));
				o.setAdditional((Additionals) rs.getObject("additional"));
				o.setSize(rs.getString("size"));
				o.setState(rs.getString("state"));
				
				orders.add(o);
			}
			return orders;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean editOrder(Orders o) {
		ResultSet rs = dao.findBySpecifiedField(o, "id");
		try {
			if(rs!=null && rs.next()) {
				if(dao.edit(o) == true) {
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
	
	public boolean deleteOrder(Orders o) {
		ResultSet rs = dao.findBySpecifiedField(o, "id");
		try {
			if(rs!=null && rs.next()) {
				if(dao.delete(o) == true) {
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
