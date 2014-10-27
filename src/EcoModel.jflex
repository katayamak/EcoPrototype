/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2001       Gerwin Klein <lsf@jflex.de>                    *
 * Copyright (C) 2001       Bernhard Rumpe <rumpe@in.tum.de>               *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


import java_cup.runtime.Symbol;

%%

%class EcoModelScanner
%cup
%implements sym
%unicode

%line
%column

%{ 
  StringBuffer string = new StringBuffer();
  
  SymTab symtab;          // externe symbol table

  public void setSymtab(SymTab symtab) {
    this.symtab = symtab; 
  }

  private Symbol sym(int sym) {
    return new Symbol(sym);
  }

  private Symbol sym(int sym, Object val) {
    return new Symbol(sym, val);
  }
%}

%state STRING

%%
<YYINITIAL> {

	"con"           { return sym(CON); }
	"true"          { return sym(TRUE); }
	"false"         { return sym(FALSE); }
	"if"            { return sym(IF); }
	"then"          { return sym(THEN); }
	"else"          { return sym(ELSE); }
	"endif"         { return sym(ENDIF); }
	"while"         { return sym(WHILE); }
	"do"            { return sym(DO); }
	"wend"          { return sym(ENDWHILE); }
	"["             { return sym(LEFTB); }
	"]"             { return sym(RIGHTB); }
	"("             { return sym(LPAR); }
	")"             { return sym(RPAR); }
	","             { return sym(COMMA); }
	";"             { return sym(SEMICOLON); }
	"-"             { return sym(MINUS); }
	"+"             { return sym(PLUS); }
	"*"             { return sym(TIMES); }
	"/"             { return sym(DIV); }
	\"              { string.setLength(0); yybegin(STRING); } 
	"="             { return sym(EQ); }
	"<"             { return sym(LE); }
	"<="            { return sym(LEQ); }
	">"             { return sym(GE); }
	">="            { return sym(GEQ); }
	"&"             { return sym(AND); }
	"\|"            { return sym(OR); }
	\u{03a3}        { return sym(SIGMA); }
	[0-9]+(\.[0-9]+)?(E[+\-]?[0-9]+)?          
	                { return sym(VALUE,yytext()); }

	[a-z|A-Z|\u{0391}-\u{03c9}]+[0-9|a-z|A-Z|\u{0391}-\u{03c9}]*          
	                { symtab.enter(yytext(),new SymtabEntry(yytext()));
	                  return sym(ID,yytext()); }

	\u{2190}        { symtab.enter(yytext(),new SymtabEntry(yytext()));
	                  return sym(LET); }
	[\ \t\b\f\r\n]+ { /* eat whitespace */ }
	"//"[^\n]*      { /* one-line comment */ }
	.               { throw new Error("Unexpected character ["+yytext()+"]"); }
}


<STRING> {
  \"                             { yybegin(YYINITIAL); return sym(STRINGLITERAL, string.toString()); }
  [^\n\r\"\\]+                   { string.append( yytext() ); }
  \\t                            { string.append('\t'); }
  \\n                            { string.append('\n'); }
  \\r                            { string.append('\r'); }
  \\\"                           { string.append('\"'); }
  \\\\                           { string.append('\\'); }
}


