package br.pro.hashi.ensino.desagil.rafaelogic.logic.view;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import br.pro.hashi.ensino.desagil.rafaelogic.logic.model.Source;
import br.pro.hashi.ensino.desagil.rafaelogic.logic.model.Gate;
import javax.swing.JCheckBox;
import javax.swing.JPanel;


public class GateView extends JPanel implements ActionListener {
	
	
	private static final long serialVersionUID = 1L;

	private Gate gate;
	///Classe JCheckBox representa a CheckBox para as entradas das portas logicas
	private JCheckBox entrada1;
	private JCheckBox entrada2;
	private JCheckBox saida;
	///Codigo para determinado portao definido pelo usuario
	public GateView(Gate gate) {
		this.gate = gate;
		
		entrada1 = new JCheckBox("Entrada 1"); /// inicializa as CheckBox e seleciona elas como false
	    entrada1.setSelected(false);
	    
		entrada2 = new JCheckBox("Entrada 2");
	    entrada2.setSelected(false);
	    
		saida = new JCheckBox("Saida");
	    saida.setSelected(false);
	
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); /// Layout do painel
	
		if (this.gate.getSize() == 1){  /// Determina o numero de entradas dependendo da selacao de portas do usuario
			add(entrada1);
		} else if (this.gate.getSize() == 2) {
			add(entrada1);
			add(entrada2);
		}
	
		add(saida);
		///Painel reage ao usuario 
		entrada1.addActionListener(this);
		entrada2.addActionListener(this);
		saida.setEnabled(false);
		
		update();
	
	}
	private void update() {
		Source pin1 = new Source(); ///inicializando as entradas das portas
		Source pin2 = new Source();
		
		pin1.turn(entrada1.isSelected()); ///Valores das entradas atribuidos pelas checkbox
		pin2.turn(entrada2.isSelected());
		
		gate.connect(1, pin2); ///conectando as entradas de acordo com a selecao do usuario
		gate.connect(0, pin1);
		
		saida.setSelected(gate.read()); ///a checkbox saida se comporta como o metodo read da classe gate
	
	}
				
	@Override
	public void actionPerformed(ActionEvent e) {
			update();
		
	}
}
