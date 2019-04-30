package intermediateCode;

public class Seq extends Stm {
	private Stm left, right;

	public Seq(Stm left, Stm right) {
		super();
		this.left = left;
		this.right = right;
	}

	public String toString() {
		if (left != null && right != null)
			return "SEQ(" + left.toString() + "," + right.toString() + ")";
		else if (right == null)
			return "SEQ(" + left.toString() + ",null)";
		else
			return "SEQ(null," + right.toString() + ")";
	}

}
