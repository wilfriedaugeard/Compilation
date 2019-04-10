package type;

importClonableSymbol;

public class TypeBoolean extends TypeAtomic {

	@Override
	public ClonableSymbol clone() {
		return new TypeBoolean();
	}

}
