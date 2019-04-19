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
Decimal 	= ({Integer}(\.{Integer})?)|(\.{Integer})
Lit_Integer = {Hexa}|{Integer}|{Decimal}

Commentary 	= \/\*~(\*\/)|\/\/.*

%%
//KEYWORD
"if"		{ return new Symbol(Terminals.IF ,yyline, yycolumn); }
"else"		{ return new Symbol(Terminals.ELSE ,yyline, yycolumn); }
"boolean"	{ return new Symbol(Terminals.BOOLEAN ,yyline, yycolumn); }
"case"		{ return new Symbol(Terminals.CASE ,yyline, yycolumn); }
"default"	{ return new Symbol(Terminals.DEFAULT ,yyline, yycolumn); }
"do"		{ return new Symbol(Terminals.DO ,yyline, yycolumn); }
"return"	{ return new Symbol(Terminals.RETURN ,yyline, yycolumn); }
"struct"	{ return new Symbol(Terminals.STRUCT ,yyline, yycolumn); }
"switch"	{ return new Symbol(Terminals.SWITCH ,yyline, yycolumn); }
"while"		{ return new Symbol(Terminals.WHILE ,yyline, yycolumn); }
"type"		{ return new Symbol(Terminals.TYPE ,yyline, yycolumn); }
"new"		{ return new Symbol(Terminals.NEW ,yyline, yycolumn); }
"dispose"	{ return new Symbol(Terminals.DISPOSE ,yyline, yycolumn); }
"println"	{ return new Symbol(Terminals.PRINTLN ,yyline, yycolumn); }
"readln"	{ return new Symbol(Terminals.READLN ,yyline, yycolumn); }
"array"		{ return new Symbol(Terminals.ARRAY ,yyline, yycolumn); }
"of"		{ return new Symbol(Terminals.OF ,yyline, yycolumn); }
"var"		{ return new Symbol(Terminals.VAR ,yyline, yycolumn); }
"procedure"	{ return new Symbol(Terminals.PROCEDURE ,yyline, yycolumn); }
"function"	{ return new Symbol(Terminals.FUNCTION ,yyline, yycolumn); }
"begin"		{ return new Symbol(Terminals.BEGIN ,yyline, yycolumn); }
"end"		{ return new Symbol(Terminals.END ,yyline, yycolumn); }
"integer"  	{ return new Symbol(Terminals.INTEGER ,yyline, yycolumn); }
"string"  	{ return new Symbol(Terminals.STRING ,yyline, yycolumn); }


//OPERATORS
"="		{ return new Symbol(Terminals.EQUALS, yyline, yycolumn); }
"^" 	{ return new Symbol(Terminals.CIRC, yyline, yycolumn); }
"+" 	{ return new Symbol(Terminals.PLUS, yyline, yycolumn); }
"-" 	{ return new Symbol(Terminals.MINUS, yyline, yycolumn); }
"*"		{ return new Symbol(Terminals.TIMES, yyline, yycolumn); }
"/"		{ return new Symbol(Terminals.DIVIDE, yyline, yycolumn); }
"!" 	{ return new Symbol(Terminals.NOT, yyline, yycolumn); }
"<" 	{ return new Symbol(Terminals.LESS, yyline, yycolumn); }
">"		{ return new Symbol(Terminals.MORE, yyline, yycolumn); }
"&&" 	{ return new Symbol(Terminals.AND, yyline, yycolumn); }
"||" 	{ return new Symbol(Terminals.OR, yyline, yycolumn); }
"!=" 	{ return new Symbol(Terminals.DIFFERENT, yyline, yycolumn); }
"==" 	{ return new Symbol(Terminals.LOGIC_EQ, yyline, yycolumn); }
"<=" 	{ return new Symbol(Terminals.LESS_EQ, yyline, yycolumn); }
">=" 	{ return new Symbol(Terminals.MORE_EQ, yyline, yycolumn); }

// PONCTUATION
","		{ return new Symbol(Terminals.COMMA , yyline, yycolumn); }
";"		{ return new Symbol(Terminals.SEMI , yyline, yycolumn); }
":"		{ return new Symbol(Terminals.COLON , yyline, yycolumn); }
"("		{ return new Symbol(Terminals.LPAR , yyline, yycolumn); }
")"		{ return new Symbol(Terminals.RPAR , yyline, yycolumn); }
"["		{ return new Symbol(Terminals.LBRA , yyline, yycolumn); }
"]"		{ return new Symbol(Terminals.RBRA , yyline, yycolumn); }
".."	{ return new Symbol(Terminals.DOT , yyline, yycolumn); }
"{"		{ return new Symbol(Terminals.LBRACE , yyline, yycolumn); }
"}"		{ return new Symbol(Terminals.RBRACE , yyline, yycolumn); }

//LITERALS
"true" 			{ return new Symbol(Terminals.TRUE, yyline, yycolumn); }
"false" 		{ return new Symbol(Terminals.FALSE, yyline, yycolumn); }
"null" 			{ return new Symbol(Terminals.NULL, yyline, yycolumn); }
{Identifier} 	{ return new Symbol(Terminals.IDENTIFIER, yyline, yycolumn, yytext()); }
{Lit_Integer} 	{ return new Symbol(Terminals.LIT_INTEGER, yyline, yycolumn, new Integer(yytext())); }
{String} 		{ return new Symbol(Terminals.LIT_STRING, yyline, yycolumn, new String(yytext())); }

// COMMENTARY
{Commentary} { }

[^]|\n 		{}