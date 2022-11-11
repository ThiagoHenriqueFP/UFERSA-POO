package br.edu.ufersa.pizzaria.api.controllers;

import java.util.List;

import br.edu.ufersa.pizzaria.api.dto.StorageDTO;
import br.edu.ufersa.pizzaria.model.services.StorageService;
import br.edu.ufersa.pizzaria.view.Screen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class StorageListController {
	@FXML private TableView<StorageDTO> tabelaEstoque;
	@FXML private TableColumn<StorageDTO, String> produto;
	@FXML private TableColumn<StorageDTO, Integer> qnt;
	@FXML private TableColumn<StorageDTO, Integer> code;
	@FXML private TableColumn<StorageDTO, Void> edit = new TableColumn<StorageDTO, Void>("Editar Cliente");
	
	
	private List<StorageDTO> storageList;
	private ObservableList<StorageDTO> obsList;
	protected static StorageDTO storageRow;
	private StorageService storageService = new StorageService();
	
	public void listStorage() {
		storageList = storageService.getAllItens();
		obsList = FXCollections.observableArrayList(storageList);
		produto.setCellValueFactory(new PropertyValueFactory<StorageDTO, String>("name"));
		qnt.setCellValueFactory(new PropertyValueFactory<StorageDTO, Integer>("amount"));
		code.setCellValueFactory(new PropertyValueFactory<StorageDTO, Integer>("id"));
		tabelaEstoque.setItems(obsList);
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
		
		edit.setCellFactory(cellFactory);
		tabelaEstoque.getColumns().add(edit);
	}
	
	
	public void voltar() {
		Screen.telaDeHome();
	}
}
