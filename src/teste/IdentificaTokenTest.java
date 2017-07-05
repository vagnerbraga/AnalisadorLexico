package teste;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import principal.IdentificaToken;
import principal.Simbolo;

public class IdentificaTokenTest {

	public static String msg = "Não consegui identificar o caracter";
	
	public static String msgCod = "Não consegui identificar o ordinal do caracter";
	private IdentificaToken id;
	
	@Before
	public void init(){
		 this.id = new IdentificaToken();
	}
	
	@Test
	public void testaVazio(){
		assertEquals(msg + Simbolo.VAZIO, Simbolo.VAZIO, this.id.identifica(""));
	}
	
	@Test
	public void testaDolar(){
		assertEquals(msg + Simbolo.$, Simbolo.$, this.id.identifica("$"));
	}
	
	@Test
	public void testaOperadorSoma(){
		assertEquals(msg + Simbolo.OPERADO_SOMA, Simbolo.OPERADO_SOMA, this.id.identifica("+"));
	}
	
	@Test
	public void testaOperadoSubtracao(){
		assertEquals(msg + Simbolo.OPERADO_SUBTRACAO, Simbolo.OPERADO_SUBTRACAO, this.id.identifica("-"));
		assertEquals(msgCod + 3, 3, this.id.identifica("-").ordinal());

	}
	@Test
	public void testaOperado_multiplicacao(){
		assertEquals(msg + Simbolo.OPERADO_MULTIPLICACAO, Simbolo.OPERADO_MULTIPLICACAO, this.id.identifica("*"));
		assertEquals(msgCod + 4, 4, this.id.identifica("*").ordinal());

	}
	@Test
	public void testaOperado_divisao(){
		assertEquals(msg + Simbolo.OPERADO_DIVISAO, Simbolo.OPERADO_DIVISAO, this.id.identifica("/"));
		assertEquals(msgCod + 5, 5, this.id.identifica("/").ordinal());

	}
	@Test
	public void testaOperado_igualdade(){
		assertEquals(msg + Simbolo.OPERADO_IGUALDADE, Simbolo.OPERADO_IGUALDADE, this.id.identifica("="));
		assertEquals(msgCod + 6, 6, this.id.identifica("=").ordinal());

	}
	@Test
	public void testaMaiorQue(){
		assertEquals(msg + Simbolo.MAIOR_QUE, Simbolo.MAIOR_QUE, this.id.identifica(">"));
		assertEquals(msgCod + 7, 7, this.id.identifica(">").ordinal());

	}
	@Test
	public void testaMaiorIgual(){
		assertEquals(msg + Simbolo.MAIOR_IGUAL, Simbolo.MAIOR_IGUAL, this.id.identifica(">="));
		assertEquals(msgCod + 8, 8, this.id.identifica(">=").ordinal());

	}
	@Test
	public void testaMenorQue(){
		assertEquals(msg + Simbolo.MENOR_QUE, Simbolo.MENOR_QUE, this.id.identifica("<"));
		assertEquals(msgCod + 9, 9, this.id.identifica("<").ordinal());

	}
	@Test
	public void testaMenorIgual(){
		assertEquals(msg + Simbolo.MENOR_IGUAL, Simbolo.MENOR_IGUAL, this.id.identifica("<="));
		assertEquals(msgCod + 10, 10, this.id.identifica("<=").ordinal());

	}
	@Test
	public void testaDiferente(){
		assertEquals(msg + Simbolo.DIFERENTE, Simbolo.DIFERENTE, this.id.identifica("<>"));
		assertEquals(msgCod + 11, 11, this.id.identifica("<>").ordinal());

	}
	@Test
	public void testaAtribuicao(){
		assertEquals(msg + Simbolo.ATRIBUICAO, Simbolo.ATRIBUICAO, this.id.identifica(":="));
		assertEquals(msgCod + 12, 12, this.id.identifica(":=").ordinal());

	}
	@Test
	public void testaDoisPontos(){
		assertEquals(msg + Simbolo.DOIS_PONTOS, Simbolo.DOIS_PONTOS, this.id.identifica(":"));
		assertEquals(msgCod + 13, 13, this.id.identifica(":").ordinal());

	}
	@Test
	public void testaPontoVirgula(){
		assertEquals(msg + Simbolo.PONTO_VIRGULA, Simbolo.PONTO_VIRGULA, this.id.identifica(";"));
		assertEquals(msgCod + 14, 14, this.id.identifica(";").ordinal());

	}
	@Test
	public void testaVirgula(){
		assertEquals(msg + Simbolo.VIRGULA, Simbolo.VIRGULA, this.id.identifica(","));
		assertEquals(msgCod + 15, 15, this.id.identifica(",").ordinal());

	}
	@Test
	public void testaPonto(){
		assertEquals(msg + Simbolo.PONTO, Simbolo.PONTO, this.id.identifica("."));
		assertEquals(msgCod + 16, 16, this.id.identifica(".").ordinal());

	}
	@Test
	public void testaAbreParentese(){
		assertEquals(msg + Simbolo.ABRE_PARENTESE, Simbolo.ABRE_PARENTESE, this.id.identifica("("));
		assertEquals(msgCod + 17, 17, this.id.identifica("(").ordinal());

	}
	@Test
	public void testaFechaParentese(){
		assertEquals(msg + Simbolo.FECHA_PARENTESE, Simbolo.FECHA_PARENTESE, this.id.identifica(")"));
		assertEquals(msgCod + 18, 18, this.id.identifica(")").ordinal());

	}
	@Test
	public void testaIdentificador(){
		
		assertEquals(msg + Simbolo.IDENTIFICADOR, Simbolo.IDENTIFICADOR, this.id.identifica("variavel"));
		
		assertEquals(msg + Simbolo.IDENTIFICADOR, Simbolo.ERROR, this.id.identifica("v ariavel"));
		
		assertEquals(msg + Simbolo.IDENTIFICADOR, Simbolo.IDENTIFICADOR, this.id.identifica("EQWEQWEQWEQWEQWEQWEQWEQWEQWEQ"));//30

		assertEquals(msg + Simbolo.IDENTIFICADOR, Simbolo.IDENTIFICADOR, this.id.identifica("eqweqweqweqweqweqweqweqweqweq"));//30
		
		assertEquals(msg + Simbolo.IDENTIFICADOR, Simbolo.ERROR, this.id.identifica("eqweqweqweqweqweqweqweqweqweqW"));//31
		
		assertEquals(msg + Simbolo.IDENTIFICADOR, Simbolo.ERROR, this.id.identifica("1variavel"));
		
		assertEquals(msgCod + 19, 19, this.id.identifica("variavel").ordinal());

	}
	@Test
	public void testaInteiro(){
		
		assertEquals(msg + Simbolo.INTEIRO, Simbolo.INTEIRO, this.id.identifica("15"));
		assertEquals(msg + Simbolo.INTEIRO, Simbolo.ERROR, this.id.identifica("32768"));
		assertEquals(msgCod + 20, 20, this.id.identifica("15").ordinal());

	}
	@Test
	public void testaLiteral(){
		assertEquals(msg + Simbolo.LITERAL, Simbolo.LITERAL, this.id.identifica("\"aaa\""));
		
		assertEquals(msg + Simbolo.LITERAL, Simbolo.LITERAL, this.id.identifica("\"aaa67890$*()!@$$%()IUYTREGHHGsdfsdfsdfsdf\""));
		assertEquals(msg + Simbolo.LITERAL, Simbolo.ERROR, this.id.identifica("\"aaa67890$*()!@$$%()IUYTREGHHGsdfsdfsdfsdf\"aaa67890$*()!@$$%()IUYTREGHHGsdfsdfsdfsdf aaa67890$*()!@$$%()IUYTREGHHGsdfsdfsdfsdf \"aaa67890$*()!@$$%()IUYTREGHHGsdfsdfsdfsdf \"aaa67890$*()!@$$%()IUYTREGHHGsdfsdfsdfsdf \"aaa67890$*()!@$$%()IUYTREGHHGsdfsdfsdfsdf\""));//259
		
		assertEquals(msg + Simbolo.LITERAL, Simbolo.ERROR, this.id.identifica("\"aaa"));
		assertEquals(msg + Simbolo.LITERAL, Simbolo.ERROR, this.id.identifica("aaa\""));
		
		assertEquals(msgCod + 21, 21, this.id.identifica("\"aaa\"").ordinal());

	}
	@Test
	public void testaProgram(){
		assertEquals(msg + Simbolo.PROGRAM, Simbolo.PROGRAM, this.id.identifica("PROGRAM"));
		assertEquals(msgCod + 22, 22, this.id.identifica("PROGRAM").ordinal());

	}
	@Test
	public void testaConst(){
		assertEquals(msg + Simbolo.CONST, Simbolo.CONST, this.id.identifica("CONST"));
		assertEquals(msgCod + 23, 23, this.id.identifica("CONST").ordinal());

	}
	@Test
	public void testaVar(){
		assertEquals(msg + Simbolo.VAR, Simbolo.VAR, this.id.identifica("VAR"));
		assertEquals(msgCod + 24, 24, this.id.identifica("VAR").ordinal());

	}
	@Test
	public void testaProcedure(){
		assertEquals(msg + Simbolo.PROCEDURE, Simbolo.PROCEDURE, this.id.identifica("PROCEDURE"));
		assertEquals(msgCod + 25, 25, this.id.identifica("PROCEDURE").ordinal());

	}
	@Test
	public void testaBegin(){
		assertEquals(msg + Simbolo.BEGIN, Simbolo.BEGIN, this.id.identifica("BEGIN"));
		assertEquals(msgCod + 26, 26, this.id.identifica("BEGIN").ordinal());

	}
	@Test
	public void testaEnd(){
		assertEquals(msg + Simbolo.END, Simbolo.END, this.id.identifica("END"));
		assertEquals(msgCod + 27, 27, this.id.identifica("END").ordinal());

	}
	@Test
	public void testaInteger(){
		assertEquals(msg + Simbolo.INTEGER, Simbolo.INTEGER, this.id.identifica("INTEGER"));
		assertEquals(msgCod + 28, 28, this.id.identifica("INTEGER").ordinal());

	}
	@Test
	public void testaOf(){
		assertEquals(msg + Simbolo.OF, Simbolo.OF, this.id.identifica("OF"));
		assertEquals(msgCod + 29, 29, this.id.identifica("OF").ordinal());

	}
	@Test
	public void testaCall(){
		assertEquals(msg + Simbolo.CALL, Simbolo.CALL, this.id.identifica("CALL"));
		assertEquals(msgCod + 30, 30, this.id.identifica("CALL").ordinal());

	}
	@Test
	public void testaIf(){
		assertEquals(msg + Simbolo.IF, Simbolo.IF, this.id.identifica("IF"));
		assertEquals(msgCod + 31, 31, this.id.identifica("IF").ordinal());

	}
	@Test
	public void testaThen(){
		assertEquals(msg + Simbolo.THEN, Simbolo.THEN, this.id.identifica("THEN"));
		assertEquals(msgCod + 32, 32, this.id.identifica("THEN").ordinal());

	}
	@Test
	public void testaElse(){
		assertEquals(msg + Simbolo.ELSE, Simbolo.ELSE, this.id.identifica("ELSE"));
		assertEquals(msgCod + 33, 33, this.id.identifica("ELSE").ordinal());

	}
	@Test
	public void testaWhile(){
		assertEquals(msg + Simbolo.WHILE, Simbolo.WHILE, this.id.identifica("WHILE"));
		assertEquals(msgCod + 34, 34, this.id.identifica("WHILE").ordinal());

	}
	@Test
	public void testaDo(){
		assertEquals(msg + Simbolo.DO, Simbolo.DO, this.id.identifica("DO"));
		assertEquals(msgCod + 35, 35, this.id.identifica("DO").ordinal());

	}
	@Test
	public void testaRepeat(){
		assertEquals(msg + Simbolo.REPEAT, Simbolo.REPEAT, this.id.identifica("REPEAT"));
		assertEquals(msgCod + 36, 36, this.id.identifica("REPEAT").ordinal());

	}
	@Test
	public void testaUntil(){
		assertEquals(msg + Simbolo.UNTIL, Simbolo.UNTIL, this.id.identifica("UNTIL"));
		assertEquals(msgCod + 37, 37, this.id.identifica("UNTIL").ordinal());

	}
	@Test
	public void testaReadln(){
		assertEquals(msg + Simbolo.READLN, Simbolo.READLN, this.id.identifica("READLN"));
		assertEquals(msgCod + 38, 38, this.id.identifica("READLN").ordinal());

	}
	@Test
	public void testaWriteln(){
		assertEquals(msg + Simbolo.WRITELN, Simbolo.WRITELN, this.id.identifica("WRITELN"));
		assertEquals(msgCod + 39, 39, this.id.identifica("WRITELN").ordinal());

	}
	@Test
	public void testaOr(){
		assertEquals(msg + Simbolo.OR, Simbolo.OR, this.id.identifica("OR"));
		assertEquals(msgCod + 40, 40, this.id.identifica("OR").ordinal());

	}
	@Test
	public void testaAnd(){
		assertEquals(msg + Simbolo.AND, Simbolo.AND, this.id.identifica("AND"));
		assertEquals(msgCod + 41, 41, this.id.identifica("AND").ordinal());

	}
	@Test
	public void testaNot(){
		assertEquals(msg + Simbolo.NOT, Simbolo.NOT, this.id.identifica("NOT"));
		assertEquals(msgCod + 42, 42, this.id.identifica("NOT").ordinal());

	}
	@Test
	public void testaFor(){
		assertEquals(msg + Simbolo.FOR, Simbolo.FOR, this.id.identifica("FOR"));
		assertEquals(msgCod + 43, 43, this.id.identifica("FOR").ordinal());

	}
	@Test
	public void testaTo(){
		assertEquals(msg + Simbolo.TO, Simbolo.TO, this.id.identifica("TO"));
		assertEquals(msgCod + 44, 44, this.id.identifica("TO").ordinal());

	}
	@Test
	public void testaCase(){
		assertEquals(msg + Simbolo.CASE, Simbolo.CASE, this.id.identifica("CASE"));
		assertEquals(msgCod + 45, 45, this.id.identifica("CASE").ordinal());
	}
	
	
	
	
}