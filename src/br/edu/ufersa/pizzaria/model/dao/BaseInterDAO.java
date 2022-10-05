package br.edu.ufersa.pizzaria.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface BaseInterDAO<entity> {
	public Connection getConnection();
	public boolean add(entity e);
	public boolean edit(entity e);
	public boolean delete(entity e);
	public entity get(entity e);
	public ResultSet getAll();
	public ResultSet findBySpecifiedField(entity e, String field);
}
