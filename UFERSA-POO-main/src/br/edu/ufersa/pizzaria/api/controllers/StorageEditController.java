package br.edu.ufersa.pizzaria.api.controllers;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.api.dto.StorageDTO;
import br.edu.ufersa.pizzaria.model.service.StorageService;
import br.edu.ufersa.pizzaria.view.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StorageEditController {
	@FXML private TextField productName;
	@FXML private TextField qntProduct;
	@FXML private TextField value;
	
	StorageService storageService = new StorageService();
	
	public void voltar() {
		Screen.telaDeListarEstoque();
	}
	
	public void btnEditProduct() {
		StorageDTO storageDTO = new StorageDTO();
		storageDTO.setItem(productName.getText());
		storageDTO.setQuantity(Integer.parseInt(qntProduct.getText()));
		storageDTO.setValue(Double.parseDouble(value.getText()));
		if(storageService.editItem(storageDTO)) {
			JOptionPane.showMessageDialog(null, "Produto Editado com Sucesso!");
			Screen.telaDeListarEstoque();
		}
	}
	
	public void btnDelProduct() {
		StorageDTO storageDTO = new StorageDTO();
		storageDTO.setItem(StorageListController.storageRow.getItem());
		if(storageService.deleteItem(storageDTO)) {
			JOptionPane.showMessageDialog(null, "Produto Deletado com Sucesso!");
			Screen.telaDeListarEstoque();
		}
	}
}
