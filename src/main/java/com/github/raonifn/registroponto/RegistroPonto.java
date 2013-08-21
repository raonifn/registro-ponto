package com.github.raonifn.registroponto;

public class RegistroPonto implements Runnable {

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new RegistroPonto());
	}

	public void run() {
		new RegistroPontoController().start();
	}

}
