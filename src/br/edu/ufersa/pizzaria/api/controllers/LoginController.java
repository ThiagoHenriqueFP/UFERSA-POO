package br.edu.ufersa.pizzaria.api.controllers;

import br.edu.ufersa.pizzaria.model.entities.Login;
import br.edu.ufersa.pizzaria.view.Screen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML private Label entrar;
	@FXML private TextField login;
	@FXML private TextField senha;
	private Login logue;
	
	@FXML protected void autenticar(ActionEvent event) {
		logue = new Login();
		boolean allSet = logue.autenticar(login.getText(), senha.getText());
		if(allSet) {
			Screen.telaDeHome();
		}
	}
}
