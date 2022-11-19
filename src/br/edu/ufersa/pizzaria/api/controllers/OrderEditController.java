package br.edu.ufersa.pizzaria.api.controllers;


import br.edu.ufersa.pizzaria.api.dto.OrderDTO;
import br.edu.ufersa.pizzaria.model.service.OrdersService;
import br.edu.ufersa.pizzaria.view.Screen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class OrderEditController {
	
	private OrderDTO orderDto = HomeController.orderRow;
	private OrdersService orderService = new OrdersService();
	
	public void goBack() {
		Screen.telaDeHome();
	}
	
	@FXML
	public void onProduction(ActionEvent event) {
		orderDto.setState("Preparando");
		orderService.editOrder(orderDto);
		goBack();
	}
	
	@FXML
	public void onTransit(ActionEvent event) {
		orderDto.setState("Saiu para Entrega");
		orderService.editOrder(orderDto);
		goBack();
	}
	
	@FXML
	public void delivered(ActionEvent event) {
		orderDto.setState("Entregue");
		orderService.editOrder(orderDto);
		goBack();
	}
	
	@FXML
	public void canceled(ActionEvent event) {
		orderDto.setState("Cancelado");
		orderService.editOrder(orderDto);
		goBack();
	}
}