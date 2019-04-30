package intermediateCode;

public class Call extends Exp {
	private Exp func;
	private ExpList args;

	public Call(Exp func, ExpList args) {
		super();
		this.func = func;
		this.args = args;
	}

	public String toString() {
		return "CALL(" + func.toString() + "," + args.toString() + ")";
	}

}
