package br.edu.ufersa.pizzaria.api.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.pizzaria.api.dto.PizzaTypeDTO;
import br.edu.ufersa.pizzaria.model.service.PizzaTypeService;
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

public class PizzaListController implements Initializable {
	@FXML 
	private TextField searchBar;
	@FXML
	private TableView<PizzaTypeDTO> tablePizza;
	@FXML
	private TableColumn<PizzaTypeDTO, String> typeList;
	@FXML
	private TableColumn<PizzaTypeDTO, Double> valueList;
	@FXML
	private TableColumn<PizzaTypeDTO, Void> edit = new TableColumn<PizzaTypeDTO, Void>("Editar Pizza");

	private List<PizzaTypeDTO> pizzaList;
	private ObservableList<PizzaTypeDTO> obsList;
	protected static PizzaTypeDTO pizzaRow;
	private PizzaTypeService pizzaService = new PizzaTypeService();
	
	//Inserindo as informa��es do sabor na tabela
	public void listPizza() {
		pizzaList = pizzaService.getAllPizza();
		obsList = FXCollections.observableArrayList(pizzaList);
		typeList.setCellValueFactory(new PropertyValueFactory<PizzaTypeDTO, String>("Type"));
		valueList.setCellValueFactory(new PropertyValueFactory<PizzaTypeDTO, Double>("Value"));
		tablePizza.setItems(search(obsList));
		addBtnToColumn();
	}
	
	//Inserindo bot�o de editar para cada linha de sabor de pizza
	public void addBtnToColumn() {
		Callback<TableColumn<PizzaTypeDTO, Void>, TableCell<PizzaTypeDTO, Void>> cellFactory = new Callback<TableColumn<PizzaTypeDTO, Void>, TableCell<PizzaTypeDTO, Void>>() {

			@Override
			public TableCell<PizzaTypeDTO, Void> call(TableColumn<PizzaTypeDTO, Void> arg0) {

				final TableCell<PizzaTypeDTO, Void> cell = new TableCell<PizzaTypeDTO, Void>() {

					private final Button btn = new Button("Edit");

					{
						btn.setOnAction((ActionEvent event) -> {
							pizzaRow = getTableView().getItems().get(getIndex());
							Screen.telaDeEditarPizza();
						});
					}

					@Override
					public void updateItem(Void item, boolean empty) {
						if (empty) {
							setGraphic(null);
						} else {
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
	
	//Implementa��o da barra de pesquisa
	public SortedList<PizzaTypeDTO> search(ObservableList<PizzaTypeDTO> obsList) {
		FilteredList<PizzaTypeDTO> filteredData = new FilteredList<>(obsList, b -> true);
		searchBar.textProperty().addListener((observable,oldValue,newValue)->{
			filteredData.setPredicate(pizza -> {
				if(newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if(pizza.getType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else {
					return false;
				}
				
			});
		});
		
		SortedList<PizzaTypeDTO> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(tablePizza.comparatorProperty());
		return sortedData;
	}

	public void voltar() {
		Screen.telaDeHome();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listPizza();
	}
}
