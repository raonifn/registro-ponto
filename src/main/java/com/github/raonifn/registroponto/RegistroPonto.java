package com.github.raonifn.registroponto;

public class RegistroPonto implements Runnable {

	private RegistroPontoController registroPontoController;

	public RegistroPonto(String fileName) {
		this.registroPontoController = new RegistroPontoController(fileName);
	}

	public static void main(String[] args) {
		String fileName;
		if (args.length == 1) {
			fileName = args[0];
		} else {
			fileName = System.getProperty("java.io.tmpdir")
					+ "/registroPonto.csv";
		}
		java.awt.EventQueue.invokeLater(new RegistroPonto(fileName));
	}

	public void run() {
		registroPontoController.start();
	}
}
