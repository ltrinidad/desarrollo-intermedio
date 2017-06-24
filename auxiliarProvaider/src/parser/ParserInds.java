/* Generated By:JavaCC: Do not edit this line. ParserInds.java */
package parser;
import java.io.StringReader;
import modelo.*;
import java.io.InputStream;

public class ParserInds implements ParserIndsConstants {
        private IndicadorBuilder indicadorBuilder;

        public ParserInds(IndicadorBuilder indicadorBuilder, String formulaCompleta) {
                this(new StringReader(formulaCompleta));
                this.indicadorBuilder = indicadorBuilder;
        }

        public Indicador parsearFormula() throws ParseException
        {
                this.formulaDelIndicador();

                return indicadorBuilder.construir();
        }

  final public void formulaDelIndicador() throws ParseException {
  Token nombre;
    nombre = jj_consume_token(COEFICIENTE);
                           indicadorBuilder.setNombreIndicador(nombre.image);
    jj_consume_token(11);
    ladoDerecho();
  }

  final public void ladoDerecho() throws ParseException {
        String operador;
        Token literalIzq;
        Token coefIzq;
        Token literalDer;
        Token coefDer;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMERO:
      literalIzq = jj_consume_token(NUMERO);
                                  indicadorBuilder.setLadoIzquierdo(new Literal(Double.parseDouble(literalIzq.image)));
      break;
    case COEFICIENTE:
      coefIzq = jj_consume_token(COEFICIENTE);
                                    indicadorBuilder.crearCoefIzquierdo(coefIzq.image);
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SUMA:
      case RESTA:
      case PRODUCTO:
      case DIVISION:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      operador = operador();
                                 indicadorBuilder.setOperacion(operador);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMERO:
        literalDer = jj_consume_token(NUMERO);
                                   indicadorBuilder.setLadoDerecho(new Literal(Double.parseDouble(literalDer.image)));
        break;
      case COEFICIENTE:
        coefDer = jj_consume_token(COEFICIENTE);
                                      indicadorBuilder.crearCoefDerecho(coefDer.image);
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public String operador() throws ParseException {
 Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SUMA:
      t = jj_consume_token(SUMA);
      break;
    case RESTA:
      t = jj_consume_token(RESTA);
      break;
    case PRODUCTO:
      t = jj_consume_token(PRODUCTO);
      break;
    case DIVISION:
      t = jj_consume_token(DIVISION);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
                                                                {if (true) return t.image;}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public ParserIndsTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[4];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x500,0xf0,0x500,0xf0,};
   }

  /** Constructor with InputStream. */
  public ParserInds(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ParserInds(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ParserIndsTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ParserInds(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserIndsTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ParserInds(ParserIndsTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ParserIndsTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[12];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 4; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 12; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}