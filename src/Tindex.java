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

	public Texp binop(Texp val2, char f) {
		Integer ivalue1 = n;
		if (val2.getClass().equals(Tvalue.class)) {
			return new Tvalue(Tvalue.calc(ivalue1.doubleValue(), ((Tvalue)val2).getValue(), f));
		} else if (val2.getClass().equals(Tindex.class)) {
			return new Tvalue(Tvalue.calc(ivalue1.doubleValue(), ((Tindex)val2).getValue().doubleValue(), f));
		} else if (val2.getClass().equals(Tstring.class)) {
			return new Tstring(ivalue1.toString() + val2.toString());
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

