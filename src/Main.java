
import java.io.*;

import abstractTree.AbstTree;
import abstractTree.AbstTreeInt;
import abstractTree.Environment;
import abstractTree.EnvironmentInt;

public class Main {
	public static void main(String[] args) throws Exception {
		ScannerExpr input = new ScannerExpr(new FileReader(args[0]));
		ParserExpr parser = new ParserExpr();
		
		// Le "%goal" du parser doit être un objet de type AbstTreeInt
		AbstTreeInt expr = (AbstTree) parser.parse(input);

		// On doit pouvoir l'afficher
		System.out.println(expr.toString());
		
	}
}
