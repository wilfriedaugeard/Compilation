package node;

import intermediateCode.*;

public class NodeOp extends NodeExp {

	protected String name;

	// Opération binaire
	// f : E X F -> F
	public NodeOp(String name, NodeExp op1, NodeExp op2) {
		super(op1, op2);
		this.name = name;
		// le type d'un opérateur
		NodeExp exprFct = (NodeExp) this.get(1);
		type = exprFct.type;
	}

	public NodeOp(String name, NodeExp op) {
		super(op);
		this.name = name;
		// le type d'un opérateur
		NodeExp exprFct = (NodeExp) this.get(0);
		type = exprFct.type;
	}

	@Override
	public boolean checksType() {
		super.checksType();
		System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
		if ((super.size() > 1) && getOp2() != null && !this.getOp1().getType().equals(this.getOp2().getType())) {
			System.out.println("faillure");
			return false;
		}
		System.out.println("success");
		return true;
	}

	private NodeExp getOp1() {
		return (NodeExp) this.get(0);
	};

	private NodeExp getOp2() {
		return (NodeExp) this.get(1);
	}

	@Override
	public NodeOp clone() {
		if (this.size() == 1)
			return new NodeOp(name, (NodeExp) getOp1().clone());
		else if (this.size() == 2)
			return new NodeOp(name, (NodeExp) getOp1().clone(), (NodeExp) getOp2().clone());
		return null;
	};

	public final static int PLUS = 0, MINUS = 1, MUL = 2, DIV = 3, AND = 4, OR = 5, LSHIFT = 6, RSHIFT = 7, ARSHIFT = 8,
			XOR = 9;

	@Override
	public IntermediateCode generateIntermediateCode() {
		// code intermediaire op1 et op2
		// switch sur les name (pour trouver l'opérateur)
		// BINOP
		this.getOp1().generateIntermediateCode();
		if (this.size() == 2)
			this.getOp2().generateIntermediateCode();
		int op = 0;
		switch (this.name) {
		case "+":
			op = PLUS;
			break;
		case "-":
			op = MINUS;
			break;
		case "*":
			op = MUL;
			break;
		case "/":
			op = DIV;
			break;
		default:
			break;
		}
		if (this.size() == 2)
			this.exp = new Binop(op, this.getOp1().getIntExp(), this.getOp2().getIntExp());
		else
			this.exp = new Binop(op, this.getOp1().getIntExp(), null);
		return this.exp;

	}

}
