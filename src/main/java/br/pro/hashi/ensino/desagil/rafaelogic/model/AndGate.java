package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class AndGate extends Gate {
	private NandGate nandgate; 
	private NotGate notgate;
	
	public AndGate() {
		nandgate = new NandGate();
		notgate = new NotGate();
		
		notgate.connect(0, nandgate);//liga a entrada 0 do not a saida do Nand
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		nandgate.connect(pinIndex, emitter); // liga os pis aos index
	}

	@Override
	public boolean read() {
		return notgate.read(); // retorna a saida do not
	}
}