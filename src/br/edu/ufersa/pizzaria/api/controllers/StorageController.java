package br.edu.ufersa.pizzaria.api.controllers;

import br.edu.ufersa.pizzaria.api.dto.StorageDTO;
import br.edu.ufersa.pizzaria.model.service.StorageService;
import br.edu.ufersa.pizzaria.view.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StorageController {
	@FXML private TextField produto;
	@FXML private TextField quant;
	@FXML private TextField cod;
	
	private StorageService storageService = new StorageService();
	
	public void storageSignUp() {
		StorageDTO storageDto = new StorageDTO();
		storageDto.setItem(produto.getText());
		storageDto.setQuantity(Integer.parseInt(quant.getText()));
		storageService.addItem(storageDto);
	}
	
	public void voltar() {
		Screen.telaDeHome();
	}
}