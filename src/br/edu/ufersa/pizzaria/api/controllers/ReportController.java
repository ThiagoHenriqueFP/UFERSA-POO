package br.edu.ufersa.pizzaria.api.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.pizzaria.api.dto.OrderDTO;
import br.edu.ufersa.pizzaria.api.dto.ReportDTO;
import br.edu.ufersa.pizzaria.api.dto.StorageDTO;
import br.edu.ufersa.pizzaria.model.service.OrdersService;
import br.edu.ufersa.pizzaria.model.service.StorageService;
import br.edu.ufersa.pizzaria.view.Screen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReportController implements Initializable{
	
	@FXML private TableView<ReportDTO> tableReport;
	@FXML private TableColumn<ReportDTO, String> client;
	@FXML private TableColumn<ReportDTO, String> type;
	@FXML private TableColumn<ReportDTO, String> size;
	@FXML private TableColumn<ReportDTO, String> addi;
	@FXML private TableColumn<ReportDTO, String> state;
	@FXML private TableColumn<ReportDTO, Double> value;
	@FXML private TableColumn<ReportDTO, Integer> storagePiQnt;
	@FXML private TableColumn<ReportDTO, Integer> storageAddiQnt;
	@FXML private TableColumn<ReportDTO, String> date;
	
	private List<ReportDTO> reportList;
	private ObservableList<ReportDTO> obsList;
	private OrdersService orderService = new OrdersService();
	private List<OrderDTO> orderList = orderService.getAllOrders();
	private StorageService storageService = new StorageService();
	private List<StorageDTO> storageList = storageService.getAllItens();
	
	public void initializeTable() {
		reportList = populateReport();
		obsList = FXCollections.observableArrayList(reportList);
		
		client.setCellValueFactory(new PropertyValueFactory<ReportDTO,String>("ClientName"));
		size.setCellValueFactory(new PropertyValueFactory<ReportDTO,String>("Size"));
		type.setCellValueFactory(new PropertyValueFactory<ReportDTO,String>("PizzaType"));
		addi.setCellValueFactory(new PropertyValueFactory<ReportDTO,String>("AddiName"));
		state.setCellValueFactory(new PropertyValueFactory<ReportDTO,String>("State"));
		value.setCellValueFactory(new PropertyValueFactory<ReportDTO,Double>("Price"));
		storagePiQnt.setCellValueFactory(new PropertyValueFactory<ReportDTO,Integer>("PiQuantity"));
		storageAddiQnt.setCellValueFactory(new PropertyValueFactory<ReportDTO,Integer>("AddiQuantity"));
		date.setCellValueFactory(new PropertyValueFactory<ReportDTO,String>("Date"));
		
		tableReport.setItems(obsList);
	}
	
	public List<ReportDTO> populateReport() {
		List<ReportDTO> list = new ArrayList<ReportDTO>();
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
			
			list.add(reportDto);
			
		}
		
		return list;
	}
	
	public void voltar() {
		Screen.telaDeHome();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeTable();
	}
}
