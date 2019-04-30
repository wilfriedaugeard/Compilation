package node;

import intermediateCode.*;

public final class NodeReturn extends NodeExp {

	public NodeReturn(Node e) {
		super(e);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
		System.out.println("success");
		return true;
	}

	@Override
	public NodeReturn clone() {
		return new NodeReturn((Node) get(0).clone());
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		this.get(0).generateIntermediateCode();
		this.exp = new Temp(new TempValue());
		return this.exp;
	}

}
