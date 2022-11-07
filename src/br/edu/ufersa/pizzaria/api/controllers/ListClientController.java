package br.edu.ufersa.pizzaria.api.controllers;



import java.util.List;

import br.edu.ufersa.pizzaria.api.dto.ClientDTO;
import br.edu.ufersa.pizzaria.model.service.ClientService;
import br.edu.ufersa.pizzaria.view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class ListClientController {

	@FXML private ImageView backgroundImg;
	@FXML private TableView<ClientDTO> tableClient;
	@FXML private TableColumn<ClientDTO, String> nameColumn;
	@FXML private TableColumn<ClientDTO, String> cpfColumn;
	@FXML private TableColumn<ClientDTO, String> addresColumn;
	      private ClientService clientService = new ClientService();
	      private ObservableList<ClientDTO> listClients;
	
	
	      public void listClient() {
	    	  List<ClientDTO> client = clientService.getAllClients();
	    	  listClients = FXCollections.observableArrayList(client);
	    	  nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
	    	  cpfColumn.setCellValueFactory(new PropertyValueFactory<>("cpf"));
	    	  addresColumn.setCellValueFactory(new PropertyValueFactory<>("addres"));
	    	  tableClient.setItems(listClients);
	    
	      }
	
	@FXML public void back(ActionEvent event) {
		Telas.telaHome();
	}
	
	@FXML public void btnClient(ActionEvent event) {
		Telas.ClientSignUp();
	}
	
	
}
