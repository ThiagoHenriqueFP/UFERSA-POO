package br.edu.ufersa.pizzaria.api.controllers;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.api.dto.PizzaTypeDTO;
import br.edu.ufersa.pizzaria.model.service.PizzaTypeService;
import br.edu.ufersa.pizzaria.view.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PizzaEditController {
	@FXML private TextField type;
	@FXML private TextField value;
	
	private PizzaTypeService pizzaService = new PizzaTypeService();
	
	public void editPizza() {
		PizzaTypeDTO pizzaDto = new PizzaTypeDTO();
		pizzaDto.setType(type.getText().toLowerCase());
		pizzaDto.setValue(Double.parseDouble(value.getText()));
		if(pizzaService.editPizza(pizzaDto)) {
			JOptionPane.showMessageDialog(null, "Pizza Editada com Sucesso!");
			Screen.telaDeListarPizza();
		}
	}
	
	public void delPizza() {
		PizzaTypeDTO pizzaDto = new PizzaTypeDTO();
		pizzaDto.setType(PizzaListController.pizzaRow.getType());
		if(pizzaService.deletePizza(pizzaDto)) {
			JOptionPane.showMessageDialog(null, "Pizza Deletada com Sucesso!");
			Screen.telaDeListarPizza();
		}
	}
	
	public void voltar() {
		Screen.telaDeListarPizza();
	}
}
