package main;
import beaver.Symbol;
import beaver.Scanner;
%%

%class ScannerExp
%extends Scanner
%function nextToken
%type Symbol
%yylexthrow Scanner.Exception
%eofval{
	return new Symbol(Terminals.EOF);
%eofval}
%unicode
%line
%column

Identifier 	= [a-zA-Z_][a-zA-Z0-9_]*
String 		= \"[^\"]*\"
Integer 	= [0-9]+
Hexa 		= 0x[0-9A-Fa-f]{1,8}

Commentary 	= \/\*~(\*\/)|\/\/.*

%%
//KEYWORD
"if"		{ System.out.println("*** if"); return new Symbol(Terminals.IF ,yyline, yycolumn); }
"else"		{ System.out.println("*** else"); return new Symbol(Terminals.ELSE ,yyline, yycolumn); }
"boolean"	{ System.out.println("*** boolean"); return new Symbol(Terminals.BOOLEAN ,yyline, yycolumn); }
"case"		{ System.out.println("*** case"); return new Symbol(Terminals.CASE ,yyline, yycolumn); }
"default"	{ System.out.println("*** default"); return new Symbol(Terminals.DEFAULT ,yyline, yycolumn); }
"do"		{ System.out.println("*** do"); return new Symbol(Terminals.DO ,yyline, yycolumn); }
"return"	{ System.out.println("*** return"); return new Symbol(Terminals.RETURN ,yyline, yycolumn); }
"struct"	{ System.out.println("*** struct"); return new Symbol(Terminals.STRUCT ,yyline, yycolumn); }
"switch"	{ System.out.println("*** switch"); return new Symbol(Terminals.SWITCH ,yyline, yycolumn); }
"while"		{ System.out.println("*** while"); return new Symbol(Terminals.WHILE ,yyline, yycolumn); }
"type"		{ System.out.println("*** type"); return new Symbol(Terminals.TYPE ,yyline, yycolumn); }
"new"		{ System.out.println("*** new"); return new Symbol(Terminals.NEW ,yyline, yycolumn); }
"dispose"	{ System.out.println("*** dispose"); return new Symbol(Terminals.DISPOSE ,yyline, yycolumn); }
"println"	{ System.out.println("*** println"); return new Symbol(Terminals.PRINTLN ,yyline, yycolumn); }
"readln"	{ System.out.println("*** readln"); return new Symbol(Terminals.READLN ,yyline, yycolumn); }
"array"		{ System.out.println("*** array"); return new Symbol(Terminals.ARRAY ,yyline, yycolumn); }
"of"		{ System.out.println("*** of"); return new Symbol(Terminals.OF ,yyline, yycolumn); }
"var"		{ System.out.println("*** var"); return new Symbol(Terminals.VAR ,yyline, yycolumn); }
"procedure"	{ System.out.println("*** procedure"); return new Symbol(Terminals.PROCEDURE ,yyline, yycolumn); }
"function"	{ System.out.println("*** function"); return new Symbol(Terminals.FUNCTION ,yyline, yycolumn); }
"then" 		{ System.out.println("*** then"); return new Symbol(Terminals.THEN, yyline, yycolumn); }
"begin"		{ System.out.println("*** begin"); return new Symbol(Terminals.BEGIN ,yyline, yycolumn); }
"end"		{ System.out.println("*** end"); return new Symbol(Terminals.END ,yyline, yycolumn); }
"integer"  	{ System.out.println("*** integer"); return new Symbol(Terminals.INTEGER ,yyline, yycolumn); }
"string"  	{ System.out.println("*** string"); return new Symbol(Terminals.STRING ,yyline, yycolumn); }


//OPERATORS
"="		{ System.out.println("*** ="); return new Symbol(Terminals.EQUALS, yyline, yycolumn); }
"^" 	{ System.out.println("*** ^"); return new Symbol(Terminals.CIRC, yyline, yycolumn); }
"+" 	{ System.out.println("*** +"); return new Symbol(Terminals.PLUS, yyline, yycolumn); }
"-" 	{ System.out.println("*** -"); return new Symbol(Terminals.MINUS, yyline, yycolumn); }
"*"		{ System.out.println("*** *"); return new Symbol(Terminals.TIMES, yyline, yycolumn); }
"/"		{ System.out.println("*** /"); return new Symbol(Terminals.DIVIDE, yyline, yycolumn); }
"!" 	{ System.out.println("*** !"); return new Symbol(Terminals.NOT, yyline, yycolumn); }
"<" 	{ System.out.println("*** <"); return new Symbol(Terminals.LESS, yyline, yycolumn); }
">"		{ System.out.println("*** >"); return new Symbol(Terminals.MORE, yyline, yycolumn); }
"&&" 	{ System.out.println("*** &&"); return new Symbol(Terminals.AND, yyline, yycolumn); }
"||" 	{ System.out.println("*** ||"); return new Symbol(Terminals.OR, yyline, yycolumn); }
"!=" 	{ System.out.println("*** !="); return new Symbol(Terminals.DIFFERENT, yyline, yycolumn); }
"==" 	{ System.out.println("*** =="); return new Symbol(Terminals.LOGIC_EQ, yyline, yycolumn); }
"<=" 	{ System.out.println("*** <="); return new Symbol(Terminals.LESS_EQ, yyline, yycolumn); }
">=" 	{ System.out.println("*** >="); return new Symbol(Terminals.MORE_EQ, yyline, yycolumn); }

// PONCTUATION
","		{ System.out.println("*** ,"); return new Symbol(Terminals.COMMA , yyline, yycolumn); }
";"		{ System.out.println("*** ;"); return new Symbol(Terminals.SEMI , yyline, yycolumn); }
":"		{ System.out.println("*** :"); return new Symbol(Terminals.COLON , yyline, yycolumn); }
"("		{ System.out.println("*** ("); return new Symbol(Terminals.LPAR , yyline, yycolumn); }
")"		{ System.out.println("*** )"); return new Symbol(Terminals.RPAR , yyline, yycolumn); }
"["		{ System.out.println("*** ["); return new Symbol(Terminals.LBRA , yyline, yycolumn); }
"]"		{ System.out.println("*** ]"); return new Symbol(Terminals.RBRA , yyline, yycolumn); }
".."	{ System.out.println("*** .."); return new Symbol(Terminals.DOT , yyline, yycolumn); }
"{"		{ System.out.println("*** {"); return new Symbol(Terminals.LBRACE , yyline, yycolumn); }
"}"		{ System.out.println("*** }"); return new Symbol(Terminals.RBRACE , yyline, yycolumn); }

//LITERALS
"true" 			{ System.out.println("*** true"); return new Symbol(Terminals.TRUE, yyline, yycolumn); }
"false" 		{ System.out.println("*** false"); return new Symbol(Terminals.FALSE, yyline, yycolumn); }
"null" 			{ System.out.println("*** null"); return new Symbol(Terminals.NULL, yyline, yycolumn); }
{Identifier} 	{ System.out.println("*** ID : " + yytext()); return new Symbol(Terminals.IDENTIFIER, yyline, yycolumn, yytext()); }
{Integer}		{ System.out.println("*** INT : " + yytext()); return new Symbol(Terminals.LIT_INTEGER, yyline, yycolumn, new Integer(yytext())); }
{Hexa} 	        { System.out.println("*** HEXA : " + yytext()); return new Symbol(Terminals.LIT_INTEGER, yyline, yycolumn, new Integer(Integer.decode(yytext()))); }
{String} 		{ System.out.println("*** STR : " + yytext()); return new Symbol(Terminals.LIT_STRING, yyline, yycolumn, new String(yytext())); }

// COMMENTARY
{Commentary} { }

[^]|\n 		{}