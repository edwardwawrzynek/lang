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
		RULE_typeDecl = 4, RULE_varType = 5, RULE_varDecl = 6, RULE_funcArgDecl = 7, 
		RULE_funcType = 8, RULE_funcBody = 9, RULE_funcDecl = 10, RULE_classDecl = 11, 
		RULE_statement = 12, RULE_literal = 13, RULE_arrayLiteral = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "funcArgsExpr", "block", "typeDecl", "varType", "varDecl", 
			"funcArgDecl", "funcType", "funcBody", "funcDecl", "classDecl", "statement", 
			"literal", "arrayLiteral"
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << OP_INC) | (1L << OP_DEC) | (1L << OP_LNOT) | (1L << OP_BNOT) | (1L << OP_ADD) | (1L << OP_SUB) | (1L << NUM) | (1L << ID) | (1L << STR) | (1L << CHR))) != 0)) {
				{
				{
				setState(30);
				statement();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
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
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(39);
				match(T__0);
				setState(40);
				expr(0);
				setState(41);
				match(T__1);
				}
				break;
			case 2:
				{
				_localctx = new LambdaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43);
				((LambdaExprContext)_localctx).varName = funcBody();
				}
				break;
			case 3:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44);
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
				setState(45);
				((PrefixExprContext)_localctx).varName = expr(18);
				}
				break;
			case 4:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(46);
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
				setState(47);
				((PrefixExprContext)_localctx).varName = expr(17);
				}
				break;
			case 5:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
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
				setState(49);
				((PrefixExprContext)_localctx).varName = expr(16);
				}
				break;
			case 6:
				{
				_localctx = new DeclExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50);
				((DeclExprContext)_localctx).decl = varDecl();
				}
				break;
			case 7:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				literal();
				}
				break;
			case 8:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(109);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new DotExprContext(new ExprContext(_parentctx, _parentState));
						((DotExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(55);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(56);
						match(OP_DOT);
						setState(57);
						((DotExprContext)_localctx).sub = expr(22);
						}
						break;
					case 2:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(58);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(59);
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
						setState(60);
						((InfixExprContext)_localctx).right = expr(16);
						}
						break;
					case 3:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(61);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(62);
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
						setState(63);
						((InfixExprContext)_localctx).right = expr(15);
						}
						break;
					case 4:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(64);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(65);
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
						setState(66);
						((InfixExprContext)_localctx).right = expr(14);
						}
						break;
					case 5:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(67);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(68);
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
						setState(69);
						((InfixExprContext)_localctx).right = expr(13);
						}
						break;
					case 6:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(71);
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
						setState(72);
						((InfixExprContext)_localctx).right = expr(12);
						}
						break;
					case 7:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(73);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(74);
						((InfixExprContext)_localctx).op = match(OP_BAND);
						setState(75);
						((InfixExprContext)_localctx).right = expr(11);
						}
						break;
					case 8:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(76);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(77);
						((InfixExprContext)_localctx).op = match(OP_BOR);
						setState(78);
						((InfixExprContext)_localctx).right = expr(10);
						}
						break;
					case 9:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(79);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(80);
						((InfixExprContext)_localctx).op = match(OP_BXOR);
						setState(81);
						((InfixExprContext)_localctx).right = expr(9);
						}
						break;
					case 10:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(82);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(83);
						((InfixExprContext)_localctx).op = match(OP_LAND);
						setState(84);
						((InfixExprContext)_localctx).right = expr(8);
						}
						break;
					case 11:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(85);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(86);
						((InfixExprContext)_localctx).op = match(OP_LOR);
						setState(87);
						((InfixExprContext)_localctx).right = expr(7);
						}
						break;
					case 12:
						{
						_localctx = new TernaryExprContext(new ExprContext(_parentctx, _parentState));
						((TernaryExprContext)_localctx).cond = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(88);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(89);
						match(T__4);
						setState(90);
						((TernaryExprContext)_localctx).left = expr(0);
						setState(91);
						match(T__5);
						setState(92);
						((TernaryExprContext)_localctx).right = expr(6);
						}
						break;
					case 13:
						{
						_localctx = new AssignmentExprContext(new ExprContext(_parentctx, _parentState));
						((AssignmentExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(94);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(95);
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
						setState(96);
						((AssignmentExprContext)_localctx).right = expr(5);
						}
						break;
					case 14:
						{
						_localctx = new FuncExprContext(new ExprContext(_parentctx, _parentState));
						((FuncExprContext)_localctx).name = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(97);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(98);
						match(T__0);
						setState(99);
						((FuncExprContext)_localctx).args = funcArgsExpr();
						setState(100);
						match(T__1);
						}
						break;
					case 15:
						{
						_localctx = new ArrayExprContext(new ExprContext(_parentctx, _parentState));
						((ArrayExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(102);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(103);
						match(T__2);
						setState(104);
						((ArrayExprContext)_localctx).sub = expr(0);
						setState(105);
						match(T__3);
						}
						break;
					case 16:
						{
						_localctx = new PostfixExprContext(new ExprContext(_parentctx, _parentState));
						((PostfixExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(107);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(108);
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
				setState(113);
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
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(114);
					expr(0);
					setState(115);
					match(T__6);
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << OP_INC) | (1L << OP_DEC) | (1L << OP_LNOT) | (1L << OP_BNOT) | (1L << OP_ADD) | (1L << OP_SUB) | (1L << NUM) | (1L << ID) | (1L << STR) | (1L << CHR))) != 0)) {
				{
				setState(122);
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
			setState(125);
			match(T__7);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << OP_INC) | (1L << OP_DEC) | (1L << OP_LNOT) | (1L << OP_BNOT) | (1L << OP_ADD) | (1L << OP_SUB) | (1L << NUM) | (1L << ID) | (1L << STR) | (1L << CHR))) != 0)) {
				{
				{
				setState(126);
				statement();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132);
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
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(134);
				match(ID);
				}
				break;
			case 2:
				{
				setState(135);
				funcType();
				}
				break;
			}
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(138);
				match(T__2);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << NUM) | (1L << STR) | (1L << CHR))) != 0)) {
					{
					setState(139);
					((TypeDeclContext)_localctx).size = literal();
					}
				}

				setState(142);
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
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			((VarTypeContext)_localctx).name = match(ID);
			setState(146);
			match(T__5);
			setState(147);
			((VarTypeContext)_localctx).typeName = typeDecl();
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
		public ExprContext init;
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode OP_ASG() { return getToken(LangParser.OP_ASG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		enterRule(_localctx, 12, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
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
			setState(150);
			((VarDeclContext)_localctx).typeName = varType();
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(151);
				match(OP_ASG);
				setState(152);
				((VarDeclContext)_localctx).init = expr(0);
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
		enterRule(_localctx, 14, RULE_funcArgDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(155);
					varType();
					setState(156);
					match(T__6);
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(163);
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
		enterRule(_localctx, 16, RULE_funcType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(166);
				match(T__0);
				setState(167);
				((FuncTypeContext)_localctx).args = funcArgDecl();
				setState(168);
				match(T__1);
				}
				break;
			}
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(172);
				match(T__5);
				setState(173);
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
		enterRule(_localctx, 18, RULE_funcBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			((FuncBodyContext)_localctx).typeName = funcType();
			setState(177);
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
		enterRule(_localctx, 20, RULE_funcDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(T__11);
			setState(180);
			((FuncDeclContext)_localctx).name = match(ID);
			setState(181);
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
		enterRule(_localctx, 22, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
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
			setState(184);
			((ClassDeclContext)_localctx).name = match(ID);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(185);
				match(T__5);
				setState(186);
				((ClassDeclContext)_localctx).parentClass = match(ID);
				}
			}

			setState(189);
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
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new IfStmntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(T__15);
				setState(192);
				match(T__0);
				setState(193);
				((IfStmntContext)_localctx).cond = expr(0);
				setState(194);
				match(T__1);
				setState(195);
				((IfStmntContext)_localctx).code = block();
				}
				break;
			case 2:
				_localctx = new ElseIfStmntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(T__16);
				setState(198);
				match(T__15);
				setState(199);
				match(T__0);
				setState(200);
				((ElseIfStmntContext)_localctx).cond = expr(0);
				setState(201);
				match(T__1);
				setState(202);
				((ElseIfStmntContext)_localctx).code = block();
				}
				break;
			case 3:
				_localctx = new ElseStmntContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
				match(T__16);
				setState(205);
				((ElseStmntContext)_localctx).code = block();
				}
				break;
			case 4:
				_localctx = new WhileStmntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(206);
				match(T__17);
				setState(207);
				match(T__0);
				setState(208);
				((WhileStmntContext)_localctx).cond = expr(0);
				setState(209);
				match(T__1);
				setState(210);
				((WhileStmntContext)_localctx).code = block();
				}
				break;
			case 5:
				_localctx = new DoWhileStmntContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(212);
				match(T__18);
				setState(213);
				((DoWhileStmntContext)_localctx).code = block();
				setState(214);
				match(T__17);
				setState(215);
				match(T__0);
				setState(216);
				((DoWhileStmntContext)_localctx).cond = expr(0);
				setState(217);
				match(T__1);
				setState(218);
				match(T__19);
				}
				break;
			case 6:
				_localctx = new ForStmntContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(220);
				match(T__20);
				setState(221);
				match(T__0);
				setState(222);
				((ForStmntContext)_localctx).init = expr(0);
				setState(223);
				match(T__19);
				setState(224);
				((ForStmntContext)_localctx).rep = expr(0);
				setState(225);
				match(T__19);
				setState(226);
				((ForStmntContext)_localctx).end = expr(0);
				setState(227);
				match(T__1);
				setState(228);
				((ForStmntContext)_localctx).code = block();
				}
				break;
			case 7:
				_localctx = new ReturnStmntContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(230);
				match(T__21);
				setState(231);
				((ReturnStmntContext)_localctx).val = expr(0);
				setState(232);
				match(T__19);
				}
				break;
			case 8:
				_localctx = new ContinueStmntContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(234);
				match(T__22);
				setState(235);
				match(T__19);
				}
				break;
			case 9:
				_localctx = new BreakStmntContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(236);
				match(T__23);
				setState(237);
				match(T__19);
				}
				break;
			case 10:
				_localctx = new FuncDeclStmntContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(238);
				((FuncDeclStmntContext)_localctx).function = funcDecl();
				}
				break;
			case 11:
				_localctx = new ClassDeclStmntContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(239);
				((ClassDeclStmntContext)_localctx).classType = classDecl();
				}
				break;
			case 12:
				_localctx = new ExprStmntContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(240);
				expr(0);
				setState(241);
				match(T__19);
				}
				break;
			case 13:
				_localctx = new BlockStmntContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(243);
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
		enterRule(_localctx, 26, RULE_literal);
		try {
			setState(250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				match(NUM);
				}
				break;
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				match(STR);
				}
				break;
			case CHR:
				enterOuterAlt(_localctx, 3);
				{
				setState(248);
				match(CHR);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 4);
				{
				setState(249);
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
		enterRule(_localctx, 28, RULE_arrayLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(T__2);
			setState(258);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(253);
					expr(0);
					setState(254);
					match(T__6);
					}
					} 
				}
				setState(260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << OP_INC) | (1L << OP_DEC) | (1L << OP_LNOT) | (1L << OP_BNOT) | (1L << OP_ADD) | (1L << OP_SUB) | (1L << NUM) | (1L << ID) | (1L << STR) | (1L << CHR))) != 0)) {
				{
				setState(261);
				expr(0);
				}
			}

			setState(264);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3B\u010d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\7\2\"\n\2\f\2\16"+
		"\2%\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\38\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\7\3p\n\3\f\3\16\3s\13\3\3\4\3\4\3\4\7\4x\n\4\f"+
		"\4\16\4{\13\4\3\4\5\4~\n\4\3\5\3\5\7\5\u0082\n\5\f\5\16\5\u0085\13\5\3"+
		"\5\3\5\3\6\3\6\5\6\u008b\n\6\3\6\3\6\5\6\u008f\n\6\3\6\5\6\u0092\n\6\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5\b\u009c\n\b\3\t\3\t\3\t\7\t\u00a1\n\t"+
		"\f\t\16\t\u00a4\13\t\3\t\5\t\u00a7\n\t\3\n\3\n\3\n\3\n\5\n\u00ad\n\n\3"+
		"\n\3\n\5\n\u00b1\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\5"+
		"\r\u00be\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u00f7\n\16\3\17\3\17\3\17\3\17\5\17\u00fd\n\17\3\20\3\20\3"+
		"\20\3\20\7\20\u0103\n\20\f\20\16\20\u0106\13\20\3\20\5\20\u0109\n\20\3"+
		"\20\3\20\3\20\2\3\4\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\f\3\2"+
		"\33\34\3\2\60\61\3\2\36\37\3\2 \"\3\2#$\3\2%(\3\2)*\3\2\62<\3\2\f\r\3"+
		"\2\17\21\2\u0132\2#\3\2\2\2\4\67\3\2\2\2\6y\3\2\2\2\b\177\3\2\2\2\n\u008a"+
		"\3\2\2\2\f\u0093\3\2\2\2\16\u0097\3\2\2\2\20\u00a2\3\2\2\2\22\u00ac\3"+
		"\2\2\2\24\u00b2\3\2\2\2\26\u00b5\3\2\2\2\30\u00b9\3\2\2\2\32\u00f6\3\2"+
		"\2\2\34\u00fc\3\2\2\2\36\u00fe\3\2\2\2 \"\5\32\16\2! \3\2\2\2\"%\3\2\2"+
		"\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2&\'\7\2\2\3\'\3\3\2\2\2()\b"+
		"\3\1\2)*\7\3\2\2*+\5\4\3\2+,\7\4\2\2,8\3\2\2\2-8\5\24\13\2./\t\2\2\2/"+
		"8\5\4\3\24\60\61\t\3\2\2\618\5\4\3\23\62\63\t\4\2\2\638\5\4\3\22\648\5"+
		"\16\b\2\658\5\34\17\2\668\7>\2\2\67(\3\2\2\2\67-\3\2\2\2\67.\3\2\2\2\67"+
		"\60\3\2\2\2\67\62\3\2\2\2\67\64\3\2\2\2\67\65\3\2\2\2\67\66\3\2\2\28q"+
		"\3\2\2\29:\f\27\2\2:;\7\35\2\2;p\5\4\3\30<=\f\21\2\2=>\t\5\2\2>p\5\4\3"+
		"\22?@\f\20\2\2@A\t\3\2\2Ap\5\4\3\21BC\f\17\2\2CD\t\6\2\2Dp\5\4\3\20EF"+
		"\f\16\2\2FG\t\7\2\2Gp\5\4\3\17HI\f\r\2\2IJ\t\b\2\2Jp\5\4\3\16KL\f\f\2"+
		"\2LM\7+\2\2Mp\5\4\3\rNO\f\13\2\2OP\7,\2\2Pp\5\4\3\fQR\f\n\2\2RS\7-\2\2"+
		"Sp\5\4\3\13TU\f\t\2\2UV\7.\2\2Vp\5\4\3\nWX\f\b\2\2XY\7/\2\2Yp\5\4\3\t"+
		"Z[\f\7\2\2[\\\7\7\2\2\\]\5\4\3\2]^\7\b\2\2^_\5\4\3\b_p\3\2\2\2`a\f\6\2"+
		"\2ab\t\t\2\2bp\5\4\3\7cd\f\31\2\2de\7\3\2\2ef\5\6\4\2fg\7\4\2\2gp\3\2"+
		"\2\2hi\f\30\2\2ij\7\5\2\2jk\5\4\3\2kl\7\6\2\2lp\3\2\2\2mn\f\26\2\2np\t"+
		"\2\2\2o9\3\2\2\2o<\3\2\2\2o?\3\2\2\2oB\3\2\2\2oE\3\2\2\2oH\3\2\2\2oK\3"+
		"\2\2\2oN\3\2\2\2oQ\3\2\2\2oT\3\2\2\2oW\3\2\2\2oZ\3\2\2\2o`\3\2\2\2oc\3"+
		"\2\2\2oh\3\2\2\2om\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\5\3\2\2\2sq"+
		"\3\2\2\2tu\5\4\3\2uv\7\t\2\2vx\3\2\2\2wt\3\2\2\2x{\3\2\2\2yw\3\2\2\2y"+
		"z\3\2\2\2z}\3\2\2\2{y\3\2\2\2|~\5\4\3\2}|\3\2\2\2}~\3\2\2\2~\7\3\2\2\2"+
		"\177\u0083\7\n\2\2\u0080\u0082\5\32\16\2\u0081\u0080\3\2\2\2\u0082\u0085"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086\u0087\7\13\2\2\u0087\t\3\2\2\2\u0088\u008b\7>\2\2"+
		"\u0089\u008b\5\22\n\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b\u0091"+
		"\3\2\2\2\u008c\u008e\7\5\2\2\u008d\u008f\5\34\17\2\u008e\u008d\3\2\2\2"+
		"\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\7\6\2\2\u0091\u008c"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\13\3\2\2\2\u0093\u0094\7>\2\2\u0094"+
		"\u0095\7\b\2\2\u0095\u0096\5\n\6\2\u0096\r\3\2\2\2\u0097\u0098\t\n\2\2"+
		"\u0098\u009b\5\f\7\2\u0099\u009a\7\62\2\2\u009a\u009c\5\4\3\2\u009b\u0099"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c\17\3\2\2\2\u009d\u009e\5\f\7\2\u009e"+
		"\u009f\7\t\2\2\u009f\u00a1\3\2\2\2\u00a0\u009d\3\2\2\2\u00a1\u00a4\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a5\u00a7\5\f\7\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\21\3\2\2\2\u00a8\u00a9\7\3\2\2\u00a9\u00aa\5\20\t\2\u00aa\u00ab"+
		"\7\4\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00b0\3\2\2\2\u00ae\u00af\7\b\2\2\u00af\u00b1\5\n\6\2\u00b0\u00ae\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\23\3\2\2\2\u00b2\u00b3\5\22\n\2\u00b3\u00b4"+
		"\5\b\5\2\u00b4\25\3\2\2\2\u00b5\u00b6\7\16\2\2\u00b6\u00b7\7>\2\2\u00b7"+
		"\u00b8\5\24\13\2\u00b8\27\3\2\2\2\u00b9\u00ba\t\13\2\2\u00ba\u00bd\7>"+
		"\2\2\u00bb\u00bc\7\b\2\2\u00bc\u00be\7>\2\2\u00bd\u00bb\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\5\b\5\2\u00c0\31\3\2\2"+
		"\2\u00c1\u00c2\7\22\2\2\u00c2\u00c3\7\3\2\2\u00c3\u00c4\5\4\3\2\u00c4"+
		"\u00c5\7\4\2\2\u00c5\u00c6\5\b\5\2\u00c6\u00f7\3\2\2\2\u00c7\u00c8\7\23"+
		"\2\2\u00c8\u00c9\7\22\2\2\u00c9\u00ca\7\3\2\2\u00ca\u00cb\5\4\3\2\u00cb"+
		"\u00cc\7\4\2\2\u00cc\u00cd\5\b\5\2\u00cd\u00f7\3\2\2\2\u00ce\u00cf\7\23"+
		"\2\2\u00cf\u00f7\5\b\5\2\u00d0\u00d1\7\24\2\2\u00d1\u00d2\7\3\2\2\u00d2"+
		"\u00d3\5\4\3\2\u00d3\u00d4\7\4\2\2\u00d4\u00d5\5\b\5\2\u00d5\u00f7\3\2"+
		"\2\2\u00d6\u00d7\7\25\2\2\u00d7\u00d8\5\b\5\2\u00d8\u00d9\7\24\2\2\u00d9"+
		"\u00da\7\3\2\2\u00da\u00db\5\4\3\2\u00db\u00dc\7\4\2\2\u00dc\u00dd\7\26"+
		"\2\2\u00dd\u00f7\3\2\2\2\u00de\u00df\7\27\2\2\u00df\u00e0\7\3\2\2\u00e0"+
		"\u00e1\5\4\3\2\u00e1\u00e2\7\26\2\2\u00e2\u00e3\5\4\3\2\u00e3\u00e4\7"+
		"\26\2\2\u00e4\u00e5\5\4\3\2\u00e5\u00e6\7\4\2\2\u00e6\u00e7\5\b\5\2\u00e7"+
		"\u00f7\3\2\2\2\u00e8\u00e9\7\30\2\2\u00e9\u00ea\5\4\3\2\u00ea\u00eb\7"+
		"\26\2\2\u00eb\u00f7\3\2\2\2\u00ec\u00ed\7\31\2\2\u00ed\u00f7\7\26\2\2"+
		"\u00ee\u00ef\7\32\2\2\u00ef\u00f7\7\26\2\2\u00f0\u00f7\5\26\f\2\u00f1"+
		"\u00f7\5\30\r\2\u00f2\u00f3\5\4\3\2\u00f3\u00f4\7\26\2\2\u00f4\u00f7\3"+
		"\2\2\2\u00f5\u00f7\5\b\5\2\u00f6\u00c1\3\2\2\2\u00f6\u00c7\3\2\2\2\u00f6"+
		"\u00ce\3\2\2\2\u00f6\u00d0\3\2\2\2\u00f6\u00d6\3\2\2\2\u00f6\u00de\3\2"+
		"\2\2\u00f6\u00e8\3\2\2\2\u00f6\u00ec\3\2\2\2\u00f6\u00ee\3\2\2\2\u00f6"+
		"\u00f0\3\2\2\2\u00f6\u00f1\3\2\2\2\u00f6\u00f2\3\2\2\2\u00f6\u00f5\3\2"+
		"\2\2\u00f7\33\3\2\2\2\u00f8\u00fd\7=\2\2\u00f9\u00fd\7?\2\2\u00fa\u00fd"+
		"\7@\2\2\u00fb\u00fd\5\36\20\2\u00fc\u00f8\3\2\2\2\u00fc\u00f9\3\2\2\2"+
		"\u00fc\u00fa\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd\35\3\2\2\2\u00fe\u0104"+
		"\7\5\2\2\u00ff\u0100\5\4\3\2\u0100\u0101\7\t\2\2\u0101\u0103\3\2\2\2\u0102"+
		"\u00ff\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2"+
		"\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0109\5\4\3\2\u0108"+
		"\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\7\6"+
		"\2\2\u010b\37\3\2\2\2\26#\67oqy}\u0083\u008a\u008e\u0091\u009b\u00a2\u00a6"+
		"\u00ac\u00b0\u00bd\u00f6\u00fc\u0104\u0108";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}