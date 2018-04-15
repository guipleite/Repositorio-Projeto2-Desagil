package br.pro.hashi.ensino.desagil.rafaelogic.logic.view;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import br.pro.hashi.ensino.desagil.rafaelogic.logic.model.Source;
import br.pro.hashi.ensino.desagil.rafaelogic.logic.model.Gate;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JLabel;


public class GateView extends SimplePanel implements ActionListener, MouseListener {

	
	private static final long serialVersionUID = 1L;

	private Gate gate;
	///Classe JCheckBox representa a CheckBox para as entradas das portas logicas
	private JCheckBox entrada1;
	private JCheckBox entrada2;
	private JCheckBox saida;
	private Color color;
	private Image image;
	
	
	///Codigo para determinado portao definido pelo usuario
	public GateView(Gate gate) {
		super(300, 200);
		
		this.gate = gate;
		
		
		entrada1 = new JCheckBox("Entrada 1"); /// inicializa as CheckBox e seleciona elas como false
	    entrada1.setSelected(false);
	    
		entrada2 = new JCheckBox("Entrada 2");
	    entrada2.setSelected(false);
	    
		saida = new JCheckBox("Saida");
	    saida.setSelected(false);
	
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); /// Layout do painel
	
		if (this.gate.getSize() == 1){  /// Determina o numero de entradas dependendo da selacao de portas do usuario
			add(entrada1, 20, 107, 75, 25);
		} else if (this.gate.getSize() == 2) {
			add(entrada1, 20, 123, 75, 25);
			add(entrada2, 20, 84, 75, 25);

		}
	
		add(saida);
		///Painel reage ao usuario 
		entrada1.addActionListener(this);
		entrada2.addActionListener(this);
		saida.setEnabled(false);
		
		update();
		
		color = Color.RED;

		String path = "/" + gate.toString() + ".png";
		URL url = getClass().getResource(path);
		image = new ImageIcon(url).getImage();

		// Toda componente Swing possui este método, que
		// permite adicionar objetos que reagem a eventos
		// de mouse que acontecem nela. Ou seja, ao passar
		// this como parâmetro, estamos pedindo para a
		// componente reagir aos próprios eventos de mouse.
		addMouseListener(this);
	
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
	
	@Override
	public void mouseClicked(MouseEvent event) {

		// Descobre em qual posição o clique ocorreu.
		int x = event.getX();
		int y = event.getY();

		// Se o clique foi dentro do retângulo colorido...
		if(x >= 195 && x < 235 && y >= 80 && y < 120 ) {

			// ...então abrimos o seletor de cor...
			color = JColorChooser.showDialog(this, null, color);

			// ...e atualizamos a tela.
			repaint();
		}
	}
	@Override
	public void mousePressed(MouseEvent event) {
		// Não estamos interessados em reagir ao ato
		// de apenas pressionar. Deixamos este vazio.
	}
	@Override
	public void mouseReleased(MouseEvent event) {
		// Não estamos interessados em reagir ao ato
		// de apenas soltar. Deixamos este vazio.
	}
	@Override
	public void mouseEntered(MouseEvent event) {
		// Não estamos interessados em reagir ao ato
		// do cursor entrar. Deixamos este vazio.
	}
	@Override
	public void mouseExited(MouseEvent event) {
		// Não estamos interessados em reagir ao ato
		// do cursor sair. Deixamos este vazio.
	}


	// Usamos isso no Projeto 1, vocês lembram?
	@Override
	public void paintComponent(Graphics g) {

		// Não podemos esquecer desta linha, pois não somos os
		// únicos responsáveis por desenhar o painel, como era
		// o caso no Projeto 1. Agora é preciso desenhar também
		// componentes internas, e isso é feito pela superclasse.
		super.paintComponent(g);

		// Desenha a imagem passando posição e tamanho.
		// O último parâmetro pode ser sempre null.
		g.drawImage(image, 95, 80, 150, 80 ,null);

		// Desenha um retângulo cheio.
		g.setColor(color);
		//g.fillRect(195, 80, 40, 175);
		g.fillArc(240,97, 40, 40, 0, 360);

		// Evita bugs visuais em alguns sistemas operacionais.
		getToolkit().sync();
    }
}


