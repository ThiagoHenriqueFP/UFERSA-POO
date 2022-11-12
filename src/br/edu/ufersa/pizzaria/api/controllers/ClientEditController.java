package br.edu.ufersa.pizzaria.api.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.api.dto.ClientDTO;
import br.edu.ufersa.pizzaria.model.service.ClientService;
import br.edu.ufersa.pizzaria.view.Screen;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class ClientEditController implements Initializable{
	@FXML private TextField name;
	@FXML private TextField address;
	private ClientService clientService = new ClientService();
	
	public void editClient() {
		ClientDTO clientDto = new ClientDTO();
		clientDto.setName(name.getText());
		clientDto.setCPF(ClientListController.clientRow.getCPF());
		clientDto.setAddress(address.getText());
		//clientService.editClient(clientDto);
		JOptionPane.showMessageDialog(null, "Cliente Editado com Sucesso!");
		Screen.telaDeListarCliente();
	}
	
	public void deleteClient() {
		ClientDTO clientDto = new ClientDTO();
		clientDto.setName(ClientListController.clientRow.getName());
		clientDto.setCPF(ClientListController.clientRow.getCPF());
		clientDto.setAddress(ClientListController.clientRow.getAddress());
		//clientService.deleteClient(clientDto);
		JOptionPane.showMessageDialog(null, "Cliente Deletado com Sucesso!");
		Screen.telaDeListarCliente();
	}
	
	public void voltar() {
		Screen.telaDeListarCliente();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		name.setText(ClientListController.clientRow.getName());
		address.setText(ClientListController.clientRow.getAddress());
	}
}
