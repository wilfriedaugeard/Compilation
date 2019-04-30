package intermediateCode;

public class LabelLocationList {
	private LabelLocation head;
	private LabelLocationList tail;

	public LabelLocationList(LabelLocation head, LabelLocationList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}

	public String toString() {
		String exp = "LabelLocationList(";
		if (head == null)
			return exp + ")";
		exp = exp + head.toString();
		if (tail == null)
			return exp + ")";
		LabelLocationList list = this.tail;
		LabelLocation h;
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
