package node;

import intermediateCode.*;

public final class NodeNew extends Node {

	public NodeNew(Node stm) {
		super(stm);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
		System.out.println("success");
		return true;
	}

	@Override
	public NodeNew clone() {
		return new NodeNew((Node) this.get(0).clone());
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		get(0).generateIntermediateCode();
		Name n = (Name) get(0).getIntExp();
		return new Label(n.getLabel());
	}

}
