package AbstTree;
import java.util.HashMap;
import java.util.Map;

public class Environment implements EnvironmentInt {

	HashMap<String,Double> hashmap;
	
	public Environment() {
		this.hashmap = new HashMap<String,Double>();
		
	}	

	@Override
	public void putVariable(String var, Double value) {
		this.hashmap.put(var,value);
	}

	@Override
	public Double getVariableValue(String variable) {
		return hashmap.get(variable);
	}

	
	
}
