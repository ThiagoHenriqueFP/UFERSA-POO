package br.edu.ufersa.pizzaria.api.controllers;

import br.edu.ufersa.pizzaria.api.dto.PizzaTypeDTO;
import br.edu.ufersa.pizzaria.model.service.PizzasTypeService;
import br.edu.ufersa.pizzaria.view.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PizzaController {
	@FXML private TextField type;
	@FXML private TextField size;
	@FXML private TextField value;
	
	private PizzasTypeService pizzaService = new PizzasTypeService();
	
	public void pizzaSignUp() {
		PizzaTypeDTO pizzaDTO = new PizzaTypeDTO();
		pizzaDTO.setType(type.getText());
		pizzaDTO.setSize(size.getText());
		pizzaDTO.setValue(Double.parseDouble(value.getText()));
		pizzaService.addPizza(pizzaDTO);
	}
	
	public void voltar() {
		Screen.telaDeHome();
	}
}
