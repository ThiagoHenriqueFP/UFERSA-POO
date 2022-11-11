package br.edu.ufersa.pizzaria.model.entities;

public class Login {
	public boolean autenticar(String login, String senha) {
		if(login.equals("admin") && senha.equals("admin")) {
			return true;
		}
		return false;
	}
}
