package br.edu.ufersa.pizzaria.api.controllers;

import br.edu.ufersa.pizzaria.api.dto.ClientDTO;
import br.edu.ufersa.pizzaria.model.service.ClientService;
import br.edu.ufersa.pizzaria.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

// alterar o path das views

public class ClientSignUpController {
	@FXML private ImageView backgroundImg;
	@FXML private TextField clientNameSignUp;
	@FXML private TextField clientCpfSignUp;
	@FXML private TextField clientAdressSignUp;
	      private ClientService clientService = new ClientService();
	
	@FXML public void btnBack(ActionEvent event){
		Telas.telaClient();
	}
	
	@FXML public void signUP(ActionEvent event){
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setName(clientNameSignUp.getText());
		clientDTO.setCpf(clientCpfSignUp.getText());
		clientDTO.setAddress(clientAdressSignUp.getText());
		clientService.addClient(clientDTO);
	}
	
}
