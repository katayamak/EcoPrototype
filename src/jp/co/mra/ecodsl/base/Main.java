package jp.co.mra.ecodsl.base;
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2001       Gerwin Klein <lsf@jflex.de>                    *
 * Copyright (C) 2001       Bernhard Rumpe <rumpe@in.tum.de>               *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


import java.io.*;

import jp.co.mra.ecodsl.command.Tprogram;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Main program of the interpreter for the AS programming language.
 * Based on JFlex/CUP.
 * 
 * Steps:
 * - scanning                               (Yylex)
 * - context free parsing and AST building  (yyparse)
 * - build up symbol table                  (setSymtabs)
 * - check context conditions               (checkcontext)
 * - prepare interpretation                 (prepInterp)
 * - start interpretation                   (interpret)
 */ 
public class Main {

	public static void main(String[] args) {
//		XSSFWorkbook workbook = new XSSFWorkbook();
//
//		workbook.createSheet("test");
//
//		FileOutputStream out = null;
//		try {
//			out = new FileOutputStream("sample.xlsx");
//			
//			workbook.write(out);
//		} catch (IOException e){
//			System.out.println(e.toString());
//		} finally {
//			try {
//				out.close();
//			} catch (IOException e){
//				System.out.println(e.toString());
//			}
//		}
		
		Reader reader = null;

		try { 
			if (args.length == 1) {
				File input = new File(args[0]);
				if (!input.canRead()) {
					System.out.println("Error: could not read [" + input + "]");
				}
				reader = new InputStreamReader(new FileInputStream(input), "UTF8");
			}
			else {  
				reader = new InputStreamReader(System.in);
			}

			EcoModelScanner scanner = new EcoModelScanner(reader);   // create scanner
			SymTab symtab = new SymTab();        // set global symbol table    
			scanner.setSymtab(symtab);

			EcoModelParser parser = new EcoModelParser(scanner); // create parser
			Tprogram syntaxbaum = null;

			try { 
				syntaxbaum = (Tprogram) parser.debug_parse().value;  // parse
			}    
			catch (Exception e) { 
				e.printStackTrace(); 
			}

			// System.out.println(symtab);
			System.out.println(syntaxbaum);

			syntaxbaum.setSymtabs();          // set symbol table
			// syntaxbaum.printSymtabs();       // print symbol table

			syntaxbaum.checkcontext();        // CoCo (DefVar, DefFun, Arity)
			if(contexterror>0) return;

			syntaxbaum.prepInterp();          // var. indices and function pointers
			// im Syntaxbaum setzen
			syntaxbaum.interpret();           // interpretation
		} catch (FileNotFoundException e) { 
			e.printStackTrace(); 
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static int contexterror = 0;        // number of errors in context conditions

	public static void error(String s) { 
		System.out.println((contexterror++) + ". " + s); 
	}
}
