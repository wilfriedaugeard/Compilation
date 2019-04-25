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
	
	

}
