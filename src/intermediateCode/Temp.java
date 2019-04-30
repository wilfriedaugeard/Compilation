package intermediateCode;

public class Temp extends Exp {
	private TempValue temp;

	public Temp(TempValue temp) {
		super();
		this.temp = temp;
	}

	public String toString() {
		return "TEMP(" + temp.toString() + ")";
	}

}
