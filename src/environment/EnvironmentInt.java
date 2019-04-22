package environment;

public interface EnvironmentInt {
	
	// Ajoute une variable à l'environement
	void putVariable(String var, Object value);

	// Retrouve une variable d'un environnement
	Object getVariableValue(String variable);
	

}
