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
class Tindex extends Texp implements AST {
	private Integer n;             // value of the number

	public Tindex(String s) {
		try { 
			n = Integer.parseInt(s); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	public Tindex(Integer d) {
		n = d; 
	}

	public Integer getValue() {
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

