package environment;
import type.*; 

public interface EnvironmentInt {
	
	// Ajoute une variable à l'environement
	void putVariable(String var, Type value);

	// Retrouve une variable d'un environnement
	Type getVariableValue(String variable);
	

}
