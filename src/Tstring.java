/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2001       Gerwin Klein <lsf@jflex.de>                    *
 * Copyright (C) 2001       Bernhard Rumpe <rumpe@in.tum.de>               *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


/**
 * AST node for a number
 */ 
class Tstring extends Texp implements AST {
	String s;             // value of the number

	public Tstring(String s) {
		try { 
			this.s = s; 
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public String toString() {
		return (s); 
	}

	public void checkcontext(SymTab st) { 
	}

	public void prepInterp(SymTab st) { 
	}

	public Texp interpret(SymTab st) {
		return this;
	}
}

