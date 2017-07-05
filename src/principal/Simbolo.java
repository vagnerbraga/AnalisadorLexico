package principal;

public enum Simbolo {
	
	VAZIO(""),
	$("$"),
	OPERADO_SOMA("+"),
	OPERADO_SUBTRACAO("-"),
	OPERADO_MULTIPLICACAO("*"),
	OPERADO_DIVISAO("/"),
	OPERADO_IGUALDADE("="),
	MAIOR_QUE(">"),
	MAIOR_IGUAL(">="),
	MENOR_QUE("<"),
	MENOR_IGUAL("<="),
	DIFERENTE("<>"),
	ATRIBUICAO(":="),
	DOIS_PONTOS(":"),
	PONTO_VIRGULA(";"),
	VIRGULA(","),
	PONTO("."),
	ABRE_PARENTESE("("),
	FECHA_PARENTESE(")"),
	IDENTIFICADOR("REVER ISSO"),
	INTEIRO("[0-9]"),
	LITERAL("[a-zA-Z]"),
	PROGRAM("PROGRAM"),
	CONST("CONST"),
	VAR("VAR"),
	PROCEDURE("PROCEDURE"),
	BEGIN("BEGIN"),
	END("END"),
	INTEGER("INTEGER"),
	OF("OF"),
	CALL("CALL"),
	IF("IF"),
	THEN("THEN"),
	ELSE("ELSE"),
	WHILE("WHILE"),
	DO("DO"),
	REPEAT("REPEAT"),
	UNTIL("UNTIL"),
	READLN("READLN"),
	WRITELN("WRITELN"),
	OR("OR"),
	AND("AND"),
	NOT("NOT"),
	FOR("FOR"),
	TO("TO"),
	CASE("CASE"),
	ERROR("Caracter não identificado");
	
	private String label;

	private Simbolo(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}