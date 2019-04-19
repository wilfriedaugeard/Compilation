package environment;

import java.util.HashMap;
import java.util.Map;

public class Environment implements EnvironmentInt {
	protected String name;
	
	protected HashMap<String,Double> environmentHMap;
	
	public Environment(String name) {
		environmentHMap = new HashMap<String, Double>();
		this.name = name;
	}

	@Override
	public void putVariable(String var, Double value) {
		environmentHMap.put(var, value);
	}

	@Override
	public Double getVariableValue(String variable) {
		return environmentHMap.get(variable);
	}

	// Implémenter la classe pour gérer un environnement
	
}
