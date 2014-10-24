/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2001       Gerwin Klein <lsf@jflex.de>                    *
 * Copyright (C) 2001       Bernhard Rumpe <rumpe@in.tum.de>               *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


/**
 * AST node for an identifier
 */ 
class Tident extends Texp implements AST {
	String name;                

	public Tident(String s) {
		name = s; 
	}

	public String toString() {
		return name; 
	}

	public void checkcontext(SymTab st) {         // CoCo (DefVar)
//		SymtabEntry ste = st.lookup(name);
//
//		if (ste == null)
//			Main.error("variable not defined: " + name);
	}

	int index;              // number of ident in environment
	boolean is_input;       // is it an input variable?    

	public void prepInterp(SymTab st) {  // set index for environment 
//		STEvar ste = (STEvar)st.lookup(name);
//		Object = ste.getIndex();
	}

	public Texp interpret(SymTab st) {
		STEvar ste = (STEvar)st.lookup(name);
//		Texp v = null;
		Object obj = ste.getValue();
//		if (obj.getClass().equals(Tvalue.class)) {
//			v = new Tvalue((Double)obj);
//		} else if (obj.getClass().equals(Tstring.class)) {
//			v = (Tstring)obj;
//		} else if (obj.getClass().equals(Texplist.class)) {
//			v = (Texplist)obj;
//		}
		return (Texp)obj;
	}
}


