package node;

import type.*;
import intermediateCode.*;

public final class NodeArrayAccess extends NodeExp {
	private String name;

	// t [i]
	public NodeArrayAccess(NodeExp t, Node i) {
		super(t, i);
		if ((t != null) && (((TypeComplex) t.type).size() == 2))
			type = ((TypeComplex) t.type).get(1);
		this.name = t.getName();
	}

	@Override
	public boolean checksType() {
		super.checksType();
		TypeArray typeArray = (TypeArray) ((NodeExp) this.get(0)).getType();
		TypeRange typeRangeOREnum = typeArray.getRangeOREnum();
		Type typeArg = ((NodeExp) get(1)).getType();
		System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
		// Si l'index n'est pas du type attendu
		if (typeArg.getClass() != typeRangeOREnum.getFirst().getClass()) {
			System.out.println("faillure");
			System.err.println("type de l'index incorrect");
			return false;
		}
		// Si l'index est un enum, mais pas le bon
		if ((typeArg instanceof TypeItemEnum) && ((TypeItemEnum) typeArg)
				.getRefEnumRange() != ((TypeItemEnum) typeRangeOREnum.getFirst()).getRefEnumRange()) {
			System.out.println("faillure");
			System.err.println("type de l'index incorrect");
			return false;
		}
		// Si la valeur constante de l'index depasse
		if ((typeArg.compareTo(typeRangeOREnum.getFirst()) < 0)
				|| (typeArg.compareTo(((TypeRange) typeRangeOREnum).getLast()) > 0)) {
			System.out.println("faillure");
			System.err.println("index constant hors tableau");
			return false;
		}
		System.out.println("success");
		return true;
	}

	@Override
	public NodeArrayAccess clone() {
		return new NodeArrayAccess((NodeExp) get(0).clone(), (Node) get(1).clone());
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		this.get(0).generateIntermediateCode();
		Mem m = new Mem(this.get(0).getIntExp());
		this.exp = m;
		return m;
	}

}
