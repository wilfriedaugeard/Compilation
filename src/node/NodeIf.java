package node;
import intermediateCode.*;


public final class NodeIf extends Node {

	public NodeIf(Node boolExp, Node stm) {
		super(boolExp, stm);
	}

	public NodeIf(Node e, Node stm1, Node stm2) {
		super(e, stm1, stm2);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
		System.out.println("success");
		return true;
	}

	@Override
	public NodeIf clone() {
		Node expNode = this.getExpNode();
		Node thenNode = this.getThenNode();
		Node elseNode = this.getElseNode();
		if (elseNode == null)
			return new NodeIf((Node) expNode.clone(), (Node) thenNode.clone());
		else
			return new NodeIf((Node) expNode, (Node) thenNode.clone(), (Node) elseNode.clone());
	}

	private Node getExpNode() {
		return this.get(0);
	}

	private Node getElseNode() {
		if (this.size() == 3)
			return this.get(2);
		else
			return null;
	}

	private Node getThenNode() {
		return this.get(1);
	}
	
	public final static int EQ = 0, NE = 1, LT = 2, GT = 3, LE = 4, GE = 5, ULT = 6, ULE = 7, UGT = 8, UGE = 9;

	@Override
	public StmList generateIntermediateCode(StmList sl) {
		NodeExp ifExp = (NodeExp) this.getExpNode();
		int relop;
		switch(ifExp.getName())	{
		case "==":
			relop = EQ;
			break;
		case "!=":
			relop = NE;
			break;
		case "<":
			relop = LT;
			break;
		case ">":
			relop = GT;
			break;
		case "<=":
			relop = LE;
			break;
		case ">=":
			relop = GE;
			break;
		}
		sl = this.getThenNode().generateIntermediateCode(sl);
		LabelLocation t = new LabelLocation();
		Name tname = new Name(t);
		Label tlabel = new Label(t);
		sl.add(tlabel);
		LabelLocation e = new LabelLocation();
		Name ename = new Name(e);
		Label elabel = new Label(e);
		sl.add(elabel);
		Cjump cjump = new Cjump(relop, t, e,tlabel, elabel);
		sl.add(cjump);
		return sl;
		
		
	}

}
