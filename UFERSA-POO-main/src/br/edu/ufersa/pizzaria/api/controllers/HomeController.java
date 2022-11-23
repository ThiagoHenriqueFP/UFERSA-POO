package br.edu.ufersa.pizzaria.api.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.api.dto.OrderDTO;
import br.edu.ufersa.pizzaria.api.dto.ReportDTO;
import br.edu.ufersa.pizzaria.api.dto.StorageDTO;
import br.edu.ufersa.pizzaria.model.service.OrdersService;
import br.edu.ufersa.pizzaria.model.service.StorageService;
import br.edu.ufersa.pizzaria.view.Screen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class HomeController implements Initializable{
	@FXML private ChoiceBox<String> client;
	@FXML private ChoiceBox<String> storage;
	@FXML private ChoiceBox<String> pizza;
	private String[] options = {"Cadastrar", "Listar"};
	
	@FXML private TextField searchBar;
	@FXML private TableView<OrderDTO> orderTable;
	@FXML private TableColumn<OrderDTO,String> clientName;
	@FXML private TableColumn<OrderDTO,String> size;
	@FXML private TableColumn<OrderDTO,String> pizzaType;
	@FXML private TableColumn<OrderDTO,String> additionalName;
	@FXML private TableColumn<OrderDTO,String> state;
	@FXML private TableColumn<OrderDTO,Double> price;
	@FXML private TableColumn<OrderDTO,Void> edit = new TableColumn<OrderDTO, Void>("Editar");
	
	protected static OrderDTO orderRow;
	private ObservableList<OrderDTO> observableOrderList;
	private OrdersService orderService = new OrdersService();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dropDownMenu();
		initializeTableView();
	}
	
	@FXML public void orderSignUp() {
		Screen.telaDeCadastroPedido();
	}
	
	//Determinar qual tela foi selecionada para a opção de Cliente
	public void getSelectedOptionClient(ActionEvent event) {
		if(client.getValue().equals("Cadastrar")) {
			Screen.telaDeCadastroCliente();
		}
		else {
			Screen.telaDeListarCliente();
		}
	}
	
	//Determinar qual tela foi selecionada para a opção de Estoque
	public void getSelectedOptionStorage(ActionEvent event) {
		if(storage.getValue().equals("Cadastrar")) {
			Screen.telaDeCadastroEstoque();
		}
		else {
			Screen.telaDeListarEstoque();
		}
	}
	
	//Determinar qual tela foi selecionada para a opção de Pizza
	public void getSelectedOptionPizza(ActionEvent event) {
		if(pizza.getValue().equals("Cadastrar")) {
			Screen.telaDeCadastroPizza();
		}
		else {
			Screen.telaDeListarPizza();
		}
	}
	
	//Inserir opções para os ícones Cliente,Estoque e Pizza
	public void dropDownMenu() {
		client.getItems().addAll(options);
		client.setOnAction(this::getSelectedOptionClient);
		
		storage.getItems().addAll(options);
		storage.setOnAction(this::getSelectedOptionStorage);
		
		pizza.getItems().addAll(options);
		pizza.setOnAction(this::getSelectedOptionPizza);
	}
	
	//Inserindo os pedidos na tabela
	public void initializeTableView() {
		List<OrderDTO> orderList = new ArrayList<OrderDTO>();
		orderList = orderService.getAllOrders();
		observableOrderList = FXCollections.observableArrayList(orderList);
		
		clientName.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("ClientName"));
		size.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("Size"));
		pizzaType.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("PizzaType"));
		additionalName.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("AddiName"));
		state.setCellValueFactory(new PropertyValueFactory<OrderDTO,String>("State"));
		price.setCellValueFactory(new PropertyValueFactory<OrderDTO,Double>("Price"));
		
		orderTable.setItems(search(observableOrderList));
		addBtnToColumn();
	}
	
	//Implementação da Barra de Pesquisa
	public SortedList<OrderDTO> search(ObservableList<OrderDTO> obsList) {
		FilteredList<OrderDTO> filteredData = new FilteredList<>(obsList, b -> true);
		searchBar.textProperty().addListener((observable,oldValue,newValue)->{
			filteredData.setPredicate(order -> {
				if(newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if(order.getClientName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(order.getPizzaType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(order.getState().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else {
					return false;
				}
				
			});
		});
		
		SortedList<OrderDTO> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(orderTable.comparatorProperty());
		return sortedData;
	}
	
	//Adicionar botão de Editar para cada linha de Pedido
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
	
	//Criação do arquivo de Relatório
	public void report() {
		
		List<ReportDTO> reportList = new ArrayList<ReportDTO>();
		OrdersService orderService = new OrdersService();
		List<OrderDTO> orderList = orderService.getAllOrders();
		StorageService storageService = new StorageService();
		List<StorageDTO> storageList = storageService.getAllItens();
		
		for(int i=0;i<orderList.size();i++) {
			
			ReportDTO reportDto = new ReportDTO();
			
			reportDto.setClientName(orderList.get(i));
			reportDto.setPizzaType(orderList.get(i));
			reportDto.setSize(orderList.get(i));
			reportDto.setAddiName(orderList.get(i));
			reportDto.setState(orderList.get(i));
			reportDto.setPrice(orderList.get(i));
			reportDto.setDate(orderList.get(i));
			
			for(int o=0;o<storageList.size();o++) {
				if(orderList.get(i).getPizzaType().equals(storageList.get(o).getItem())) {
					reportDto.setPiQuantity(storageList.get(o));
				}
				if(orderList.get(i).getAddiName().equals(storageList.get(o).getItem())) {
					reportDto.setAddiQuantity(storageList.get(o));
				}
			}
			
			reportList.add(reportDto);
			
		}
		
		try {
			File reportFile = new File("Relatorio.txt");
			if(reportFile.createNewFile()) {
				
				FileWriter writer = new FileWriter("Relatorio.txt");
				
				writer.write("Cliente                     Tamanho  Sabor       Adicional     Estado             Valor   Estoque-Pizza  Estoque-Adicional   Data\r\n");
				
				for(int i=0;i<reportList.size();i++) {
					writer.write(reportList.get(i).getClientName()+"             "+reportList.get(i).getSize()+"        "+reportList.get(i).getPizzaType()+
							"   "+reportList.get(i).getAddiName()+"        "+reportList.get(i).getState()+"           "+reportList.get(i).getPrice()+
							"   "+reportList.get(i).getPiQuantity()+"            "+reportList.get(i).getAddiQuantity()+"                   "+
							reportList.get(i).getDate()+"\r\n");
				}
				
				writer.close();
				
				JOptionPane.showMessageDialog(null, "Relatório Criado com Sucesso!");
			}
			else {
				JOptionPane.showMessageDialog(null, "Relatório já Existente!");
			}
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Falha ao Criar Relatório!");
			e.printStackTrace();
		}
		
		//Screen.telaDeReport();
	}
	
}
