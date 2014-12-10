package jp.co.mra.ecodsl.exp;
import java.util.ArrayList;

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
 * AST node for a list of expressions.
 * 
 * The interpretation of a list of expressions stores the
 * results of the expressions in an array that can be used
 * as parameter list for function calls.
 */ 
public class Texplist extends Texp implements AST {

	Texp exp;                   // expression of this list node
	Texplist explist;           // next list element (optional null)

	public Texplist getExplist() {
		return explist;
	}

	public Texp getExp() {
		return exp;
	}

//	public Texplist(Texplist p, Texp e) {
//		explist = p;
//		exp = e;
//	}
//
	public Texplist(Texp e, Texplist p) {
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
			return  exp + ", "+ explist;
		else 
			return exp.toString() + "]";
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
	
	public Texp binop(Texp val2, char f) throws Exception {
		if (val2.getClass().equals(Tvalue.class)) {				//	相手が単数だった場合
//			Texplist vl = (Texplist)val1;
			if (exp == null) {		//	自分が空リストの場合
				return this;
			} else {
				if (explist == null) {	//	要素が一つの場合
					return new Texplist(exp.binop(val2,  f));
				} else {				//	要素が二つ以上の場合
					return new Texplist(explist.binop(val2, f), (Texplist)explist.binop(val2, f));
//					return new Texplist((Texplist)operate(vl.getTail(), val2, f), operate(vl.getHead(), val2, f));
				}
			}
		} else {	//	相手がリストの場合
			Texplist v2 = (Texplist)val2;
			if (exp == null) {		//	自分が空リストの場合
				if (v2.getHead() == null) {		//	相手も空リストの場合
					return this;
				} else {
					throw new Exception("配列の要素数が異なっています");
				}
			} else {	//	自分が空リストでない場合
				if (v2.getHead() == null) {	//	相手が空リストの場合
					throw new Exception("配列の要素数が異なっています");
				} else if (explist == null) {	//	要素が一つの場合
					if (v2.getTail() != null) {
						throw new Exception("配列の要素数が異なっています");
					} else {
						return new Texplist(exp.binop(v2.getHead(), f));
					}
				} else {						//	要素が二つ以上の場合
					return new Texplist(exp.binop(v2.getHead(), f), (Texplist)explist.binop(v2.getTail(), f));
//					return new Texplist((Texplist)operate(v1.getTail(), v2.getTail(), f), operate(v1.getHead(), v2.getHead(), f));
				}
			}
		}
	}
	
	public Texp interpret(SymTab st) throws Exception {
		Texp obj = exp.interpret(st);
		Texp others = null; 
		if (explist != null) {
			others = explist.interpret(st);
		}
		return new Texplist(obj, (Texplist)others);
	}
}

