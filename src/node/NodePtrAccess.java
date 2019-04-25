package node;

import type.*;
import intermediateCode.*;


public final class NodePtrAccess extends NodeExp {

	private String name;
	
	// e = NodeExp(TypePointer(\tau))
	public NodePtrAccess(NodeExp e) {
		super(e);
		if (e.getType() instanceof TypeComplex) {
			Type t = (TypeComplex) e.getType();
			if (t != null && (t instanceof TypePointer)) {
				Type tr = ((TypePointer) t).get(0);
				if (tr != null)
					this.type = tr;
			}
		}
		this.name=e.getName();
	}

	@Override
	public boolean checksType() {
		super.checksType();
		System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
		System.out.println("success");
		return true;
	}

	@Override
	public NodePtrAccess clone() {
		return new NodePtrAccess((NodeExp) this.get(0).clone());
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public StmList generateIntermediateCode(StmList sl) {
		
		////CALL sur case label correspondant a cette case qui deviendra un JUMP
		return sl;
	}

}
