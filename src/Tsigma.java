/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2001       Gerwin Klein <lsf@jflex.de>                    *
 * Copyright (C) 2001       Bernhard Rumpe <rumpe@in.tum.de>               *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


/**
 * AST node for function declarations.
 * 
 * Also contains a reference to the symbol table of 
 * the paramaters and their arity.
 */ 
class Tsigma extends Texp implements AST {
	Texp exp;                   // function body

	public Tsigma(Texp e) {
		exp = e;
	}

	public String toString() {
		return "Σ(" + exp.toString() + ")";
	}

	//  SymTab params;              // symbol table of the parameters 

	public void setSymtab(SymTab st) {
		//    params = new SymTab(st);
		//    parlist.setSymtab(params,false,0);

		//    boolean isNew = st.enter(ident.toString(),
		//                             new STEfun(ident.toString(),this,arity));
		// CoCo (Fun)
		//    if(!isNew) Main.error("funktion "+ident+" defined twice!");
	}

	public void printSymtabs() {
		//    System.out.print("funktion "+ident.toString()+"\n"+params); 
	}

	@Override
	public void checkcontext(SymTab st) {
		// TODO Auto-generated method stub
		
	}

	public void prepInterp(SymTab st) {   // set pointers and indices
		//   exp.prepInterp(params);
	}

	public Texp sumUp(Texplist v) {
		if (v.getHead() == null) {
			return null;
		} else if (v.getHead().getClass().equals(Tvalue.class)) {
			Tvalue hv = (Tvalue)(v.getHead());
			if (v.getTail() == null) {
				return hv;
			} else {
				return new Tvalue(hv.getValue() + ((Tvalue)(sumUp(v.getTail()))).getValue());
			}
		} else {
			Texplist hv = (Texplist)sumUp((Texplist)(v.getHead()));
			if (v.getTail() == null) {
				return new Texplist(hv, null);
			} else {
				return new Texplist(hv, sumUp(v.getTail()));
			}
		}
	}
	
	public Texp binop(Texp val2, char f) throws Exception {
		throw new Exception("Illigal operation.");
	}
	
	public Texp interpret(SymTab st) throws Exception {
		Texp v = exp.interpret(st);
		if (v == null) {
			return null;
		} else if (v.getClass().equals(Tvalue.class)) {
			return v;
		} else {
			return sumUp((Texplist)v);
		}
	}

	//  public int arity() { return(arity); }
}

