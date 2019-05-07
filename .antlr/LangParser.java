// Generated from /home/edward/Documents/scplang/Lang.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		OP_INC=25, OP_DEC=26, OP_DOT=27, OP_LNOT=28, OP_BNOT=29, OP_MUL=30, OP_DIV=31, 
		OP_MOD=32, OP_LSH=33, OP_RSH=34, OP_LT=35, OP_LTE=36, OP_GT=37, OP_GTE=38, 
		OP_EQ=39, OP_NEQ=40, OP_BAND=41, OP_BOR=42, OP_BXOR=43, OP_LAND=44, OP_LOR=45, 
		OP_ADD=46, OP_SUB=47, OP_ASG=48, OP_ADD_ASG=49, OP_SUB_ASG=50, OP_MUL_ASG=51, 
		OP_DIV_ASG=52, OP_MOD_ASG=53, OP_LSH_ASG=54, OP_RSH_ASG=55, OP_BAND_ASG=56, 
		OP_BXOR_ASG=57, OP_BOR_ASG=58, NUM=59, ID=60, STR=61, CHR=62, WS=63;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_funcArgsExpr = 2, RULE_block = 3, 
		RULE_typeDecl = 4, RULE_varType = 5, RULE_varDecl = 6, RULE_funcArgDecl = 7, 
		RULE_funcType = 8, RULE_funcBody = 9, RULE_funcDecl = 10, RULE_classDecl = 11, 
		RULE_statment = 12, RULE_literal = 13;
	public static final String[] ruleNames = {
		"program", "expr", "funcArgsExpr", "block", "typeDecl", "varType", "varDecl", 
		"funcArgDecl", "funcType", "funcBody", "funcDecl", "classDecl", "statment", 
		"literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'['", "']'", "'?'", "':'", "','", "'{'", "'}'", "'var'", 
		"'val'", "'fn'", "'final'", "'class'", "'object'", "'if'", "'else'", "'while'", 
		"'do'", "';'", "'for'", "'return'", "'continue'", "'break'", "'++'", "'--'", 
		"'.'", "'!'", "'~'", "'*'", "'/'", "'%'", "'<<'", "'>>'", "'<'", "'<='", 
		"'>'", "'>='", "'=='", "'!='", "'&'", "'|'", "'^'", "'&&'", "'||'", "'+'", 
		"'-'", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'<<='", "'>>='", 
		"'&='", "'^='", "'|='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "OP_INC", "OP_DEC", "OP_DOT", "OP_LNOT", "OP_BNOT", "OP_MUL", "OP_DIV", 
		"OP_MOD", "OP_LSH", "OP_RSH", "OP_LT", "OP_LTE", "OP_GT", "OP_GTE", "OP_EQ", 
		"OP_NEQ", "OP_BAND", "OP_BOR", "OP_BXOR", "OP_LAND", "OP_LOR", "OP_ADD", 
		"OP_SUB", "OP_ASG", "OP_ADD_ASG", "OP_SUB_ASG", "OP_MUL_ASG", "OP_DIV_ASG", 
		"OP_MOD_ASG", "OP_LSH_ASG", "OP_RSH_ASG", "OP_BAND_ASG", "OP_BXOR_ASG", 
		"OP_BOR_ASG", "NUM", "ID", "STR", "CHR", "WS"
	};
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

	@Override
	public String getGrammarFileName() { return "Lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LangParser.EOF, 0); }
		public List<StatmentContext> statment() {
			return getRuleContexts(StatmentContext.class);
		}
		public StatmentContext statment(int i) {
			return getRuleContext(StatmentContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << OP_INC) | (1L << OP_DEC) | (1L << OP_LNOT) | (1L << OP_BNOT) | (1L << OP_BOR) | (1L << OP_ADD) | (1L << OP_SUB) | (1L << NUM) | (1L << ID) | (1L << STR) | (1L << CHR))) != 0)) {
				{
				{
				setState(28);
				statment();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignmentExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AssignmentExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class PrefixExprContext extends ExprContext {
		public Token op;
		public ExprContext var;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrefixExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class DotExprContext extends ExprContext {
		public ExprContext var;
		public ExprContext sub;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DotExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class InfixExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public InfixExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class FuncExprContext extends ExprContext {
		public ExprContext name;
		public FuncArgsExprContext args;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FuncArgsExprContext funcArgsExpr() {
			return getRuleContext(FuncArgsExprContext.class,0);
		}
		public FuncExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class TernaryExprContext extends ExprContext {
		public ExprContext cond;
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TernaryExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ArrayExprContext extends ExprContext {
		public ExprContext var;
		public ExprContext sub;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class LambdaExprContext extends ExprContext {
		public FuncBodyContext var;
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
		}
		public LambdaExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class LiteralExprContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class PostfixExprContext extends ExprContext {
		public ExprContext var;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PostfixExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ParenExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(37);
				match(T__0);
				setState(38);
				expr(0);
				setState(39);
				match(T__1);
				}
				break;
			case T__5:
			case OP_BOR:
				{
				_localctx = new LambdaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(41);
				((LambdaExprContext)_localctx).var = funcBody();
				}
				break;
			case OP_INC:
			case OP_DEC:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42);
				((PrefixExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==OP_INC || _la==OP_DEC) ) {
					((PrefixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(43);
				((PrefixExprContext)_localctx).var = expr(17);
				}
				break;
			case OP_ADD:
			case OP_SUB:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44);
				((PrefixExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==OP_ADD || _la==OP_SUB) ) {
					((PrefixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(45);
				((PrefixExprContext)_localctx).var = expr(16);
				}
				break;
			case OP_LNOT:
			case OP_BNOT:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(46);
				((PrefixExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==OP_LNOT || _la==OP_BNOT) ) {
					((PrefixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(47);
				((PrefixExprContext)_localctx).var = expr(15);
				}
				break;
			case NUM:
			case STR:
			case CHR:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
				literal();
				}
				break;
			case ID:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(49);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(106);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new DotExprContext(new ExprContext(_parentctx, _parentState));
						((DotExprContext)_localctx).var = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(52);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(53);
						match(OP_DOT);
						setState(54);
						((DotExprContext)_localctx).sub = expr(21);
						}
						break;
					case 2:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(55);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(56);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_MUL) | (1L << OP_DIV) | (1L << OP_MOD))) != 0)) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(57);
						((InfixExprContext)_localctx).right = expr(15);
						}
						break;
					case 3:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(58);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(59);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_ADD || _la==OP_SUB) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(60);
						((InfixExprContext)_localctx).right = expr(14);
						}
						break;
					case 4:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(61);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(62);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_LSH || _la==OP_RSH) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(63);
						((InfixExprContext)_localctx).right = expr(13);
						}
						break;
					case 5:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(64);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(65);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_LT) | (1L << OP_LTE) | (1L << OP_GT) | (1L << OP_GTE))) != 0)) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(66);
						((InfixExprContext)_localctx).right = expr(12);
						}
						break;
					case 6:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(67);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(68);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_EQ || _la==OP_NEQ) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(69);
						((InfixExprContext)_localctx).right = expr(11);
						}
						break;
					case 7:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(71);
						((InfixExprContext)_localctx).op = match(OP_BAND);
						setState(72);
						((InfixExprContext)_localctx).right = expr(10);
						}
						break;
					case 8:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(73);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(74);
						((InfixExprContext)_localctx).op = match(OP_BOR);
						setState(75);
						((InfixExprContext)_localctx).right = expr(9);
						}
						break;
					case 9:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(76);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(77);
						((InfixExprContext)_localctx).op = match(OP_BXOR);
						setState(78);
						((InfixExprContext)_localctx).right = expr(8);
						}
						break;
					case 10:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(79);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(80);
						((InfixExprContext)_localctx).op = match(OP_LAND);
						setState(81);
						((InfixExprContext)_localctx).right = expr(7);
						}
						break;
					case 11:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(82);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(83);
						((InfixExprContext)_localctx).op = match(OP_LOR);
						setState(84);
						((InfixExprContext)_localctx).right = expr(6);
						}
						break;
					case 12:
						{
						_localctx = new TernaryExprContext(new ExprContext(_parentctx, _parentState));
						((TernaryExprContext)_localctx).cond = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(85);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(86);
						match(T__4);
						setState(87);
						((TernaryExprContext)_localctx).left = expr(0);
						setState(88);
						match(T__5);
						setState(89);
						((TernaryExprContext)_localctx).right = expr(5);
						}
						break;
					case 13:
						{
						_localctx = new AssignmentExprContext(new ExprContext(_parentctx, _parentState));
						((AssignmentExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(91);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(92);
						((AssignmentExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_ASG) | (1L << OP_ADD_ASG) | (1L << OP_SUB_ASG) | (1L << OP_MUL_ASG) | (1L << OP_DIV_ASG) | (1L << OP_MOD_ASG) | (1L << OP_LSH_ASG) | (1L << OP_RSH_ASG) | (1L << OP_BAND_ASG) | (1L << OP_BXOR_ASG) | (1L << OP_BOR_ASG))) != 0)) ) {
							((AssignmentExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(93);
						((AssignmentExprContext)_localctx).right = expr(4);
						}
						break;
					case 14:
						{
						_localctx = new FuncExprContext(new ExprContext(_parentctx, _parentState));
						((FuncExprContext)_localctx).name = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(94);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(95);
						match(T__0);
						setState(96);
						((FuncExprContext)_localctx).args = funcArgsExpr();
						setState(97);
						match(T__1);
						}
						break;
					case 15:
						{
						_localctx = new ArrayExprContext(new ExprContext(_parentctx, _parentState));
						((ArrayExprContext)_localctx).var = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(99);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(100);
						match(T__2);
						setState(101);
						((ArrayExprContext)_localctx).sub = expr(0);
						setState(102);
						match(T__3);
						}
						break;
					case 16:
						{
						_localctx = new PostfixExprContext(new ExprContext(_parentctx, _parentState));
						((PostfixExprContext)_localctx).var = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(105);
						_la = _input.LA(1);
						if ( !(_la==OP_INC || _la==OP_DEC) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FuncArgsExprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncArgsExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcArgsExpr; }
	}

	public final FuncArgsExprContext funcArgsExpr() throws RecognitionException {
		FuncArgsExprContext _localctx = new FuncArgsExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcArgsExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(111);
					expr(0);
					setState(112);
					match(T__6);
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << OP_INC) | (1L << OP_DEC) | (1L << OP_LNOT) | (1L << OP_BNOT) | (1L << OP_BOR) | (1L << OP_ADD) | (1L << OP_SUB) | (1L << NUM) | (1L << ID) | (1L << STR) | (1L << CHR))) != 0)) {
				{
				setState(119);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatmentContext> statment() {
			return getRuleContexts(StatmentContext.class);
		}
		public StatmentContext statment(int i) {
			return getRuleContext(StatmentContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(T__7);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << OP_INC) | (1L << OP_DEC) | (1L << OP_LNOT) | (1L << OP_BNOT) | (1L << OP_BOR) | (1L << OP_ADD) | (1L << OP_SUB) | (1L << NUM) | (1L << ID) | (1L << STR) | (1L << CHR))) != 0)) {
				{
				{
				setState(123);
				statment();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public TypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDecl; }
	}

	public final TypeDeclContext typeDecl() throws RecognitionException {
		TypeDeclContext _localctx = new TypeDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_typeDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(131);
				match(ID);
				}
				break;
			case T__5:
			case OP_BOR:
				{
				setState(132);
				funcType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarTypeContext extends ParserRuleContext {
		public Token name;
		public TypeDeclContext type;
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TypeDeclContext typeDecl() {
			return getRuleContext(TypeDeclContext.class,0);
		}
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			((VarTypeContext)_localctx).name = match(ID);
			setState(136);
			match(T__5);
			setState(137);
			((VarTypeContext)_localctx).type = typeDecl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclContext extends ParserRuleContext {
		public Token mut;
		public VarTypeContext type;
		public ExprContext init;
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			((VarDeclContext)_localctx).mut = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__9 || _la==T__10) ) {
				((VarDeclContext)_localctx).mut = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(140);
			((VarDeclContext)_localctx).type = varType();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASG) {
				{
				setState(141);
				match(OP_ASG);
				setState(142);
				((VarDeclContext)_localctx).init = expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncArgDeclContext extends ParserRuleContext {
		public List<VarTypeContext> varType() {
			return getRuleContexts(VarTypeContext.class);
		}
		public VarTypeContext varType(int i) {
			return getRuleContext(VarTypeContext.class,i);
		}
		public FuncArgDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcArgDecl; }
	}

	public final FuncArgDeclContext funcArgDecl() throws RecognitionException {
		FuncArgDeclContext _localctx = new FuncArgDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcArgDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(145);
					varType();
					setState(146);
					match(T__6);
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(153);
				varType();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncTypeContext extends ParserRuleContext {
		public FuncArgDeclContext args;
		public TypeDeclContext retType;
		public TypeDeclContext typeDecl() {
			return getRuleContext(TypeDeclContext.class,0);
		}
		public FuncArgDeclContext funcArgDecl() {
			return getRuleContext(FuncArgDeclContext.class,0);
		}
		public FuncTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcType; }
	}

	public final FuncTypeContext funcType() throws RecognitionException {
		FuncTypeContext _localctx = new FuncTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_BOR) {
				{
				setState(156);
				match(OP_BOR);
				setState(157);
				((FuncTypeContext)_localctx).args = funcArgDecl();
				setState(158);
				match(OP_BOR);
				}
			}

			setState(162);
			match(T__5);
			setState(163);
			((FuncTypeContext)_localctx).retType = typeDecl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncBodyContext extends ParserRuleContext {
		public FuncTypeContext type;
		public BlockContext code;
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcBody; }
	}

	public final FuncBodyContext funcBody() throws RecognitionException {
		FuncBodyContext _localctx = new FuncBodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			((FuncBodyContext)_localctx).type = funcType();
			setState(166);
			((FuncBodyContext)_localctx).code = block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDeclContext extends ParserRuleContext {
		public Token bindType;
		public Token name;
		public FuncBodyContext func;
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
		}
		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecl; }
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			((FuncDeclContext)_localctx).bindType = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__11 || _la==T__12) ) {
				((FuncDeclContext)_localctx).bindType = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(169);
			((FuncDeclContext)_localctx).name = match(ID);
			setState(170);
			((FuncDeclContext)_localctx).func = funcBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclContext extends ParserRuleContext {
		public Token type;
		public Token name;
		public Token parent;
		public BlockContext body;
		public List<TerminalNode> ID() { return getTokens(LangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LangParser.ID, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			((ClassDeclContext)_localctx).type = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==T__14) ) {
				((ClassDeclContext)_localctx).type = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(173);
			((ClassDeclContext)_localctx).name = match(ID);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(174);
				match(T__5);
				setState(175);
				((ClassDeclContext)_localctx).parent = match(ID);
				}
			}

			setState(178);
			((ClassDeclContext)_localctx).body = block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatmentContext extends ParserRuleContext {
		public StatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statment; }
	 
		public StatmentContext() { }
		public void copyFrom(StatmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ContinueStmntContext extends StatmentContext {
		public ContinueStmntContext(StatmentContext ctx) { copyFrom(ctx); }
	}
	public static class DoWhileStmntContext extends StatmentContext {
		public BlockContext code;
		public ExprContext cond;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DoWhileStmntContext(StatmentContext ctx) { copyFrom(ctx); }
	}
	public static class ReturnStmntContext extends StatmentContext {
		public ExprContext val;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmntContext(StatmentContext ctx) { copyFrom(ctx); }
	}
	public static class BlockStmntContext extends StatmentContext {
		public BlockContext code;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStmntContext(StatmentContext ctx) { copyFrom(ctx); }
	}
	public static class ClassDeclStmntContext extends StatmentContext {
		public ClassDeclContext classType;
		public ClassDeclContext classDecl() {
			return getRuleContext(ClassDeclContext.class,0);
		}
		public ClassDeclStmntContext(StatmentContext ctx) { copyFrom(ctx); }
	}
	public static class DeclStmntContext extends StatmentContext {
		public VarDeclContext decl;
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public DeclStmntContext(StatmentContext ctx) { copyFrom(ctx); }
	}
	public static class ExprStmntContext extends StatmentContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmntContext(StatmentContext ctx) { copyFrom(ctx); }
	}
	public static class WhileStmntContext extends StatmentContext {
		public ExprContext cond;
		public BlockContext code;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStmntContext(StatmentContext ctx) { copyFrom(ctx); }
	}
	public static class IfStmntContext extends StatmentContext {
		public ExprContext cond;
		public BlockContext code;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfStmntContext(StatmentContext ctx) { copyFrom(ctx); }
	}
	public static class ElseIfStmntContext extends StatmentContext {
		public ExprContext cond;
		public BlockContext code;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseIfStmntContext(StatmentContext ctx) { copyFrom(ctx); }
	}
	public static class ElseStmntContext extends StatmentContext {
		public BlockContext code;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStmntContext(StatmentContext ctx) { copyFrom(ctx); }
	}
	public static class ForStmntContext extends StatmentContext {
		public ExprContext init;
		public ExprContext rep;
		public ExprContext end;
		public BlockContext code;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForStmntContext(StatmentContext ctx) { copyFrom(ctx); }
	}
	public static class FuncDeclStmntContext extends StatmentContext {
		public FuncDeclContext func;
		public FuncDeclContext funcDecl() {
			return getRuleContext(FuncDeclContext.class,0);
		}
		public FuncDeclStmntContext(StatmentContext ctx) { copyFrom(ctx); }
	}
	public static class BreakStmntContext extends StatmentContext {
		public BreakStmntContext(StatmentContext ctx) { copyFrom(ctx); }
	}

	public final StatmentContext statment() throws RecognitionException {
		StatmentContext _localctx = new StatmentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statment);
		try {
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new IfStmntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				match(T__15);
				setState(181);
				match(T__0);
				setState(182);
				((IfStmntContext)_localctx).cond = expr(0);
				setState(183);
				match(T__1);
				setState(184);
				((IfStmntContext)_localctx).code = block();
				}
				break;
			case 2:
				_localctx = new ElseIfStmntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				match(T__16);
				setState(187);
				match(T__15);
				setState(188);
				match(T__0);
				setState(189);
				((ElseIfStmntContext)_localctx).cond = expr(0);
				setState(190);
				match(T__1);
				setState(191);
				((ElseIfStmntContext)_localctx).code = block();
				}
				break;
			case 3:
				_localctx = new ElseStmntContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(193);
				match(T__16);
				setState(194);
				((ElseStmntContext)_localctx).code = block();
				}
				break;
			case 4:
				_localctx = new WhileStmntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(195);
				match(T__17);
				setState(196);
				match(T__0);
				setState(197);
				((WhileStmntContext)_localctx).cond = expr(0);
				setState(198);
				match(T__1);
				setState(199);
				((WhileStmntContext)_localctx).code = block();
				}
				break;
			case 5:
				_localctx = new DoWhileStmntContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(201);
				match(T__18);
				setState(202);
				((DoWhileStmntContext)_localctx).code = block();
				setState(203);
				match(T__17);
				setState(204);
				match(T__0);
				setState(205);
				((DoWhileStmntContext)_localctx).cond = expr(0);
				setState(206);
				match(T__1);
				setState(207);
				match(T__19);
				}
				break;
			case 6:
				_localctx = new ForStmntContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(209);
				match(T__20);
				setState(210);
				match(T__0);
				setState(211);
				((ForStmntContext)_localctx).init = expr(0);
				setState(212);
				match(T__19);
				setState(213);
				((ForStmntContext)_localctx).rep = expr(0);
				setState(214);
				match(T__19);
				setState(215);
				((ForStmntContext)_localctx).end = expr(0);
				setState(216);
				match(T__1);
				setState(217);
				((ForStmntContext)_localctx).code = block();
				}
				break;
			case 7:
				_localctx = new ReturnStmntContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(219);
				match(T__21);
				setState(220);
				((ReturnStmntContext)_localctx).val = expr(0);
				setState(221);
				match(T__19);
				}
				break;
			case 8:
				_localctx = new ContinueStmntContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(223);
				match(T__22);
				setState(224);
				match(T__19);
				}
				break;
			case 9:
				_localctx = new BreakStmntContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(225);
				match(T__23);
				setState(226);
				match(T__19);
				}
				break;
			case 10:
				_localctx = new DeclStmntContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(227);
				((DeclStmntContext)_localctx).decl = varDecl();
				setState(228);
				match(T__19);
				}
				break;
			case 11:
				_localctx = new FuncDeclStmntContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(230);
				((FuncDeclStmntContext)_localctx).func = funcDecl();
				}
				break;
			case 12:
				_localctx = new ClassDeclStmntContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(231);
				((ClassDeclStmntContext)_localctx).classType = classDecl();
				}
				break;
			case 13:
				_localctx = new ExprStmntContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(232);
				expr(0);
				setState(233);
				match(T__19);
				}
				break;
			case 14:
				_localctx = new BlockStmntContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(235);
				((BlockStmntContext)_localctx).code = block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(LangParser.NUM, 0); }
		public TerminalNode STR() { return getToken(LangParser.STR, 0); }
		public TerminalNode CHR() { return getToken(LangParser.CHR, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUM) | (1L << STR) | (1L << CHR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 20);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		case 13:
			return precpred(_ctx, 22);
		case 14:
			return precpred(_ctx, 21);
		case 15:
			return precpred(_ctx, 19);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3A\u00f3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\7\2 \n\2\f\2\16\2#\13\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\65"+
		"\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\7\3m\n\3\f\3\16\3p\13\3\3\4\3\4\3\4\7\4u\n\4\f\4\16\4x\13\4"+
		"\3\4\5\4{\n\4\3\5\3\5\7\5\177\n\5\f\5\16\5\u0082\13\5\3\5\3\5\3\6\3\6"+
		"\5\6\u0088\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5\b\u0092\n\b\3\t\3\t\3"+
		"\t\7\t\u0097\n\t\f\t\16\t\u009a\13\t\3\t\5\t\u009d\n\t\3\n\3\n\3\n\3\n"+
		"\5\n\u00a3\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\5\r\u00b3\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u00ef\n\16\3\17\3\17\3\17\2\3\4\20\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\2\16\3\2\33\34\3\2\60\61\3\2\36\37\3"+
		"\2 \"\3\2#$\3\2%(\3\2)*\3\2\62<\3\2\f\r\3\2\16\17\3\2\20\21\4\2==?@\2"+
		"\u0111\2!\3\2\2\2\4\64\3\2\2\2\6v\3\2\2\2\b|\3\2\2\2\n\u0087\3\2\2\2\f"+
		"\u0089\3\2\2\2\16\u008d\3\2\2\2\20\u0098\3\2\2\2\22\u00a2\3\2\2\2\24\u00a7"+
		"\3\2\2\2\26\u00aa\3\2\2\2\30\u00ae\3\2\2\2\32\u00ee\3\2\2\2\34\u00f0\3"+
		"\2\2\2\36 \5\32\16\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\""+
		"$\3\2\2\2#!\3\2\2\2$%\7\2\2\3%\3\3\2\2\2&\'\b\3\1\2\'(\7\3\2\2()\5\4\3"+
		"\2)*\7\4\2\2*\65\3\2\2\2+\65\5\24\13\2,-\t\2\2\2-\65\5\4\3\23./\t\3\2"+
		"\2/\65\5\4\3\22\60\61\t\4\2\2\61\65\5\4\3\21\62\65\5\34\17\2\63\65\7>"+
		"\2\2\64&\3\2\2\2\64+\3\2\2\2\64,\3\2\2\2\64.\3\2\2\2\64\60\3\2\2\2\64"+
		"\62\3\2\2\2\64\63\3\2\2\2\65n\3\2\2\2\66\67\f\26\2\2\678\7\35\2\28m\5"+
		"\4\3\279:\f\20\2\2:;\t\5\2\2;m\5\4\3\21<=\f\17\2\2=>\t\3\2\2>m\5\4\3\20"+
		"?@\f\16\2\2@A\t\6\2\2Am\5\4\3\17BC\f\r\2\2CD\t\7\2\2Dm\5\4\3\16EF\f\f"+
		"\2\2FG\t\b\2\2Gm\5\4\3\rHI\f\13\2\2IJ\7+\2\2Jm\5\4\3\fKL\f\n\2\2LM\7,"+
		"\2\2Mm\5\4\3\13NO\f\t\2\2OP\7-\2\2Pm\5\4\3\nQR\f\b\2\2RS\7.\2\2Sm\5\4"+
		"\3\tTU\f\7\2\2UV\7/\2\2Vm\5\4\3\bWX\f\6\2\2XY\7\7\2\2YZ\5\4\3\2Z[\7\b"+
		"\2\2[\\\5\4\3\7\\m\3\2\2\2]^\f\5\2\2^_\t\t\2\2_m\5\4\3\6`a\f\30\2\2ab"+
		"\7\3\2\2bc\5\6\4\2cd\7\4\2\2dm\3\2\2\2ef\f\27\2\2fg\7\5\2\2gh\5\4\3\2"+
		"hi\7\6\2\2im\3\2\2\2jk\f\25\2\2km\t\2\2\2l\66\3\2\2\2l9\3\2\2\2l<\3\2"+
		"\2\2l?\3\2\2\2lB\3\2\2\2lE\3\2\2\2lH\3\2\2\2lK\3\2\2\2lN\3\2\2\2lQ\3\2"+
		"\2\2lT\3\2\2\2lW\3\2\2\2l]\3\2\2\2l`\3\2\2\2le\3\2\2\2lj\3\2\2\2mp\3\2"+
		"\2\2nl\3\2\2\2no\3\2\2\2o\5\3\2\2\2pn\3\2\2\2qr\5\4\3\2rs\7\t\2\2su\3"+
		"\2\2\2tq\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wz\3\2\2\2xv\3\2\2\2y{\5"+
		"\4\3\2zy\3\2\2\2z{\3\2\2\2{\7\3\2\2\2|\u0080\7\n\2\2}\177\5\32\16\2~}"+
		"\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7\13\2\2\u0084\t\3\2\2\2\u0085"+
		"\u0088\7>\2\2\u0086\u0088\5\22\n\2\u0087\u0085\3\2\2\2\u0087\u0086\3\2"+
		"\2\2\u0088\13\3\2\2\2\u0089\u008a\7>\2\2\u008a\u008b\7\b\2\2\u008b\u008c"+
		"\5\n\6\2\u008c\r\3\2\2\2\u008d\u008e\t\n\2\2\u008e\u0091\5\f\7\2\u008f"+
		"\u0090\7\62\2\2\u0090\u0092\5\4\3\2\u0091\u008f\3\2\2\2\u0091\u0092\3"+
		"\2\2\2\u0092\17\3\2\2\2\u0093\u0094\5\f\7\2\u0094\u0095\7\t\2\2\u0095"+
		"\u0097\3\2\2\2\u0096\u0093\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009b"+
		"\u009d\5\f\7\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\21\3\2\2"+
		"\2\u009e\u009f\7,\2\2\u009f\u00a0\5\20\t\2\u00a0\u00a1\7,\2\2\u00a1\u00a3"+
		"\3\2\2\2\u00a2\u009e\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a5\7\b\2\2\u00a5\u00a6\5\n\6\2\u00a6\23\3\2\2\2\u00a7\u00a8\5\22\n"+
		"\2\u00a8\u00a9\5\b\5\2\u00a9\25\3\2\2\2\u00aa\u00ab\t\13\2\2\u00ab\u00ac"+
		"\7>\2\2\u00ac\u00ad\5\24\13\2\u00ad\27\3\2\2\2\u00ae\u00af\t\f\2\2\u00af"+
		"\u00b2\7>\2\2\u00b0\u00b1\7\b\2\2\u00b1\u00b3\7>\2\2\u00b2\u00b0\3\2\2"+
		"\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\5\b\5\2\u00b5\31"+
		"\3\2\2\2\u00b6\u00b7\7\22\2\2\u00b7\u00b8\7\3\2\2\u00b8\u00b9\5\4\3\2"+
		"\u00b9\u00ba\7\4\2\2\u00ba\u00bb\5\b\5\2\u00bb\u00ef\3\2\2\2\u00bc\u00bd"+
		"\7\23\2\2\u00bd\u00be\7\22\2\2\u00be\u00bf\7\3\2\2\u00bf\u00c0\5\4\3\2"+
		"\u00c0\u00c1\7\4\2\2\u00c1\u00c2\5\b\5\2\u00c2\u00ef\3\2\2\2\u00c3\u00c4"+
		"\7\23\2\2\u00c4\u00ef\5\b\5\2\u00c5\u00c6\7\24\2\2\u00c6\u00c7\7\3\2\2"+
		"\u00c7\u00c8\5\4\3\2\u00c8\u00c9\7\4\2\2\u00c9\u00ca\5\b\5\2\u00ca\u00ef"+
		"\3\2\2\2\u00cb\u00cc\7\25\2\2\u00cc\u00cd\5\b\5\2\u00cd\u00ce\7\24\2\2"+
		"\u00ce\u00cf\7\3\2\2\u00cf\u00d0\5\4\3\2\u00d0\u00d1\7\4\2\2\u00d1\u00d2"+
		"\7\26\2\2\u00d2\u00ef\3\2\2\2\u00d3\u00d4\7\27\2\2\u00d4\u00d5\7\3\2\2"+
		"\u00d5\u00d6\5\4\3\2\u00d6\u00d7\7\26\2\2\u00d7\u00d8\5\4\3\2\u00d8\u00d9"+
		"\7\26\2\2\u00d9\u00da\5\4\3\2\u00da\u00db\7\4\2\2\u00db\u00dc\5\b\5\2"+
		"\u00dc\u00ef\3\2\2\2\u00dd\u00de\7\30\2\2\u00de\u00df\5\4\3\2\u00df\u00e0"+
		"\7\26\2\2\u00e0\u00ef\3\2\2\2\u00e1\u00e2\7\31\2\2\u00e2\u00ef\7\26\2"+
		"\2\u00e3\u00e4\7\32\2\2\u00e4\u00ef\7\26\2\2\u00e5\u00e6\5\16\b\2\u00e6"+
		"\u00e7\7\26\2\2\u00e7\u00ef\3\2\2\2\u00e8\u00ef\5\26\f\2\u00e9\u00ef\5"+
		"\30\r\2\u00ea\u00eb\5\4\3\2\u00eb\u00ec\7\26\2\2\u00ec\u00ef\3\2\2\2\u00ed"+
		"\u00ef\5\b\5\2\u00ee\u00b6\3\2\2\2\u00ee\u00bc\3\2\2\2\u00ee\u00c3\3\2"+
		"\2\2\u00ee\u00c5\3\2\2\2\u00ee\u00cb\3\2\2\2\u00ee\u00d3\3\2\2\2\u00ee"+
		"\u00dd\3\2\2\2\u00ee\u00e1\3\2\2\2\u00ee\u00e3\3\2\2\2\u00ee\u00e5\3\2"+
		"\2\2\u00ee\u00e8\3\2\2\2\u00ee\u00e9\3\2\2\2\u00ee\u00ea\3\2\2\2\u00ee"+
		"\u00ed\3\2\2\2\u00ef\33\3\2\2\2\u00f0\u00f1\t\r\2\2\u00f1\35\3\2\2\2\20"+
		"!\64lnvz\u0080\u0087\u0091\u0098\u009c\u00a2\u00b2\u00ee";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}