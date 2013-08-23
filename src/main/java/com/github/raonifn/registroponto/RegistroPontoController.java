package com.github.raonifn.registroponto;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class RegistroPontoController {

	private RegistroPontoJFrame frame = new RegistroPontoJFrame();

	private Timer timer;

	private Date init;

	private final String fileName;

	public RegistroPontoController(String fileName) {
		this.fileName = fileName;
	}

	public void start() {
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getJLabelTempo().setText("A iniciar");
		frame.getJLabelTempo()
				.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
                
                frame.getJLabelHora()
				.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));

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
				if (JOptionPane.showConfirmDialog(frame,
						"Deseja realmente registrar parada?",
						"Registrar Parada", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) != JOptionPane.YES_OPTION) {
					return;
				}

				frame.getBtParar().setEnabled(false);
				frame.getBtIniciar().setEnabled(true);

				registrarHora("TERMINO");

				finalizarContador();
			}

		});
                
                Timer hora = new Timer(1 * 1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarHora();
			}
		});
                hora.start();
                atualizarHora();
	}
        
        private void atualizarHora() {
            frame.getJLabelHora().setText(
                            String.format("%1$td/%1$tm/%1$ty %1$TT", new Date()));
        }

	private void finalizarContador() {
		frame.getJLabelTempo().setText("A iniciar");
		timer.stop();
	}

	private void iniciarContador() {
		showLabel();

		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showLabel();
			}
		});
		timer.start();
	}

	private void showLabel() {
		long now = System.currentTimeMillis();
		long diff = now - init.getTime();

		long hours = diff / 1000 / 60 / 60;
                long hoursMili = hours * 1000 * 60 * 60;
		long minutes = (diff - hoursMili) / 1000 / 60;
                long minutesMili = minutes * 1000 * 60;
		long seconds = (diff - hoursMili - minutesMili) / 1000;

		String text = String.format("Entrada: %TT   %02d:%02d:%02d", init,
				hours, minutes, seconds);
		frame.getJLabelTempo().setText(text);
	}

	private Date registrarHora(String tipo) {
		Date now = new Date();

		PrintWriter print = null;
		try {
			print = new PrintWriter(new FileWriter(fileName, true));
			print.format("%1$td/%1$tm/%1$ty %1$TT,%2$s,%3$s\n", now,now.getTime(), tipo);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (print != null) {
				print.close();
			}
		}

		return now;
	}
}
