package br.edu.ufersa.pizzaria.api.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.api.dto.OrderDTO;
import br.edu.ufersa.pizzaria.view.Screen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HomeController implements Initializable{
	@FXML private ChoiceBox<String> client;
	@FXML private ChoiceBox<String> storage;
	@FXML private ChoiceBox<String> pizza;
	private String[] options = {"Cadastrar", "Listar"};
	
	@FXML private TableView<OrderDTO> orderTable;
	@FXML private TableColumn<OrderDTO,String> clientName;
	@FXML private TableColumn<OrderDTO,String> size;
	@FXML private TableColumn<OrderDTO,String> pizzaType;
	@FXML private TableColumn<OrderDTO,String> additionalName;
	@FXML private TableColumn<OrderDTO,String> state;
	@FXML private TableColumn<OrderDTO,String> edit;
	
	private List<OrderDTO> orderList = new ArrayList<OrderDTO>();
	
	private ObservableList<OrderDTO> observableOrderList;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dropDownMenu();
		initializeTableView();
	}
	
	@FXML public void orderSignUp() {
		Screen.telaDeCadastroPedido();
	}
	
	public void getSelectedOptionClient(ActionEvent event) {
		if(client.getValue().equals("Cadastrar")) {
			Screen.telaDeCadastroCliente();
		}
		else {
			Screen.telaDeListarCliente();
		}
	}
	
	public void getSelectedOptionStorage(ActionEvent event) {
		if(storage.getValue().equals("Cadastrar")) {
			Screen.telaDeCadastroEstoque();
		}
		else {
			Screen.telaDeListarEstoque();
		}
	}
	
	public void getSelectedOptionPizza(ActionEvent event) {
		if(pizza.getValue().equals("Cadastrar")) {
			Screen.telaDeCadastroPizza();
		}
		else {
			JOptionPane.showMessageDialog(null, "Abrindo tela de Lista!");
		}
	}
	
	public void dropDownMenu() {
		client.getItems().addAll(options);
		client.setOnAction(this::getSelectedOptionClient);
		
		storage.getItems().addAll(options);
		storage.setOnAction(this::getSelectedOptionStorage);
		
		pizza.getItems().addAll(options);
		pizza.setOnAction(this::getSelectedOptionPizza);
	}
	
	public void initializeTableView() {
		clientName.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("clientName"));
		size.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("size"));
		pizzaType.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("pizzaType"));
		additionalName.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("additionalName"));
		state.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("state"));
		edit.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("edit"));
		
		OrderDTO o1 = new OrderDTO("Vinicius Dantas de Sousa","Calabresa","Nenhum","M","Preparando","Edit");
		OrderDTO o2 = new OrderDTO("Whesley Xavier","Frango Catupiry","Milho","P","Saiu para entrega","Edit");
		
		orderList.add(o1);
		orderList.add(o2);
		
		observableOrderList = FXCollections.observableArrayList(orderList);
		
		orderTable.setItems(observableOrderList);
	}
	
}
