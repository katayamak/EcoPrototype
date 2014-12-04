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
class Tlet implements AST {
	Tident ident;               // identifier
	Texp exp;                   // function body

	private Texp convertIfList(Texp e) {
		if (e.getClass().equals(Texplist.class)) {
			return ((Texplist)e).getExpArray();
		}
		return e;
	}
	
	public Tlet(Tident i, Texp e) {
		ident = i;
		
		exp = e; //convertIfList(e);
	}
	
	public Tlet(Texp e) {		//	Console out
		ident = null;
		exp = e; //convertIfList(e);
	}

	public String toString() {
		if (ident == null) {
			return ("console out " + exp);
		} else {
			return (ident + " = " + exp);
		}
	}

	SymTab params;              // symbol table of the parameters 
	//  int arity;                  

	public void setSymtab(SymTab st) throws Exception {
		params = new SymTab(st);
		params.enter(ident.name, new STEvar(ident.name, exp.interpret(st)));
		//    parlist.setSymtab(params,false,0);
		//    arity = params.size();

		//    boolean isNew = st.enter(ident.toString(),
		//                             new STEfun(ident.toString(),this,arity));
		// CoCo (Fun)
		//    if(!isNew) Main.error("funktion "+ident+" defined twice!");
	}

	public void printSymtabs() {
		//   System.out.print("funktion "+ident.toString()+"\n"+params); 
	}


	public void checkcontext(SymTab st) {        
		if (ident != null) 
			ident.checkcontext(st);         // CoCo (DefFun,DefVar,Arity)
	}

	public void prepInterp(SymTab st) {   // set pointers and indices
		exp.prepInterp(st);
	}

	public SymTab interpret(SymTab st) throws Exception {
		if (ident == null) {
			String name = "";
			if (exp.getClass().equals(Tident.class)) {
				name = "(" + ((Tident)exp).name + ")  ";
			}
			System.out.println("ConOut : " + name + exp.interpret(st).toString());
			return st;
		} else {
			SymTab newWorld = new SymTab(st);
			newWorld.enter(ident.name, new STEvar(ident.name, exp.interpret(st)));
			return newWorld;
		}
	}
}

