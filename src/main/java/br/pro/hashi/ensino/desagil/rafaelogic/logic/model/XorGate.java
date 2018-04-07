package br.pro.hashi.ensino.desagil.rafaelogic.logic.model;

public class XorGate extends Gate{

	private NandGate nandGatea;
	private NandGate nandGateb;
	private NandGate nandGatec;
	private NandGate nandGated;
	
	public XorGate() {
		
		nandGatea = new NandGate();
		nandGateb = new NandGate();
		nandGatec = new NandGate();
		nandGated = new NandGate();
		
		nandGatea.connect(0,nandGateb);
		nandGatea.connect(1,nandGatec);
		nandGateb.connect(1, nandGated);
		nandGatec.connect(0, nandGated);
		
	}
	
	
	@Override
	public void connect(int pinIndex, Emitter emitter) {
		if(pinIndex == 0){
			nandGateb.connect(0, emitter);
			nandGated.connect(0, emitter);
		}
		if(pinIndex == 1){
			nandGatec.connect(1, emitter);
			nandGated.connect(1, emitter);
		}

	}

	@Override
	public boolean read() {
		return nandGatea.read();
	}
}
