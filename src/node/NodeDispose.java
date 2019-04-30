package node;

import intermediateCode.*;

public final class NodeDispose extends Node {

	public NodeDispose(Node e) {
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
	public NodeDispose clone() {
		return new NodeDispose((Node) this.get(0).clone());
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		get(0).generateIntermediateCode();
		Move move = new Move(get(0).getIntExp(), new Name(new LabelLocation("null")));
		return move;
	}

}
