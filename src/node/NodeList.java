package node;

import intermediateCode.*;

import java.util.Iterator;

public final class NodeList extends Node {

	public NodeList(Node stm) {
		super(stm);
	}

	public NodeList() {
		super();
	}

	@Override
	public boolean checksType() {
		super.checksType();
		boolean result = true;
		for (Node elt : this.elts) {
			if (elt != null && !elt.checksType()) {
				result = false;
				break;
			}
		}
		System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
		if (result)
			System.out.println("success");
		else
			System.out.println("faillure");
		return result;
	}

	public Iterator<Node> iterator() {
		return this.elts.iterator();
	}

	public int size() {
		return this.elts.size();
	}

	@Override
	public NodeList clone() {
		NodeList node = new NodeList();
		for (Node elt : this.elts) {
			node.add((Node) elt.clone());
		}
		return node;
	}

	public Stm seqRec(Iterator<Node> arg) {
		Stm s = (Stm) arg.next().generateIntermediateCode();
		if (arg.hasNext())
			return new Seq(s, seqRec(arg));
		else
			return new Seq(s, null);
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		// ExpList sur les élements
		Iterator<Node> itArgs = this.elts.iterator();
		return seqRec(itArgs);
	}

}
