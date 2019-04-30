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
	public IntermediateCode generateIntermediateCode() {
		this.get(0).generateIntermediateCode();
		Mem m = new Mem(this.get(0).getIntExp());
		this.exp = m;
		return m;
	}

}
