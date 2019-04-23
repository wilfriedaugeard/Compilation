package environment;

import type.*; 
import java.util.HashMap;
import java.util.Map;

public class Environment implements EnvironmentInt {
	protected String name;
	
	protected HashMap<String,Type> environmentHMap;
	
	public Environment(String name) {
		environmentHMap = new HashMap<String, Type>();
		this.name = name;
	}

	@Override
	public void putVariable(String var, Type value) {
		environmentHMap.put(var, value);
	}

	@Override
	public Type getVariableValue(String variable) {
		return environmentHMap.get(variable);
	}
	
	public String toString(){
		return environmentHMap.toString();
	}

	// Implémenter la classe pour gérer un environnement
	
}
