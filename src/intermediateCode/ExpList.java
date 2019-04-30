package intermediateCode;

public class ExpList implements IntermediateCode {
	private Exp head;
	private ExpList tail;

	public ExpList(Exp head, ExpList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}

	@Override
	public void canonicalTransformation() {
		// TODO Auto-generated method stub
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".canonicalTransformation()()");
	}

	public String toString() {
		String exp = "ExpList(";
		if (head == null)
			return exp + ")";
		exp = exp + head.toString();
		if (tail == null)
			return exp + ")";
		ExpList list = this.tail;
		Exp h;
		while (list != null) {
			h = list.head;
			if (h != null)
				exp = exp + "," + h.toString();
			else
				exp = exp + ",null";
			list = list.tail;
		}
		exp = exp + " )";
		return exp;
	}

}
