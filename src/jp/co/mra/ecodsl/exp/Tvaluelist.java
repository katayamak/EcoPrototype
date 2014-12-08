package jp.co.mra.ecodsl.exp;


public class Tvaluelist {
	Object obj;
	Tvaluelist objlist;           // next list element (optional null)
	
	public Tvaluelist getTail() {
		return objlist;
	}

	public Object getHead() {
		return obj;
	}

	public String toString() {
		return "[" + (objlist == null ? "" : objlist.toString() + ",") + obj.toString() + "]";
	}

	public Tvaluelist(Object o, Tvaluelist l) {
		objlist = l;
		obj = o;
	}

	public Tvaluelist(Texp o) {
		objlist = new Tvaluelist();
		obj = o;
	}

	public Tvaluelist() {
		objlist = null;
		obj = null;
	}

}

