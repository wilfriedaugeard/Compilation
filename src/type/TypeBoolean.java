package type;

import main.ClonableSymbol;

public class TypeBoolean extends TypeAtomic {

	private Boolean const_value;

	public TypeBoolean(Boolean value) {
		this();
		this.const_value = value;
	}

	public TypeBoolean() {
		super();
	}
	

	@Override
	public ClonableSymbol clone() {
		return new TypeBoolean();
	}

	@Override
	public String toString() {
		return super.toString() + '_' + getConst_value();
	}

	public Boolean getConst_value() {
		return const_value;
	}

}
