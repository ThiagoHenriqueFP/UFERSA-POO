package br.edu.ufersa.pizzaria.api.controllers;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ClientSignUpController {
	@FXML ImageView backgroundImg;
	@FXML TextField clientNameSignUp;
	@FXML TextField clientCpfSignUp;
	@FXML TextField clientAdressSignUp;
	
	@FXML public void btnBack(ActionEvent event){
		Telas.telaClient();
	}
	
	@FXML public void signUP(ActionEvent event){
		JOptionPane.showMessageDialog(null, "Em progresso!!!");
	}
	
}
