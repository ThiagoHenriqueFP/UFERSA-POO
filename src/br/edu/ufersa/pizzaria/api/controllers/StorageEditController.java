package br.edu.ufersa.pizzaria.api.controllers;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.view.Screen;

public class StorageEditController {
	public void voltar() {
		Screen.telaDeListarEstoque();
	}
	
	public void btnEditProduct() {
		JOptionPane.showMessageDialog(null, "Produto Editado com Sucesso!");
	}
	
	public void btnDelProduct() {
		JOptionPane.showMessageDialog(null, "Produto Deletado com Sucesso!");
	}
}
