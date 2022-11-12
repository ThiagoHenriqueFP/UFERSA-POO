package br.edu.ufersa.pizzaria.api.controllers;

import javax.swing.JOptionPane;

import br.edu.ufersa.pizzaria.view.Screen;

public class OrderController {
	
	public void orderSignUp() {
		JOptionPane.showMessageDialog(null, "Pedido Cadastrado com Sucesso!");
		voltar();
	}
	
	public void voltar() {
		Screen.telaDeHome();
	}
}
