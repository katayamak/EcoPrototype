/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2001       Gerwin Klein <lsf@jflex.de>                    *
 * Copyright (C) 2001       Bernhard Rumpe <rumpe@in.tum.de>               *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


/**
 * AST node for function declarations.
 * 
 * Also contains a reference to the symbol table of 
 * the paramaters and their arity.
 */ 
class Tope implements AST {
	Tlet let;
	Tifthenelse ifthenelse;

	public Tope(Tlet l) {
		let = l;
	}

	public Tope(Tifthenelse i) {
		ifthenelse = i;
	}

	public String toString() {
		if (let != null) {
			return(let.toString());
		} else {
			return(ifthenelse.toString());
		}
	}

	SymTab params;              // symbol table of the parameters 
	int arity;                  

	public void setSymtab(SymTab st) {
	}

	public void printSymtabs(SymTab st) {
	}

	public void checkcontext(SymTab st) {        
		if (let != null) {
			let.checkcontext(st);
		} else {
			ifthenelse.checkcontext(st);
		}
	}

	public void prepInterp(SymTab st) {   // set pointers and indices
		if (let != null) {
			let.prepInterp(st);
		} else {
			ifthenelse.prepInterp(st);
		}
	}

	public SymTab interpret(SymTab st) throws Exception {
		if (let != null) {
			return let.interpret(st);
		} else if (ifthenelse != null) {
			return ifthenelse.interpret(st);
		}
		return st;
	}
}

