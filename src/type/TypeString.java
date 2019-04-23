package type;

public final class TypeString extends TypeAtomic {

	private String const_value;

	public TypeString(String value) {
		this();
		this.const_value = value;
	}

	public TypeString() {
		super();
	}
	
	public void putValue(String val) {
		this.const_value=val;
	}

	@Override
	public Type clone() {
		return new TypeString(this.getConst_value());
	}

	@Override
	public String toString() {
		return super.toString() + '_' + getConst_value();
	}

	public String getConst_value() {
		return const_value;
	}

}
