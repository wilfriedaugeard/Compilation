package node;

import type.TypeBoolean;
import type.TypeInt;
import intermediateCode.*;

public class NodeRel extends NodeExp {

	protected String name;

	// Relation binaire
	// f : E X F -> {0,1}
	public NodeRel(String name, Node op1, Node op2) {
		super(op1, op2);
		this.name = name;
		this.type = new TypeBoolean();
	}

	public NodeRel(String name, Node op) {
		super(op);
		this.name = name;
		this.type = new TypeBoolean();
	}

	@Override
	public boolean checksType() {
		super.checksType();
		System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
		if ((!(this.getOp1().getType() instanceof TypeInt)) || (!(this.getOp2().getType() instanceof TypeInt))) {
			System.out.println("faillure");
			return false;
		}
		System.out.println("success");
		return true;
	}

	public NodeExp getOp1() {
		return (NodeExp) this.get(0);
	};

	public NodeExp getOp2() {
		return (NodeExp) this.get(1);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public NodeRel clone() {
		return new NodeRel(name, (Node) getOp1().clone(), (Node) getOp2().clone());
	};

	public final static int PLUS = 0, MINUS = 1, MUL = 2, DIV = 3, AND = 4, OR = 5, LSHIFT = 6, RSHIFT = 7, ARSHIFT = 8,
			XOR = 9;

	@Override
	public IntermediateCode generateIntermediateCode() {
		this.getOp1().generateIntermediateCode();
		if (this.getOp2() != null)
			this.getOp2().generateIntermediateCode();
		Exp left = this.getOp1().getIntExp();
		Exp right;
		if (this.getOp2() != null)
			right = this.getOp2().getIntExp();
		else
			right = null;
		Binop newExp, first, less, less2, more, xor, eq;
		switch (this.name) {
		case "&&":
			newExp = new Binop(AND, left, right);
			break;
		case "||":
			newExp = new Binop(OR, left, right);
			break;
		case "<":
			// (-left) && right
			first = new Binop(MINUS, left, null);
			newExp = new Binop(AND, first, right);
			break;
		case ">":
			// left && (- right)
			first = new Binop(MINUS, right, null);
			newExp = new Binop(AND, left, first);
			break;
		case "<=":
			less = new Binop(AND, new Binop(MINUS, left, null), right);
			more = new Binop(AND, left, new Binop(MINUS, right, null));
			xor = new Binop(XOR, less, more);
			eq = new Binop(XOR, xor, new Temp(new TempValue()));
			first = new Binop(MINUS, right, null);
			less2 = new Binop(AND, left, first);
			newExp = new Binop(OR, less2, eq);
			break;
		case ">=":
			// more or equal
			less = new Binop(AND, new Binop(MINUS, left, null), right);
			more = new Binop(AND, left, new Binop(MINUS, right, null));
			xor = new Binop(XOR, less, more);
			eq = new Binop(XOR, xor, new Temp(new TempValue()));
			first = new Binop(MINUS, right, null);
			more = new Binop(AND, left, first);
			newExp = new Binop(OR, more, eq);
			break;
		case "==":
			// NOT (LESS XOR MORE)
			// LESS = 1 MORE =1 DONC 1 XOR 1 = 0 et NOT 0 = 1
			less = new Binop(AND, new Binop(MINUS, left, null), right);
			more = new Binop(AND, left, new Binop(MINUS, right, null));
			xor = new Binop(XOR, less, more);
			newExp = new Binop(XOR, xor, new Temp(new TempValue()));
			break;
		case "!=":
			// NOT (left == right)
			less = new Binop(AND, new Binop(MINUS, left, null), right);
			more = new Binop(AND, left, new Binop(MINUS, right, null));
			xor = new Binop(XOR, less, more);
			eq = new Binop(XOR, xor, new Temp(new TempValue()));
			newExp = new Binop(XOR, eq, new Temp(new TempValue()));
			break;
		case "!":
			// 1 XOR left
			Temp tmp = new Temp(new TempValue());
			newExp = new Binop(XOR, left, tmp);
			break;
		default:
			newExp = null;
		}
		this.exp =newExp;
		return newExp;
	}

}
