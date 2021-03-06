package jp.co.mra.ecodsl.base;
/* The following code was generated by JFlex 1.6.0 */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2001       Gerwin Klein <lsf@jflex.de>                    *
 * Copyright (C) 2001       Bernhard Rumpe <rumpe@in.tum.de>               *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


import java_cup.runtime.Symbol;
import jp.co.mra.ecodsl.base.EcoModelScanner;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.0
 * from the specification file <tt>EcoModel.jflex</tt>
 */
class EcoModelScanner implements java_cup.runtime.Scanner, sym {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\10\0\2\52\1\53\1\55\1\52\1\54\22\0\1\52\1\0\1\36"+
    "\3\0\1\42\1\0\1\26\1\27\1\34\1\33\1\30\1\32\1\46"+
    "\1\35\12\45\1\0\1\31\1\40\1\37\1\41\2\0\4\50\1\47"+
    "\25\50\1\23\1\56\1\25\3\0\1\11\1\50\1\1\1\16\1\7"+
    "\1\10\1\50\1\15\1\14\2\50\1\12\1\50\1\3\1\2\2\50"+
    "\1\5\1\13\1\4\1\6\1\20\1\17\3\50\1\21\1\24\1\22"+
    "\7\0\1\55\u030b\0\22\50\1\43\46\50\u1c5e\0\1\55\1\55\u0166\0"+
    "\1\51\157\0\1\44\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\ude0f\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\10\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\0\7\2\1\34\1\35"+
    "\2\2\1\36\1\37\1\40\1\41\1\42\2\0\1\43"+
    "\1\44\1\45\1\46\1\47\1\50\1\51\7\2\1\52"+
    "\1\0\1\52\1\53\1\54\1\2\1\55\1\2\1\56"+
    "\1\2\1\57\1\60\1\61";

  private static int [] zzUnpackAction() {
    int [] result = new int[82];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\57\0\136\0\215\0\274\0\353\0\u011a\0\u0149"+
    "\0\u0178\0\u01a7\0\u01d6\0\136\0\136\0\u0205\0\u0234\0\136"+
    "\0\136\0\136\0\136\0\136\0\136\0\136\0\136\0\u0263"+
    "\0\136\0\136\0\u0292\0\u02c1\0\136\0\274\0\136\0\u02f0"+
    "\0\136\0\u031f\0\u034e\0\136\0\u037d\0\u03ac\0\u03db\0\u040a"+
    "\0\u0439\0\u0468\0\u0497\0\u04c6\0\274\0\274\0\u04f5\0\u0524"+
    "\0\136\0\136\0\u0553\0\136\0\136\0\u0582\0\u05b1\0\136"+
    "\0\136\0\136\0\136\0\136\0\274\0\274\0\u05e0\0\u060f"+
    "\0\u063e\0\u066d\0\u069c\0\u06cb\0\u06fa\0\u0729\0\u0758\0\u0758"+
    "\0\274\0\274\0\u0787\0\274\0\u07b6\0\274\0\u07e5\0\274"+
    "\0\274\0\274";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[82];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\2\5\1\6\2\5\1\7\1\10\3\5"+
    "\1\11\1\5\1\12\1\13\1\5\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\3\2\5\1\41\3\42\1\0\1\3"+
    "\36\43\1\44\14\43\2\0\1\43\1\45\60\0\1\5"+
    "\1\46\10\5\1\47\5\5\3\0\1\5\16\0\1\5"+
    "\1\0\1\5\1\0\2\5\7\0\20\5\3\0\1\5"+
    "\16\0\1\5\1\0\1\5\1\0\2\5\7\0\4\5"+
    "\1\50\7\5\1\51\3\5\3\0\1\5\16\0\1\5"+
    "\1\0\1\5\1\0\2\5\7\0\2\5\1\52\6\5"+
    "\1\53\6\5\3\0\1\5\16\0\1\5\1\0\1\5"+
    "\1\0\2\5\7\0\10\5\1\54\7\5\3\0\1\5"+
    "\16\0\1\5\1\0\1\5\1\0\2\5\7\0\7\5"+
    "\1\55\10\5\3\0\1\5\16\0\1\5\1\0\1\5"+
    "\1\0\2\5\7\0\1\5\1\56\16\5\3\0\1\5"+
    "\16\0\1\5\1\0\1\5\1\0\2\5\7\0\6\5"+
    "\1\57\5\5\1\60\3\5\3\0\1\5\16\0\1\5"+
    "\1\0\1\5\1\0\2\5\32\0\1\61\33\0\20\5"+
    "\3\0\1\5\1\62\15\0\1\5\1\0\1\5\1\0"+
    "\2\5\43\0\1\63\60\0\1\64\56\0\1\65\64\0"+
    "\1\40\1\66\1\67\61\0\3\42\2\0\36\43\1\0"+
    "\14\43\2\0\1\43\4\0\1\70\1\71\1\72\30\0"+
    "\1\73\17\0\1\74\1\0\2\5\1\75\15\5\3\0"+
    "\1\5\16\0\1\5\1\0\1\5\1\0\2\5\7\0"+
    "\17\5\1\76\3\0\1\5\16\0\1\5\1\0\1\5"+
    "\1\0\2\5\7\0\5\5\1\77\12\5\3\0\1\5"+
    "\16\0\1\5\1\0\1\5\1\0\2\5\7\0\6\5"+
    "\1\100\11\5\3\0\1\5\16\0\1\5\1\0\1\5"+
    "\1\0\2\5\7\0\15\5\1\101\2\5\3\0\1\5"+
    "\16\0\1\5\1\0\1\5\1\0\2\5\7\0\12\5"+
    "\1\102\5\5\3\0\1\5\16\0\1\5\1\0\1\5"+
    "\1\0\2\5\7\0\11\5\1\103\6\5\3\0\1\5"+
    "\16\0\1\5\1\0\1\5\1\0\2\5\7\0\2\5"+
    "\1\104\15\5\3\0\1\5\16\0\1\5\1\0\1\5"+
    "\1\0\2\5\7\0\13\5\1\105\4\5\3\0\1\5"+
    "\16\0\1\5\1\0\1\5\1\0\2\5\6\0\53\63"+
    "\1\0\3\63\45\0\1\106\43\0\2\107\11\0\1\110"+
    "\12\0\6\5\1\111\11\5\3\0\1\5\16\0\1\5"+
    "\1\0\1\5\1\0\2\5\7\0\2\5\1\112\15\5"+
    "\3\0\1\5\16\0\1\5\1\0\1\5\1\0\2\5"+
    "\7\0\13\5\1\113\4\5\3\0\1\5\16\0\1\5"+
    "\1\0\1\5\1\0\2\5\7\0\6\5\1\114\11\5"+
    "\3\0\1\5\16\0\1\5\1\0\1\5\1\0\2\5"+
    "\7\0\12\5\1\115\5\5\3\0\1\5\16\0\1\5"+
    "\1\0\1\5\1\0\2\5\7\0\15\5\1\116\2\5"+
    "\3\0\1\5\16\0\1\5\1\0\1\5\1\0\2\5"+
    "\7\0\11\5\1\117\6\5\3\0\1\5\16\0\1\5"+
    "\1\0\1\5\1\0\2\5\53\0\1\106\1\0\1\67"+
    "\54\0\1\110\12\0\7\5\1\120\10\5\3\0\1\5"+
    "\16\0\1\5\1\0\1\5\1\0\2\5\7\0\6\5"+
    "\1\121\11\5\3\0\1\5\16\0\1\5\1\0\1\5"+
    "\1\0\2\5\7\0\6\5\1\122\11\5\3\0\1\5"+
    "\16\0\1\5\1\0\1\5\1\0\2\5\6\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2068];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\10\1\2\11\2\1\10\11\1\1\2\11"+
    "\2\1\1\11\1\1\1\11\1\1\1\11\2\1\1\11"+
    "\1\0\13\1\2\11\1\1\2\11\2\0\5\11\12\1"+
    "\1\0\13\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[82];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
  StringBuffer string = new StringBuffer();
  
  jp.co.mra.ecodsl.base.SymTab symtab;          // externe symbol table

  public void setSymtab(SymTab symtab) {
    this.symtab = symtab; 
  }

  private Symbol sym(int sym) {
    return new Symbol(sym);
  }

  private Symbol sym(int sym, Object val) {
    return new Symbol(sym, val);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  EcoModelScanner(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 180) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;           
    int totalRead = 0;
    while (totalRead < requested) {
      int numRead = zzReader.read(zzBuffer, zzEndRead + totalRead, requested - totalRead);
      if (numRead == -1) {
        break;
      }
      totalRead += numRead;
    }

    if (totalRead > 0) {
      zzEndRead += totalRead;
      if (totalRead == requested) { /* possibly more input available */
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      return false;
    }

    // totalRead = 0: End of stream
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 1: 
          { throw new Error("Unexpected character ["+yytext()+"]");
          }
        case 50: break;
        case 2: 
          { symtab.enter(yytext(),new jp.co.mra.ecodsl.base.SymtabEntry(yytext()));
	                  return sym(ID,yytext());
          }
        case 51: break;
        case 3: 
          { return sym(LEFTCB);
          }
        case 52: break;
        case 4: 
          { return sym(RIGHTCB);
          }
        case 53: break;
        case 5: 
          { return sym(LEFTB);
          }
        case 54: break;
        case 6: 
          { return sym(OR);
          }
        case 55: break;
        case 7: 
          { return sym(RIGHTB);
          }
        case 56: break;
        case 8: 
          { return sym(LPAR);
          }
        case 57: break;
        case 9: 
          { return sym(RPAR);
          }
        case 58: break;
        case 10: 
          { return sym(COMMA);
          }
        case 59: break;
        case 11: 
          { return sym(SEMICOLON);
          }
        case 60: break;
        case 12: 
          { return sym(MINUS);
          }
        case 61: break;
        case 13: 
          { return sym(PLUS);
          }
        case 62: break;
        case 14: 
          { return sym(TIMES);
          }
        case 63: break;
        case 15: 
          { return sym(DIV);
          }
        case 64: break;
        case 16: 
          { string.setLength(0); yybegin(STRING);
          }
        case 65: break;
        case 17: 
          { return sym(EQ);
          }
        case 66: break;
        case 18: 
          { return sym(LE);
          }
        case 67: break;
        case 19: 
          { return sym(GE);
          }
        case 68: break;
        case 20: 
          { return sym(AND);
          }
        case 69: break;
        case 21: 
          { return sym(SIGMA);
          }
        case 70: break;
        case 22: 
          { return sym(FORALL);
          }
        case 71: break;
        case 23: 
          { return sym(INDEX,yytext());
          }
        case 72: break;
        case 24: 
          { symtab.enter(yytext(),new jp.co.mra.ecodsl.base.SymtabEntry(yytext()));   // �?
	                  return sym(LET);
          }
        case 73: break;
        case 25: 
          { /* eat whitespace */
          }
        case 74: break;
        case 26: 
          { string.append( yytext() );
          }
        case 75: break;
        case 27: 
          { yybegin(YYINITIAL); return sym(STRINGLITERAL, string.toString());
          }
        case 76: break;
        case 28: 
          { return sym(IF);
          }
        case 77: break;
        case 29: 
          { return sym(DO);
          }
        case 78: break;
        case 30: 
          { return sym(LEFTAR);
          }
        case 79: break;
        case 31: 
          { return sym(RIGHTAR);
          }
        case 80: break;
        case 32: 
          { /* one-line comment */
          }
        case 81: break;
        case 33: 
          { return sym(LEQ);
          }
        case 82: break;
        case 34: 
          { return sym(GEQ);
          }
        case 83: break;
        case 35: 
          { string.append('\n');
          }
        case 84: break;
        case 36: 
          { string.append('\t');
          }
        case 85: break;
        case 37: 
          { string.append('\r');
          }
        case 86: break;
        case 38: 
          { string.append('\"');
          }
        case 87: break;
        case 39: 
          { string.append('\\');
          }
        case 88: break;
        case 40: 
          { return sym(CON);
          }
        case 89: break;
        case 41: 
          { return sym(CSV);
          }
        case 90: break;
        case 42: 
          { return sym(VALUE,yytext());
          }
        case 91: break;
        case 43: 
          { return sym(TRUE);
          }
        case 92: break;
        case 44: 
          { return sym(THEN);
          }
        case 93: break;
        case 45: 
          { return sym(ELSE);
          }
        case 94: break;
        case 46: 
          { return sym(ENDWHILE);
          }
        case 95: break;
        case 47: 
          { return sym(ENDIF);
          }
        case 96: break;
        case 48: 
          { return sym(FALSE);
          }
        case 97: break;
        case 49: 
          { return sym(WHILE);
          }
        case 98: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
