/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2001       Gerwin Klein <lsf@jflex.de>                    *
 * Copyright (C) 2001       Bernhard Rumpe <rumpe@in.tum.de>               *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


/**
 * AST node for declaration lists of functions
 */ 
class Topelist implements AST {
	Topelist opelist;         // rest list (optional null)
	Tope ope;                 // declaration

	public Topelist(Topelist p, Tope e) {
		opelist = p;
		ope = e;
	}

	public Topelist(Tope e) {
		opelist = null;
		ope = e;
	}

	public String toString() {
		if (opelist != null) 
			return (opelist + ",\n" + ope);
		else 
			return (ope.toString());
	}

	public void setSymtab(SymTab st) {
		if (opelist != null) 
			opelist.setSymtab(st);
		ope.setSymtab(st);
	}

	public void printSymtabs(SymTab st) {
		if (opelist != null) 
			opelist.printSymtabs(st);
		ope.printSymtabs(st);
	}

	public void checkcontext(SymTab st) {
		if (opelist != null) 
			opelist.checkcontext(st);    
		ope.checkcontext(st);              // CoCo (DefFun,DefVar,Arity)
	}                                   // in function body

	
	public void prepInterp(SymTab st) {  // set pointers and indices
		ope.prepInterp(st);
		if (opelist != null) opelist.prepInterp(st);
	}

	public int length() {
		if (opelist!=null) 
			return 1 + opelist.length();
		else 
			return 1;
	}

	public SymTab interpret(SymTab st) throws Exception {    
		SymTab newWorld = st;
		if (opelist != null) {
			newWorld = opelist.interpret(st);
		}
		return ope.interpret(newWorld);
	}
}

