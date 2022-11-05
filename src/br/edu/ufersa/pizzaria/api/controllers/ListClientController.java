package br.edu.ufersa.pizzaria.api.controllers;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

public class ListClientController {

	@FXML private ImageView backgroundImg;
	@FXML private TableView<?> tableClient;
	@FXML private TableColumn<?, ?> nameColumn;
	@FXML private TableColumn<?, ?> cpfColumn;
	@FXML private TableColumn<?, ?> adressColumn;
	
	
	
	@FXML public void back(ActionEvent event) {
		Telas.telaHome();
	}
	
	@FXML public void btnClient(ActionEvent event) {
		JOptionPane.showMessageDialog(null, "Em progresso!!!");
	}
	
	
}
