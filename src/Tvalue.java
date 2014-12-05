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

	public static double calc (double a, double b, char f) {
		switch (f) {
		case '+': return a + b;
		case '-': return a - b;
		case '*': return a * b;
		case '/': return a / b;
		}
		return 0.0;
	}

	public Texp binop(Texp val, char f) {
		Double dvalue1 = n;
		if (val.getClass().equals(Tvalue.class)) {
			return new Tvalue(calc(dvalue1, ((Tvalue)val).getValue(), f));
		} else if (val.getClass().equals(Tindex.class)) {
			return new Tvalue(calc(dvalue1, ((Tindex)val).getValue().doubleValue(), f));
		} else if (val.getClass().equals(Tstring.class)) {
			return new Tstring(dvalue1.toString() + val.toString());
		} else {
			Texplist vl = (Texplist)val;
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

