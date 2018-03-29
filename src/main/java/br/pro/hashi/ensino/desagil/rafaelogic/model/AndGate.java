package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class AndGate extends Gate {
	private NandGate nandgate;
	private NotGate notgate;
	
	public AndGate() {
		nandgate = new NandGate();
		notgate = new NotGate();
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		nandgate.connect(0, emitter);
		nandgate.connect(1, emitter);
	}

	@Override
	public boolean read() {
		return notgate.read();
	}
}