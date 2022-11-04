package br.edu.ufersa.pizzaria.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application{

	private static Stage stage;
	
	public static void main(String[] args) {
		launch();
	}

	public static void setStage(Stage st) {
		stage = st;
	}
		
	
	@Override
	public void start(Stage stage) throws Exception {		
		
		setStage(stage);
		stage.setTitle("Teste");
		telaLogin();	
	}
	
	public static void telaLogin() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getClassLoader().getResource("br/edu/ufersa/pizzaria/view/resources/telaLogin.fxml"));
			Scene cena = new Scene(root);
			
			stage.setTitle("Pizzaria-Login");
			stage.setScene(cena);
			stage.show();
			
		}catch(Exception a){
			a.printStackTrace();
		}
	}
	
	public static void telaHome() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getClassLoader().getResource("br/edu/ufersa/pizzaria/view/resources/optionsSession.fxml"));
			Scene cena = new Scene(root);
			
			stage.setTitle("Pizzaria-Home");
			stage.setScene(cena);
			stage.show();
			
		}catch(Exception a){
			a.printStackTrace();
		}
	}



}
