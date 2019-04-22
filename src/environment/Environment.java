package environment;

import java.util.HashMap;
import java.util.Map;

public class Environment implements EnvironmentInt {
	protected String name;
	
	protected HashMap<String,Object> environmentHMap;
	
	public Environment(String name) {
		environmentHMap = new HashMap<String, Object>();
		this.name = name;
	}

	@Override
	public void putVariable(String var, Object value) {
		environmentHMap.put(var, value);
	}

	@Override
	public Object getVariableValue(String variable) {
		return environmentHMap.get(variable);
	}
	
	public String toString(){
		return environmentHMap.toString();
	}

	// Implémenter la classe pour gérer un environnement
	
}
