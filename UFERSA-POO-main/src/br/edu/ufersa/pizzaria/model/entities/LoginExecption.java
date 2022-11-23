package br.edu.ufersa.pizzaria.model.entities;

import javax.swing.JOptionPane;

public class LoginExecption extends Exception {
	public LoginExecption (String erroMessage) {
		super(erroMessage);
		JOptionPane.showMessageDialog(null, "Login incorreto");
	}
}
