package br.edu.ufersa.pizzaria.api.controllers;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.api.dto.ClientDTO;
import br.edu.ufersa.pizzaria.model.service.ClientService;
import br.edu.ufersa.pizzaria.view.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ClientController{
	@FXML private TextField name;
	@FXML private TextField cpf;
	@FXML private TextField address;
	
	private ClientService clientService = new ClientService();
	
	//Cadastro
	public void signUp() {
		ClientDTO clientDto = new ClientDTO();
		clientDto.setName(name.getText());
		clientDto.setCPF(cpf.getText());
		clientDto.setAddress(address.getText());
		if(clientService.addClient(clientDto)) {
			JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
			Screen.telaDeHome();
		}
	}
	
	public void voltar() {
		Screen.telaDeHome();
	}

}
