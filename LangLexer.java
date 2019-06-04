// Generated from Lang.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, OP_INC=26, OP_DEC=27, OP_DOT=28, OP_LNOT=29, OP_BNOT=30, OP_MUL=31, 
		OP_DIV=32, OP_MOD=33, OP_LSH=34, OP_RSH=35, OP_LT=36, OP_LTE=37, OP_GT=38, 
		OP_GTE=39, OP_EQ=40, OP_NEQ=41, OP_BAND=42, OP_BOR=43, OP_BXOR=44, OP_LAND=45, 
		OP_LOR=46, OP_ADD=47, OP_SUB=48, OP_ASG=49, OP_ADD_ASG=50, OP_SUB_ASG=51, 
		OP_MUL_ASG=52, OP_DIV_ASG=53, OP_MOD_ASG=54, OP_LSH_ASG=55, OP_RSH_ASG=56, 
		OP_BAND_ASG=57, OP_BXOR_ASG=58, OP_BOR_ASG=59, NUM=60, ID=61, STR=62, 
		CHR=63, WS=64, COMMENT=65, MULTICOMMENT=66;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"OP_INC", "OP_DEC", "OP_DOT", "OP_LNOT", "OP_BNOT", "OP_MUL", "OP_DIV", 
			"OP_MOD", "OP_LSH", "OP_RSH", "OP_LT", "OP_LTE", "OP_GT", "OP_GTE", "OP_EQ", 
			"OP_NEQ", "OP_BAND", "OP_BOR", "OP_BXOR", "OP_LAND", "OP_LOR", "OP_ADD", 
			"OP_SUB", "OP_ASG", "OP_ADD_ASG", "OP_SUB_ASG", "OP_MUL_ASG", "OP_DIV_ASG", 
			"OP_MOD_ASG", "OP_LSH_ASG", "OP_RSH_ASG", "OP_BAND_ASG", "OP_BXOR_ASG", 
			"OP_BOR_ASG", "NUM", "ID", "STR", "CHR", "WS", "COMMENT", "MULTICOMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'?'", "':'", "','", "'{'", "'}'", 
			"'var'", "'val'", "'fn'", "'class'", "'singelton'", "'struct'", "'if'", 
			"'elif'", "'else'", "'while'", "'do'", "';'", "'for'", "'return'", "'continue'", 
			"'break'", "'++'", "'--'", "'.'", "'!'", "'~'", "'*'", "'/'", "'%'", 
			"'<<'", "'>>'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&'", 
			"'|'", "'^'", "'&&'", "'||'", "'+'", "'-'", "'='", "'+='", "'-='", "'*='", 
			"'/='", "'%='", "'<<='", "'>>='", "'&='", "'^='", "'|='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "OP_INC", "OP_DEC", "OP_DOT", "OP_LNOT", "OP_BNOT", "OP_MUL", 
			"OP_DIV", "OP_MOD", "OP_LSH", "OP_RSH", "OP_LT", "OP_LTE", "OP_GT", "OP_GTE", 
			"OP_EQ", "OP_NEQ", "OP_BAND", "OP_BOR", "OP_BXOR", "OP_LAND", "OP_LOR", 
			"OP_ADD", "OP_SUB", "OP_ASG", "OP_ADD_ASG", "OP_SUB_ASG", "OP_MUL_ASG", 
			"OP_DIV_ASG", "OP_MOD_ASG", "OP_LSH_ASG", "OP_RSH_ASG", "OP_BAND_ASG", 
			"OP_BXOR_ASG", "OP_BOR_ASG", "NUM", "ID", "STR", "CHR", "WS", "COMMENT", 
			"MULTICOMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2D\u0187\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3&\3"+
		"&\3&\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3.\3/"+
		"\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65"+
		"\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38\38\39\39\39\39\3:\3"+
		":\3:\3;\3;\3;\3<\3<\3<\3=\6=\u0149\n=\r=\16=\u014a\3>\6>\u014e\n>\r>\16"+
		">\u014f\3>\7>\u0153\n>\f>\16>\u0156\13>\3?\3?\3?\7?\u015b\n?\f?\16?\u015e"+
		"\13?\3?\3?\3@\3@\5@\u0164\n@\3@\3@\3@\3A\3A\3A\3A\3B\3B\7B\u016f\nB\f"+
		"B\16B\u0172\13B\3B\3B\3B\3B\3C\3C\3C\3C\3C\7C\u017d\nC\fC\16C\u0180\13"+
		"C\3C\3C\3C\3C\3C\3C\4\u0170\u017e\2D\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083"+
		"C\u0085D\3\2\b\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\3\2$$\3\2))\5\2\13\f"+
		"\17\17\"\"\2\u018e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k"+
		"\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2"+
		"\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2"+
		"\u0083\3\2\2\2\2\u0085\3\2\2\2\3\u0087\3\2\2\2\5\u0089\3\2\2\2\7\u008b"+
		"\3\2\2\2\t\u008d\3\2\2\2\13\u008f\3\2\2\2\r\u0091\3\2\2\2\17\u0093\3\2"+
		"\2\2\21\u0095\3\2\2\2\23\u0097\3\2\2\2\25\u0099\3\2\2\2\27\u009d\3\2\2"+
		"\2\31\u00a1\3\2\2\2\33\u00a4\3\2\2\2\35\u00aa\3\2\2\2\37\u00b4\3\2\2\2"+
		"!\u00bb\3\2\2\2#\u00be\3\2\2\2%\u00c3\3\2\2\2\'\u00c8\3\2\2\2)\u00ce\3"+
		"\2\2\2+\u00d1\3\2\2\2-\u00d3\3\2\2\2/\u00d7\3\2\2\2\61\u00de\3\2\2\2\63"+
		"\u00e7\3\2\2\2\65\u00ed\3\2\2\2\67\u00f0\3\2\2\29\u00f3\3\2\2\2;\u00f5"+
		"\3\2\2\2=\u00f7\3\2\2\2?\u00f9\3\2\2\2A\u00fb\3\2\2\2C\u00fd\3\2\2\2E"+
		"\u00ff\3\2\2\2G\u0102\3\2\2\2I\u0105\3\2\2\2K\u0107\3\2\2\2M\u010a\3\2"+
		"\2\2O\u010c\3\2\2\2Q\u010f\3\2\2\2S\u0112\3\2\2\2U\u0115\3\2\2\2W\u0117"+
		"\3\2\2\2Y\u0119\3\2\2\2[\u011b\3\2\2\2]\u011e\3\2\2\2_\u0121\3\2\2\2a"+
		"\u0123\3\2\2\2c\u0125\3\2\2\2e\u0127\3\2\2\2g\u012a\3\2\2\2i\u012d\3\2"+
		"\2\2k\u0130\3\2\2\2m\u0133\3\2\2\2o\u0136\3\2\2\2q\u013a\3\2\2\2s\u013e"+
		"\3\2\2\2u\u0141\3\2\2\2w\u0144\3\2\2\2y\u0148\3\2\2\2{\u014d\3\2\2\2}"+
		"\u0157\3\2\2\2\177\u0161\3\2\2\2\u0081\u0168\3\2\2\2\u0083\u016c\3\2\2"+
		"\2\u0085\u0177\3\2\2\2\u0087\u0088\7*\2\2\u0088\4\3\2\2\2\u0089\u008a"+
		"\7+\2\2\u008a\6\3\2\2\2\u008b\u008c\7]\2\2\u008c\b\3\2\2\2\u008d\u008e"+
		"\7_\2\2\u008e\n\3\2\2\2\u008f\u0090\7A\2\2\u0090\f\3\2\2\2\u0091\u0092"+
		"\7<\2\2\u0092\16\3\2\2\2\u0093\u0094\7.\2\2\u0094\20\3\2\2\2\u0095\u0096"+
		"\7}\2\2\u0096\22\3\2\2\2\u0097\u0098\7\177\2\2\u0098\24\3\2\2\2\u0099"+
		"\u009a\7x\2\2\u009a\u009b\7c\2\2\u009b\u009c\7t\2\2\u009c\26\3\2\2\2\u009d"+
		"\u009e\7x\2\2\u009e\u009f\7c\2\2\u009f\u00a0\7n\2\2\u00a0\30\3\2\2\2\u00a1"+
		"\u00a2\7h\2\2\u00a2\u00a3\7p\2\2\u00a3\32\3\2\2\2\u00a4\u00a5\7e\2\2\u00a5"+
		"\u00a6\7n\2\2\u00a6\u00a7\7c\2\2\u00a7\u00a8\7u\2\2\u00a8\u00a9\7u\2\2"+
		"\u00a9\34\3\2\2\2\u00aa\u00ab\7u\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7"+
		"p\2\2\u00ad\u00ae\7i\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7n\2\2\u00b0\u00b1"+
		"\7v\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7p\2\2\u00b3\36\3\2\2\2\u00b4\u00b5"+
		"\7u\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7t\2\2\u00b7\u00b8\7w\2\2\u00b8"+
		"\u00b9\7e\2\2\u00b9\u00ba\7v\2\2\u00ba \3\2\2\2\u00bb\u00bc\7k\2\2\u00bc"+
		"\u00bd\7h\2\2\u00bd\"\3\2\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7n\2\2\u00c0"+
		"\u00c1\7k\2\2\u00c1\u00c2\7h\2\2\u00c2$\3\2\2\2\u00c3\u00c4\7g\2\2\u00c4"+
		"\u00c5\7n\2\2\u00c5\u00c6\7u\2\2\u00c6\u00c7\7g\2\2\u00c7&\3\2\2\2\u00c8"+
		"\u00c9\7y\2\2\u00c9\u00ca\7j\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7n\2\2"+
		"\u00cc\u00cd\7g\2\2\u00cd(\3\2\2\2\u00ce\u00cf\7f\2\2\u00cf\u00d0\7q\2"+
		"\2\u00d0*\3\2\2\2\u00d1\u00d2\7=\2\2\u00d2,\3\2\2\2\u00d3\u00d4\7h\2\2"+
		"\u00d4\u00d5\7q\2\2\u00d5\u00d6\7t\2\2\u00d6.\3\2\2\2\u00d7\u00d8\7t\2"+
		"\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7w\2\2\u00db\u00dc"+
		"\7t\2\2\u00dc\u00dd\7p\2\2\u00dd\60\3\2\2\2\u00de\u00df\7e\2\2\u00df\u00e0"+
		"\7q\2\2\u00e0\u00e1\7p\2\2\u00e1\u00e2\7v\2\2\u00e2\u00e3\7k\2\2\u00e3"+
		"\u00e4\7p\2\2\u00e4\u00e5\7w\2\2\u00e5\u00e6\7g\2\2\u00e6\62\3\2\2\2\u00e7"+
		"\u00e8\7d\2\2\u00e8\u00e9\7t\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7c\2\2"+
		"\u00eb\u00ec\7m\2\2\u00ec\64\3\2\2\2\u00ed\u00ee\7-\2\2\u00ee\u00ef\7"+
		"-\2\2\u00ef\66\3\2\2\2\u00f0\u00f1\7/\2\2\u00f1\u00f2\7/\2\2\u00f28\3"+
		"\2\2\2\u00f3\u00f4\7\60\2\2\u00f4:\3\2\2\2\u00f5\u00f6\7#\2\2\u00f6<\3"+
		"\2\2\2\u00f7\u00f8\7\u0080\2\2\u00f8>\3\2\2\2\u00f9\u00fa\7,\2\2\u00fa"+
		"@\3\2\2\2\u00fb\u00fc\7\61\2\2\u00fcB\3\2\2\2\u00fd\u00fe\7\'\2\2\u00fe"+
		"D\3\2\2\2\u00ff\u0100\7>\2\2\u0100\u0101\7>\2\2\u0101F\3\2\2\2\u0102\u0103"+
		"\7@\2\2\u0103\u0104\7@\2\2\u0104H\3\2\2\2\u0105\u0106\7>\2\2\u0106J\3"+
		"\2\2\2\u0107\u0108\7>\2\2\u0108\u0109\7?\2\2\u0109L\3\2\2\2\u010a\u010b"+
		"\7@\2\2\u010bN\3\2\2\2\u010c\u010d\7@\2\2\u010d\u010e\7?\2\2\u010eP\3"+
		"\2\2\2\u010f\u0110\7?\2\2\u0110\u0111\7?\2\2\u0111R\3\2\2\2\u0112\u0113"+
		"\7#\2\2\u0113\u0114\7?\2\2\u0114T\3\2\2\2\u0115\u0116\7(\2\2\u0116V\3"+
		"\2\2\2\u0117\u0118\7~\2\2\u0118X\3\2\2\2\u0119\u011a\7`\2\2\u011aZ\3\2"+
		"\2\2\u011b\u011c\7(\2\2\u011c\u011d\7(\2\2\u011d\\\3\2\2\2\u011e\u011f"+
		"\7~\2\2\u011f\u0120\7~\2\2\u0120^\3\2\2\2\u0121\u0122\7-\2\2\u0122`\3"+
		"\2\2\2\u0123\u0124\7/\2\2\u0124b\3\2\2\2\u0125\u0126\7?\2\2\u0126d\3\2"+
		"\2\2\u0127\u0128\7-\2\2\u0128\u0129\7?\2\2\u0129f\3\2\2\2\u012a\u012b"+
		"\7/\2\2\u012b\u012c\7?\2\2\u012ch\3\2\2\2\u012d\u012e\7,\2\2\u012e\u012f"+
		"\7?\2\2\u012fj\3\2\2\2\u0130\u0131\7\61\2\2\u0131\u0132\7?\2\2\u0132l"+
		"\3\2\2\2\u0133\u0134\7\'\2\2\u0134\u0135\7?\2\2\u0135n\3\2\2\2\u0136\u0137"+
		"\7>\2\2\u0137\u0138\7>\2\2\u0138\u0139\7?\2\2\u0139p\3\2\2\2\u013a\u013b"+
		"\7@\2\2\u013b\u013c\7@\2\2\u013c\u013d\7?\2\2\u013dr\3\2\2\2\u013e\u013f"+
		"\7(\2\2\u013f\u0140\7?\2\2\u0140t\3\2\2\2\u0141\u0142\7`\2\2\u0142\u0143"+
		"\7?\2\2\u0143v\3\2\2\2\u0144\u0145\7~\2\2\u0145\u0146\7?\2\2\u0146x\3"+
		"\2\2\2\u0147\u0149\t\2\2\2\u0148\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a"+
		"\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014bz\3\2\2\2\u014c\u014e\t\3\2\2"+
		"\u014d\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150"+
		"\3\2\2\2\u0150\u0154\3\2\2\2\u0151\u0153\t\4\2\2\u0152\u0151\3\2\2\2\u0153"+
		"\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155|\3\2\2\2"+
		"\u0156\u0154\3\2\2\2\u0157\u015c\7$\2\2\u0158\u015b\n\5\2\2\u0159\u015b"+
		"\7$\2\2\u015a\u0158\3\2\2\2\u015a\u0159\3\2\2\2\u015b\u015e\3\2\2\2\u015c"+
		"\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015f\3\2\2\2\u015e\u015c\3\2"+
		"\2\2\u015f\u0160\7$\2\2\u0160~\3\2\2\2\u0161\u0163\7)\2\2\u0162\u0164"+
		"\7^\2\2\u0163\u0162\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\3\2\2\2\u0165"+
		"\u0166\n\6\2\2\u0166\u0167\7)\2\2\u0167\u0080\3\2\2\2\u0168\u0169\t\7"+
		"\2\2\u0169\u016a\3\2\2\2\u016a\u016b\bA\2\2\u016b\u0082\3\2\2\2\u016c"+
		"\u0170\7%\2\2\u016d\u016f\13\2\2\2\u016e\u016d\3\2\2\2\u016f\u0172\3\2"+
		"\2\2\u0170\u0171\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0173\3\2\2\2\u0172"+
		"\u0170\3\2\2\2\u0173\u0174\7\f\2\2\u0174\u0175\3\2\2\2\u0175\u0176\bB"+
		"\2\2\u0176\u0084\3\2\2\2\u0177\u0178\7%\2\2\u0178\u0179\7%\2\2\u0179\u017a"+
		"\7@\2\2\u017a\u017e\3\2\2\2\u017b\u017d\13\2\2\2\u017c\u017b\3\2\2\2\u017d"+
		"\u0180\3\2\2\2\u017e\u017f\3\2\2\2\u017e\u017c\3\2\2\2\u017f\u0181\3\2"+
		"\2\2\u0180\u017e\3\2\2\2\u0181\u0182\7%\2\2\u0182\u0183\7%\2\2\u0183\u0184"+
		"\7>\2\2\u0184\u0185\3\2\2\2\u0185\u0186\bC\2\2\u0186\u0086\3\2\2\2\13"+
		"\2\u014a\u014f\u0154\u015a\u015c\u0163\u0170\u017e\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}