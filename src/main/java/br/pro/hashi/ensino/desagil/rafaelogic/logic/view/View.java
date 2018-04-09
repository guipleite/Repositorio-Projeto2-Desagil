package br.pro.hashi.ensino.desagil.rafaelogic.logic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import br.pro.hashi.ensino.desagil.rafaelogic.logic.model.Gate;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class View extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	//adiciona menu e subpainel para o programa
	private JComboBox<Gate> menu;
	private GateView gateView;

	public View(LinkedList<Gate> model) {

		///classe JComboBox gera o menu
		menu = new JComboBox<>();

		//Adicionando as classes ao menu
		for(Gate gate: model) {
			menu.addItem(gate);
		}
		//Layout do Box
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Adiciona o menu 
		add(menu);

		// adiciona o subpainel
		addGateView(0);

		// painel reagindo a mudancas do menu
		menu.addActionListener(this);
	}


	// Adiciona o subpainel de uma calculadora a este painel.
	private void addGateView(int index) {
		Gate gate = menu.getItemAt(index);
		gateView = new GateView(gate);
		add(gateView);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		remove(gateView);
		int index = menu.getSelectedIndex();
		addGateView(index);

		((JFrame) SwingUtilities.getRoot(this)).pack();
	}
}
