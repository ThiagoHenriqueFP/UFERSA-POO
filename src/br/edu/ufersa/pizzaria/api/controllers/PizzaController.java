package br.edu.ufersa.pizzaria.api.controllers;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.api.dto.PizzaTypeDTO;
import br.edu.ufersa.pizzaria.model.service.PizzaTypeService;
import br.edu.ufersa.pizzaria.view.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PizzaController {
	@FXML private TextField type;
	@FXML private TextField value;
	
	private PizzaTypeService pizzaService = new PizzaTypeService();
	
	public void pizzaSignUp() {
		PizzaTypeDTO pizzaDTO = new PizzaTypeDTO();
		pizzaDTO.setType(type.getText().toLowerCase());
		pizzaDTO.setValue(Double.parseDouble(value.getText()));
		if(pizzaService.addPizza(pizzaDTO)) {
			JOptionPane.showMessageDialog(null, "Pizza Cadastrada com Sucesso!");
			Screen.telaDeHome();
		}
	}
	
	public void voltar() {
		Screen.telaDeHome();
	}
}
