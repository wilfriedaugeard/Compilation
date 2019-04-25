package node;

import type.Type;

public final class NodeId extends NodeExp {

	protected String name;

	public NodeId(String name, Type type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String toString() {
		return this.getClass().getSimpleName() + "#" + name + ':' + type + '#';
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean checksType() {
		super.checksType();
		System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
		System.out.println("success");
		return true;
	}

	protected String toDotNodeName() {
		return "NodeId " + name;
	}

	@Override
	public NodeId clone() {
		return new NodeId(name, type);
	}

}
