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
		if (!get(0).checksType()) {
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
		} else {
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
	public IntermediateCode generateIntermediateCode() {
		// code intermédiaire lhs et de rhs
		// MOVE(MEM(lhs), rhs)
		getLhs().generateIntermediateCode();
		getRhs().generateIntermediateCode();
		Move move = new Move(getLhs().getIntExp(), getRhs().getIntExp());
		return move;
	}

}
