package node;

import type.*;

import intermediateCode.*;

public abstract class NodeExp extends Node {

	protected Type type;

	public NodeExp(Node... abstTrees) {
		super(abstTrees);
	}

	public Type getType() {
		return this.type;
	}
	
	public String getName() {
		return "";
	}
	
	@Override
	public StmList generateIntermediateCode(StmList sl) {
		return sl;
		
	}


}
