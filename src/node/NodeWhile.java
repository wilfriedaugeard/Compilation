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
		if (get(0) == null)
			System.out.println("0 null");
		if (get(1) == null)
			System.out.println("1 null");
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

	public final static int EQ = 0, NE = 1, LT = 2, GT = 3, LE = 4, GE = 5, ULT = 6, ULE = 7, UGT = 8, UGE = 9;

	@Override
	public IntermediateCode generateIntermediateCode() {
		Label w = new Label(new LabelLocation("while"));
		Name tname = new Name(new LabelLocation("true"));
		Label t = new Label(tname.getLabel());
		Name fname = new Name(new LabelLocation("false"));
		Label f = new Label(fname.getLabel());
		Stm toDo = (Stm) this.getStm().generateIntermediateCode();
		NodeExp test = (NodeExp) this.getExp();
		String valTest = test.getType().toString();
		// cas pour un test de == null implicite
		if (valTest.startsWith("TypeBoolean") == false) {
			NodeExp n = (NodeExp) this.getExp();
			n.generateIntermediateCode();
			Exp l = n.getIntExp();
			Cjump c = new Cjump(EQ, l, null, tname.getLabel(), fname.getLabel());
			return new Seq(new Seq(new Seq(w, c), new Seq(t, toDo)), f);
		}
		// cas normal
		NodeRel n = (NodeRel) this.getExp();
		n.getOp1().generateIntermediateCode();
		Exp l = n.getOp1().getIntExp();
		n.getOp2().generateIntermediateCode();
		Exp r = n.getOp2().getIntExp();
		int op = EQ;
		switch (n.getName()) {
		case "==":
			op = EQ;
			break;
		case "!=":
			op = NE;
			break;
		case "<":
			op = LT;
			break;
		case ">":
			op = GT;
			break;
		case "<=":
			op = LE;
			break;
		case ">=":
			op = GE;
			break;
		default:
			break;
		}
		Cjump c = new Cjump(op, l, r, tname.getLabel(), fname.getLabel());

		return new Seq(new Seq(new Seq(w, c), new Seq(t, toDo)), f);
	}

}
