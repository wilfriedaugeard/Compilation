package node;

import type.Type;
import intermediateCode.*;

public final class NodeAssign extends Node {

	public NodeAssign(NodeExp lhs, NodeExp rhs) {
		super(lhs, rhs);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		if (!get(0).checksType())  {
			System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
			System.out.println("faillure 1");
			return false;
		}
		if (!get(1).checksType()) {
			System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
			System.out.println("faillure 2");
			return false;
		}
		Type lhsType = this.getLhs().getType();
		Type rhsType = this.getRhs().getType();
		if (lhsType == null || rhsType == null || !lhsType.equals(rhsType)) {
			System.out.println("--lhs " + lhsType + " --rhs " + rhsType);
			System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
			System.out.println("faillure 3");
			return false;
		}
		else {
			System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
			System.out.println("success");
			return true;
		}
	}

	private NodeExp getLhs() {
		return (NodeExp) this.get(0);
	};

	private NodeExp getRhs() {
		return (NodeExp) this.get(1);
	}

	@Override
	public NodeAssign clone() {
		return new NodeAssign((NodeExp) getLhs().clone(), (NodeExp) getRhs().clone());
	};
	
	@Override
	public StmList generateIntermediateCode(StmList sl) {
		// code intermédiaire lhs et de rhs 
		// MOVE(MEM(lhs), rhs), 
		sl = this.getLhs().generateIntermediateCode(sl);
		LabelLocation l = new LabelLocation();
		Name lname = new Name(l);
		Label llabel = new Label(l);
		sl.add(llabel);
		sl = this.getRhs().generateIntermediateCode(sl);
		Name rname = new Name(l);
		Label rlabel = new Label(l);
		sl.add(rlabel);
		Mem mem = new Mem(lname);
		Move move = new Move(mem, rname);
		sl.add(move);
		return sl;
	}

}
