package jp.co.mra.ecodsl.exp;
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
 * AST node for a number
 */ 
public class Tstring extends Texp implements AST {
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
	
	public Texp binop(Texp val2, char f) {
		String svalue1 = s;
		if (val2.getClass().equals(Tstring.class)) {
			return new Tstring(svalue1 + val2.toString());
		} else if (val2.getClass().equals(Tvalue.class)) {
			return new Tstring(svalue1 + val2.toString());
		} else if (val2.getClass().equals(Tindex.class)) {
			return new Tstring(svalue1 + val2.toString());
		} else {
			Texplist vl = (Texplist)val2;
			if (vl.getHead() == null) {
				return vl;
			} else {
				if (vl.getTail() == null) {
					return new Texplist(binop(vl.getHead(), f));
				} else {
					return new Texplist((Texplist)binop(vl.getTail(), f), binop(vl.getHead(), f));
				}
			}
		}
	}
	
	public Texp interpret(SymTab st) {
		return this;
	}
}

