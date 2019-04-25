package node;
import intermediateCode.*;


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
	@Override
	public StmList generateIntermediateCode(StmList sl) {
		return sl;
	}


}
