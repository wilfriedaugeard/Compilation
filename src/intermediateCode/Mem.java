package intermediateCode;

public class Mem extends Exp {
	private Exp exp;

	public Mem(Exp exp) {
		super();
		this.exp = exp;
	}

	public String toString() {
		return "MEM(" + exp.toString() + ")";
	}

}
