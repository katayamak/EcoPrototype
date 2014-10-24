/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2001       Gerwin Klein <lsf@jflex.de>                    *
 * Copyright (C) 2001       Bernhard Rumpe <rumpe@in.tum.de>               *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


/**
 * Symbol table entry for variables.
 * 
 * Contains index in the parameter list and a flag if it
 * is an input variable.
 */ 
class STEvar extends SymtabEntry {
	Object value;                  

	public STEvar(String v, Object value) {
		super(v);
		this.value = value;
	}

	public int kind() {
		return SymtabEntry.VAR; 
	}

	public String toString() {
		return value.toString();
	}

	public Object getValue() {
		return value; 
	}
}

