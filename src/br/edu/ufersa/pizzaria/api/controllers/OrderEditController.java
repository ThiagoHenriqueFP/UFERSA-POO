package br.edu.ufersa.pizzaria.api.controllers;

import br.edu.ufersa.pizzaria.view.Screen;
import javax.swing.JOptionPane;

public class OrderEditController {
	public void goBack() {
		Screen.telaDeHome();
	}
	
	public void onClick() {
		JOptionPane.showMessageDialog(null, "Pedido Realizado");
	}
	
	public void onProduction() {
		JOptionPane.showMessageDialog(null, "Pedido em produção");
	}
	
	public void onTransit() {
		JOptionPane.showMessageDialog(null, "Pedido saiu para entrega");
	}
	
	public void delivered() {
		JOptionPane.showMessageDialog(null, "Pedido entregue");
	}
	
	public void canceled() {
		JOptionPane.showMessageDialog(null, "Pedido cancelado");
	}
}