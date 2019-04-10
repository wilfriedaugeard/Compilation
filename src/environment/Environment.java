package environment;

import java.util.HashMap;
import java.util.Map;

public class Environment implements EnvironmentInt {
	
	HashMap<String,Double> environmentHMap;
	
	public Environment() {
		environmentHMap = new HashMap<String, Double>();
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
