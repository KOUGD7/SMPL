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
    "\10\0\1\2\1\2\1\1\1\0\1\2\1\1\22\0\1\2\1\15"+
    "\1\0\1\47\1\0\1\11\2\0\1\27\1\30\1\7\1\5\1\33"+
    "\1\6\1\62\1\10\2\51\10\4\1\26\1\61\1\16\1\14\1\17"+
    "\1\54\1\13\6\53\24\3\1\45\1\0\1\46\1\12\1\3\1\0"+
    "\1\20\1\50\1\42\1\22\1\43\1\34\1\3\1\60\1\44\2\3"+
    "\1\41\1\36\1\21\1\23\1\37\1\56\1\24\1\40\1\25\1\35"+
    "\1\57\1\3\1\52\1\3\1\55\1\31\1\0\1\32\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uff92\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\4\3\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\10\3\1\14\1\15"+
    "\1\0\1\16\1\17\15\0\1\20\1\21\4\3\1\22"+
    "\1\23\16\3\1\24\1\25\1\26\1\27\1\30\1\0"+
    "\1\31\2\0\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\1\40\1\41\1\42\1\0\1\43\3\0\1\44\1\45"+
    "\2\3\1\46\1\47\6\3\1\50\1\3\1\51\2\3"+
    "\1\52\3\3\1\53\1\0\1\54\1\55\1\56\1\57"+
    "\1\0\1\60\1\61\1\62\1\3\1\63\1\64\1\3"+
    "\1\65\1\66\1\67\1\70\1\71\1\3\1\72\1\3"+
    "\1\0\1\54\1\55\1\73\2\3\1\74\1\75\1\76"+
    "\1\0\1\54\1\55\1\3\1\21\1\3\1\77\1\54"+
    "\1\55\1\100\1\101\1\54\1\55\1\54\1\55\1\54"+
    "\1\55\1\54\1\55\30\54";

  private static int [] zzUnpackAction() {
    int [] result = new int[182];
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
    "\0\0\0\63\0\63\0\146\0\231\0\314\0\377\0\u0132"+
    "\0\u0165\0\u0198\0\u01cb\0\u01fe\0\u01fe\0\u01fe\0\u01fe\0\u01fe"+
    "\0\u0231\0\u0264\0\u0297\0\u02ca\0\u02fd\0\u0330\0\u0363\0\u0396"+
    "\0\u03c9\0\u01fe\0\u03fc\0\u01fe\0\u01fe\0\u042f\0\u0462\0\u0495"+
    "\0\u04c8\0\u04fb\0\u052e\0\u0561\0\u0594\0\u05c7\0\u05fa\0\u062d"+
    "\0\u0660\0\u0693\0\u06c6\0\u01fe\0\u06f9\0\u072c\0\u075f\0\u0792"+
    "\0\u01fe\0\u01fe\0\u07c5\0\u07f8\0\u082b\0\u085e\0\u0891\0\u08c4"+
    "\0\u08f7\0\u092a\0\u095d\0\u0990\0\u09c3\0\u09f6\0\u0a29\0\u0a5c"+
    "\0\146\0\146\0\u01fe\0\u01fe\0\u01fe\0\u0a8f\0\u01fe\0\u0ac2"+
    "\0\u0af5\0\u01fe\0\u01fe\0\u01fe\0\u01fe\0\u01fe\0\u01fe\0\u01fe"+
    "\0\u01fe\0\u01fe\0\u0b28\0\u01fe\0\u0b5b\0\u0b8e\0\u0bc1\0\146"+
    "\0\146\0\u0bf4\0\u0c27\0\146\0\146\0\u0c5a\0\u0c8d\0\u0cc0"+
    "\0\u0cf3\0\u0d26\0\u0d59\0\146\0\u0d8c\0\146\0\u0dbf\0\u0df2"+
    "\0\146\0\u0e25\0\u0e58\0\u0e8b\0\146\0\u0ebe\0\u0ef1\0\u0f24"+
    "\0\u01fe\0\u01fe\0\u0f57\0\u01fe\0\u0f8a\0\146\0\u0fbd\0\146"+
    "\0\146\0\u0ff0\0\146\0\146\0\146\0\146\0\146\0\u1023"+
    "\0\146\0\u1056\0\u1089\0\u10bc\0\u10ef\0\u01fe\0\u1122\0\u1155"+
    "\0\u1188\0\146\0\146\0\u11bb\0\u11ee\0\u1221\0\u1254\0\146"+
    "\0\u1287\0\u01fe\0\u12ba\0\u12ed\0\146\0\146\0\u1320\0\u1353"+
    "\0\u1386\0\u13b9\0\u13ec\0\u141f\0\u1452\0\u01fe\0\u1485\0\u14b8"+
    "\0\u14eb\0\u151e\0\u1551\0\u1584\0\u15b7\0\u15ea\0\u161d\0\u1650"+
    "\0\u1683\0\u16b6\0\u16e9\0\u171c\0\u174f\0\u1782\0\u17b5\0\u17e8"+
    "\0\u181b\0\u184e\0\u1881\0\u18b4\0\u18e7\0\u01fe";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[182];
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
    "\1\0\1\2\1\3\1\4\1\5\1\0\1\6\11\0"+
    "\1\4\1\7\1\10\1\4\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\4\1\22\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
    "\1\4\1\5\2\4\1\34\4\4\1\35\6\0\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
    "\1\47\1\50\1\51\2\0\1\52\42\0\2\4\13\0"+
    "\6\4\6\0\11\4\3\0\4\4\1\0\4\4\6\0"+
    "\1\5\44\0\1\5\10\0\1\53\17\0\1\54\46\0"+
    "\2\4\13\0\3\4\1\55\2\4\6\0\11\4\3\0"+
    "\4\4\1\0\4\4\5\0\2\4\13\0\6\4\6\0"+
    "\7\4\1\56\1\4\3\0\4\4\1\0\4\4\5\0"+
    "\2\4\13\0\6\4\6\0\7\4\1\57\1\4\3\0"+
    "\4\4\1\0\4\4\5\0\2\4\13\0\6\4\6\0"+
    "\11\4\3\0\4\4\1\0\3\4\1\60\16\0\1\61"+
    "\31\0\1\62\102\0\2\4\13\0\3\4\1\63\2\4"+
    "\6\0\1\4\1\64\7\4\3\0\4\4\1\0\4\4"+
    "\5\0\2\4\13\0\1\65\5\4\6\0\11\4\3\0"+
    "\4\4\1\0\4\4\5\0\2\4\13\0\1\66\3\4"+
    "\1\67\1\4\6\0\5\4\1\70\3\4\3\0\4\4"+
    "\1\0\4\4\5\0\2\4\13\0\6\4\6\0\10\4"+
    "\1\71\3\0\4\4\1\0\4\4\5\0\2\4\13\0"+
    "\6\4\6\0\7\4\1\72\1\73\3\0\4\4\1\0"+
    "\4\4\5\0\2\4\13\0\1\74\1\4\1\75\3\4"+
    "\6\0\5\4\1\76\3\4\3\0\4\4\1\0\4\4"+
    "\5\0\2\4\13\0\6\4\6\0\5\4\1\77\3\4"+
    "\3\0\4\4\1\0\1\4\1\100\2\4\5\0\2\4"+
    "\13\0\1\4\1\101\4\4\6\0\1\102\10\4\3\0"+
    "\4\4\1\0\4\4\30\0\1\103\61\0\1\104\6\0"+
    "\1\105\1\106\5\0\1\107\4\0\1\110\1\0\1\111"+
    "\11\0\2\112\61\0\2\113\61\0\2\114\61\0\2\115"+
    "\61\0\2\116\61\0\2\117\61\0\2\120\61\0\2\121"+
    "\74\0\1\45\47\0\2\122\11\0\1\123\47\0\2\124"+
    "\11\0\1\125\67\0\1\126\65\0\1\127\42\0\1\53"+
    "\44\0\1\53\14\0\2\4\13\0\5\4\1\130\6\0"+
    "\11\4\3\0\4\4\1\0\4\4\5\0\2\4\13\0"+
    "\6\4\6\0\1\131\10\4\3\0\4\4\1\0\4\4"+
    "\5\0\2\4\13\0\1\132\5\4\6\0\11\4\3\0"+
    "\4\4\1\0\4\4\5\0\2\4\13\0\6\4\6\0"+
    "\7\4\1\133\1\4\3\0\4\4\1\0\4\4\5\0"+
    "\2\4\13\0\4\4\1\134\1\4\6\0\11\4\3\0"+
    "\4\4\1\0\4\4\5\0\2\4\13\0\1\4\1\135"+
    "\4\4\6\0\11\4\3\0\4\4\1\0\4\4\5\0"+
    "\2\4\13\0\6\4\6\0\3\4\1\136\5\4\3\0"+
    "\4\4\1\0\4\4\5\0\2\4\13\0\6\4\6\0"+
    "\10\4\1\137\3\0\4\4\1\0\4\4\5\0\2\4"+
    "\13\0\3\4\1\140\2\4\6\0\10\4\1\141\3\0"+
    "\4\4\1\0\4\4\5\0\2\4\13\0\3\4\1\142"+
    "\2\4\6\0\11\4\3\0\4\4\1\0\4\4\5\0"+
    "\2\4\13\0\6\4\6\0\11\4\3\0\4\4\1\0"+
    "\1\143\3\4\5\0\2\4\13\0\5\4\1\144\6\0"+
    "\11\4\3\0\4\4\1\0\4\4\5\0\2\4\13\0"+
    "\6\4\6\0\4\4\1\145\4\4\3\0\4\4\1\0"+
    "\4\4\5\0\2\4\13\0\4\4\1\146\1\4\6\0"+
    "\4\4\1\147\1\150\3\4\3\0\4\4\1\0\4\4"+
    "\5\0\2\4\13\0\4\4\1\151\1\4\6\0\11\4"+
    "\3\0\4\4\1\0\4\4\5\0\2\4\13\0\6\4"+
    "\6\0\7\4\1\152\1\4\3\0\4\4\1\0\4\4"+
    "\5\0\2\4\13\0\6\4\6\0\4\4\1\153\4\4"+
    "\3\0\4\4\1\0\4\4\5\0\2\4\13\0\6\4"+
    "\6\0\1\4\1\154\7\4\3\0\4\4\1\0\2\4"+
    "\1\155\1\4\6\0\1\156\13\0\1\156\1\0\1\156"+
    "\11\0\1\156\5\0\2\156\4\0\2\156\1\0\1\156"+
    "\60\0\1\157\15\0\1\160\13\0\1\160\1\0\1\160"+
    "\11\0\1\160\5\0\2\160\4\0\2\160\1\0\1\160"+
    "\10\0\2\161\61\0\2\162\102\0\1\163\41\0\2\164"+
    "\63\0\2\4\13\0\2\4\1\165\3\4\6\0\11\4"+
    "\3\0\4\4\1\0\4\4\5\0\2\4\13\0\1\4"+
    "\1\166\4\4\6\0\11\4\3\0\4\4\1\0\4\4"+
    "\5\0\2\4\13\0\6\4\6\0\4\4\1\167\4\4"+
    "\3\0\4\4\1\0\4\4\5\0\2\4\13\0\4\4"+
    "\1\170\1\4\6\0\11\4\3\0\4\4\1\0\4\4"+
    "\5\0\2\4\13\0\6\4\6\0\6\4\1\171\2\4"+
    "\3\0\4\4\1\0\4\4\5\0\2\4\13\0\1\4"+
    "\1\172\4\4\6\0\11\4\3\0\4\4\1\0\4\4"+
    "\5\0\2\4\13\0\5\4\1\173\6\0\11\4\3\0"+
    "\4\4\1\0\4\4\5\0\2\4\13\0\6\4\6\0"+
    "\7\4\1\174\1\4\3\0\4\4\1\0\4\4\5\0"+
    "\2\4\13\0\5\4\1\175\6\0\11\4\3\0\4\4"+
    "\1\0\4\4\5\0\2\4\13\0\6\4\6\0\7\4"+
    "\1\176\1\4\3\0\4\4\1\0\4\4\5\0\2\4"+
    "\13\0\6\4\6\0\5\4\1\177\3\4\3\0\4\4"+
    "\1\0\4\4\5\0\2\4\13\0\1\200\5\4\6\0"+
    "\11\4\3\0\4\4\1\0\4\4\5\0\2\4\13\0"+
    "\6\4\6\0\7\4\1\201\1\4\3\0\4\4\1\0"+
    "\4\4\5\0\2\4\13\0\1\202\5\4\6\0\11\4"+
    "\3\0\4\4\1\0\4\4\6\0\1\203\13\0\1\203"+
    "\1\0\1\203\11\0\1\203\5\0\2\203\4\0\2\203"+
    "\1\0\1\203\60\0\1\204\15\0\1\205\13\0\1\205"+
    "\1\0\1\205\11\0\1\205\5\0\2\205\4\0\2\205"+
    "\1\0\1\205\10\0\2\206\63\0\2\4\13\0\6\4"+
    "\6\0\10\4\1\207\3\0\4\4\1\0\4\4\5\0"+
    "\2\4\13\0\5\4\1\210\6\0\11\4\3\0\4\4"+
    "\1\0\4\4\5\0\2\4\13\0\5\4\1\211\6\0"+
    "\11\4\3\0\4\4\1\0\4\4\5\0\2\4\13\0"+
    "\4\4\1\212\1\4\6\0\11\4\3\0\4\4\1\0"+
    "\4\4\5\0\2\4\13\0\6\4\6\0\5\4\1\213"+
    "\3\4\3\0\4\4\1\0\4\4\6\0\1\214\13\0"+
    "\1\214\1\0\1\214\11\0\1\214\5\0\2\214\4\0"+
    "\2\214\1\0\1\214\60\0\1\215\15\0\1\216\13\0"+
    "\1\216\1\0\1\216\11\0\1\216\5\0\2\216\4\0"+
    "\2\216\1\0\1\216\12\0\2\4\13\0\1\4\1\217"+
    "\4\4\6\0\11\4\3\0\4\4\1\0\4\4\5\0"+
    "\2\4\13\0\3\4\1\220\2\4\6\0\11\4\3\0"+
    "\4\4\1\0\4\4\5\0\2\4\13\0\6\4\6\0"+
    "\5\4\1\221\3\4\3\0\4\4\1\0\4\4\6\0"+
    "\1\222\13\0\1\222\1\0\1\222\11\0\1\222\5\0"+
    "\2\222\4\0\2\222\1\0\1\222\60\0\1\223\15\0"+
    "\1\224\13\0\1\224\1\0\1\224\11\0\1\224\5\0"+
    "\2\224\4\0\2\224\1\0\1\224\12\0\2\4\13\0"+
    "\5\4\1\225\6\0\11\4\3\0\4\4\1\0\4\4"+
    "\5\0\2\4\13\0\1\4\1\226\4\4\6\0\11\4"+
    "\3\0\4\4\1\0\4\4\53\0\1\227\15\0\1\230"+
    "\13\0\1\230\1\0\1\230\11\0\1\230\5\0\2\230"+
    "\4\0\2\230\1\0\1\230\60\0\1\231\15\0\1\232"+
    "\13\0\1\232\1\0\1\232\11\0\1\232\5\0\2\232"+
    "\4\0\2\232\1\0\1\232\60\0\1\233\15\0\1\234"+
    "\13\0\1\234\1\0\1\234\11\0\1\234\5\0\2\234"+
    "\4\0\2\234\1\0\1\234\60\0\1\235\15\0\1\236"+
    "\13\0\1\236\1\0\1\236\11\0\1\236\5\0\2\236"+
    "\4\0\2\236\1\0\1\236\60\0\1\237\62\0\1\240"+
    "\62\0\1\241\62\0\1\242\62\0\1\243\62\0\1\244"+
    "\62\0\1\245\62\0\1\246\62\0\1\247\62\0\1\250"+
    "\62\0\1\251\62\0\1\252\62\0\1\253\62\0\1\254"+
    "\62\0\1\255\62\0\1\256\62\0\1\257\62\0\1\260"+
    "\62\0\1\261\62\0\1\262\62\0\1\263\62\0\1\264"+
    "\62\0\1\265\62\0\1\266\11\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6426];
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
    "\1\0\12\1\5\11\11\1\1\11\1\0\2\11\15\0"+
    "\1\1\1\11\4\1\2\11\20\1\3\11\1\0\1\11"+
    "\2\0\11\11\1\0\1\11\3\0\26\1\1\0\2\1"+
    "\2\11\1\0\1\11\16\1\1\0\2\1\1\11\5\1"+
    "\1\0\5\1\1\11\13\1\1\11\27\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[182];
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
    while (i < 170) {
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
          case 66: break;
          case 2: 
            { //skip whitespace
            }
          case 67: break;
          case 3: 
            { // VARIABLE
	       return new Symbol(sym.VARIABLE, yytext());
            }
          case 68: break;
          case 4: 
            { // INTEGER
	       return new Symbol(sym.INTEGER, 
				 new Double(yytext()));
            }
          case 69: break;
          case 5: 
            { return new Symbol(sym.MINUS);
            }
          case 70: break;
          case 6: 
            { return new Symbol(sym.COLON);
            }
          case 71: break;
          case 7: 
            { return new Symbol(sym.LPAREN);
            }
          case 72: break;
          case 8: 
            { return new Symbol(sym.RPAREN);
            }
          case 73: break;
          case 9: 
            { return new Symbol(sym.LBRACE);
            }
          case 74: break;
          case 10: 
            { return new Symbol(sym.RBRACE);
            }
          case 75: break;
          case 11: 
            { return new Symbol(sym.COMMA);
            }
          case 76: break;
          case 12: 
            { return new Symbol(sym.LSQR);
            }
          case 77: break;
          case 13: 
            { return new Symbol(sym.RSQR);
            }
          case 78: break;
          case 14: 
            { return new Symbol(sym.QUESTION);
            }
          case 79: break;
          case 15: 
            { return new Symbol(sym.SEMI);
            }
          case 80: break;
          case 16: 
            { // FLOAT
	       return new Symbol(sym.INTEGER, 
				 new Double(yytext()));
            }
          case 81: break;
          case 17: 
            { return new Symbol(sym.MAPS);
            }
          case 82: break;
          case 18: 
            { return new Symbol(sym.ASSIGN);
            }
          case 83: break;
          case 19: 
            { return new Symbol(sym.RVEC);
            }
          case 84: break;
          case 20: 
            { return new Symbol(sym.IN);
            }
          case 85: break;
          case 21: 
            { return new Symbol(sym.IF);
            }
          case 86: break;
          case 22: 
            { return new Symbol(sym.LVEC);
            }
          case 87: break;
          case 23: 
            { return new Symbol(sym.BOOL, new Boolean(true));
            }
          case 88: break;
          case 24: 
            { return new Symbol(sym.BOOL, new Boolean(false));
            }
          case 89: break;
          case 25: 
            { return new Symbol(sym.EMPTY);
            }
          case 90: break;
          case 26: 
            { return new Symbol(sym.PLUS);
            }
          case 91: break;
          case 27: 
            { return new Symbol(sym.SUBTRACT);
            }
          case 92: break;
          case 28: 
            { return new Symbol(sym.MUL);
            }
          case 93: break;
          case 29: 
            { return new Symbol(sym.DIV);
            }
          case 94: break;
          case 30: 
            { return new Symbol(sym.MOD);
            }
          case 95: break;
          case 31: 
            { return new Symbol(sym.POW);
            }
          case 96: break;
          case 32: 
            { return new Symbol(sym.CONCAT);
            }
          case 97: break;
          case 33: 
            { return new Symbol(sym.COMPARE, "=");
            }
          case 98: break;
          case 34: 
            { return new Symbol(sym.COMPARE, "<");
            }
          case 99: break;
          case 35: 
            { return new Symbol(sym.COMPARE, ">");
            }
          case 100: break;
          case 36: 
            { return new Symbol(sym.LOGOP, "not");
            }
          case 101: break;
          case 37: 
            { return new Symbol(sym.DEF);
            }
          case 102: break;
          case 38: 
            { return new Symbol(sym.FOR);
            }
          case 103: break;
          case 39: 
            { return new Symbol(sym.FUN);
            }
          case 104: break;
          case 40: 
            { return new Symbol(sym.LET);
            }
          case 105: break;
          case 41: 
            { return new Symbol(sym.CAR);
            }
          case 106: break;
          case 42: 
            { return new Symbol(sym.CDR);
            }
          case 107: break;
          case 43: 
            { return new Symbol(sym.EQV);
            }
          case 108: break;
          case 44: 
            { return new Symbol(sym.BIN, yytext());
            }
          case 109: break;
          case 45: 
            { return new Symbol(sym.HEX, yytext());
            }
          case 110: break;
          case 46: 
            { return new Symbol(sym.COMPARE, "<=");
            }
          case 111: break;
          case 47: 
            { return new Symbol(sym.COMPARE, ">=");
            }
          case 112: break;
          case 48: 
            { return new Symbol(sym.LOGOP, "or");
            }
          case 113: break;
          case 49: 
            { return new Symbol(sym.READ);
            }
          case 114: break;
          case 50: 
            { return new Symbol(sym.THEN);
            }
          case 115: break;
          case 51: 
            { return new Symbol(sym.PAIR);
            }
          case 116: break;
          case 52: 
            { return new Symbol(sym.PROC);
            }
          case 117: break;
          case 53: 
            { return new Symbol(sym.PLOT);
            }
          case 118: break;
          case 54: 
            { return new Symbol(sym.SIZE);
            }
          case 119: break;
          case 55: 
            { return new Symbol(sym.LIST);
            }
          case 120: break;
          case 56: 
            { return new Symbol(sym.CASE);
            }
          case 121: break;
          case 57: 
            { return new Symbol(sym.CALL);
            }
          case 122: break;
          case 58: 
            { return new Symbol(sym.ELSE);
            }
          case 123: break;
          case 59: 
            { return new Symbol(sym.LOGOP, "and");
            }
          case 124: break;
          case 60: 
            { return new Symbol(sym.PRINT);
            }
          case 125: break;
          case 61: 
            { return new Symbol(sym.CLEAR);
            }
          case 126: break;
          case 62: 
            { return new Symbol(sym.EQUAL);
            }
          case 127: break;
          case 63: 
            { return new Symbol(sym.UNI, yytext());
            }
          case 128: break;
          case 64: 
            { return new Symbol(sym.READINT);
            }
          case 129: break;
          case 65: 
            { return new Symbol(sym.PRINTLN);
            }
          case 130: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
