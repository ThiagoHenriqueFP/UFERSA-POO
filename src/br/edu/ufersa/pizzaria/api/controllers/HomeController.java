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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

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
	@FXML private TableColumn<OrderDTO,Void> edit = new TableColumn<OrderDTO, Void>("Editar");
	
	protected static OrderDTO orderRow;
	
	private List<OrderDTO> orderList = new ArrayList<OrderDTO>();
	
	private ObservableList<OrderDTO> observableOrderList;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dropDownMenu();
		initializeTableView();
		addBtnToColumn();
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
			Screen.telaDeListarPizza();
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
	
	public void addBtnToColumn() {
		Callback<TableColumn<OrderDTO, Void>, TableCell<OrderDTO, Void>> cellFactory = new Callback<TableColumn<OrderDTO, Void>, TableCell<OrderDTO, Void>>(){

			@Override
			public TableCell<OrderDTO, Void> call(TableColumn<OrderDTO, Void> arg0) {
				
				final TableCell<OrderDTO,Void> cell = new TableCell<OrderDTO,Void>(){
					
					private final Button btn = new Button("Edit");
					
					{
						btn.setOnAction((ActionEvent event) -> {
							orderRow = getTableView().getItems().get(getIndex());
							Screen.telaDeEditarPedido();
						});
					}
					
					@Override
					public void updateItem(Void item, boolean empty) {
						if(empty) {
							setGraphic(null);
						}
						else {
							setGraphic(btn);
						}
					}
				};
				
				return cell;
			}
		};
		
		edit.setCellFactory(cellFactory);
		orderTable.getColumns().add(edit);
	}

	
	public void initializeTableView() {
		clientName.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("clientName"));
		size.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("size"));
		pizzaType.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("pizzaType"));
		additionalName.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("AddiName"));
		state.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("state"));
		//edit.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("edit"));
		
		OrderDTO o1 = new OrderDTO("Vinicius Dantas de Sousa","Calabresa","Nenhum","M","Preparando","Edit");
		OrderDTO o2 = new OrderDTO("Whesley Xavier","Frango Catupiry","Milho","P","Saiu para entrega","Edit");
		
		orderList.add(o1);
		orderList.add(o2);
		
		observableOrderList = FXCollections.observableArrayList(orderList);
		
		orderTable.setItems(observableOrderList);
	}	
}
