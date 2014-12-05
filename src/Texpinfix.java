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

//	@FunctionalInterface
//	private interface DoubleBinOp {
//		public Double apply(Double a, Double b);
//	}
//
//	@FunctionalInterface
//	private interface IntBinOp {
//		public Double apply(Integer a, Integer b);
//	}
	
	private Texp operate(Texp val1, Texp val2, char f) throws Exception
	{
		if (val1 == null && val2 == null) {
			return null;
		} else if (val1 == null || val2 == null) {
			throw new Exception ("配列の要素数が異なっています");
		} 
		if ((val1.getClass().equals(Tstring.class) || val2.getClass().equals(Tstring.class)) && f != '+') {	//	文字列は＋のみ許可
			throw new Exception ("文字列は加算のみ可能です");
		}
		
		return val1.binop(val2, f);
	}

	public Texp binop(Texp val2, char f) throws Exception {
		throw new Exception("Illigal operation.");
	}

	public Texp interpret(SymTab st) throws Exception {    
		Texp e1 = exp1.interpret(st);
		Texp e2 = exp2.interpret(st);
		return (operate(e1, e2, kind));
		
//		switch (kind) {
//		case '+': return (operate(e1, e2, (a, b) -> a + b));
//		case '-': return (operate(e1, e2, (a, b) -> a - b));
//		case '*': return (operate(e1, e2, (a, b) -> a * b));
//		case '/': return (operate(e1, e2, (a, b) -> a / b));
//		}

//		return new Tvalue(-1.0);        // error
	}
}


