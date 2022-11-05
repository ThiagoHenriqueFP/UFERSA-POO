package br.edu.ufersa.pizzaria.api.controllers;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class OptionsSessionController {
	@FXML public void sessionClient(ActionEvent event){
		Telas.telaClient();
	}
		
	@FXML public void sessionStorage(ActionEvent event){
		JOptionPane.showMessageDialog(null, "Bem vindo ADMIN!");
	}
	
	@FXML public void sessionRequest(ActionEvent event){
		JOptionPane.showMessageDialog(null, "Bem vindo ADMIN!");
	}

	@FXML public void sessionPizzas(ActionEvent event){
		JOptionPane.showMessageDialog(null, "Bem vindo ADMIN!");
	}

}
