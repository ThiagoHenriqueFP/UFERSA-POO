package br.edu.ufersa.pizzaria.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO<entity> implements BaseInterDAO<entity>{
	private Connection con;

	@Override
	synchronized public Connection getConnection() {
		if(con == null) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/pizzaria","root","SENHA MUITO BOA");
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return con;
		}
		else {
			return con;
		}
	}

	@Override
	public boolean add(entity e) {
		return false;
	}

	@Override
	public boolean edit(entity e) {
		return false;
	}

	@Override
	public boolean delete(entity e) {
		return false;
	}

	@Override
	public entity get(entity e) {
		return null;
	}

	@Override
	public ResultSet getAll() {
		return null;
	}

	@Override
	public ResultSet findBySpecifiedField(entity e, String field) {
		return null;
	}
	
}
