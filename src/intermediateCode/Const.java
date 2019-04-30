package intermediateCode;

public class Const extends Exp {
	private Object value;

	public Const(Object value) {
		super();
		this.value = value;
	}

	public String toString() {
		return "CONST(" + value + ")";
	}

}
