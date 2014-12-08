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
public class TexpArray extends Texp implements AST {
	ArrayList<Texp> ar = new ArrayList<Texp>();
	
	public TexpArray(Texplist list) {
		
		Texplist tail = list;
		Texp head = list.getHead();
		while (head != null) {
			if (head.getClass().equals(Texplist.class)) {
				head = new TexpArray(((Texplist)head));
			}
			ar.add(head);
			tail = tail.getTail();
			if (tail != null) {
				head = tail.getHead();
			} else {
				head = null;
			}
		}
	}

	public TexpArray(ArrayList<Texp> ar) {
		this.ar = ar;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		for (Texp item : ar) {
			sb.append(item.toString() + ", ");
		}
		sb.append("]");
		return sb.toString();
	}

	public void checkcontext(SymTab st) {
		for (Texp item : ar) {
			item.checkcontext(st);
		}
	}                                   // in expression

	public int length() {
		return ar.size();
	}

	public Texp get(int index) {
		return ar.get(index);
	}

	public void prepInterp(SymTab st) {  // set pointers and indices
		for (Texp item : ar) {
			item.prepInterp(st);
		}
	}
	
	public Texp binop(Texp val2, char f) throws Exception {
		if (val2.getClass().equals(TexpArray.class)) {				//	相手が配列だった場合
			TexpArray v2ar = (TexpArray)val2;
			if (ar.size() != v2ar.length()) {
				throw new Exception("配列の要素数が異なっています");
			}
			ArrayList<Texp> nextAr = new ArrayList<Texp>();
			for (int i = 0; i < ar.size(); i++) {
				nextAr.add(ar.get(i).binop(v2ar.get(i), f));
			}
			return new TexpArray(nextAr);
		} else {
//			if (val2.getClass().equals(Tvalue.class)) {				//	相手が単数だった場合
				ArrayList<Texp> nextAr = new ArrayList<Texp>();
				for (int i = 0; i < ar.size(); i++) {
					nextAr.add(ar.get(i).binop(val2, f));
				}
				return new TexpArray(nextAr);
//			} 			
		}
	}

	public Texp interpret(SymTab st) throws Exception {
		ArrayList<Texp> newAr = new ArrayList<Texp>();
		for (Texp item : ar) {
			Texp newexp = item.interpret(st);
			newAr.add(newexp);
		}
		return new TexpArray(newAr);
	}
}

