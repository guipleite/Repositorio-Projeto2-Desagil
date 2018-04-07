package br.pro.hashi.ensino.desagil.rafaelogic.logic.model;

public class NotGate extends Gate {
	private NandGate nandgate;
	
	public NotGate() {
		nandgate = new NandGate();
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		nandgate.connect(0, emitter);//Conecta as duas entradas do nand em um emmiter
		nandgate.connect(1, emitter);
	}

	@Override
	public boolean read() {
		return nandgate.read(); // retorna a saida do nand
	}
}