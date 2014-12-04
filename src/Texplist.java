import java.util.ArrayList;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2001       Gerwin Klein <lsf@jflex.de>                    *
 * Copyright (C) 2001       Bernhard Rumpe <rumpe@in.tum.de>               *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


/**
 * AST node for a list of expressions.
 * 
 * The interpretation of a list of expressions stores the
 * results of the expressions in an array that can be used
 * as parameter list for function calls.
 */ 
class Texplist extends Texp implements AST {

	Texp exp;                   // expression of this list node
	Texplist explist;           // next list element (optional null)

	public Texplist getExplist() {
		return explist;
	}

	public Texp getExp() {
		return exp;
	}

	public Texplist(Texplist p, Texp e) {
		explist = p;
		exp = e;
	}

	public Texplist(Texp e) {
		explist = null;
		exp = e;
	}

	public Texplist() {
		explist = null;
		exp = null;
	}

	public TexpArray getExpArray() {
		return new TexpArray(this);
	}

	
	
	public Texplist(Texplist p) {
		explist = p.getExplist();
		exp = p.getExp();
	}
	
	public Texplist getTail() {
		return explist;
	}

	public Texp getHead() {
		return exp;
	}

	public String toString() {
		if (explist != null)
			return explist + ", " + exp;
		else 
			return "[" + exp.toString();
	}

	public void checkcontext(SymTab st) {
		if (explist != null) 
			explist.checkcontext(st);
		exp.checkcontext(st);             // CoCo (DefFun,DefVar,Arity)
	}                                   // in expression

	public int length() {
		if (explist != null) 
			return 1 + explist.length();
		else 
			return 1;
	}

	public void prepInterp(SymTab st) {  // set pointers and indices
		exp.prepInterp(st);
		if (explist != null) explist.prepInterp(st);
	}

	public Texp interpret(SymTab st) throws Exception {
		Texp obj = exp.interpret(st);
		Texp others = null; 
		if (explist != null) {
			others = explist.interpret(st);
		}
		return new Texplist((Texplist)others, obj);
	}
}

