package br.edu.ufersa.pizzaria.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Screen extends Application{
	public static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Pizzaria Restaurant");
		setPalco(stage);
		telaDeLogin();
	}
	
	public static void setPalco(Stage palco) {
		stage = palco;
	}
	
	public static void telaDeLogin() {
		try {
			FXMLLoader loader = new FXMLLoader(Screen.class.getResource("/loginJFX.fxml"));
			Pane loginScreen = loader.load();
			Scene scene = new Scene(loginScreen);
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDeHome() {
		try {
			FXMLLoader loader = new FXMLLoader(Screen.class.getResource("/home.fxml"));
			Pane homeScreen = loader.load();
			Scene scene = new Scene(homeScreen);
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDeReport() {
		try {
			FXMLLoader loader = new FXMLLoader(Screen.class.getResource("/relatorio.fxml"));
			Pane homeScreen = loader.load();
			Scene scene = new Scene(homeScreen);
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDeCadastroCliente() {
		try {
			FXMLLoader loader = new FXMLLoader(Screen.class.getResource("/clientSignUp.fxml"));
			Pane clientSignUpScreen = loader.load();
			Scene scene = new Scene(clientSignUpScreen);
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDeListarCliente() {
		try {
			FXMLLoader loader = new FXMLLoader(Screen.class.getResource("/clientList.fxml"));
			Pane clientSignUpScreen = loader.load();
			Scene scene = new Scene(clientSignUpScreen);
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDeEditarCliente() {
		try {
			FXMLLoader loader = new FXMLLoader(Screen.class.getResource("/clientEdit.fxml"));
			Pane clientSignUpScreen = loader.load();
			Scene scene = new Scene(clientSignUpScreen);
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDeCadastroPedido() {
		try {
			FXMLLoader loader = new FXMLLoader(Screen.class.getResource("/OrderSignUp.fxml"));
			Pane clientSignUpScreen = loader.load();
			Scene scene = new Scene(clientSignUpScreen);
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDeEditarPedido() {
		try {
			FXMLLoader loader = new FXMLLoader(Screen.class.getResource("/editRequest.fxml"));
			Pane clientSignUpScreen = loader.load();
			Scene scene = new Scene(clientSignUpScreen);
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDeCadastroPizza() {
		try {
			FXMLLoader loader = new FXMLLoader(Screen.class.getResource("/pizzaSignUp.fxml"));
			Pane clientSignUpScreen = loader.load();
			Scene scene = new Scene(clientSignUpScreen);
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDeListarPizza() {
		try {
			FXMLLoader loader = new FXMLLoader(Screen.class.getResource("/pizzaList.fxml"));
			Pane clientSignUpScreen = loader.load();
			Scene scene = new Scene(clientSignUpScreen);
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDeEditarPizza() {
		try {
			FXMLLoader loader = new FXMLLoader(Screen.class.getResource("/pizzaEdit.fxml"));
			Pane clientSignUpScreen = loader.load();
			Scene scene = new Scene(clientSignUpScreen);
			stage.setScene(scene);
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDeCadastroEstoque() {
		try {
			FXMLLoader loader = new FXMLLoader(Screen.class.getResource("/storageSignUp.fxml"));
			Pane clientSignUpScreen = loader.load();
			Scene scene = new Scene(clientSignUpScreen);
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDeListarEstoque() {
		try {
			FXMLLoader loader = new FXMLLoader(Screen.class.getResource("/storageList.fxml"));
			Pane clientSignUpScreen = loader.load();
			Scene scene = new Scene(clientSignUpScreen);
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDeEditarEstoque() {
		try {
			FXMLLoader loader = new FXMLLoader(Screen.class.getResource("/storageEdit.fxml"));
			Pane clientSignUpScreen = loader.load();
			Scene scene = new Scene(clientSignUpScreen);
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String args[]) {
		launch();
	}
	
}
