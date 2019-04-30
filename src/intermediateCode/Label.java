package intermediateCode;

public class Label extends Stm {
	private LabelLocation label;

	public Label(LabelLocation label) {
		super();
		this.label = label;
	}

	public String toString() {
		return "LABEL(" + label.toString() + ")";
	}

}
