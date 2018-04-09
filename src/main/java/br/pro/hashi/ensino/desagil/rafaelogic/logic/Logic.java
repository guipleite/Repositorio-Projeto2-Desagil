package br.pro.hashi.ensino.desagil.rafaelogic.logic;

import java.util.LinkedList;
import br.pro.hashi.ensino.desagil.rafaelogic.logic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.logic.view.View;
import br.pro.hashi.ensino.desagil.rafaelogic.logic.model.AndGate;
import br.pro.hashi.ensino.desagil.rafaelogic.logic.model.NotGate;
import br.pro.hashi.ensino.desagil.rafaelogic.logic.model.OrGate;
import br.pro.hashi.ensino.desagil.rafaelogic.logic.model.XorGate;
import br.pro.hashi.ensino.desagil.rafaelogic.logic.model.NandGate;
import javax.swing.JFrame;

public class Logic {

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				LinkedList<Gate> model = new LinkedList<>();
				model.add(new NandGate());
				model.add(new OrGate());
				model.add(new XorGate());
				model.add(new AndGate());
				model.add(new NotGate());

				View view = new View(model);

				JFrame frame = new JFrame();
            	frame.setContentPane(view);
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	frame.setResizable(false);
            	frame.pack();
            	frame.setVisible(true);
			}
		});
	}

}
