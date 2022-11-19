package br.edu.ufersa.pizzaria.api.controllers;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.api.dto.StorageDTO;
import br.edu.ufersa.pizzaria.model.service.StorageService;
import br.edu.ufersa.pizzaria.view.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StorageController {
	@FXML private TextField produto;
	@FXML private TextField quant;
	@FXML private TextField value;
	
	private StorageService storageService = new StorageService();
	
	public void storageSignUp() {
		StorageDTO storageDto = new StorageDTO();
		storageDto.setItem(produto.getText().toLowerCase());
		storageDto.setQuantity(Integer.parseInt(quant.getText()));
		storageDto.setValue(Double.parseDouble(value.getText()));
		if(storageService.addItem(storageDto)) {
			JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
			Screen.telaDeHome();
		}
	}
	
	public void voltar() {
		Screen.telaDeHome();
	}
}