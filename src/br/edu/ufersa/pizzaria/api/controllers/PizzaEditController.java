package br.edu.ufersa.pizzaria.api.controllers;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.view.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PizzaEditController {
	@FXML TextField tamPizza;
	@FXML TextField valPizza;
	
	public void editPizza() {
		JOptionPane.showMessageDialog(null, "Pizza Editada com Sucesso!");
	}
	
	public void delPizza() {
		JOptionPane.showMessageDialog(null, "Pizza Deletada com Sucesso!");
	}
	
	public void voltar() {
		Screen.telaDeListarPizza();
	}
}
