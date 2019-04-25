package environment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import type.Type;

public class StackEnvironment extends Environment{
	
	private LinkedList<HashMap<String,Type>> stack;
	
	public StackEnvironment(String name) {
		super(name);
		stack = new LinkedList<HashMap<String,Type>>();
	}
	
	public void push(HashMap<String,Type> hm){
		stack.push(hm);
	}
	
	public HashMap<String,Type> pop(){
		return stack.pop();
	}
	
	@Override
	public void putVariable(String var, Type value) {
		stack.getFirst().put(var, value);
	}
	
	@Override
	public Type getVariableValue(String variable) {
		Iterator<HashMap<String,Type>> it = stack.iterator();
		while(it.hasNext()) {
			HashMap<String,Type> hm = it.next();
			if(hm.get(variable) != null)return hm.get(variable);
		}
		return null;
	}
	
	@Override
	public String toString() {
		String res = "StackEnvironment \""+name+"\" :\n";
		Iterator<HashMap<String,Type>> it = stack.iterator();
		while(it.hasNext()) {
			HashMap<String,Type> hm = it.next();
			res = res + hm.toString() + "\n";
		}
		return res;
	}
	
}