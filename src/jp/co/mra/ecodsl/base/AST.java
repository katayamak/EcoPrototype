package jp.co.mra.ecodsl.base;


/**
 * General interface for nodes in the abstract syntax tree. Contains   
 * only the method toString which is already inherited from Object,   
 * so the interface doesn't add any functionality. It only provides   
 * a common super type for all elements in the AST.                   
 */
public interface AST {
  public String toString();   // already inherited from Object
}
