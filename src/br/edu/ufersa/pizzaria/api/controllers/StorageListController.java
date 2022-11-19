package br.edu.ufersa.pizzaria.api.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.pizzaria.api.dto.StorageDTO;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class StorageListController implements Initializable{
	@FXML private TextField searchBar;
	@FXML private TableView<StorageDTO> tabelaEstoque;
	@FXML private TableColumn<StorageDTO, String> produto;
	@FXML private TableColumn<StorageDTO, Integer> qnt;
	@FXML private TableColumn<StorageDTO, Integer> value;
	@FXML private TableColumn<StorageDTO, Void> edit = new TableColumn<StorageDTO, Void>("Editar Produto");
	
	
	private List<StorageDTO> storageList;
	private ObservableList<StorageDTO> obsList;
	protected static StorageDTO storageRow;
	private StorageService storageService = new StorageService();
	
	public void listStorage() {
		storageList = storageService.getAllItens();
		obsList = FXCollections.observableArrayList(storageList);
		produto.setCellValueFactory(new PropertyValueFactory<StorageDTO, String>("item"));
		qnt.setCellValueFactory(new PropertyValueFactory<StorageDTO, Integer>("quantity"));
		value.setCellValueFactory(new PropertyValueFactory<StorageDTO, Integer>("value"));
		tabelaEstoque.setItems(search(obsList));
		addBtnToColumn();
	}
	
	public void addBtnToColumn() {
		Callback<TableColumn<StorageDTO, Void>, TableCell<StorageDTO, Void>> cellFactory = new Callback<TableColumn<StorageDTO, Void>, TableCell<StorageDTO, Void>>(){

			@Override
			public TableCell<StorageDTO, Void> call(TableColumn<StorageDTO, Void> arg0) {
				
				final TableCell<StorageDTO,Void> cell = new TableCell<StorageDTO,Void>(){
					
					private final Button btn = new Button("Edit");
					
					{
						btn.setOnAction((ActionEvent event) -> {
							storageRow = getTableView().getItems().get(getIndex());
							Screen.telaDeEditarEstoque();
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
		tabelaEstoque.getColumns().add(edit);
	}
	
	public SortedList<StorageDTO> search(ObservableList<StorageDTO> obsList) {
		FilteredList<StorageDTO> filteredData = new FilteredList<>(obsList, b -> true);
		searchBar.textProperty().addListener((observable,oldValue,newValue)->{
			filteredData.setPredicate(storage -> {
				if(newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if(storage.getItem().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else {
					return false;
				}
				
			});
		});
		
		SortedList<StorageDTO> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(tabelaEstoque.comparatorProperty());
		return sortedData;
	}
	
	public void voltar() {
		Screen.telaDeHome();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listStorage();	
	}
}