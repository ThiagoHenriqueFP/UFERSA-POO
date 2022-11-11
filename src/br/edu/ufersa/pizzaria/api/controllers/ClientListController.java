package br.edu.ufersa.pizzaria.api.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.pizzaria.api.dto.ClientDTO;
import br.edu.ufersa.pizzaria.model.services.ClientService;
import br.edu.ufersa.pizzaria.view.Screen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class ClientListController implements Initializable{
	@FXML private TableView<ClientDTO> tableClient;
	@FXML private TableColumn<ClientDTO,String> nameList;
	@FXML private TableColumn<ClientDTO,String> cpfList;
	@FXML private TableColumn<ClientDTO,String> addressList;
	@FXML private TableColumn<ClientDTO,Void> editList = new TableColumn<ClientDTO, Void>("Editar Cliente");
	
	private List<ClientDTO> clientList;
	private ObservableList<ClientDTO> obsList;
	protected static ClientDTO clientRow;
	private ClientService clientService = new ClientService();
	
	public void listAllClients() {
		clientList = clientService.getAllClients();
		obsList = FXCollections.observableArrayList(clientList);
		
		nameList.setCellValueFactory(new PropertyValueFactory<ClientDTO,String>("name"));
		cpfList.setCellValueFactory(new PropertyValueFactory<ClientDTO,String>("CPF"));
		addressList.setCellValueFactory(new PropertyValueFactory<ClientDTO,String>("address"));
		
		tableClient.setItems(obsList);
		addBtnToColumn();
	}
	
	public void addBtnToColumn() {
		Callback<TableColumn<ClientDTO, Void>, TableCell<ClientDTO, Void>> cellFactory = new Callback<TableColumn<ClientDTO, Void>, TableCell<ClientDTO, Void>>(){

			@Override
			public TableCell<ClientDTO, Void> call(TableColumn<ClientDTO, Void> arg0) {
				
				final TableCell<ClientDTO,Void> cell = new TableCell<ClientDTO,Void>(){
					
					private final Button btn = new Button("Edit");
					
					{
						btn.setOnAction((ActionEvent event) -> {
							clientRow = getTableView().getItems().get(getIndex());
							Screen.telaDeEditarCliente();
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
		
		editList.setCellFactory(cellFactory);
		tableClient.getColumns().add(editList);
	}
	
	public void voltar() {
		Screen.telaDeHome();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listAllClients();
	}
}
