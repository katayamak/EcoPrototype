/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2001       Gerwin Klein <lsf@jflex.de>                    *
 * Copyright (C) 2001       Bernhard Rumpe <rumpe@in.tum.de>               *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


/**
 * AST node for the whole program (top node).
 * 
 * Also contains two symbol tables, one for input variables,
 * one for function names. 
 *
 * All operations like context check, symbol table build up
 * etc. start here.
 */ 
class Tprogram implements AST {

	Topelist opelist;           // input variables

	public Tprogram(Tvalue ol) {
//		opelist = ol;
	}

	public Tprogram(Topelist ol) {
		opelist = ol;
	}

	public String toString() {
		return("Program:\n=============\ninput "+ opelist + "\nend");
	}

	SymTab world = new SymTab();      // table of input variables

	public void setSymtabs() {          // calculate symbol table entries
	}

	public void printSymtabs() {
	}

	public void checkcontext() {
		opelist.checkcontext(world);          // CoCo (DefFun,DefVar,Arity)
		// in function bodies
	}

	public void prepInterp() {          // set pointers and indices
	}

	public void interpret() throws Exception {    

		System.out.println("Result:\n=============");

//		int[] ergebnis = new int[opelist.length()];
		SymTab newWorld = opelist.interpret(world);  // calculate result

//		System.out.print(newWorld.toString());
		
//		int i;
//		for (i = opelist.length() - 1; i > 0; i--) {
//			System.out.print(ergebnis[i] + ",  ");
//		}
//		System.out.println(ergebnis[i]);
	}
}

