<<<<<<< HEAD
package br.edu.ufersa.pizzaria.api.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.pizzaria.api.dto.PizzaTypeDTO;
import br.edu.ufersa.pizzaria.model.service.PizzasTypeService;
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

public class PizzaListController implements Initializable{
	
	@FXML private TableView<PizzaTypeDTO> tablePizza;
	@FXML private TableColumn<PizzaTypeDTO, String> typeList;
	@FXML private TableColumn<PizzaTypeDTO, String> sizeList;
	@FXML private TableColumn<PizzaTypeDTO, Double> valueList;
	@FXML private TableColumn<PizzaTypeDTO, Void> edit = new TableColumn<PizzaTypeDTO, Void>("Editar Pizza");
	
	
	private List<PizzaTypeDTO> pizzaList;
	private ObservableList<PizzaTypeDTO> obsList;
	protected static PizzaTypeDTO pizzaRow;
	private PizzasTypeService pizzaService = new PizzasTypeService();
	
	public void listStorage() {
		//storageList = storageService.getAllItens();
		pizzaList = new ArrayList<PizzaTypeDTO>();
		PizzaTypeDTO dto = new PizzaTypeDTO();
		dto.setType("Cala a boca");
		dto.setSize("M");
		dto.setValue(24);
		pizzaList.add(dto);
		
		obsList = FXCollections.observableArrayList(pizzaList);
		typeList.setCellValueFactory(new PropertyValueFactory<PizzaTypeDTO, String>("type"));
		sizeList.setCellValueFactory(new PropertyValueFactory<PizzaTypeDTO, String>("size"));
		valueList.setCellValueFactory(new PropertyValueFactory<PizzaTypeDTO, Double>("value"));
		tablePizza.setItems(obsList);
		addBtnToColumn();
	}
	
	public void addBtnToColumn() {
		Callback<TableColumn<PizzaTypeDTO, Void>, TableCell<PizzaTypeDTO, Void>> cellFactory = new Callback<TableColumn<PizzaTypeDTO, Void>, TableCell<PizzaTypeDTO, Void>>(){

			@Override
			public TableCell<PizzaTypeDTO, Void> call(TableColumn<PizzaTypeDTO, Void> arg0) {
				
				final TableCell<PizzaTypeDTO,Void> cell = new TableCell<PizzaTypeDTO,Void>(){
					
					private final Button btn = new Button("Edit");
					
					{
						btn.setOnAction((ActionEvent event) -> {
							pizzaRow = getTableView().getItems().get(getIndex());
							Screen.telaDeEditarPizza();
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
		tablePizza.getColumns().add(edit);
	}
	
	
	public void voltar() {
		Screen.telaDeHome();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listStorage();	
	}
}
=======
package br.edu.ufersa.pizzaria.api.controllers;

import br.edu.ufersa.pizzaria.view.Screen;

public class PizzaListController {
	public void voltar() {
		Screen.telaDeHome();
	}
}
>>>>>>> vinicius
