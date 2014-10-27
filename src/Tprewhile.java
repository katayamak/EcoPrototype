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
class Tprewhile implements AST {
	Tboolexp boolexp;               // 脱出条件
	Topelist ol;                   // function body

	public Tprewhile(Tboolexp b, Topelist ol) {
		this.boolexp = b;
		this.ol = ol;
	}

	public String toString() {
		return ("while (" + boolexp + ") {"+ ol + "}");
	}

	SymTab params;              // symbol table of the parameters 
	//  int arity;                  

	public void setSymtab(SymTab st) throws Exception {
//		params = new SymTab(st);
//		params.enter(ident.name, new STEvar(ident.name, exp.interpret(st)));
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
//		if (ident != null) 
//			ident.checkcontext(st);         // CoCo (DefFun,DefVar,Arity)
	}

	public void prepInterp(SymTab st) {   // set pointers and indices
//		exp.prepInterp(st);
	}

	public SymTab interpret(SymTab st) throws Exception {
		SymTab s = st;
		while (boolexp.interpret(s).getValue()) { 
			s = ol.interpret(s);
		}
		return s;
	}
}

