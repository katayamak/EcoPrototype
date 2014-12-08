package jp.co.mra.ecodsl.command;
import jp.co.mra.ecodsl.base.AST;
import jp.co.mra.ecodsl.base.SymTab;


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
public class Tope implements AST {
	Tlet let;
	Tifthenelse ifthenelse;
	Tprewhile prewhile;
	Tpostwhile postwhile;
	
	public Tope(Tlet l) {
		let = l;
	}

	public Tope(Tifthenelse i) {
		ifthenelse = i;
	}

	public Tope(Tprewhile w) {
		prewhile = w;
	}

	public Tope(Tpostwhile w) {
		postwhile = w;
	}
	
	public String toString() {
		if (let != null) {
			return(let.toString());
		} else if (ifthenelse != null) {
			return(ifthenelse.toString());
		} else if (prewhile != null) {
			return(prewhile.toString());
		} else if (postwhile != null) {
			return(postwhile.toString());
		}
		return "";
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
		} else if (ifthenelse != null) {
			ifthenelse.checkcontext(st);
		} else if (prewhile != null) {
			prewhile.checkcontext(st);
		} else if (postwhile != null) {
			postwhile.checkcontext(st);
		}
	}

	public void prepInterp(SymTab st) {   // set pointers and indices
		if (let != null) {
			let.prepInterp(st);
		} else if (ifthenelse != null) {
			ifthenelse.prepInterp(st);
		} else if (prewhile != null) {
			prewhile.prepInterp(st);
		} else if (postwhile != null) {
			postwhile.prepInterp(st);
		}
	}

	public SymTab interpret(SymTab st) throws Exception {
		if (let != null) {
			return let.interpret(st);
		} else if (ifthenelse != null) {
			return ifthenelse.interpret(st);
		} else if (prewhile != null) {
			return prewhile.interpret(st);
		} else if (postwhile != null) {
			return postwhile.interpret(st);
		}
		return st;
	}
}

