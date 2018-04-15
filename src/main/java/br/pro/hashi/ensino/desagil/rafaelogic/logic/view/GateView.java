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
		
		
		entrada1 = new JCheckBox(); /// inicializa as CheckBox e seleciona elas como false
	    entrada1.setSelected(false);
	    
		entrada2 = new JCheckBox();
	    entrada2.setSelected(false);
	    
		saida = new JCheckBox();
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
		
		color = Color.BLACK;

		String path = "/" + gate.toString() + ".png";
		URL url = getClass().getResource(path);
		image = new ImageIcon(url).getImage();

		update();
		
		addMouseListener(this);
	
	}
	private void update() {
		Source pin1 = new Source(); ///inicializando as entradas das portas
		Source pin2 = new Source();
		
		pin1.turn(entrada1.isSelected()); ///Valores das entradas atribuidos pelas checkbox
		pin2.turn(entrada2.isSelected());
		
		gate.connect(1, pin2); ///conectando as entradas de acordo com a selecao do usuario
		gate.connect(0, pin1);
		
	//a LED saida se comporta como o metodo read da classe gate e muda de cor dependendo da booleana
		
		if(gate.read() == true) {
			color = Color.RED;
			repaint();
		}
		else {
			color = Color.BLACK;
			repaint();
		}
	}
				
	@Override
	public void actionPerformed(ActionEvent e) {
			update();
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {

		int x = event.getX();
		int y = event.getY();

		//boolean isIn =  (x - 40) * (x - 40) + (y - 40) * (y - 40) <= 20 * 20;System.out.println(isIn);
		// Se o clique foi dentro do retângulo colorido...
		if(x >= 195 && x < 235 && y >= 80 && y < 120 ) {

			color = JColorChooser.showDialog(this, null, color);

			repaint();
		}
	}
	@Override
	public void mousePressed(MouseEvent event) {
	}
	@Override
	public void mouseReleased(MouseEvent event) {
	}
	@Override
	public void mouseEntered(MouseEvent event) {
	}
	@Override
	public void mouseExited(MouseEvent event) {
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		g.drawImage(image, 95, 80, 150, 80 ,null);

		g.setColor(color);
		g.fillArc(240,97, 40, 40, 0, 360);

		// Evita bugs visuais em alguns sistemas operacionais.
		getToolkit().sync();

    }
}


