package br.edu.ufersa.pizzaria.api.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.api.dto.ClientDTO;
import br.edu.ufersa.pizzaria.api.dto.OrderDTO;
import br.edu.ufersa.pizzaria.api.dto.PizzaTypeDTO;
import br.edu.ufersa.pizzaria.api.dto.StorageDTO;
import br.edu.ufersa.pizzaria.model.service.ClientService;
import br.edu.ufersa.pizzaria.model.service.OrdersService;
import br.edu.ufersa.pizzaria.model.service.PizzaTypeService;
import br.edu.ufersa.pizzaria.model.service.StorageService;
import br.edu.ufersa.pizzaria.view.Screen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class OrderController implements Initializable{
	@FXML private ChoiceBox<String> clientNames;
	@FXML private ChoiceBox<String> pizzaTypes;
	@FXML private ChoiceBox<String> addiNames;
	@FXML private ChoiceBox<String> size;
	@FXML private Label price;
	
	private OrdersService orderService = new OrdersService();
	private ClientService clientService = new ClientService();
	private PizzaTypeService pizzaService = new PizzaTypeService();
	private StorageService storageService = new StorageService();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dropDown();
	}
	
	public void orderSignUp() {
		OrderDTO orderDto = new OrderDTO();
		orderDto.setSize(size.getValue());
		orderDto.setClientName(clientNames.getValue());
		orderDto.setPizzaType(pizzaTypes.getValue());
		orderDto.setAddiName(addiNames.getValue());
		orderDto.setState("Preparando");
		orderDto.setPrice(Double.parseDouble(price.getText()));
		
		StorageDTO storageDtoAddi = new StorageDTO();
		if(!addiNames.getValue().equals("Nenhum")) {
			storageDtoAddi.setItem(addiNames.getValue());
			storageDtoAddi.setValue(sumAdditional());
			storageDtoAddi.setQuantity(subAdditional());
			storageService.editItem(storageDtoAddi);
		}
		
		StorageDTO storageDtoPizza = new StorageDTO();
		storageDtoPizza.setItem(pizzaTypes.getValue());
		storageDtoPizza.setValue(getPizzaStorageValue());
		storageDtoPizza.setQuantity(subPizza());
		storageService.editItem(storageDtoPizza);
		
		if(orderService.addOrder(orderDto)) {
			JOptionPane.showMessageDialog(null, "Pedido Cadastrado com Sucesso!");
			voltar();
		}
	}
	
	public void dropDown() {
		List<ClientDTO> clientDto = new ArrayList<ClientDTO>();
		clientDto = clientService.getAllClients();
		for(int i=0;i<clientDto.size();i++) {
			clientNames.getItems().add(clientDto.get(i).getName());
		}
		
		List<PizzaTypeDTO> pizzaDto = new ArrayList<PizzaTypeDTO>();
		pizzaDto = pizzaService.getAllPizza();
		for(int i=0;i<pizzaDto.size();i++) {
			pizzaTypes.getItems().add(pizzaDto.get(i).getType());
		}
		
		List<StorageDTO> storageDto = new ArrayList<StorageDTO>();
		storageDto = storageService.getAllItens();
		addiNames.getItems().add("Nenhum");
		for(int i=0;i<storageDto.size();i++) {
			addiNames.getItems().add(storageDto.get(i).getItem());
		}
		
		String[] options = {"P","M","G"};
		size.getItems().addAll(options);
		size.setOnAction(this::changePricePerSize);
	}
	
	public void changePricePerSize(ActionEvent event) {
		double val = 0;
		switch(size.getValue()) {
			case "M":
				val = (Double.parseDouble(verifyPrice())*2)+sumAdditional();
				price.setText(Double.toString(val));
				break;
			case "G":
				val = Double.parseDouble(verifyPrice())*3.5+sumAdditional();
				price.setText(Double.toString(val));
				break;
			default:
				val = Double.parseDouble(verifyPrice())+sumAdditional();
				price.setText(Double.toString(val));
				break;
		}
	}
	
	public String verifyPrice() {
		List<PizzaTypeDTO> pizzaDto = new ArrayList<PizzaTypeDTO>();
		pizzaDto = pizzaService.getAllPizza();
		String result = "";
		for(int i=0;i<pizzaDto.size();i++) {
			if(pizzaDto.get(i).getType().equals(pizzaTypes.getValue())) {
				result = Double.toString(pizzaDto.get(i).getValue());
			}
		}
		return result;
	}
	
	public Double sumAdditional() {
		List<StorageDTO> storageDto = new ArrayList<StorageDTO>();
		storageDto = storageService.getAllItens();
		
		double val = 0;
		for(int i=0;i<storageDto.size();i++) {
			if(storageDto.get(i).getItem().equals(addiNames.getValue())) {
				val = storageDto.get(i).getValue();
			}
		}
		return val;
	}
	
	public int subAdditional() {
		List<StorageDTO> storageDto = new ArrayList<StorageDTO>();
		storageDto = storageService.getAllItens();
		
		int val = 0;
		for(int i=0;i<storageDto.size();i++) {
			if(storageDto.get(i).getItem().equals(addiNames.getValue())) {
				val = storageDto.get(i).getQuantity();
			}
		}
		return val-1;
	}
	
	public int subPizza() {
		List<StorageDTO> storageDto = new ArrayList<StorageDTO>();
		storageDto = storageService.getAllItens();
		
		int val = 0;
		for(int i=0;i<storageDto.size();i++) {
			if(storageDto.get(i).getItem().equals(pizzaTypes.getValue())) {
				val = storageDto.get(i).getQuantity();
			}
		}
		return val-1;
	}
	
	public double getPizzaStorageValue() {
		List<StorageDTO> storageDto = new ArrayList<StorageDTO>();
		storageDto = storageService.getAllItens();
		
		double val = 0;
		for(int i=0;i<storageDto.size();i++) {
			if(storageDto.get(i).getItem().equals(pizzaTypes.getValue())) {
				val = storageDto.get(i).getValue();
			}
		}
		return val;
	}
	
	public void voltar() {
		Screen.telaDeHome();
	}
}
