package br.edu.ufersa.pizzaria.api.controllers;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class TelaLoginController {
	@FXML private ImageView backgroundImg;
	@FXML private ImageView logoImg;
	@FXML private ImageView loginImg;
	@FXML private TextField userLogin;
	@FXML private PasswordField passwordLogin;
	
	
	@FXML public void loginConnect(ActionEvent event) {
		if(userLogin.getText() == "admin" && passwordLogin.getText() == "admin") {
			JOptionPane.showMessageDialog(null, "Bem vindo ADMIN!");
		}else {
			JOptionPane.showMessageDialog(null, "Acesso negado!!!");
		}
	}
	
}
