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
class Tboolexp extends Texp implements AST {
	private Boolean n = null;             // value of the number
	private Texp e1 = null; 
	private Texp e2 = null; 
	private Tboolexp b1 = null; 
	private Tboolexp b2 = null; 
	private char op; 
	public static Tboolexp truevalue = new Tboolexp(true);
	public static Tboolexp falsevalue = new Tboolexp(false);
	

	public Tboolexp(String s) {
		n = Boolean.parseBoolean(s); 
	}
	
	public Tboolexp(Boolean d) {
		n = d; 
	}

	public Tboolexp(Texp v1, char kind, Texp v2) {
		e1 = v1;
		e2 = v2;
		op = kind;
	}
	public Tboolexp(Tboolexp v1, char kind, Tboolexp v2) {
		b1 = v1;
		b2 = v2;
		op = kind;
	}

	public Boolean getValue() {
		return n;
	}

	public String toString() {
		return("" + n); 
	}

	public void checkcontext(SymTab st) { 
	}

	public void prepInterp(SymTab st) { 
	}

	private boolean isBadType(Texp e1, Texp e2) throws Exception {
		if (!e1.getClass().equals(e2.getClass())) {
			return true;
		}
		if (e1.getClass().equals(Texplist.class)) {
			throw new Exception("行列同士の大小比較演算は定義されていません。");
		}
		if (e2.getClass().equals(Tstring.class)) {
			throw new Exception("文字列同士の大小比較演算は定義されていません。");
		}
		return false;
	}
	
	public Tboolexp interpret(SymTab st) throws Exception {
		Texp e1x = e1.interpret(st);
		Texp e2x = e2.interpret(st);
		switch (op) {
		case '=':
			if (!e1x.getClass().equals(e2x.getClass())) {
				return falsevalue;
			}
			if (!e1x.toString().equals(e2x.toString())) {
				return falsevalue;
			}
			return truevalue;
		case '<':
			if (isBadType(e1x, e2x)) {
				return falsevalue;
			}
			if (((Tvalue)e1x).getValue() < ((Tvalue)e2x).getValue()) {
				return truevalue;
			}
			return falsevalue;
		case '!':   // <=
			if (isBadType(e1x, e2x)) {
				return falsevalue;
			}
			if (((Tvalue)e1x).getValue() <= ((Tvalue)e2x).getValue()) {
				return truevalue;
			}
			return falsevalue;
		case '>':
			if (isBadType(e1x, e2x)) {
				return falsevalue;
			}
			if (((Tvalue)e1x).getValue() > ((Tvalue)e2x).getValue()) {
				return truevalue;
			}
			return falsevalue;
		case '$':	// >=
			if (isBadType(e1x, e2x)) {
				return falsevalue;
			}
			if (((Tvalue)e1x).getValue() >= ((Tvalue)e2x).getValue()) {
				return truevalue;
			}
			return falsevalue;
		case '&':	// AND
			if (!e1x.getClass().equals(Tboolexp.class) || !e2x.getClass().equals(Tboolexp.class)) {
				throw new Exception("and演算にはbool型が必要です。");
			}
			if (((Tboolexp)e1x).getValue() && ((Tboolexp)e2x).getValue()) {
				return truevalue;
			} else {
				return falsevalue;
			}
		case '|':	//	OR
			if (!e1x.getClass().equals(Tboolexp.class) || !e2x.getClass().equals(Tboolexp.class)) {
				throw new Exception("or演算にはbool型が必要です。");
			}
			if (((Tboolexp)e1x).getValue() || ((Tboolexp)e2x).getValue()) {
				return truevalue;
			} else {
				return falsevalue;
			}
			}
		return this;
	}
}

