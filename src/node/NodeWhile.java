package node;
import intermediateCode.*;


public final class NodeWhile extends Node {

	public NodeWhile(Node boolExpr, Node stm) {
		super(boolExpr, stm);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
		if (get(0) == null) System.out.println("0 null");
		if (get(1) == null) System.out.println("1 null");
		if (!get(0).checksType()) {
			System.out.println("faillure");
			return false;
		}
		if (!get(1).checksType()) {
			System.out.println("faillure");
			return false;
		}
		System.out.println("success");
		return true;
	}

	@Override
	public NodeWhile clone() {
		return new NodeWhile((Node) this.getExp().clone(), (Node) this.getStm().clone());
	}

	private Node getStm() {
		return this.get(1);
	}

	private Node getExp() {
		return this.get(0);
	}
	
	@Override
	public IntermediateCode generateIntermediateCode()  {
		//NAME TEST (boolexpr)
		//CALL WHILE
		//CALL END
		//NAME WHILE 
		// code intermédiaire de stm
		//CALL TEST
		//NAME END
		// le tout dans expList
		return null;
	}


}
