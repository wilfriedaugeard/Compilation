package node;

import intermediateCode.*;
import java.util.Iterator;

public final class NodeCaseList extends NodeExp {

	public NodeCaseList() {
		super();
	}

	@Override
	public boolean checksType() {
		super.checksType();
		System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
		System.out.println("success");
		return true;
	}

	@Override
	public NodeCaseList clone() {
		return new NodeCaseList();
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
		Iterator<Node> itArgs = this.elts.iterator();
		return seqRec(itArgs);
	}
}
