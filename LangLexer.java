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
		T__24=25, T__25=26, OP_INC=27, OP_DEC=28, OP_DOT=29, OP_LNOT=30, OP_BNOT=31, 
		OP_MUL=32, OP_DIV=33, OP_MOD=34, OP_LSH=35, OP_RSH=36, OP_LT=37, OP_LTE=38, 
		OP_GT=39, OP_GTE=40, OP_EQ=41, OP_NEQ=42, OP_BAND=43, OP_BOR=44, OP_BXOR=45, 
		OP_LAND=46, OP_LOR=47, OP_ADD=48, OP_SUB=49, OP_ASG=50, OP_ADD_ASG=51, 
		OP_SUB_ASG=52, OP_MUL_ASG=53, OP_DIV_ASG=54, OP_MOD_ASG=55, OP_LSH_ASG=56, 
		OP_RSH_ASG=57, OP_BAND_ASG=58, OP_BXOR_ASG=59, OP_BOR_ASG=60, NUM=61, 
		ID=62, STR=63, CHR=64, WS=65, COMMENT=66, MULTICOMMENT=67;
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
			"T__25", "OP_INC", "OP_DEC", "OP_DOT", "OP_LNOT", "OP_BNOT", "OP_MUL", 
			"OP_DIV", "OP_MOD", "OP_LSH", "OP_RSH", "OP_LT", "OP_LTE", "OP_GT", "OP_GTE", 
			"OP_EQ", "OP_NEQ", "OP_BAND", "OP_BOR", "OP_BXOR", "OP_LAND", "OP_LOR", 
			"OP_ADD", "OP_SUB", "OP_ASG", "OP_ADD_ASG", "OP_SUB_ASG", "OP_MUL_ASG", 
			"OP_DIV_ASG", "OP_MOD_ASG", "OP_LSH_ASG", "OP_RSH_ASG", "OP_BAND_ASG", 
			"OP_BXOR_ASG", "OP_BOR_ASG", "NUM", "ID", "STR", "CHR", "WS", "COMMENT", 
			"MULTICOMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'?'", "':'", "','", "'{'", "'}'", 
			"'var'", "'val'", "'->'", "'fn'", "'class'", "'singelton'", "'struct'", 
			"'if'", "'elif'", "'else'", "'while'", "'do'", "';'", "'for'", "'return'", 
			"'continue'", "'break'", "'++'", "'--'", "'.'", "'!'", "'~'", "'*'", 
			"'/'", "'%'", "'<<'", "'>>'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", 
			"'&'", "'|'", "'^'", "'&&'", "'||'", "'+'", "'-'", "'='", "'+='", "'-='", 
			"'*='", "'/='", "'%='", "'<<='", "'>>='", "'&='", "'^='", "'|='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "OP_INC", "OP_DEC", "OP_DOT", "OP_LNOT", "OP_BNOT", 
			"OP_MUL", "OP_DIV", "OP_MOD", "OP_LSH", "OP_RSH", "OP_LT", "OP_LTE", 
			"OP_GT", "OP_GTE", "OP_EQ", "OP_NEQ", "OP_BAND", "OP_BOR", "OP_BXOR", 
			"OP_LAND", "OP_LOR", "OP_ADD", "OP_SUB", "OP_ASG", "OP_ADD_ASG", "OP_SUB_ASG", 
			"OP_MUL_ASG", "OP_DIV_ASG", "OP_MOD_ASG", "OP_LSH_ASG", "OP_RSH_ASG", 
			"OP_BAND_ASG", "OP_BXOR_ASG", "OP_BOR_ASG", "NUM", "ID", "STR", "CHR", 
			"WS", "COMMENT", "MULTICOMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2E\u018c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\3\2\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\35\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3"+
		"%\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3-\3"+
		"-\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64"+
		"\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\39\3"+
		"9\3:\3:\3:\3:\3;\3;\3;\3<\3<\3<\3=\3=\3=\3>\6>\u014e\n>\r>\16>\u014f\3"+
		"?\6?\u0153\n?\r?\16?\u0154\3?\7?\u0158\n?\f?\16?\u015b\13?\3@\3@\3@\7"+
		"@\u0160\n@\f@\16@\u0163\13@\3@\3@\3A\3A\5A\u0169\nA\3A\3A\3A\3B\3B\3B"+
		"\3B\3C\3C\7C\u0174\nC\fC\16C\u0177\13C\3C\3C\3C\3C\3D\3D\3D\3D\3D\7D\u0182"+
		"\nD\fD\16D\u0185\13D\3D\3D\3D\3D\3D\3D\4\u0175\u0183\2E\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{"+
		"?}@\177A\u0081B\u0083C\u0085D\u0087E\3\2\b\3\2\62;\5\2C\\aac|\6\2\62;"+
		"C\\aac|\3\2$$\3\2))\5\2\13\f\17\17\"\"\2\u0193\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y"+
		"\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2"+
		"\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2"+
		"\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2"+
		"\2\3\u0089\3\2\2\2\5\u008b\3\2\2\2\7\u008d\3\2\2\2\t\u008f\3\2\2\2\13"+
		"\u0091\3\2\2\2\r\u0093\3\2\2\2\17\u0095\3\2\2\2\21\u0097\3\2\2\2\23\u0099"+
		"\3\2\2\2\25\u009b\3\2\2\2\27\u009f\3\2\2\2\31\u00a3\3\2\2\2\33\u00a6\3"+
		"\2\2\2\35\u00a9\3\2\2\2\37\u00af\3\2\2\2!\u00b9\3\2\2\2#\u00c0\3\2\2\2"+
		"%\u00c3\3\2\2\2\'\u00c8\3\2\2\2)\u00cd\3\2\2\2+\u00d3\3\2\2\2-\u00d6\3"+
		"\2\2\2/\u00d8\3\2\2\2\61\u00dc\3\2\2\2\63\u00e3\3\2\2\2\65\u00ec\3\2\2"+
		"\2\67\u00f2\3\2\2\29\u00f5\3\2\2\2;\u00f8\3\2\2\2=\u00fa\3\2\2\2?\u00fc"+
		"\3\2\2\2A\u00fe\3\2\2\2C\u0100\3\2\2\2E\u0102\3\2\2\2G\u0104\3\2\2\2I"+
		"\u0107\3\2\2\2K\u010a\3\2\2\2M\u010c\3\2\2\2O\u010f\3\2\2\2Q\u0111\3\2"+
		"\2\2S\u0114\3\2\2\2U\u0117\3\2\2\2W\u011a\3\2\2\2Y\u011c\3\2\2\2[\u011e"+
		"\3\2\2\2]\u0120\3\2\2\2_\u0123\3\2\2\2a\u0126\3\2\2\2c\u0128\3\2\2\2e"+
		"\u012a\3\2\2\2g\u012c\3\2\2\2i\u012f\3\2\2\2k\u0132\3\2\2\2m\u0135\3\2"+
		"\2\2o\u0138\3\2\2\2q\u013b\3\2\2\2s\u013f\3\2\2\2u\u0143\3\2\2\2w\u0146"+
		"\3\2\2\2y\u0149\3\2\2\2{\u014d\3\2\2\2}\u0152\3\2\2\2\177\u015c\3\2\2"+
		"\2\u0081\u0166\3\2\2\2\u0083\u016d\3\2\2\2\u0085\u0171\3\2\2\2\u0087\u017c"+
		"\3\2\2\2\u0089\u008a\7*\2\2\u008a\4\3\2\2\2\u008b\u008c\7+\2\2\u008c\6"+
		"\3\2\2\2\u008d\u008e\7]\2\2\u008e\b\3\2\2\2\u008f\u0090\7_\2\2\u0090\n"+
		"\3\2\2\2\u0091\u0092\7A\2\2\u0092\f\3\2\2\2\u0093\u0094\7<\2\2\u0094\16"+
		"\3\2\2\2\u0095\u0096\7.\2\2\u0096\20\3\2\2\2\u0097\u0098\7}\2\2\u0098"+
		"\22\3\2\2\2\u0099\u009a\7\177\2\2\u009a\24\3\2\2\2\u009b\u009c\7x\2\2"+
		"\u009c\u009d\7c\2\2\u009d\u009e\7t\2\2\u009e\26\3\2\2\2\u009f\u00a0\7"+
		"x\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7n\2\2\u00a2\30\3\2\2\2\u00a3\u00a4"+
		"\7/\2\2\u00a4\u00a5\7@\2\2\u00a5\32\3\2\2\2\u00a6\u00a7\7h\2\2\u00a7\u00a8"+
		"\7p\2\2\u00a8\34\3\2\2\2\u00a9\u00aa\7e\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac"+
		"\7c\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae\7u\2\2\u00ae\36\3\2\2\2\u00af\u00b0"+
		"\7u\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7p\2\2\u00b2\u00b3\7i\2\2\u00b3"+
		"\u00b4\7g\2\2\u00b4\u00b5\7n\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7q\2\2"+
		"\u00b7\u00b8\7p\2\2\u00b8 \3\2\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7v\2"+
		"\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7w\2\2\u00bd\u00be\7e\2\2\u00be\u00bf"+
		"\7v\2\2\u00bf\"\3\2\2\2\u00c0\u00c1\7k\2\2\u00c1\u00c2\7h\2\2\u00c2$\3"+
		"\2\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7n\2\2\u00c5\u00c6\7k\2\2\u00c6"+
		"\u00c7\7h\2\2\u00c7&\3\2\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\7n\2\2\u00ca"+
		"\u00cb\7u\2\2\u00cb\u00cc\7g\2\2\u00cc(\3\2\2\2\u00cd\u00ce\7y\2\2\u00ce"+
		"\u00cf\7j\2\2\u00cf\u00d0\7k\2\2\u00d0\u00d1\7n\2\2\u00d1\u00d2\7g\2\2"+
		"\u00d2*\3\2\2\2\u00d3\u00d4\7f\2\2\u00d4\u00d5\7q\2\2\u00d5,\3\2\2\2\u00d6"+
		"\u00d7\7=\2\2\u00d7.\3\2\2\2\u00d8\u00d9\7h\2\2\u00d9\u00da\7q\2\2\u00da"+
		"\u00db\7t\2\2\u00db\60\3\2\2\2\u00dc\u00dd\7t\2\2\u00dd\u00de\7g\2\2\u00de"+
		"\u00df\7v\2\2\u00df\u00e0\7w\2\2\u00e0\u00e1\7t\2\2\u00e1\u00e2\7p\2\2"+
		"\u00e2\62\3\2\2\2\u00e3\u00e4\7e\2\2\u00e4\u00e5\7q\2\2\u00e5\u00e6\7"+
		"p\2\2\u00e6\u00e7\7v\2\2\u00e7\u00e8\7k\2\2\u00e8\u00e9\7p\2\2\u00e9\u00ea"+
		"\7w\2\2\u00ea\u00eb\7g\2\2\u00eb\64\3\2\2\2\u00ec\u00ed\7d\2\2\u00ed\u00ee"+
		"\7t\2\2\u00ee\u00ef\7g\2\2\u00ef\u00f0\7c\2\2\u00f0\u00f1\7m\2\2\u00f1"+
		"\66\3\2\2\2\u00f2\u00f3\7-\2\2\u00f3\u00f4\7-\2\2\u00f48\3\2\2\2\u00f5"+
		"\u00f6\7/\2\2\u00f6\u00f7\7/\2\2\u00f7:\3\2\2\2\u00f8\u00f9\7\60\2\2\u00f9"+
		"<\3\2\2\2\u00fa\u00fb\7#\2\2\u00fb>\3\2\2\2\u00fc\u00fd\7\u0080\2\2\u00fd"+
		"@\3\2\2\2\u00fe\u00ff\7,\2\2\u00ffB\3\2\2\2\u0100\u0101\7\61\2\2\u0101"+
		"D\3\2\2\2\u0102\u0103\7\'\2\2\u0103F\3\2\2\2\u0104\u0105\7>\2\2\u0105"+
		"\u0106\7>\2\2\u0106H\3\2\2\2\u0107\u0108\7@\2\2\u0108\u0109\7@\2\2\u0109"+
		"J\3\2\2\2\u010a\u010b\7>\2\2\u010bL\3\2\2\2\u010c\u010d\7>\2\2\u010d\u010e"+
		"\7?\2\2\u010eN\3\2\2\2\u010f\u0110\7@\2\2\u0110P\3\2\2\2\u0111\u0112\7"+
		"@\2\2\u0112\u0113\7?\2\2\u0113R\3\2\2\2\u0114\u0115\7?\2\2\u0115\u0116"+
		"\7?\2\2\u0116T\3\2\2\2\u0117\u0118\7#\2\2\u0118\u0119\7?\2\2\u0119V\3"+
		"\2\2\2\u011a\u011b\7(\2\2\u011bX\3\2\2\2\u011c\u011d\7~\2\2\u011dZ\3\2"+
		"\2\2\u011e\u011f\7`\2\2\u011f\\\3\2\2\2\u0120\u0121\7(\2\2\u0121\u0122"+
		"\7(\2\2\u0122^\3\2\2\2\u0123\u0124\7~\2\2\u0124\u0125\7~\2\2\u0125`\3"+
		"\2\2\2\u0126\u0127\7-\2\2\u0127b\3\2\2\2\u0128\u0129\7/\2\2\u0129d\3\2"+
		"\2\2\u012a\u012b\7?\2\2\u012bf\3\2\2\2\u012c\u012d\7-\2\2\u012d\u012e"+
		"\7?\2\2\u012eh\3\2\2\2\u012f\u0130\7/\2\2\u0130\u0131\7?\2\2\u0131j\3"+
		"\2\2\2\u0132\u0133\7,\2\2\u0133\u0134\7?\2\2\u0134l\3\2\2\2\u0135\u0136"+
		"\7\61\2\2\u0136\u0137\7?\2\2\u0137n\3\2\2\2\u0138\u0139\7\'\2\2\u0139"+
		"\u013a\7?\2\2\u013ap\3\2\2\2\u013b\u013c\7>\2\2\u013c\u013d\7>\2\2\u013d"+
		"\u013e\7?\2\2\u013er\3\2\2\2\u013f\u0140\7@\2\2\u0140\u0141\7@\2\2\u0141"+
		"\u0142\7?\2\2\u0142t\3\2\2\2\u0143\u0144\7(\2\2\u0144\u0145\7?\2\2\u0145"+
		"v\3\2\2\2\u0146\u0147\7`\2\2\u0147\u0148\7?\2\2\u0148x\3\2\2\2\u0149\u014a"+
		"\7~\2\2\u014a\u014b\7?\2\2\u014bz\3\2\2\2\u014c\u014e\t\2\2\2\u014d\u014c"+
		"\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"|\3\2\2\2\u0151\u0153\t\3\2\2\u0152\u0151\3\2\2\2\u0153\u0154\3\2\2\2"+
		"\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0159\3\2\2\2\u0156\u0158"+
		"\t\4\2\2\u0157\u0156\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159"+
		"\u015a\3\2\2\2\u015a~\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u0161\7$\2\2\u015d"+
		"\u0160\n\5\2\2\u015e\u0160\7$\2\2\u015f\u015d\3\2\2\2\u015f\u015e\3\2"+
		"\2\2\u0160\u0163\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162"+
		"\u0164\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u0165\7$\2\2\u0165\u0080\3\2"+
		"\2\2\u0166\u0168\7)\2\2\u0167\u0169\7^\2\2\u0168\u0167\3\2\2\2\u0168\u0169"+
		"\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b\n\6\2\2\u016b\u016c\7)\2\2\u016c"+
		"\u0082\3\2\2\2\u016d\u016e\t\7\2\2\u016e\u016f\3\2\2\2\u016f\u0170\bB"+
		"\2\2\u0170\u0084\3\2\2\2\u0171\u0175\7%\2\2\u0172\u0174\13\2\2\2\u0173"+
		"\u0172\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0176\3\2\2\2\u0175\u0173\3\2"+
		"\2\2\u0176\u0178\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u0179\7\f\2\2\u0179"+
		"\u017a\3\2\2\2\u017a\u017b\bC\2\2\u017b\u0086\3\2\2\2\u017c\u017d\7%\2"+
		"\2\u017d\u017e\7%\2\2\u017e\u017f\7@\2\2\u017f\u0183\3\2\2\2\u0180\u0182"+
		"\13\2\2\2\u0181\u0180\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0184\3\2\2\2"+
		"\u0183\u0181\3\2\2\2\u0184\u0186\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u0187"+
		"\7%\2\2\u0187\u0188\7%\2\2\u0188\u0189\7>\2\2\u0189\u018a\3\2\2\2\u018a"+
		"\u018b\bD\2\2\u018b\u0088\3\2\2\2\13\2\u014f\u0154\u0159\u015f\u0161\u0168"+
		"\u0175\u0183\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}