/* The following code was generated by JFlex 1.6.1 */

package fnplot.syntax;

/* Specification for ArithExp tokens */

// user customisations
import java_cup.runtime.*;

// Jlex directives

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>FnPlotLexer</tt>
 */
public class FnPlotLexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\10\0\1\2\1\2\1\1\1\0\1\2\1\1\22\0\1\2\2\0"+
    "\1\43\1\0\1\11\2\0\1\14\1\15\1\7\1\5\1\20\1\6"+
    "\1\57\1\10\2\45\10\4\1\42\1\56\1\0\1\12\1\32\1\51"+
    "\1\0\6\47\24\3\1\40\1\0\1\41\1\13\1\3\1\0\1\25"+
    "\1\44\1\35\1\50\1\36\1\21\1\3\1\55\1\37\2\3\1\33"+
    "\1\24\1\23\1\31\1\26\1\53\1\34\1\27\1\30\1\22\1\54"+
    "\1\3\1\46\1\3\1\52\1\16\1\0\1\17\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uff92\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\0\1\5\1\6"+
    "\1\7\1\10\1\11\12\3\1\12\1\13\1\14\1\0"+
    "\1\3\1\15\1\16\7\0\1\17\1\20\20\3\1\21"+
    "\1\22\1\23\1\0\1\24\1\25\2\0\1\3\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\7\3\1\37\4\3\1\40\1\3\1\41\2\3\1\42"+
    "\1\0\1\43\1\44\1\45\1\3\1\46\1\47\1\50"+
    "\1\3\1\51\1\52\1\53\1\54\1\55\1\56\1\3"+
    "\1\57\1\3\1\0\1\43\1\44\1\3\1\60\1\3"+
    "\1\61\1\62\1\0\1\43\1\44\1\20\2\3\1\63"+
    "\1\43\1\44\1\64\1\65\1\43\1\44\1\43\1\44"+
    "\1\43\1\44\1\43\1\44\30\43";

  private static int [] zzUnpackAction() {
    int [] result = new int[158];
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
    "\0\0\0\60\0\60\0\140\0\220\0\300\0\360\0\360"+
    "\0\360\0\360\0\360\0\u0120\0\u0150\0\u0180\0\u01b0\0\u01e0"+
    "\0\u0210\0\u0240\0\u0270\0\u02a0\0\u02d0\0\360\0\360\0\360"+
    "\0\u0300\0\u0330\0\360\0\360\0\u0360\0\u0390\0\u03c0\0\u03f0"+
    "\0\u0420\0\u0450\0\u0480\0\u04b0\0\360\0\u04e0\0\u0510\0\u0540"+
    "\0\u0570\0\u05a0\0\u05d0\0\u0600\0\u0630\0\u0660\0\u0690\0\u06c0"+
    "\0\u06f0\0\u0720\0\u0750\0\u0780\0\u07b0\0\140\0\140\0\360"+
    "\0\u07e0\0\360\0\360\0\u0810\0\u0840\0\u0870\0\360\0\360"+
    "\0\360\0\360\0\360\0\360\0\360\0\140\0\140\0\u08a0"+
    "\0\u08d0\0\u0900\0\u0930\0\u0960\0\u0990\0\u09c0\0\140\0\u09f0"+
    "\0\u0a20\0\u0a50\0\u0a80\0\140\0\u0ab0\0\140\0\u0ae0\0\u0b10"+
    "\0\140\0\u0b40\0\u0b70\0\u0ba0\0\140\0\u0bd0\0\140\0\140"+
    "\0\140\0\u0c00\0\140\0\140\0\140\0\u0c30\0\140\0\140"+
    "\0\u0c60\0\140\0\u0c90\0\u0cc0\0\u0cf0\0\u0d20\0\u0d50\0\u0d80"+
    "\0\u0db0\0\140\0\140\0\u0de0\0\u0e10\0\u0e40\0\140\0\u0e70"+
    "\0\u0ea0\0\360\0\u0ed0\0\u0f00\0\140\0\140\0\u0f30\0\u0f60"+
    "\0\u0f90\0\u0fc0\0\u0ff0\0\u1020\0\u1050\0\360\0\u1080\0\u10b0"+
    "\0\u10e0\0\u1110\0\u1140\0\u1170\0\u11a0\0\u11d0\0\u1200\0\u1230"+
    "\0\u1260\0\u1290\0\u12c0\0\u12f0\0\u1320\0\u1350\0\u1380\0\u13b0"+
    "\0\u13e0\0\u1410\0\u1440\0\u1470\0\u14a0\0\360";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[158];
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
    "\1\0\1\2\1\3\1\4\1\5\1\0\1\6\5\0"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\2\4\1\15"+
    "\1\4\1\16\1\17\1\20\1\4\1\0\1\21\1\22"+
    "\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\4"+
    "\1\5\2\4\1\32\1\33\4\4\1\34\6\0\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\47\0\2\4"+
    "\14\0\11\4\1\0\5\4\4\0\5\4\1\0\4\4"+
    "\6\0\1\5\40\0\1\5\11\0\1\44\32\0\1\45"+
    "\110\0\2\4\14\0\1\4\1\46\6\4\1\47\1\0"+
    "\5\4\4\0\5\4\1\0\4\4\5\0\2\4\14\0"+
    "\4\4\1\50\4\4\1\0\5\4\4\0\5\4\1\0"+
    "\4\4\5\0\2\4\14\0\4\4\1\51\4\4\1\0"+
    "\1\52\1\53\3\4\4\0\5\4\1\0\4\4\5\0"+
    "\2\4\14\0\11\4\1\0\4\4\1\54\4\0\5\4"+
    "\1\0\4\4\5\0\2\4\14\0\11\4\1\0\5\4"+
    "\4\0\5\4\1\0\3\4\1\55\5\0\2\4\14\0"+
    "\11\4\1\0\3\4\1\56\1\57\4\0\5\4\1\0"+
    "\4\4\5\0\2\4\14\0\11\4\1\0\3\4\1\60"+
    "\1\4\4\0\5\4\1\0\4\4\5\0\2\4\14\0"+
    "\4\4\1\61\4\4\1\0\1\62\4\4\4\0\4\4"+
    "\1\63\1\0\4\4\5\0\2\4\14\0\11\4\1\0"+
    "\1\64\4\4\4\0\5\4\1\0\1\4\1\65\2\4"+
    "\5\0\2\4\14\0\1\66\1\4\1\67\6\4\1\0"+
    "\5\4\4\0\5\4\1\0\4\4\23\0\1\70\1\71"+
    "\5\0\1\72\5\0\1\73\5\0\1\74\1\0\1\75"+
    "\14\0\2\4\14\0\11\4\1\0\3\4\1\76\1\4"+
    "\4\0\5\4\1\0\4\4\3\0\2\77\56\0\2\100"+
    "\56\0\2\101\56\0\2\102\56\0\2\103\56\0\2\104"+
    "\56\0\2\105\61\0\1\44\40\0\1\44\15\0\2\4"+
    "\14\0\2\4\1\106\6\4\1\0\5\4\4\0\5\4"+
    "\1\0\4\4\5\0\2\4\14\0\11\4\1\0\1\4"+
    "\1\107\3\4\4\0\5\4\1\0\4\4\5\0\2\4"+
    "\14\0\5\4\1\110\3\4\1\0\5\4\4\0\5\4"+
    "\1\0\4\4\5\0\2\4\14\0\11\4\1\0\4\4"+
    "\1\111\4\0\5\4\1\0\4\4\5\0\2\4\14\0"+
    "\10\4\1\112\1\0\5\4\4\0\5\4\1\0\4\4"+
    "\5\0\2\4\14\0\10\4\1\113\1\0\4\4\1\114"+
    "\4\0\5\4\1\0\4\4\5\0\2\4\14\0\11\4"+
    "\1\0\5\4\4\0\5\4\1\0\1\115\3\4\5\0"+
    "\2\4\14\0\11\4\1\0\3\4\1\116\1\4\4\0"+
    "\5\4\1\0\4\4\5\0\2\4\14\0\7\4\1\117"+
    "\1\4\1\0\5\4\4\0\5\4\1\0\4\4\5\0"+
    "\2\4\14\0\6\4\1\120\2\4\1\0\5\4\4\0"+
    "\5\4\1\0\4\4\5\0\2\4\14\0\4\4\1\121"+
    "\4\4\1\0\5\4\4\0\5\4\1\0\4\4\5\0"+
    "\2\4\14\0\6\4\1\122\2\4\1\0\1\123\1\124"+
    "\3\4\4\0\5\4\1\0\4\4\5\0\2\4\14\0"+
    "\11\4\1\0\3\4\1\125\1\4\4\0\5\4\1\0"+
    "\4\4\5\0\2\4\14\0\11\4\1\0\1\4\1\126"+
    "\3\4\4\0\5\4\1\0\4\4\5\0\2\4\14\0"+
    "\6\4\1\127\2\4\1\0\5\4\4\0\5\4\1\0"+
    "\4\4\5\0\2\4\14\0\1\4\1\130\7\4\1\0"+
    "\5\4\4\0\5\4\1\0\2\4\1\131\1\4\6\0"+
    "\1\132\14\0\1\132\3\0\1\132\7\0\2\132\5\0"+
    "\2\132\1\0\2\132\54\0\1\133\16\0\1\134\14\0"+
    "\1\134\3\0\1\134\7\0\2\134\5\0\2\134\1\0"+
    "\2\134\12\0\2\4\14\0\1\135\10\4\1\0\5\4"+
    "\4\0\5\4\1\0\4\4\5\0\2\4\14\0\6\4"+
    "\1\136\2\4\1\0\5\4\4\0\5\4\1\0\4\4"+
    "\5\0\2\4\14\0\11\4\1\0\1\4\1\137\3\4"+
    "\4\0\5\4\1\0\4\4\5\0\2\4\14\0\7\4"+
    "\1\140\1\4\1\0\5\4\4\0\5\4\1\0\4\4"+
    "\5\0\2\4\14\0\11\4\1\0\2\4\1\141\2\4"+
    "\4\0\5\4\1\0\4\4\5\0\2\4\14\0\2\4"+
    "\1\142\6\4\1\0\5\4\4\0\5\4\1\0\4\4"+
    "\5\0\2\4\14\0\11\4\1\0\3\4\1\143\1\4"+
    "\4\0\5\4\1\0\4\4\5\0\2\4\14\0\2\4"+
    "\1\144\6\4\1\0\5\4\4\0\5\4\1\0\4\4"+
    "\5\0\2\4\14\0\7\4\1\145\1\4\1\0\5\4"+
    "\4\0\5\4\1\0\4\4\5\0\2\4\14\0\11\4"+
    "\1\0\5\4\4\0\4\4\1\146\1\0\4\4\5\0"+
    "\2\4\14\0\11\4\1\0\3\4\1\147\1\4\4\0"+
    "\5\4\1\0\4\4\5\0\2\4\14\0\11\4\1\0"+
    "\1\150\4\4\4\0\5\4\1\0\4\4\5\0\2\4"+
    "\14\0\4\4\1\151\4\4\1\0\5\4\4\0\5\4"+
    "\1\0\4\4\5\0\2\4\14\0\11\4\1\0\3\4"+
    "\1\152\1\4\4\0\5\4\1\0\4\4\5\0\2\4"+
    "\14\0\4\4\1\153\4\4\1\0\5\4\4\0\5\4"+
    "\1\0\4\4\6\0\1\154\14\0\1\154\3\0\1\154"+
    "\7\0\2\154\5\0\2\154\1\0\2\154\54\0\1\155"+
    "\16\0\1\156\14\0\1\156\3\0\1\156\7\0\2\156"+
    "\5\0\2\156\1\0\2\156\12\0\2\4\14\0\7\4"+
    "\1\157\1\4\1\0\5\4\4\0\5\4\1\0\4\4"+
    "\5\0\2\4\14\0\7\4\1\160\1\4\1\0\5\4"+
    "\4\0\5\4\1\0\4\4\5\0\2\4\14\0\11\4"+
    "\1\0\4\4\1\161\4\0\5\4\1\0\4\4\5\0"+
    "\2\4\14\0\11\4\1\0\1\4\1\162\3\4\4\0"+
    "\5\4\1\0\4\4\5\0\2\4\14\0\11\4\1\0"+
    "\1\163\4\4\4\0\5\4\1\0\4\4\6\0\1\164"+
    "\14\0\1\164\3\0\1\164\7\0\2\164\5\0\2\164"+
    "\1\0\2\164\54\0\1\165\16\0\1\166\14\0\1\166"+
    "\3\0\1\166\7\0\2\166\5\0\2\166\1\0\2\166"+
    "\12\0\2\4\14\0\10\4\1\167\1\0\5\4\4\0"+
    "\5\4\1\0\4\4\5\0\2\4\14\0\11\4\1\0"+
    "\1\170\4\4\4\0\5\4\1\0\4\4\5\0\2\4"+
    "\14\0\2\4\1\171\6\4\1\0\5\4\4\0\5\4"+
    "\1\0\4\4\6\0\1\172\14\0\1\172\3\0\1\172"+
    "\7\0\2\172\5\0\2\172\1\0\2\172\54\0\1\173"+
    "\16\0\1\174\14\0\1\174\3\0\1\174\7\0\2\174"+
    "\5\0\2\174\1\0\2\174\12\0\2\4\14\0\2\4"+
    "\1\175\6\4\1\0\5\4\4\0\5\4\1\0\4\4"+
    "\5\0\2\4\14\0\7\4\1\176\1\4\1\0\5\4"+
    "\4\0\5\4\1\0\4\4\47\0\1\177\16\0\1\200"+
    "\14\0\1\200\3\0\1\200\7\0\2\200\5\0\2\200"+
    "\1\0\2\200\54\0\1\201\16\0\1\202\14\0\1\202"+
    "\3\0\1\202\7\0\2\202\5\0\2\202\1\0\2\202"+
    "\54\0\1\203\16\0\1\204\14\0\1\204\3\0\1\204"+
    "\7\0\2\204\5\0\2\204\1\0\2\204\54\0\1\205"+
    "\16\0\1\206\14\0\1\206\3\0\1\206\7\0\2\206"+
    "\5\0\2\206\1\0\2\206\54\0\1\207\57\0\1\210"+
    "\57\0\1\211\57\0\1\212\57\0\1\213\57\0\1\214"+
    "\57\0\1\215\57\0\1\216\57\0\1\217\57\0\1\220"+
    "\57\0\1\221\57\0\1\222\57\0\1\223\57\0\1\224"+
    "\57\0\1\225\57\0\1\226\57\0\1\227\57\0\1\230"+
    "\57\0\1\231\57\0\1\232\57\0\1\233\57\0\1\234"+
    "\57\0\1\235\57\0\1\236\12\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5328];
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
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\4\1\1\0\5\11\12\1\3\11\1\0\1\1"+
    "\2\11\7\0\1\1\1\11\22\1\1\11\1\0\2\11"+
    "\2\0\1\1\7\11\24\1\1\0\21\1\1\0\7\1"+
    "\1\0\5\1\1\11\13\1\1\11\27\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[158];
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
    public int getChar() {
	return yychar + 1;
    }

    public int getColumn() {
    	return yycolumn + 1;
    }

    public int getLine() {
	return yyline + 1;
    }

    public String getText() {
	return yytext();
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public FnPlotLexer(java.io.Reader in) {
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
    while (i < 168) {
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
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
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

      yychar+= zzMarkedPosL-zzStartRead;

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
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
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

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
          { 	return new Symbol(sym.EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { //skip newline, but reset char counter
			yycolumn = 0;
            }
          case 54: break;
          case 2: 
            { //skip whitespace
            }
          case 55: break;
          case 3: 
            { // VARIABLE
	       return new Symbol(sym.VARIABLE, yytext());
            }
          case 56: break;
          case 4: 
            { // INTEGER
	       return new Symbol(sym.INTEGER, 
				 new Double(yytext()));
            }
          case 57: break;
          case 5: 
            { return new Symbol(sym.LPAREN);
            }
          case 58: break;
          case 6: 
            { return new Symbol(sym.RPAREN);
            }
          case 59: break;
          case 7: 
            { return new Symbol(sym.LBRACE);
            }
          case 60: break;
          case 8: 
            { return new Symbol(sym.RBRACE);
            }
          case 61: break;
          case 9: 
            { return new Symbol(sym.COMMA);
            }
          case 62: break;
          case 10: 
            { return new Symbol(sym.LSQR);
            }
          case 63: break;
          case 11: 
            { return new Symbol(sym.RSQR);
            }
          case 64: break;
          case 12: 
            { return new Symbol(sym.COLON);
            }
          case 65: break;
          case 13: 
            { return new Symbol(sym.QUESTION);
            }
          case 66: break;
          case 14: 
            { return new Symbol(sym.SEMI);
            }
          case 67: break;
          case 15: 
            { // FLOAT
	       return new Symbol(sym.INTEGER, 
				 new Double(yytext()));
            }
          case 68: break;
          case 16: 
            { return new Symbol(sym.MAPS);
            }
          case 69: break;
          case 17: 
            { return new Symbol(sym.IF);
            }
          case 70: break;
          case 18: 
            { return new Symbol(sym.IN);
            }
          case 71: break;
          case 19: 
            { return new Symbol(sym.BOOL, new Boolean(false));
            }
          case 72: break;
          case 20: 
            { return new Symbol(sym.BOOL, new Boolean(true));
            }
          case 73: break;
          case 21: 
            { return new Symbol(sym.EMPTY);
            }
          case 74: break;
          case 22: 
            { return new Symbol(sym.PLUS);
            }
          case 75: break;
          case 23: 
            { return new Symbol(sym.MINUS);
            }
          case 76: break;
          case 24: 
            { return new Symbol(sym.MUL);
            }
          case 77: break;
          case 25: 
            { return new Symbol(sym.DIV);
            }
          case 78: break;
          case 26: 
            { return new Symbol(sym.MOD);
            }
          case 79: break;
          case 27: 
            { return new Symbol(sym.ASSIGN);
            }
          case 80: break;
          case 28: 
            { return new Symbol(sym.POW);
            }
          case 81: break;
          case 29: 
            { return new Symbol(sym.FUN);
            }
          case 82: break;
          case 30: 
            { return new Symbol(sym.FOR);
            }
          case 83: break;
          case 31: 
            { return new Symbol(sym.LET);
            }
          case 84: break;
          case 32: 
            { return new Symbol(sym.CAR);
            }
          case 85: break;
          case 33: 
            { return new Symbol(sym.CDR);
            }
          case 86: break;
          case 34: 
            { return new Symbol(sym.EQV);
            }
          case 87: break;
          case 35: 
            { return new Symbol(sym.BIN, yytext());
            }
          case 88: break;
          case 36: 
            { return new Symbol(sym.HEX, yytext());
            }
          case 89: break;
          case 37: 
            { return new Symbol(sym.DEF);
            }
          case 90: break;
          case 38: 
            { return new Symbol(sym.PAIR);
            }
          case 91: break;
          case 39: 
            { return new Symbol(sym.PLOT);
            }
          case 92: break;
          case 40: 
            { return new Symbol(sym.PROC);
            }
          case 93: break;
          case 41: 
            { return new Symbol(sym.SIZE);
            }
          case 94: break;
          case 42: 
            { return new Symbol(sym.THEN);
            }
          case 95: break;
          case 43: 
            { return new Symbol(sym.LIST);
            }
          case 96: break;
          case 44: 
            { return new Symbol(sym.READ);
            }
          case 97: break;
          case 45: 
            { return new Symbol(sym.CASE);
            }
          case 98: break;
          case 46: 
            { return new Symbol(sym.CALL);
            }
          case 99: break;
          case 47: 
            { return new Symbol(sym.ELSE);
            }
          case 100: break;
          case 48: 
            { return new Symbol(sym.PRINT);
            }
          case 101: break;
          case 49: 
            { return new Symbol(sym.CLEAR);
            }
          case 102: break;
          case 50: 
            { return new Symbol(sym.EQUAL);
            }
          case 103: break;
          case 51: 
            { return new Symbol(sym.UNI, yytext());
            }
          case 104: break;
          case 52: 
            { return new Symbol(sym.PRINTLN);
            }
          case 105: break;
          case 53: 
            { return new Symbol(sym.READINT);
            }
          case 106: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}