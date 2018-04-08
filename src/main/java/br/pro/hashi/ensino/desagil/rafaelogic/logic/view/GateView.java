package br.pro.hashi.ensino.desagil.rafaelogic.logic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.pro.hashi.ensino.desagil.rafaelogic.logic.model.Gate;


public class GateView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Gate gate;

	private	JTextField weightField;
	private	JTextField radiusField;
	private JTextField resultField;


	public GateView(Gate gate){
		this.gate = gate;

		weightField = new JTextField();
		radiusField = new JTextField();
		resultField = new JTextField();

		JLabel weightLabel = new JLabel("Weight");
		JLabel radiusLabel = new JLabel("Radius");
		JLabel resultLabel = new JLabel("Result");

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(weightLabel);
		add(weightField);
		add(radiusLabel);
		add(radiusField);
		add(resultLabel);
		add(resultField);

		weightField.addActionListener(this);
		radiusField.addActionListener(this);

		resultField.setEnabled(false);

		update();
	}


	private void update() {
		double weight;
		double radius;

		try {
			weight = Double.parseDouble(weightField.getText());
			radius = Double.parseDouble(radiusField.getText());
		}
		catch(NumberFormatException exception) {
			resultField.setText("?");
			return;
		}

		//double result = gate.calculate(weight, radius);
		double result = 1;
		resultField.setText(Double.toString(result));
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}
}
