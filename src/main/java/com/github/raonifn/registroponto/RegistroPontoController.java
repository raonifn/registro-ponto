package com.github.raonifn.registroponto;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.WindowConstants;

public class RegistroPontoController {

	private RegistroPontoJFrame frame = new RegistroPontoJFrame();

	private Timer timer;

	private long init;

	public void start() {
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getJLabelTempo().setText("A iniciar");
		frame.getJLabelTempo()
				.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

		takeControl();

		frame.setVisible(true);
	}

	private void takeControl() {
		frame.getBtParar().setEnabled(false);
		frame.getBtIniciar().setEnabled(true);

		frame.getBtIniciar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getBtParar().setEnabled(true);
				frame.getBtIniciar().setEnabled(false);

				init = registrarHora("INICIO");
				iniciarContador();
			}

		});

		frame.getBtParar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getBtParar().setEnabled(false);
				frame.getBtIniciar().setEnabled(true);

				registrarHora("TERMINO");

				finalizarContador();
			}

		});
	}

	private void finalizarContador() {
		frame.getJLabelTempo().setText("A iniciar");
		timer.stop();
	}

	private void iniciarContador() {
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long now = System.currentTimeMillis();
				long diff = now - init;

				long hours = diff / 1000 / 60 / 60;
				long minutes = (diff - hours) / 1000 / 60;
				long seconds = (diff - hours - minutes) / 1000;

				String text = String.format("%02d:%02d:%02d", hours, minutes,
						seconds);
				frame.getJLabelTempo().setText(text);
			}
		});
		timer.start();
	}

	private long registrarHora(String string) {
		return System.currentTimeMillis();
	}

}
