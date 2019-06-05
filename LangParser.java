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
		T__24=25, T__25=26, OP_INC=27, OP_DEC=28, OP_DOT=29, OP_LNOT=30, OP_BNOT=31, 
		OP_MUL=32, OP_DIV=33, OP_MOD=34, OP_LSH=35, OP_RSH=36, OP_LT=37, OP_LTE=38, 
		OP_GT=39, OP_GTE=40, OP_EQ=41, OP_NEQ=42, OP_BAND=43, OP_BOR=44, OP_BXOR=45, 
		OP_LAND=46, OP_LOR=47, OP_ADD=48, OP_SUB=49, OP_ASG=50, OP_ADD_ASG=51, 
		OP_SUB_ASG=52, OP_MUL_ASG=53, OP_DIV_ASG=54, OP_MOD_ASG=55, OP_LSH_ASG=56, 
		OP_RSH_ASG=57, OP_BAND_ASG=58, OP_BXOR_ASG=59, OP_BOR_ASG=60, NUM=61, 
		ID=62, STR=63, CHR=64, WS=65, COMMENT=66, MULTICOMMENT=67;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_funcArgsExpr = 2, RULE_block = 3, 
		RULE_arrayDecl = 4, RULE_typeDecl = 5, RULE_varType = 6, RULE_funcArgVarType = 7, 
		RULE_varInit = 8, RULE_varDecl = 9, RULE_funcArgDecl = 10, RULE_funcType = 11, 
		RULE_funcBody = 12, RULE_funcDecl = 13, RULE_classDecl = 14, RULE_statement = 15, 
		RULE_literal = 16, RULE_arrayLiteral = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "funcArgsExpr", "block", "arrayDecl", "typeDecl", 
			"varType", "funcArgVarType", "varInit", "varDecl", "funcArgDecl", "funcType", 
			"funcBody", "funcDecl", "classDecl", "statement", "literal", "arrayLiteral"
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
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (T__0 - 1)) | (1L << (T__2 - 1)) | (1L << (T__7 - 1)) | (1L << (T__9 - 1)) | (1L << (T__10 - 1)) | (1L << (T__11 - 1)) | (1L << (T__12 - 1)) | (1L << (T__13 - 1)) | (1L << (T__14 - 1)) | (1L << (T__15 - 1)) | (1L << (T__16 - 1)) | (1L << (T__17 - 1)) | (1L << (T__18 - 1)) | (1L << (T__19 - 1)) | (1L << (T__20 - 1)) | (1L << (T__22 - 1)) | (1L << (T__23 - 1)) | (1L << (T__24 - 1)) | (1L << (T__25 - 1)) | (1L << (OP_INC - 1)) | (1L << (OP_DEC - 1)) | (1L << (OP_LNOT - 1)) | (1L << (OP_BNOT - 1)) | (1L << (OP_ADD - 1)) | (1L << (OP_SUB - 1)) | (1L << (NUM - 1)) | (1L << (ID - 1)) | (1L << (STR - 1)) | (1L << (CHR - 1)))) != 0)) {
				{
				{
				setState(36);
				statement();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
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
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(45);
				match(T__0);
				setState(46);
				expr(0);
				setState(47);
				match(T__1);
				}
				break;
			case 2:
				{
				_localctx = new LambdaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(49);
				((LambdaExprContext)_localctx).varName = funcBody();
				}
				break;
			case 3:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50);
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
				setState(51);
				((PrefixExprContext)_localctx).varName = expr(17);
				}
				break;
			case 4:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
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
				setState(53);
				((PrefixExprContext)_localctx).varName = expr(16);
				}
				break;
			case 5:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(54);
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
				setState(55);
				((PrefixExprContext)_localctx).varName = expr(15);
				}
				break;
			case 6:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				literal();
				}
				break;
			case 7:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(114);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new DotExprContext(new ExprContext(_parentctx, _parentState));
						((DotExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(60);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(61);
						match(OP_DOT);
						setState(62);
						((DotExprContext)_localctx).sub = expr(21);
						}
						break;
					case 2:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(63);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(64);
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
						setState(65);
						((InfixExprContext)_localctx).right = expr(15);
						}
						break;
					case 3:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(66);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(67);
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
						setState(68);
						((InfixExprContext)_localctx).right = expr(14);
						}
						break;
					case 4:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(69);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(70);
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
						setState(71);
						((InfixExprContext)_localctx).right = expr(13);
						}
						break;
					case 5:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(72);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(73);
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
						setState(74);
						((InfixExprContext)_localctx).right = expr(12);
						}
						break;
					case 6:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(75);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(76);
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
						setState(77);
						((InfixExprContext)_localctx).right = expr(11);
						}
						break;
					case 7:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(78);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(79);
						((InfixExprContext)_localctx).op = match(OP_BAND);
						setState(80);
						((InfixExprContext)_localctx).right = expr(10);
						}
						break;
					case 8:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(81);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(82);
						((InfixExprContext)_localctx).op = match(OP_BOR);
						setState(83);
						((InfixExprContext)_localctx).right = expr(9);
						}
						break;
					case 9:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(84);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(85);
						((InfixExprContext)_localctx).op = match(OP_BXOR);
						setState(86);
						((InfixExprContext)_localctx).right = expr(8);
						}
						break;
					case 10:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(87);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(88);
						((InfixExprContext)_localctx).op = match(OP_LAND);
						setState(89);
						((InfixExprContext)_localctx).right = expr(7);
						}
						break;
					case 11:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(90);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(91);
						((InfixExprContext)_localctx).op = match(OP_LOR);
						setState(92);
						((InfixExprContext)_localctx).right = expr(6);
						}
						break;
					case 12:
						{
						_localctx = new TernaryExprContext(new ExprContext(_parentctx, _parentState));
						((TernaryExprContext)_localctx).cond = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(93);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(94);
						match(T__4);
						setState(95);
						((TernaryExprContext)_localctx).left = expr(0);
						setState(96);
						match(T__5);
						setState(97);
						((TernaryExprContext)_localctx).right = expr(5);
						}
						break;
					case 13:
						{
						_localctx = new AssignmentExprContext(new ExprContext(_parentctx, _parentState));
						((AssignmentExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(99);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(100);
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
						setState(101);
						((AssignmentExprContext)_localctx).right = expr(4);
						}
						break;
					case 14:
						{
						_localctx = new FuncExprContext(new ExprContext(_parentctx, _parentState));
						((FuncExprContext)_localctx).name = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(102);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(103);
						match(T__0);
						setState(104);
						((FuncExprContext)_localctx).args = funcArgsExpr();
						setState(105);
						match(T__1);
						}
						break;
					case 15:
						{
						_localctx = new ArrayExprContext(new ExprContext(_parentctx, _parentState));
						((ArrayExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(107);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(108);
						match(T__2);
						setState(109);
						((ArrayExprContext)_localctx).sub = expr(0);
						setState(110);
						match(T__3);
						}
						break;
					case 16:
						{
						_localctx = new PostfixExprContext(new ExprContext(_parentctx, _parentState));
						((PostfixExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(112);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(113);
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
				setState(118);
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
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(119);
					expr(0);
					setState(120);
					match(T__6);
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (T__0 - 1)) | (1L << (T__2 - 1)) | (1L << (T__7 - 1)) | (1L << (T__11 - 1)) | (1L << (OP_INC - 1)) | (1L << (OP_DEC - 1)) | (1L << (OP_LNOT - 1)) | (1L << (OP_BNOT - 1)) | (1L << (OP_ADD - 1)) | (1L << (OP_SUB - 1)) | (1L << (NUM - 1)) | (1L << (ID - 1)) | (1L << (STR - 1)) | (1L << (CHR - 1)))) != 0)) {
				{
				setState(127);
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
			setState(130);
			match(T__7);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (T__0 - 1)) | (1L << (T__2 - 1)) | (1L << (T__7 - 1)) | (1L << (T__9 - 1)) | (1L << (T__10 - 1)) | (1L << (T__11 - 1)) | (1L << (T__12 - 1)) | (1L << (T__13 - 1)) | (1L << (T__14 - 1)) | (1L << (T__15 - 1)) | (1L << (T__16 - 1)) | (1L << (T__17 - 1)) | (1L << (T__18 - 1)) | (1L << (T__19 - 1)) | (1L << (T__20 - 1)) | (1L << (T__22 - 1)) | (1L << (T__23 - 1)) | (1L << (T__24 - 1)) | (1L << (T__25 - 1)) | (1L << (OP_INC - 1)) | (1L << (OP_DEC - 1)) | (1L << (OP_LNOT - 1)) | (1L << (OP_BNOT - 1)) | (1L << (OP_ADD - 1)) | (1L << (OP_SUB - 1)) | (1L << (NUM - 1)) | (1L << (ID - 1)) | (1L << (STR - 1)) | (1L << (CHR - 1)))) != 0)) {
				{
				{
				setState(131);
				statement();
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(137);
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

	public static class ArrayDeclContext extends ParserRuleContext {
		public Token size;
		public TerminalNode NUM() { return getToken(LangParser.NUM, 0); }
		public ArrayDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitArrayDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclContext arrayDecl() throws RecognitionException {
		ArrayDeclContext _localctx = new ArrayDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arrayDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(T__2);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUM) {
				{
				setState(140);
				((ArrayDeclContext)_localctx).size = match(NUM);
				}
			}

			setState(143);
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

	public static class TypeDeclContext extends ParserRuleContext {
		public ArrayDeclContext array;
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public ArrayDeclContext arrayDecl() {
			return getRuleContext(ArrayDeclContext.class,0);
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
		enterRule(_localctx, 10, RULE_typeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(145);
				((TypeDeclContext)_localctx).array = arrayDecl();
				}
			}

			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(148);
				match(ID);
				}
				break;
			case T__0:
			case T__1:
			case T__6:
			case T__7:
			case T__11:
			case T__21:
			case OP_ASG:
				{
				setState(149);
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
		enterRule(_localctx, 12, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(152);
				((VarTypeContext)_localctx).name = match(ID);
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(153);
					match(T__6);
					}
				}

				}
				}
				setState(158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(160);
				match(T__5);
				setState(161);
				((VarTypeContext)_localctx).typeName = typeDecl();
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

	public static class FuncArgVarTypeContext extends ParserRuleContext {
		public Token mut;
		public Token name;
		public TypeDeclContext typeName;
		public TypeDeclContext typeDecl() {
			return getRuleContext(TypeDeclContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(LangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LangParser.ID, i);
		}
		public FuncArgVarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcArgVarType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFuncArgVarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncArgVarTypeContext funcArgVarType() throws RecognitionException {
		FuncArgVarTypeContext _localctx = new FuncArgVarTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcArgVarType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9 || _la==T__10) {
				{
				setState(164);
				((FuncArgVarTypeContext)_localctx).mut = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__9 || _la==T__10) ) {
					((FuncArgVarTypeContext)_localctx).mut = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(171); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(167);
				((FuncArgVarTypeContext)_localctx).name = match(ID);
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(168);
					match(T__6);
					}
				}

				}
				}
				setState(173); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(175);
			match(T__5);
			setState(176);
			((FuncArgVarTypeContext)_localctx).typeName = typeDecl();
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
		enterRule(_localctx, 16, RULE_varInit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(178);
				expr(0);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(179);
					match(T__6);
					}
				}

				}
				}
				setState(184); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (T__0 - 1)) | (1L << (T__2 - 1)) | (1L << (T__7 - 1)) | (1L << (T__11 - 1)) | (1L << (OP_INC - 1)) | (1L << (OP_DEC - 1)) | (1L << (OP_LNOT - 1)) | (1L << (OP_BNOT - 1)) | (1L << (OP_ADD - 1)) | (1L << (OP_SUB - 1)) | (1L << (NUM - 1)) | (1L << (ID - 1)) | (1L << (STR - 1)) | (1L << (CHR - 1)))) != 0) );
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
		enterRule(_localctx, 18, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
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
			setState(187);
			((VarDeclContext)_localctx).typeName = varType();
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASG) {
				{
				setState(188);
				match(OP_ASG);
				setState(189);
				((VarDeclContext)_localctx).init = varInit();
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
		public List<FuncArgVarTypeContext> funcArgVarType() {
			return getRuleContexts(FuncArgVarTypeContext.class);
		}
		public FuncArgVarTypeContext funcArgVarType(int i) {
			return getRuleContext(FuncArgVarTypeContext.class,i);
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
		enterRule(_localctx, 20, RULE_funcArgDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(192);
					funcArgVarType();
					setState(193);
					match(T__6);
					}
					} 
				}
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << ID))) != 0)) {
				{
				setState(200);
				funcArgVarType();
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
		enterRule(_localctx, 22, RULE_funcType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(203);
				match(T__0);
				setState(204);
				((FuncTypeContext)_localctx).args = funcArgDecl();
				setState(205);
				match(T__1);
				}
			}

			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(209);
				match(T__11);
				setState(210);
				((FuncTypeContext)_localctx).retType = typeDecl();
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
		enterRule(_localctx, 24, RULE_funcBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			((FuncBodyContext)_localctx).typeName = funcType();
			setState(214);
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
		enterRule(_localctx, 26, RULE_funcDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(T__12);
			setState(217);
			((FuncDeclContext)_localctx).name = match(ID);
			setState(218);
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
		enterRule(_localctx, 28, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			((ClassDeclContext)_localctx).classType = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
				((ClassDeclContext)_localctx).classType = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(221);
			((ClassDeclContext)_localctx).name = match(ID);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(222);
				match(T__5);
				setState(223);
				((ClassDeclContext)_localctx).parentClass = match(ID);
				}
			}

			setState(226);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		public StatementContext init;
		public ExprContext rep;
		public ExprContext end;
		public BlockContext code;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
	public static class VarDeclStmntContext extends StatementContext {
		public VarDeclContext decl;
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public VarDeclStmntContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitVarDeclStmnt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_statement);
		try {
			setState(306);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new IfStmntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				match(T__16);
				setState(234);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					{
					setState(229);
					match(T__0);
					setState(230);
					((IfStmntContext)_localctx).cond = expr(0);
					setState(231);
					match(T__1);
					}
					}
					break;
				case 2:
					{
					{
					setState(233);
					((IfStmntContext)_localctx).cond = expr(0);
					}
					}
					break;
				}
				setState(236);
				((IfStmntContext)_localctx).code = block();
				}
				break;
			case 2:
				_localctx = new ElseIfStmntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				match(T__17);
				setState(244);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					{
					setState(239);
					match(T__0);
					setState(240);
					((ElseIfStmntContext)_localctx).cond = expr(0);
					setState(241);
					match(T__1);
					}
					}
					break;
				case 2:
					{
					{
					setState(243);
					((ElseIfStmntContext)_localctx).cond = expr(0);
					}
					}
					break;
				}
				setState(246);
				((ElseIfStmntContext)_localctx).code = block();
				}
				break;
			case 3:
				_localctx = new ElseStmntContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(248);
				match(T__18);
				setState(249);
				((ElseStmntContext)_localctx).code = block();
				}
				break;
			case 4:
				_localctx = new WhileStmntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(250);
				match(T__19);
				setState(256);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					{
					setState(251);
					match(T__0);
					setState(252);
					((WhileStmntContext)_localctx).cond = expr(0);
					setState(253);
					match(T__1);
					}
					}
					break;
				case 2:
					{
					{
					setState(255);
					((WhileStmntContext)_localctx).cond = expr(0);
					}
					}
					break;
				}
				setState(258);
				((WhileStmntContext)_localctx).code = block();
				}
				break;
			case 5:
				_localctx = new DoWhileStmntContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(260);
				match(T__20);
				setState(261);
				((DoWhileStmntContext)_localctx).code = block();
				setState(262);
				match(T__19);
				setState(268);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					{
					setState(263);
					match(T__0);
					setState(264);
					((DoWhileStmntContext)_localctx).cond = expr(0);
					setState(265);
					match(T__1);
					}
					}
					break;
				case 2:
					{
					{
					setState(267);
					((DoWhileStmntContext)_localctx).cond = expr(0);
					}
					}
					break;
				}
				setState(270);
				match(T__21);
				}
				break;
			case 6:
				_localctx = new ForStmntContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(272);
				match(T__22);
				setState(285);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					{
					setState(273);
					match(T__0);
					setState(274);
					((ForStmntContext)_localctx).init = statement();
					setState(275);
					((ForStmntContext)_localctx).rep = expr(0);
					setState(276);
					match(T__21);
					setState(277);
					((ForStmntContext)_localctx).end = expr(0);
					setState(278);
					match(T__1);
					}
					}
					break;
				case 2:
					{
					{
					setState(280);
					((ForStmntContext)_localctx).init = statement();
					setState(281);
					((ForStmntContext)_localctx).rep = expr(0);
					setState(282);
					match(T__21);
					setState(283);
					((ForStmntContext)_localctx).end = expr(0);
					}
					}
					break;
				}
				setState(287);
				((ForStmntContext)_localctx).code = block();
				}
				break;
			case 7:
				_localctx = new ReturnStmntContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(289);
				match(T__23);
				setState(290);
				((ReturnStmntContext)_localctx).val = expr(0);
				setState(291);
				match(T__21);
				}
				break;
			case 8:
				_localctx = new ContinueStmntContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(293);
				match(T__24);
				setState(294);
				match(T__21);
				}
				break;
			case 9:
				_localctx = new BreakStmntContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(295);
				match(T__25);
				setState(296);
				match(T__21);
				}
				break;
			case 10:
				_localctx = new FuncDeclStmntContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(297);
				((FuncDeclStmntContext)_localctx).function = funcDecl();
				}
				break;
			case 11:
				_localctx = new ClassDeclStmntContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(298);
				((ClassDeclStmntContext)_localctx).classType = classDecl();
				}
				break;
			case 12:
				_localctx = new ExprStmntContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(299);
				expr(0);
				setState(300);
				match(T__21);
				}
				break;
			case 13:
				_localctx = new BlockStmntContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(302);
				((BlockStmntContext)_localctx).code = block();
				}
				break;
			case 14:
				_localctx = new VarDeclStmntContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(303);
				((VarDeclStmntContext)_localctx).decl = varDecl();
				setState(304);
				match(T__21);
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
		enterRule(_localctx, 32, RULE_literal);
		try {
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				match(NUM);
				}
				break;
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(309);
				match(STR);
				}
				break;
			case CHR:
				enterOuterAlt(_localctx, 3);
				{
				setState(310);
				match(CHR);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 4);
				{
				setState(311);
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
		enterRule(_localctx, 34, RULE_arrayLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(T__2);
			setState(320);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(315);
					expr(0);
					setState(316);
					match(T__6);
					}
					} 
				}
				setState(322);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (T__0 - 1)) | (1L << (T__2 - 1)) | (1L << (T__7 - 1)) | (1L << (T__11 - 1)) | (1L << (OP_INC - 1)) | (1L << (OP_DEC - 1)) | (1L << (OP_LNOT - 1)) | (1L << (OP_BNOT - 1)) | (1L << (OP_ADD - 1)) | (1L << (OP_SUB - 1)) | (1L << (NUM - 1)) | (1L << (ID - 1)) | (1L << (STR - 1)) | (1L << (CHR - 1)))) != 0)) {
				{
				setState(323);
				expr(0);
				}
			}

			setState(326);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3E\u014b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3=\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3u\n\3\f\3\16\3x\13"+
		"\3\3\4\3\4\3\4\7\4}\n\4\f\4\16\4\u0080\13\4\3\4\5\4\u0083\n\4\3\5\3\5"+
		"\7\5\u0087\n\5\f\5\16\5\u008a\13\5\3\5\3\5\3\6\3\6\5\6\u0090\n\6\3\6\3"+
		"\6\3\7\5\7\u0095\n\7\3\7\3\7\5\7\u0099\n\7\3\b\3\b\5\b\u009d\n\b\6\b\u009f"+
		"\n\b\r\b\16\b\u00a0\3\b\3\b\5\b\u00a5\n\b\3\t\5\t\u00a8\n\t\3\t\3\t\5"+
		"\t\u00ac\n\t\6\t\u00ae\n\t\r\t\16\t\u00af\3\t\3\t\3\t\3\n\3\n\5\n\u00b7"+
		"\n\n\6\n\u00b9\n\n\r\n\16\n\u00ba\3\13\3\13\3\13\3\13\5\13\u00c1\n\13"+
		"\3\f\3\f\3\f\7\f\u00c6\n\f\f\f\16\f\u00c9\13\f\3\f\5\f\u00cc\n\f\3\r\3"+
		"\r\3\r\3\r\5\r\u00d2\n\r\3\r\3\r\5\r\u00d6\n\r\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u00e3\n\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u00ed\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00f7\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u0103\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u010f"+
		"\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u0120\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0135\n\21\3\22"+
		"\3\22\3\22\3\22\5\22\u013b\n\22\3\23\3\23\3\23\3\23\7\23\u0141\n\23\f"+
		"\23\16\23\u0144\13\23\3\23\5\23\u0147\n\23\3\23\3\23\3\23\2\3\4\24\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\f\3\2\35\36\3\2\62\63\3\2 !"+
		"\3\2\"$\3\2%&\3\2\'*\3\2+,\3\2\64>\3\2\f\r\3\2\20\22\2\u017a\2)\3\2\2"+
		"\2\4<\3\2\2\2\6~\3\2\2\2\b\u0084\3\2\2\2\n\u008d\3\2\2\2\f\u0094\3\2\2"+
		"\2\16\u009e\3\2\2\2\20\u00a7\3\2\2\2\22\u00b8\3\2\2\2\24\u00bc\3\2\2\2"+
		"\26\u00c7\3\2\2\2\30\u00d1\3\2\2\2\32\u00d7\3\2\2\2\34\u00da\3\2\2\2\36"+
		"\u00de\3\2\2\2 \u0134\3\2\2\2\"\u013a\3\2\2\2$\u013c\3\2\2\2&(\5 \21\2"+
		"\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,-\7\2\2"+
		"\3-\3\3\2\2\2./\b\3\1\2/\60\7\3\2\2\60\61\5\4\3\2\61\62\7\4\2\2\62=\3"+
		"\2\2\2\63=\5\32\16\2\64\65\t\2\2\2\65=\5\4\3\23\66\67\t\3\2\2\67=\5\4"+
		"\3\2289\t\4\2\29=\5\4\3\21:=\5\"\22\2;=\7@\2\2<.\3\2\2\2<\63\3\2\2\2<"+
		"\64\3\2\2\2<\66\3\2\2\2<8\3\2\2\2<:\3\2\2\2<;\3\2\2\2=v\3\2\2\2>?\f\26"+
		"\2\2?@\7\37\2\2@u\5\4\3\27AB\f\20\2\2BC\t\5\2\2Cu\5\4\3\21DE\f\17\2\2"+
		"EF\t\3\2\2Fu\5\4\3\20GH\f\16\2\2HI\t\6\2\2Iu\5\4\3\17JK\f\r\2\2KL\t\7"+
		"\2\2Lu\5\4\3\16MN\f\f\2\2NO\t\b\2\2Ou\5\4\3\rPQ\f\13\2\2QR\7-\2\2Ru\5"+
		"\4\3\fST\f\n\2\2TU\7.\2\2Uu\5\4\3\13VW\f\t\2\2WX\7/\2\2Xu\5\4\3\nYZ\f"+
		"\b\2\2Z[\7\60\2\2[u\5\4\3\t\\]\f\7\2\2]^\7\61\2\2^u\5\4\3\b_`\f\6\2\2"+
		"`a\7\7\2\2ab\5\4\3\2bc\7\b\2\2cd\5\4\3\7du\3\2\2\2ef\f\5\2\2fg\t\t\2\2"+
		"gu\5\4\3\6hi\f\30\2\2ij\7\3\2\2jk\5\6\4\2kl\7\4\2\2lu\3\2\2\2mn\f\27\2"+
		"\2no\7\5\2\2op\5\4\3\2pq\7\6\2\2qu\3\2\2\2rs\f\25\2\2su\t\2\2\2t>\3\2"+
		"\2\2tA\3\2\2\2tD\3\2\2\2tG\3\2\2\2tJ\3\2\2\2tM\3\2\2\2tP\3\2\2\2tS\3\2"+
		"\2\2tV\3\2\2\2tY\3\2\2\2t\\\3\2\2\2t_\3\2\2\2te\3\2\2\2th\3\2\2\2tm\3"+
		"\2\2\2tr\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\5\3\2\2\2xv\3\2\2\2yz"+
		"\5\4\3\2z{\7\t\2\2{}\3\2\2\2|y\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3"+
		"\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0081\u0083\5\4\3\2\u0082\u0081"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\7\3\2\2\2\u0084\u0088\7\n\2\2\u0085"+
		"\u0087\5 \21\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2"+
		"\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b"+
		"\u008c\7\13\2\2\u008c\t\3\2\2\2\u008d\u008f\7\5\2\2\u008e\u0090\7?\2\2"+
		"\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092"+
		"\7\6\2\2\u0092\13\3\2\2\2\u0093\u0095\5\n\6\2\u0094\u0093\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0099\7@\2\2\u0097\u0099\5\30"+
		"\r\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\r\3\2\2\2\u009a\u009c"+
		"\7@\2\2\u009b\u009d\7\t\2\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009f\3\2\2\2\u009e\u009a\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a3\7\b\2\2\u00a3"+
		"\u00a5\5\f\7\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\17\3\2\2"+
		"\2\u00a6\u00a8\t\n\2\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00ad"+
		"\3\2\2\2\u00a9\u00ab\7@\2\2\u00aa\u00ac\7\t\2\2\u00ab\u00aa\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00a9\3\2\2\2\u00ae\u00af\3\2"+
		"\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00b2\7\b\2\2\u00b2\u00b3\5\f\7\2\u00b3\21\3\2\2\2\u00b4\u00b6\5\4\3"+
		"\2\u00b5\u00b7\7\t\2\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9"+
		"\3\2\2\2\u00b8\u00b4\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\23\3\2\2\2\u00bc\u00bd\t\n\2\2\u00bd\u00c0\5\16\b"+
		"\2\u00be\u00bf\7\64\2\2\u00bf\u00c1\5\22\n\2\u00c0\u00be\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\25\3\2\2\2\u00c2\u00c3\5\20\t\2\u00c3\u00c4\7\t\2"+
		"\2\u00c4\u00c6\3\2\2\2\u00c5\u00c2\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5"+
		"\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca"+
		"\u00cc\5\20\t\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\27\3\2\2"+
		"\2\u00cd\u00ce\7\3\2\2\u00ce\u00cf\5\26\f\2\u00cf\u00d0\7\4\2\2\u00d0"+
		"\u00d2\3\2\2\2\u00d1\u00cd\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d5\3\2"+
		"\2\2\u00d3\u00d4\7\16\2\2\u00d4\u00d6\5\f\7\2\u00d5\u00d3\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6\31\3\2\2\2\u00d7\u00d8\5\30\r\2\u00d8\u00d9\5\b\5"+
		"\2\u00d9\33\3\2\2\2\u00da\u00db\7\17\2\2\u00db\u00dc\7@\2\2\u00dc\u00dd"+
		"\5\32\16\2\u00dd\35\3\2\2\2\u00de\u00df\t\13\2\2\u00df\u00e2\7@\2\2\u00e0"+
		"\u00e1\7\b\2\2\u00e1\u00e3\7@\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2"+
		"\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\5\b\5\2\u00e5\37\3\2\2\2\u00e6\u00ec"+
		"\7\23\2\2\u00e7\u00e8\7\3\2\2\u00e8\u00e9\5\4\3\2\u00e9\u00ea\7\4\2\2"+
		"\u00ea\u00ed\3\2\2\2\u00eb\u00ed\5\4\3\2\u00ec\u00e7\3\2\2\2\u00ec\u00eb"+
		"\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\5\b\5\2\u00ef\u0135\3\2\2\2\u00f0"+
		"\u00f6\7\24\2\2\u00f1\u00f2\7\3\2\2\u00f2\u00f3\5\4\3\2\u00f3\u00f4\7"+
		"\4\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f7\5\4\3\2\u00f6\u00f1\3\2\2\2\u00f6"+
		"\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\5\b\5\2\u00f9\u0135\3\2"+
		"\2\2\u00fa\u00fb\7\25\2\2\u00fb\u0135\5\b\5\2\u00fc\u0102\7\26\2\2\u00fd"+
		"\u00fe\7\3\2\2\u00fe\u00ff\5\4\3\2\u00ff\u0100\7\4\2\2\u0100\u0103\3\2"+
		"\2\2\u0101\u0103\5\4\3\2\u0102\u00fd\3\2\2\2\u0102\u0101\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104\u0105\5\b\5\2\u0105\u0135\3\2\2\2\u0106\u0107\7\27"+
		"\2\2\u0107\u0108\5\b\5\2\u0108\u010e\7\26\2\2\u0109\u010a\7\3\2\2\u010a"+
		"\u010b\5\4\3\2\u010b\u010c\7\4\2\2\u010c\u010f\3\2\2\2\u010d\u010f\5\4"+
		"\3\2\u010e\u0109\3\2\2\2\u010e\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\u0111\7\30\2\2\u0111\u0135\3\2\2\2\u0112\u011f\7\31\2\2\u0113\u0114\7"+
		"\3\2\2\u0114\u0115\5 \21\2\u0115\u0116\5\4\3\2\u0116\u0117\7\30\2\2\u0117"+
		"\u0118\5\4\3\2\u0118\u0119\7\4\2\2\u0119\u0120\3\2\2\2\u011a\u011b\5 "+
		"\21\2\u011b\u011c\5\4\3\2\u011c\u011d\7\30\2\2\u011d\u011e\5\4\3\2\u011e"+
		"\u0120\3\2\2\2\u011f\u0113\3\2\2\2\u011f\u011a\3\2\2\2\u0120\u0121\3\2"+
		"\2\2\u0121\u0122\5\b\5\2\u0122\u0135\3\2\2\2\u0123\u0124\7\32\2\2\u0124"+
		"\u0125\5\4\3\2\u0125\u0126\7\30\2\2\u0126\u0135\3\2\2\2\u0127\u0128\7"+
		"\33\2\2\u0128\u0135\7\30\2\2\u0129\u012a\7\34\2\2\u012a\u0135\7\30\2\2"+
		"\u012b\u0135\5\34\17\2\u012c\u0135\5\36\20\2\u012d\u012e\5\4\3\2\u012e"+
		"\u012f\7\30\2\2\u012f\u0135\3\2\2\2\u0130\u0135\5\b\5\2\u0131\u0132\5"+
		"\24\13\2\u0132\u0133\7\30\2\2\u0133\u0135\3\2\2\2\u0134\u00e6\3\2\2\2"+
		"\u0134\u00f0\3\2\2\2\u0134\u00fa\3\2\2\2\u0134\u00fc\3\2\2\2\u0134\u0106"+
		"\3\2\2\2\u0134\u0112\3\2\2\2\u0134\u0123\3\2\2\2\u0134\u0127\3\2\2\2\u0134"+
		"\u0129\3\2\2\2\u0134\u012b\3\2\2\2\u0134\u012c\3\2\2\2\u0134\u012d\3\2"+
		"\2\2\u0134\u0130\3\2\2\2\u0134\u0131\3\2\2\2\u0135!\3\2\2\2\u0136\u013b"+
		"\7?\2\2\u0137\u013b\7A\2\2\u0138\u013b\7B\2\2\u0139\u013b\5$\23\2\u013a"+
		"\u0136\3\2\2\2\u013a\u0137\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u0139\3\2"+
		"\2\2\u013b#\3\2\2\2\u013c\u0142\7\5\2\2\u013d\u013e\5\4\3\2\u013e\u013f"+
		"\7\t\2\2\u013f\u0141\3\2\2\2\u0140\u013d\3\2\2\2\u0141\u0144\3\2\2\2\u0142"+
		"\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2"+
		"\2\2\u0145\u0147\5\4\3\2\u0146\u0145\3\2\2\2\u0146\u0147\3\2\2\2\u0147"+
		"\u0148\3\2\2\2\u0148\u0149\7\6\2\2\u0149%\3\2\2\2#)<tv~\u0082\u0088\u008f"+
		"\u0094\u0098\u009c\u00a0\u00a4\u00a7\u00ab\u00af\u00b6\u00ba\u00c0\u00c7"+
		"\u00cb\u00d1\u00d5\u00e2\u00ec\u00f6\u0102\u010e\u011f\u0134\u013a\u0142"+
		"\u0146";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}