/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2001       Gerwin Klein <lsf@jflex.de>                    *
 * Copyright (C) 2001       Bernhard Rumpe <rumpe@in.tum.de>               *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


/**
 * AST node for infix expressions
 */ 
class Texpinfix extends Texp implements AST {
	Texp exp1, exp2;            // left and right sub expression
	char kind;                  // kind ('+', '-', '*', '/')

	public Texpinfix(Texp e1, char k, Texp e2) {
		exp1 = e1;
		kind = k;
		exp2 = e2;
	}

	public String toString() {
		return("(" + exp1 + kind + exp2 + ")"); 
	}

	public void checkcontext(SymTab st) { // context conditions
		exp1.checkcontext(st);
		exp2.checkcontext(st);
	}

	public void prepInterp(SymTab st) {  // set pointers und indices
		exp1.prepInterp(st);
		exp2.prepInterp(st);
	}

	@FunctionalInterface
	private interface BinOp {
		public Double apply(Double a, Double b);
	}

	private Texp operate(Texp val1, Texp val2, BinOp f) throws Exception
	{
		if (val1 == null && val2 == null) {
			return null;
		} else if (val1 == null || val2 == null) {
			throw new Exception ("配列の要素数が異なっています");
		} 
		if ((val1.getClass().equals(Tstring.class) || val2.getClass().equals(Tstring.class)) && f.apply(1.0, 1.0) != 2.0) {	//	文字列は＋のみ許可
			throw new Exception ("文字列は加算のみ可能です");
		}
		
		
		if (val1.getClass().equals(Tvalue.class)) {
			Double dvalue1 = ((Tvalue)val1).getValue();
			if (val2.getClass().equals(Tvalue.class)) {
				return new Tvalue(f.apply(dvalue1, ((Tvalue)val2).getValue()));
			} else if (val2.getClass().equals(Tstring.class)) {
				return new Tstring(dvalue1.toString() + val2.toString());
			} else {
				Texplist vl = (Texplist)val2;
				if (vl.getHead() == null) {
					return vl;
				} else {
					if (vl.getTail() == null) {
						return new Texplist(operate(val1, vl.getHead(), f));
					} else {
						return new Texplist((Texplist)operate(val1, vl.getTail(), f), operate(val1, vl.getHead(), f));
					}
				}
			}
		} else if (val1.getClass().equals(Tstring.class)) {
			String svalue1 = val1.toString();
			if (val2.getClass().equals(Tstring.class)) {
				return new Tstring(svalue1 + val2.toString());
			} else if (val2.getClass().equals(Tvalue.class)) {
				return new Tstring(svalue1 + val2.toString());
			} else {
				Texplist vl = (Texplist)val2;
				if (vl.getHead() == null) {
					return vl;
				} else {
					if (vl.getTail() == null) {
						return new Texplist(operate(val1, vl.getHead(), f));
					} else {
						return new Texplist((Texplist)operate(val1, vl.getTail(), f), operate(val1, vl.getHead(), f));
					}
				}
			}
		} else {
			if (val2.getClass().equals(Tvalue.class)) {
				Texplist vl = (Texplist)val1;
				if (vl.getHead() == null) {
					return vl;
				} else {
					if (vl.getTail() == null) {
						return new Texplist(operate(vl.getHead(), val2,  f));
					} else {
						return new Texplist((Texplist)operate(vl.getTail(), val2, f), operate(vl.getHead(), val2, f));
					}
				}
			} else {
				Texplist v1 = (Texplist)val1;
				Texplist v2 = (Texplist)val2;
				if (v1.getHead() == null) {
					if (v2.getHead() == null) {
						return v1;
					} else {
						throw new Exception("配列の要素数が異なっています");
					}
				} else {
					if (v2.getHead() == null) {
						throw new Exception("配列の要素数が異なっています");
					} else {
						return new Texplist((Texplist)operate(v1.getTail(), v2.getTail(), f), operate(v1.getHead(), v2.getHead(), f));
					}
				}
			}
		}
	}


	public Texp interpret(SymTab st) throws Exception {    
		Texp e1 = exp1.interpret(st);
		Texp e2 = exp2.interpret(st);

		switch (kind) {
		case '+': return (operate(e1, e2, (a, b) -> a + b));
		case '-': return (operate(e1, e2, (a, b) -> a - b));
		case '*': return (operate(e1, e2, (a, b) -> a * b));
		case '/': return (operate(e1, e2, (a, b) -> a / b));
		}

		return new Tvalue(-1.0);        // error
	}
}


