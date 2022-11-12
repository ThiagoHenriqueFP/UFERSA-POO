package br.edu.ufersa.pizzaria.api.controllers;

import br.edu.ufersa.pizzaria.view.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PizzaEditController {
	@FXML TextField tamPizza;
	@FXML TextField valPizza;
	
	public void editPizza() {
		
	}
	
	public void delPizza() {
		
	}
	
	public void voltar() {
		Screen.telaDeListarPizza();
	}
}
