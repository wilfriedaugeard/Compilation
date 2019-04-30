package intermediateCode;

public class StmList {
	private Stm head;
	private StmList tail;

	public StmList(Stm head, StmList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}

	public void add(Stm s) {
		tail.add(this.head);
		this.head = s;
	}

	public Stm getHead() {
		return this.head;
	}

	public String toString() {
		String exp = "StmList(" + head.toString();
		if (head == null)
			return exp + ")";
		exp = exp + head.toString();
		if (tail == null)
			return exp + ")";
		StmList list = this.tail;
		Stm h;
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
