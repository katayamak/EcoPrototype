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
class Tvalue extends Texp implements AST {
	private Double n;             // value of the number

	public Tvalue(String s) {
		try { 
			n = Double.parseDouble(s); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	public Tvalue(Double d) {
		n = d; 
	}

	public Double getValue() {
		return n;
	}

	public String toString() {
		return("" + n); 
	}

	public void checkcontext(SymTab st) { 
	}

	public void prepInterp(SymTab st) { 
	}

	public Texp interpret(SymTab st) {
		return this;
	}
}

