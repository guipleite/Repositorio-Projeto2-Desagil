package br.pro.hashi.ensino.desagil.rafaelogic.logic.model;

public class OrGate extends Gate{

	private NandGate nandGatea;
	private NandGate nandGateb;
	private NandGate nandGatec;
	
	public OrGate() {
		super("Or");
		nandGatea = new NandGate(); //Cria 3 nandgate
		nandGateb = new NandGate();
		nandGatec = new NandGate();
		
		nandGatea.connect(0,nandGateb);
		nandGatea.connect(1,nandGatec);
		
	}
	
	@Override
	public void connect(int pinIndex, Emitter emitter) {
		if(pinIndex == 0){
			nandGateb.connect(0, emitter);
			nandGateb.connect(1, emitter);
		}
		if(pinIndex == 1){
			nandGatec.connect(0, emitter);
			nandGatec.connect(1, emitter);
		}

	}

	@Override
	public boolean read() {
		return nandGatea.read(); // retorna a saida do ultimo nand
	}
}