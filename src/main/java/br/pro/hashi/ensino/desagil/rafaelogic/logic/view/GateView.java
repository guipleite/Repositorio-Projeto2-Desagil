package br.pro.hashi.ensino.desagil.rafaelogic.logic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import br.pro.hashi.ensino.desagil.rafaelogic.logic.model.Gate;


public class GateView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Gate gate;

	private	JCheckBox c1;
	private	JCheckBox c2;
	private JCheckBox c3;


	public GateView(Gate gate){
		this.gate = gate;

		c1 = new JCheckBox();
		c2 = new JCheckBox();
		c3 = new JCheckBox();

		JLabel inLabel = new JLabel("Entrada: ");
		JLabel outLabel = new JLabel("Saída: ");

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		add(inLabel);
		add(c1);
		add(inLabel);
		add(c2);
		add(outLabel);
		add(c3);

		c1.addActionListener(this);
		c2.addActionListener(this);
		c3.setEnabled(false);

		update();
	}


	private void update() {
		
		try {
			
		}
		catch(NumberFormatException exception) {
			c3.setText("?");
			return;
		}

		//double result = gate.calculate(weight, radius);
		//double result = 1;
		//resultField.setText(Double.toString(result));
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}
}
