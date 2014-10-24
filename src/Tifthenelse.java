/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2001       Gerwin Klein <lsf@jflex.de>                    *
 * Copyright (C) 2001       Bernhard Rumpe <rumpe@in.tum.de>               *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


/**
 * AST node for if-then-else expressions
 */ 
class Tifthenelse implements AST {
	Tboolexp boolexp;           // condition
	Topelist ol1, ol2;            // then and else branch

	public Tifthenelse(Tboolexp b, Topelist e1, Topelist e2) {
		boolexp = b;
		ol1 = e1;
		ol2 = e2;
	}
	public Tifthenelse(Tboolexp b, Topelist e1) {
		boolexp = b;
		ol1 = e1;
		ol2 = null;
	}

	public String toString() {
		return "if " + boolexp + " then "+ ol1 + " else " + ol2 + " endif"; 
	}

	public void checkcontext(SymTab st) {
		boolexp.checkcontext(st);
		ol1.checkcontext(st);
		ol2.checkcontext(st);
	}

	public void prepInterp(SymTab st) {
		boolexp.prepInterp(st);
		ol1.prepInterp(st);
		ol2.prepInterp(st);
	}

	
	public SymTab interpret(SymTab st) throws Exception {
		Tboolexp b = boolexp.interpret(st);
		if (b.getValue()) 
			return ol1.interpret(st);
		else 
			return ol2.interpret(st);
	}
}

