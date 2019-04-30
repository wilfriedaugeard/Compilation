package node;

import intermediateCode.*;

import type.Type;

public final class NodeLiteral extends NodeExp {

	private Object value;

	public NodeLiteral(Type type, Object value) {
		super();
		this.type = type;
		this.value = value;
	}

	public String toString() {
		return this.getClass().getSimpleName() + '#' + value + ':' + type + '#';
	}

	@Override
	public boolean checksType() {
		super.checksType();
		System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
		System.out.println("success");
		return true;
	}

	public String toDotNodeName() {
		if(value == null) return "NodeLiteral";
		return "NodeLiteral " + value.toString();
	}

	@Override
	public NodeLiteral clone() {
		return new NodeLiteral(type, value);
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		this.exp = new Const(this.value);
		return this.exp;
	}

}
