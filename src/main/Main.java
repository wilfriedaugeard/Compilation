package main;
import java.io.FileReader;

import node.Node;
import intermediateCode.*;

public class Main {
	private static boolean checksType;

	public static void main(String[] args) throws Exception {
		for (String arg : args) {
			if (arg.charAt(0) == '-') {
				if (arg.equals("-checkType"))
					checksType = true;
			} else {
				ScannerExp input = new ScannerExp(new FileReader(arg));
				Parser parser = new Parser();
				try {
					 System.err.println("*** Fichier " + arg);
					 Node result = (Node) parser.parse(input);
					 System.err.println("*** Analyse syntaxique ok");
					 result.toDot("file.dot");
					 IntermediateCode InterCode = result.generateIntermediateCode();
					 System.out.println(InterCode.toString());
					 
					 if (checksType) {
						 if (!result.checksType())
							 System.err.println("*** Erreur de typage");
						 else
							 System.err.println("*** Typage correct");
					 }
				 } catch (beaver.Parser.Exception e) {
					 System.err.println("*** Erreur de syntaxe: " + arg + ":" + e.getMessage());
				 }
			}

		}
	}
}