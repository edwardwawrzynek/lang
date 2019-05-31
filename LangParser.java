// Generated from Lang.g4 by ANTLR 4.7.2
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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

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
		OP_BXOR_ASG=57, OP_BOR_ASG=58, NUM=59, ID=60, STR=61, CHR=62, WS=63, COMMENT=64;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_funcArgsExpr = 2, RULE_block = 3, 
		RULE_typeDecl = 4, RULE_varType = 5, RULE_varInit = 6, RULE_varDecl = 7, 
		RULE_funcArgDecl = 8, RULE_funcType = 9, RULE_funcBody = 10, RULE_funcDecl = 11, 
		RULE_classDecl = 12, RULE_statement = 13, RULE_literal = 14, RULE_arrayLiteral = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "funcArgsExpr", "block", "typeDecl", "varType", "varInit", 
			"varDecl", "funcArgDecl", "funcType", "funcBody", "funcDecl", "classDecl", 
			"statement", "literal", "arrayLiteral"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'?'", "':'", "','", "'{'", "'}'", 
			"'var'", "'val'", "'fn'", "'class'", "'singelton'", "'struct'", "'if'", 
			"'else'", "'while'", "'do'", "';'", "'for'", "'return'", "'continue'", 
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
			null, "OP_INC", "OP_DEC", "OP_DOT", "OP_LNOT", "OP_BNOT", "OP_MUL", "OP_DIV", 
			"OP_MOD", "OP_LSH", "OP_RSH", "OP_LT", "OP_LTE", "OP_GT", "OP_GTE", "OP_EQ", 
			"OP_NEQ", "OP_BAND", "OP_BOR", "OP_BXOR", "OP_LAND", "OP_LOR", "OP_ADD", 
			"OP_SUB", "OP_ASG", "OP_ADD_ASG", "OP_SUB_ASG", "OP_MUL_ASG", "OP_DIV_ASG", 
			"OP_MOD_ASG", "OP_LSH_ASG", "OP_RSH_ASG", "OP_BAND_ASG", "OP_BXOR_ASG", 
			"OP_BOR_ASG", "NUM", "ID", "STR", "CHR", "WS", "COMMENT"
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << OP_INC) | (1L << OP_DEC) | (1L << OP_LNOT) | (1L << OP_BNOT) | (1L << OP_ADD) | (1L << OP_SUB) | (1L << NUM) | (1L << ID) | (1L << STR) | (1L << CHR))) != 0)) {
				{
				{
				setState(32);
				statement();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
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
		public TerminalNode OP_ASG() { return getToken(LangParser.OP_ASG, 0); }
		public TerminalNode OP_ADD_ASG() { return getToken(LangParser.OP_ADD_ASG, 0); }
		public TerminalNode OP_SUB_ASG() { return getToken(LangParser.OP_SUB_ASG, 0); }
		public TerminalNode OP_MUL_ASG() { return getToken(LangParser.OP_MUL_ASG, 0); }
		public TerminalNode OP_DIV_ASG() { return getToken(LangParser.OP_DIV_ASG, 0); }
		public TerminalNode OP_MOD_ASG() { return getToken(LangParser.OP_MOD_ASG, 0); }
		public TerminalNode OP_LSH_ASG() { return getToken(LangParser.OP_LSH_ASG, 0); }
		public TerminalNode OP_RSH_ASG() { return getToken(LangParser.OP_RSH_ASG, 0); }
		public TerminalNode OP_BAND_ASG() { return getToken(LangParser.OP_BAND_ASG, 0); }
		public TerminalNode OP_BXOR_ASG() { return getToken(LangParser.OP_BXOR_ASG, 0); }
		public TerminalNode OP_BOR_ASG() { return getToken(LangParser.OP_BOR_ASG, 0); }
		public AssignmentExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitAssignmentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DotExprContext extends ExprContext {
		public ExprContext varName;
		public ExprContext sub;
		public TerminalNode OP_DOT() { return getToken(LangParser.OP_DOT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDotExpr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExprContext extends ExprContext {
		public ExprContext varName;
		public ExprContext sub;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixExprContext extends ExprContext {
		public Token op;
		public ExprContext varName;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OP_INC() { return getToken(LangParser.OP_INC, 0); }
		public TerminalNode OP_DEC() { return getToken(LangParser.OP_DEC, 0); }
		public TerminalNode OP_ADD() { return getToken(LangParser.OP_ADD, 0); }
		public TerminalNode OP_SUB() { return getToken(LangParser.OP_SUB, 0); }
		public TerminalNode OP_LNOT() { return getToken(LangParser.OP_LNOT, 0); }
		public TerminalNode OP_BNOT() { return getToken(LangParser.OP_BNOT, 0); }
		public PrefixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitPrefixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclExprContext extends ExprContext {
		public VarDeclContext decl;
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public DeclExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDeclExpr(this);
			else return visitor.visitChildren(this);
		}
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
		public TerminalNode OP_MUL() { return getToken(LangParser.OP_MUL, 0); }
		public TerminalNode OP_DIV() { return getToken(LangParser.OP_DIV, 0); }
		public TerminalNode OP_MOD() { return getToken(LangParser.OP_MOD, 0); }
		public TerminalNode OP_ADD() { return getToken(LangParser.OP_ADD, 0); }
		public TerminalNode OP_SUB() { return getToken(LangParser.OP_SUB, 0); }
		public TerminalNode OP_LSH() { return getToken(LangParser.OP_LSH, 0); }
		public TerminalNode OP_RSH() { return getToken(LangParser.OP_RSH, 0); }
		public TerminalNode OP_LT() { return getToken(LangParser.OP_LT, 0); }
		public TerminalNode OP_LTE() { return getToken(LangParser.OP_LTE, 0); }
		public TerminalNode OP_GT() { return getToken(LangParser.OP_GT, 0); }
		public TerminalNode OP_GTE() { return getToken(LangParser.OP_GTE, 0); }
		public TerminalNode OP_EQ() { return getToken(LangParser.OP_EQ, 0); }
		public TerminalNode OP_NEQ() { return getToken(LangParser.OP_NEQ, 0); }
		public TerminalNode OP_BAND() { return getToken(LangParser.OP_BAND, 0); }
		public TerminalNode OP_BOR() { return getToken(LangParser.OP_BOR, 0); }
		public TerminalNode OP_BXOR() { return getToken(LangParser.OP_BXOR, 0); }
		public TerminalNode OP_LAND() { return getToken(LangParser.OP_LAND, 0); }
		public TerminalNode OP_LOR() { return getToken(LangParser.OP_LOR, 0); }
		public InfixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitInfixExpr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitTernaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaExprContext extends ExprContext {
		public FuncBodyContext varName;
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
		}
		public LambdaExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLambdaExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralExprContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostfixExprContext extends ExprContext {
		public ExprContext varName;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OP_INC() { return getToken(LangParser.OP_INC, 0); }
		public TerminalNode OP_DEC() { return getToken(LangParser.OP_DEC, 0); }
		public PostfixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitPostfixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
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
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(41);
				match(T__0);
				setState(42);
				expr(0);
				setState(43);
				match(T__1);
				}
				break;
			case 2:
				{
				_localctx = new LambdaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				((LambdaExprContext)_localctx).varName = funcBody();
				}
				break;
			case 3:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(46);
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
				setState(47);
				((PrefixExprContext)_localctx).varName = expr(18);
				}
				break;
			case 4:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
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
				setState(49);
				((PrefixExprContext)_localctx).varName = expr(17);
				}
				break;
			case 5:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50);
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
				setState(51);
				((PrefixExprContext)_localctx).varName = expr(16);
				}
				break;
			case 6:
				{
				_localctx = new DeclExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				((DeclExprContext)_localctx).decl = varDecl();
				}
				break;
			case 7:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53);
				literal();
				}
				break;
			case 8:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(54);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(111);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new DotExprContext(new ExprContext(_parentctx, _parentState));
						((DotExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(57);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(58);
						match(OP_DOT);
						setState(59);
						((DotExprContext)_localctx).sub = expr(22);
						}
						break;
					case 2:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(60);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(61);
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
						setState(62);
						((InfixExprContext)_localctx).right = expr(16);
						}
						break;
					case 3:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(63);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(64);
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
						setState(65);
						((InfixExprContext)_localctx).right = expr(15);
						}
						break;
					case 4:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(66);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(67);
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
						setState(68);
						((InfixExprContext)_localctx).right = expr(14);
						}
						break;
					case 5:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(69);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(70);
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
						setState(71);
						((InfixExprContext)_localctx).right = expr(13);
						}
						break;
					case 6:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(72);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(73);
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
						setState(74);
						((InfixExprContext)_localctx).right = expr(12);
						}
						break;
					case 7:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(75);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(76);
						((InfixExprContext)_localctx).op = match(OP_BAND);
						setState(77);
						((InfixExprContext)_localctx).right = expr(11);
						}
						break;
					case 8:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(78);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(79);
						((InfixExprContext)_localctx).op = match(OP_BOR);
						setState(80);
						((InfixExprContext)_localctx).right = expr(10);
						}
						break;
					case 9:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(81);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(82);
						((InfixExprContext)_localctx).op = match(OP_BXOR);
						setState(83);
						((InfixExprContext)_localctx).right = expr(9);
						}
						break;
					case 10:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(84);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(85);
						((InfixExprContext)_localctx).op = match(OP_LAND);
						setState(86);
						((InfixExprContext)_localctx).right = expr(8);
						}
						break;
					case 11:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(87);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(88);
						((InfixExprContext)_localctx).op = match(OP_LOR);
						setState(89);
						((InfixExprContext)_localctx).right = expr(7);
						}
						break;
					case 12:
						{
						_localctx = new TernaryExprContext(new ExprContext(_parentctx, _parentState));
						((TernaryExprContext)_localctx).cond = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(90);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(91);
						match(T__4);
						setState(92);
						((TernaryExprContext)_localctx).left = expr(0);
						setState(93);
						match(T__5);
						setState(94);
						((TernaryExprContext)_localctx).right = expr(6);
						}
						break;
					case 13:
						{
						_localctx = new AssignmentExprContext(new ExprContext(_parentctx, _parentState));
						((AssignmentExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(96);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(97);
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
						setState(98);
						((AssignmentExprContext)_localctx).right = expr(5);
						}
						break;
					case 14:
						{
						_localctx = new FuncExprContext(new ExprContext(_parentctx, _parentState));
						((FuncExprContext)_localctx).name = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(99);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(100);
						match(T__0);
						setState(101);
						((FuncExprContext)_localctx).args = funcArgsExpr();
						setState(102);
						match(T__1);
						}
						break;
					case 15:
						{
						_localctx = new ArrayExprContext(new ExprContext(_parentctx, _parentState));
						((ArrayExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(105);
						match(T__2);
						setState(106);
						((ArrayExprContext)_localctx).sub = expr(0);
						setState(107);
						match(T__3);
						}
						break;
					case 16:
						{
						_localctx = new PostfixExprContext(new ExprContext(_parentctx, _parentState));
						((PostfixExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(110);
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
				setState(115);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFuncArgsExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncArgsExprContext funcArgsExpr() throws RecognitionException {
		FuncArgsExprContext _localctx = new FuncArgsExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcArgsExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(116);
					expr(0);
					setState(117);
					match(T__6);
					}
					} 
				}
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << OP_INC) | (1L << OP_DEC) | (1L << OP_LNOT) | (1L << OP_BNOT) | (1L << OP_ADD) | (1L << OP_SUB) | (1L << NUM) | (1L << ID) | (1L << STR) | (1L << CHR))) != 0)) {
				{
				setState(124);
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(T__7);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << OP_INC) | (1L << OP_DEC) | (1L << OP_LNOT) | (1L << OP_BNOT) | (1L << OP_ADD) | (1L << OP_SUB) | (1L << NUM) | (1L << ID) | (1L << STR) | (1L << CHR))) != 0)) {
				{
				{
				setState(128);
				statement();
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(134);
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
		public LiteralContext size;
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitTypeDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDeclContext typeDecl() throws RecognitionException {
		TypeDeclContext _localctx = new TypeDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_typeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(136);
				match(ID);
				}
				break;
			case 2:
				{
				setState(137);
				funcType();
				}
				break;
			}
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(140);
				match(T__2);
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << NUM) | (1L << STR) | (1L << CHR))) != 0)) {
					{
					setState(141);
					((TypeDeclContext)_localctx).size = literal();
					}
				}

				setState(144);
				match(T__3);
				}
				break;
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
		public TypeDeclContext typeName;
		public List<TerminalNode> ID() { return getTokens(LangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LangParser.ID, i);
		}
		public TypeDeclContext typeDecl() {
			return getRuleContext(TypeDeclContext.class,0);
		}
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitVarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(151); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(147);
					((VarTypeContext)_localctx).name = match(ID);
					setState(149);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						setState(148);
						match(T__6);
						}
						break;
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(153); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(155);
				match(T__5);
				setState(156);
				((VarTypeContext)_localctx).typeName = typeDecl();
				}
				break;
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

	public static class VarInitContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public VarInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varInit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitVarInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarInitContext varInit() throws RecognitionException {
		VarInitContext _localctx = new VarInitContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varInit);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(159);
					expr(0);
					setState(161);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						setState(160);
						match(T__6);
						}
						break;
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(165); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public VarTypeContext typeName;
		public VarInitContext init;
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode OP_ASG() { return getToken(LangParser.OP_ASG, 0); }
		public VarInitContext varInit() {
			return getRuleContext(VarInitContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
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
			setState(168);
			((VarDeclContext)_localctx).typeName = varType();
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(169);
				match(OP_ASG);
				setState(170);
				((VarDeclContext)_localctx).init = varInit();
				}
				break;
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFuncArgDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncArgDeclContext funcArgDecl() throws RecognitionException {
		FuncArgDeclContext _localctx = new FuncArgDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcArgDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(173);
					varType();
					setState(174);
					match(T__6);
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(181);
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
		public FuncArgDeclContext funcArgDecl() {
			return getRuleContext(FuncArgDeclContext.class,0);
		}
		public TypeDeclContext typeDecl() {
			return getRuleContext(TypeDeclContext.class,0);
		}
		public FuncTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFuncType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncTypeContext funcType() throws RecognitionException {
		FuncTypeContext _localctx = new FuncTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(184);
				match(T__0);
				setState(185);
				((FuncTypeContext)_localctx).args = funcArgDecl();
				setState(186);
				match(T__1);
				}
				break;
			}
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(190);
				match(T__5);
				setState(191);
				((FuncTypeContext)_localctx).retType = typeDecl();
				}
				break;
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

	public static class FuncBodyContext extends ParserRuleContext {
		public FuncTypeContext typeName;
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFuncBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncBodyContext funcBody() throws RecognitionException {
		FuncBodyContext _localctx = new FuncBodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			((FuncBodyContext)_localctx).typeName = funcType();
			setState(195);
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
		public Token name;
		public FuncBodyContext function;
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
		}
		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFuncDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_funcDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(T__11);
			setState(198);
			((FuncDeclContext)_localctx).name = match(ID);
			setState(199);
			((FuncDeclContext)_localctx).function = funcBody();
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
		public Token classType;
		public Token name;
		public Token parentClass;
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			((ClassDeclContext)_localctx).classType = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
				((ClassDeclContext)_localctx).classType = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(202);
			((ClassDeclContext)_localctx).name = match(ID);
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(203);
				match(T__5);
				setState(204);
				((ClassDeclContext)_localctx).parentClass = match(ID);
				}
			}

			setState(207);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ContinueStmntContext extends StatementContext {
		public ContinueStmntContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitContinueStmnt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoWhileStmntContext extends StatementContext {
		public BlockContext code;
		public ExprContext cond;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DoWhileStmntContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDoWhileStmnt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStmntContext extends StatementContext {
		public ExprContext val;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmntContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitReturnStmnt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStmntContext extends StatementContext {
		public BlockContext code;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStmntContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitBlockStmnt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassDeclStmntContext extends StatementContext {
		public ClassDeclContext classType;
		public ClassDeclContext classDecl() {
			return getRuleContext(ClassDeclContext.class,0);
		}
		public ClassDeclStmntContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitClassDeclStmnt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprStmntContext extends StatementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmntContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitExprStmnt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStmntContext extends StatementContext {
		public ExprContext cond;
		public BlockContext code;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStmntContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitWhileStmnt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStmntContext extends StatementContext {
		public ExprContext cond;
		public BlockContext code;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfStmntContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIfStmnt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ElseIfStmntContext extends StatementContext {
		public ExprContext cond;
		public BlockContext code;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseIfStmntContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitElseIfStmnt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ElseStmntContext extends StatementContext {
		public BlockContext code;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStmntContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitElseStmnt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForStmntContext extends StatementContext {
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
		public ForStmntContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitForStmnt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncDeclStmntContext extends StatementContext {
		public FuncDeclContext function;
		public FuncDeclContext funcDecl() {
			return getRuleContext(FuncDeclContext.class,0);
		}
		public FuncDeclStmntContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFuncDeclStmnt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakStmntContext extends StatementContext {
		public BreakStmntContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitBreakStmnt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		try {
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new IfStmntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(T__15);
				setState(210);
				match(T__0);
				setState(211);
				((IfStmntContext)_localctx).cond = expr(0);
				setState(212);
				match(T__1);
				setState(213);
				((IfStmntContext)_localctx).code = block();
				}
				break;
			case 2:
				_localctx = new ElseIfStmntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				match(T__16);
				setState(216);
				match(T__15);
				setState(217);
				match(T__0);
				setState(218);
				((ElseIfStmntContext)_localctx).cond = expr(0);
				setState(219);
				match(T__1);
				setState(220);
				((ElseIfStmntContext)_localctx).code = block();
				}
				break;
			case 3:
				_localctx = new ElseStmntContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(222);
				match(T__16);
				setState(223);
				((ElseStmntContext)_localctx).code = block();
				}
				break;
			case 4:
				_localctx = new WhileStmntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(224);
				match(T__17);
				setState(225);
				match(T__0);
				setState(226);
				((WhileStmntContext)_localctx).cond = expr(0);
				setState(227);
				match(T__1);
				setState(228);
				((WhileStmntContext)_localctx).code = block();
				}
				break;
			case 5:
				_localctx = new DoWhileStmntContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(230);
				match(T__18);
				setState(231);
				((DoWhileStmntContext)_localctx).code = block();
				setState(232);
				match(T__17);
				setState(233);
				match(T__0);
				setState(234);
				((DoWhileStmntContext)_localctx).cond = expr(0);
				setState(235);
				match(T__1);
				setState(236);
				match(T__19);
				}
				break;
			case 6:
				_localctx = new ForStmntContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(238);
				match(T__20);
				setState(239);
				match(T__0);
				setState(240);
				((ForStmntContext)_localctx).init = expr(0);
				setState(241);
				match(T__19);
				setState(242);
				((ForStmntContext)_localctx).rep = expr(0);
				setState(243);
				match(T__19);
				setState(244);
				((ForStmntContext)_localctx).end = expr(0);
				setState(245);
				match(T__1);
				setState(246);
				((ForStmntContext)_localctx).code = block();
				}
				break;
			case 7:
				_localctx = new ReturnStmntContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(248);
				match(T__21);
				setState(249);
				((ReturnStmntContext)_localctx).val = expr(0);
				setState(250);
				match(T__19);
				}
				break;
			case 8:
				_localctx = new ContinueStmntContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(252);
				match(T__22);
				setState(253);
				match(T__19);
				}
				break;
			case 9:
				_localctx = new BreakStmntContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(254);
				match(T__23);
				setState(255);
				match(T__19);
				}
				break;
			case 10:
				_localctx = new FuncDeclStmntContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(256);
				((FuncDeclStmntContext)_localctx).function = funcDecl();
				}
				break;
			case 11:
				_localctx = new ClassDeclStmntContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(257);
				((ClassDeclStmntContext)_localctx).classType = classDecl();
				}
				break;
			case 12:
				_localctx = new ExprStmntContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(258);
				expr(0);
				setState(259);
				match(T__19);
				}
				break;
			case 13:
				_localctx = new BlockStmntContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(261);
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
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_literal);
		try {
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				match(NUM);
				}
				break;
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				match(STR);
				}
				break;
			case CHR:
				enterOuterAlt(_localctx, 3);
				{
				setState(266);
				match(CHR);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 4);
				{
				setState(267);
				arrayLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ArrayLiteralContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_arrayLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(T__2);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(271);
					expr(0);
					setState(272);
					match(T__6);
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << OP_INC) | (1L << OP_DEC) | (1L << OP_LNOT) | (1L << OP_BNOT) | (1L << OP_ADD) | (1L << OP_SUB) | (1L << NUM) | (1L << ID) | (1L << STR) | (1L << CHR))) != 0)) {
				{
				setState(279);
				expr(0);
				}
			}

			setState(282);
			match(T__3);
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
			return precpred(_ctx, 21);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		case 8:
			return precpred(_ctx, 8);
		case 9:
			return precpred(_ctx, 7);
		case 10:
			return precpred(_ctx, 6);
		case 11:
			return precpred(_ctx, 5);
		case 12:
			return precpred(_ctx, 4);
		case 13:
			return precpred(_ctx, 23);
		case 14:
			return precpred(_ctx, 22);
		case 15:
			return precpred(_ctx, 20);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3B\u011f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\7\2$\n"+
		"\2\f\2\16\2\'\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3:\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3r\n\3\f\3\16\3u\13\3\3\4\3\4\3\4\7"+
		"\4z\n\4\f\4\16\4}\13\4\3\4\5\4\u0080\n\4\3\5\3\5\7\5\u0084\n\5\f\5\16"+
		"\5\u0087\13\5\3\5\3\5\3\6\3\6\5\6\u008d\n\6\3\6\3\6\5\6\u0091\n\6\3\6"+
		"\5\6\u0094\n\6\3\7\3\7\5\7\u0098\n\7\6\7\u009a\n\7\r\7\16\7\u009b\3\7"+
		"\3\7\5\7\u00a0\n\7\3\b\3\b\5\b\u00a4\n\b\6\b\u00a6\n\b\r\b\16\b\u00a7"+
		"\3\t\3\t\3\t\3\t\5\t\u00ae\n\t\3\n\3\n\3\n\7\n\u00b3\n\n\f\n\16\n\u00b6"+
		"\13\n\3\n\5\n\u00b9\n\n\3\13\3\13\3\13\3\13\5\13\u00bf\n\13\3\13\3\13"+
		"\5\13\u00c3\n\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\5\16"+
		"\u00d0\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u0109\n\17\3\20\3\20\3\20\3\20\5\20\u010f\n\20\3\21\3\21\3"+
		"\21\3\21\7\21\u0115\n\21\f\21\16\21\u0118\13\21\3\21\5\21\u011b\n\21\3"+
		"\21\3\21\3\21\2\3\4\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\f\3\2"+
		"\33\34\3\2\60\61\3\2\36\37\3\2 \"\3\2#$\3\2%(\3\2)*\3\2\62<\3\2\f\r\3"+
		"\2\17\21\2\u0148\2%\3\2\2\2\49\3\2\2\2\6{\3\2\2\2\b\u0081\3\2\2\2\n\u008c"+
		"\3\2\2\2\f\u0099\3\2\2\2\16\u00a5\3\2\2\2\20\u00a9\3\2\2\2\22\u00b4\3"+
		"\2\2\2\24\u00be\3\2\2\2\26\u00c4\3\2\2\2\30\u00c7\3\2\2\2\32\u00cb\3\2"+
		"\2\2\34\u0108\3\2\2\2\36\u010e\3\2\2\2 \u0110\3\2\2\2\"$\5\34\17\2#\""+
		"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'%\3\2\2\2()\7\2\2\3"+
		")\3\3\2\2\2*+\b\3\1\2+,\7\3\2\2,-\5\4\3\2-.\7\4\2\2.:\3\2\2\2/:\5\26\f"+
		"\2\60\61\t\2\2\2\61:\5\4\3\24\62\63\t\3\2\2\63:\5\4\3\23\64\65\t\4\2\2"+
		"\65:\5\4\3\22\66:\5\20\t\2\67:\5\36\20\28:\7>\2\29*\3\2\2\29/\3\2\2\2"+
		"9\60\3\2\2\29\62\3\2\2\29\64\3\2\2\29\66\3\2\2\29\67\3\2\2\298\3\2\2\2"+
		":s\3\2\2\2;<\f\27\2\2<=\7\35\2\2=r\5\4\3\30>?\f\21\2\2?@\t\5\2\2@r\5\4"+
		"\3\22AB\f\20\2\2BC\t\3\2\2Cr\5\4\3\21DE\f\17\2\2EF\t\6\2\2Fr\5\4\3\20"+
		"GH\f\16\2\2HI\t\7\2\2Ir\5\4\3\17JK\f\r\2\2KL\t\b\2\2Lr\5\4\3\16MN\f\f"+
		"\2\2NO\7+\2\2Or\5\4\3\rPQ\f\13\2\2QR\7,\2\2Rr\5\4\3\fST\f\n\2\2TU\7-\2"+
		"\2Ur\5\4\3\13VW\f\t\2\2WX\7.\2\2Xr\5\4\3\nYZ\f\b\2\2Z[\7/\2\2[r\5\4\3"+
		"\t\\]\f\7\2\2]^\7\7\2\2^_\5\4\3\2_`\7\b\2\2`a\5\4\3\bar\3\2\2\2bc\f\6"+
		"\2\2cd\t\t\2\2dr\5\4\3\7ef\f\31\2\2fg\7\3\2\2gh\5\6\4\2hi\7\4\2\2ir\3"+
		"\2\2\2jk\f\30\2\2kl\7\5\2\2lm\5\4\3\2mn\7\6\2\2nr\3\2\2\2op\f\26\2\2p"+
		"r\t\2\2\2q;\3\2\2\2q>\3\2\2\2qA\3\2\2\2qD\3\2\2\2qG\3\2\2\2qJ\3\2\2\2"+
		"qM\3\2\2\2qP\3\2\2\2qS\3\2\2\2qV\3\2\2\2qY\3\2\2\2q\\\3\2\2\2qb\3\2\2"+
		"\2qe\3\2\2\2qj\3\2\2\2qo\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\5\3\2"+
		"\2\2us\3\2\2\2vw\5\4\3\2wx\7\t\2\2xz\3\2\2\2yv\3\2\2\2z}\3\2\2\2{y\3\2"+
		"\2\2{|\3\2\2\2|\177\3\2\2\2}{\3\2\2\2~\u0080\5\4\3\2\177~\3\2\2\2\177"+
		"\u0080\3\2\2\2\u0080\7\3\2\2\2\u0081\u0085\7\n\2\2\u0082\u0084\5\34\17"+
		"\2\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086"+
		"\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\7\13\2\2"+
		"\u0089\t\3\2\2\2\u008a\u008d\7>\2\2\u008b\u008d\5\24\13\2\u008c\u008a"+
		"\3\2\2\2\u008c\u008b\3\2\2\2\u008d\u0093\3\2\2\2\u008e\u0090\7\5\2\2\u008f"+
		"\u0091\5\36\20\2\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3"+
		"\2\2\2\u0092\u0094\7\6\2\2\u0093\u008e\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\13\3\2\2\2\u0095\u0097\7>\2\2\u0096\u0098\7\t\2\2\u0097\u0096\3\2\2\2"+
		"\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0095\3\2\2\2\u009a\u009b"+
		"\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f\3\2\2\2\u009d"+
		"\u009e\7\b\2\2\u009e\u00a0\5\n\6\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\r\3\2\2\2\u00a1\u00a3\5\4\3\2\u00a2\u00a4\7\t\2\2\u00a3\u00a2"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\17\3\2\2"+
		"\2\u00a9\u00aa\t\n\2\2\u00aa\u00ad\5\f\7\2\u00ab\u00ac\7\62\2\2\u00ac"+
		"\u00ae\5\16\b\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\21\3\2\2"+
		"\2\u00af\u00b0\5\f\7\2\u00b0\u00b1\7\t\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00af"+
		"\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b9\5\f\7\2\u00b8\u00b7\3\2"+
		"\2\2\u00b8\u00b9\3\2\2\2\u00b9\23\3\2\2\2\u00ba\u00bb\7\3\2\2\u00bb\u00bc"+
		"\5\22\n\2\u00bc\u00bd\7\4\2\2\u00bd\u00bf\3\2\2\2\u00be\u00ba\3\2\2\2"+
		"\u00be\u00bf\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00c1\7\b\2\2\u00c1\u00c3"+
		"\5\n\6\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\25\3\2\2\2\u00c4"+
		"\u00c5\5\24\13\2\u00c5\u00c6\5\b\5\2\u00c6\27\3\2\2\2\u00c7\u00c8\7\16"+
		"\2\2\u00c8\u00c9\7>\2\2\u00c9\u00ca\5\26\f\2\u00ca\31\3\2\2\2\u00cb\u00cc"+
		"\t\13\2\2\u00cc\u00cf\7>\2\2\u00cd\u00ce\7\b\2\2\u00ce\u00d0\7>\2\2\u00cf"+
		"\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\5\b"+
		"\5\2\u00d2\33\3\2\2\2\u00d3\u00d4\7\22\2\2\u00d4\u00d5\7\3\2\2\u00d5\u00d6"+
		"\5\4\3\2\u00d6\u00d7\7\4\2\2\u00d7\u00d8\5\b\5\2\u00d8\u0109\3\2\2\2\u00d9"+
		"\u00da\7\23\2\2\u00da\u00db\7\22\2\2\u00db\u00dc\7\3\2\2\u00dc\u00dd\5"+
		"\4\3\2\u00dd\u00de\7\4\2\2\u00de\u00df\5\b\5\2\u00df\u0109\3\2\2\2\u00e0"+
		"\u00e1\7\23\2\2\u00e1\u0109\5\b\5\2\u00e2\u00e3\7\24\2\2\u00e3\u00e4\7"+
		"\3\2\2\u00e4\u00e5\5\4\3\2\u00e5\u00e6\7\4\2\2\u00e6\u00e7\5\b\5\2\u00e7"+
		"\u0109\3\2\2\2\u00e8\u00e9\7\25\2\2\u00e9\u00ea\5\b\5\2\u00ea\u00eb\7"+
		"\24\2\2\u00eb\u00ec\7\3\2\2\u00ec\u00ed\5\4\3\2\u00ed\u00ee\7\4\2\2\u00ee"+
		"\u00ef\7\26\2\2\u00ef\u0109\3\2\2\2\u00f0\u00f1\7\27\2\2\u00f1\u00f2\7"+
		"\3\2\2\u00f2\u00f3\5\4\3\2\u00f3\u00f4\7\26\2\2\u00f4\u00f5\5\4\3\2\u00f5"+
		"\u00f6\7\26\2\2\u00f6\u00f7\5\4\3\2\u00f7\u00f8\7\4\2\2\u00f8\u00f9\5"+
		"\b\5\2\u00f9\u0109\3\2\2\2\u00fa\u00fb\7\30\2\2\u00fb\u00fc\5\4\3\2\u00fc"+
		"\u00fd\7\26\2\2\u00fd\u0109\3\2\2\2\u00fe\u00ff\7\31\2\2\u00ff\u0109\7"+
		"\26\2\2\u0100\u0101\7\32\2\2\u0101\u0109\7\26\2\2\u0102\u0109\5\30\r\2"+
		"\u0103\u0109\5\32\16\2\u0104\u0105\5\4\3\2\u0105\u0106\7\26\2\2\u0106"+
		"\u0109\3\2\2\2\u0107\u0109\5\b\5\2\u0108\u00d3\3\2\2\2\u0108\u00d9\3\2"+
		"\2\2\u0108\u00e0\3\2\2\2\u0108\u00e2\3\2\2\2\u0108\u00e8\3\2\2\2\u0108"+
		"\u00f0\3\2\2\2\u0108\u00fa\3\2\2\2\u0108\u00fe\3\2\2\2\u0108\u0100\3\2"+
		"\2\2\u0108\u0102\3\2\2\2\u0108\u0103\3\2\2\2\u0108\u0104\3\2\2\2\u0108"+
		"\u0107\3\2\2\2\u0109\35\3\2\2\2\u010a\u010f\7=\2\2\u010b\u010f\7?\2\2"+
		"\u010c\u010f\7@\2\2\u010d\u010f\5 \21\2\u010e\u010a\3\2\2\2\u010e\u010b"+
		"\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010d\3\2\2\2\u010f\37\3\2\2\2\u0110"+
		"\u0116\7\5\2\2\u0111\u0112\5\4\3\2\u0112\u0113\7\t\2\2\u0113\u0115\3\2"+
		"\2\2\u0114\u0111\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011b\5\4"+
		"\3\2\u011a\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c"+
		"\u011d\7\6\2\2\u011d!\3\2\2\2\33%9qs{\177\u0085\u008c\u0090\u0093\u0097"+
		"\u009b\u009f\u00a3\u00a7\u00ad\u00b4\u00b8\u00be\u00c2\u00cf\u0108\u010e"+
		"\u0116\u011a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}