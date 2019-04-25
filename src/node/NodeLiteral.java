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
		return "NodeLiteral " + value.toString();
	}

	@Override
	public NodeLiteral clone() {
		return new NodeLiteral(type, value);
	}
	
	@Override
	public StmList generateIntermediateCode(StmList sl) {
		//CONST
		return sl;
	}

}
