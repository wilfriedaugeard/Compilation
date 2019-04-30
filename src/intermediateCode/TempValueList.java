package intermediateCode;

public class TempValueList {
	private TempValue head;
	private TempValueList tail;

	public TempValueList(TempValue head, TempValueList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}

	public String toString() {
		String exp = "TempValueList(" + head.toString();
		if (head == null)
			return exp + ")";
		exp = exp + head.toString();
		if (tail == null)
			return exp + ")";
		TempValueList list = this.tail;
		TempValue h;
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
