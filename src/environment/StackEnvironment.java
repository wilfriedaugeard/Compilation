package environment;

import java.util.HashMap;
import java.util.Stack;

import type.Type;

public class StackEnvironment extends Environment{
	
	private Stack<HashMap<String,Type>> stack;
	
	public StackEnvironment(String name) {
		super(name);
		stack = new Stack<HashMap<String,Type>>();
	}
	
	public HashMap<String,Type> push(HashMap<String,Type> hm){
		return stack.push(hm);
	}
	
	public HashMap<String,Type> pop(){
		return stack.pop();
	}
	
	@Override
	public void putVariable(String var, Type value) {
		stack.peek().put(var, value);
	}
	
	@Override
	public Type getVariableValue(String variable) {
		return stack.peek().get(variable);
	}
	
	@Override
	public String toString() {
		return stack.toString();
	}
	
	
}