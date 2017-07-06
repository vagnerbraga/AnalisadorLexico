package principal;

public enum Simbolo {
	
	VAZIO("", 0),
	$("$", 1),
	OPERADO_SOMA("+", 2),
	OPERADO_SUBTRACAO("-", 3),
	OPERADO_MULTIPLICACAO("*", 4),
	OPERADO_DIVISAO("/", 5),
	ATRIBUICAO(":=", 12),
	OPERADO_IGUALDADE("=", 6),
	MAIOR_QUE(">", 7),
	MAIOR_IGUAL(">=", 8),
	MENOR_QUE("<", 9),
	MENOR_IGUAL("<=", 10),
	DIFERENTE("<>", 11),
	DOIS_PONTOS(":", 13),
	PONTO_VIRGULA(";", 14),
	VIRGULA(",", 15),
	PONTO(".", 16),
	ABRE_PARENTESE("(", 17),
	FECHA_PARENTESE(")", 18),
	IDENTIFICADOR("REVER ISSO", 19),
	INTEIRO("[0-9]", 20),
	LITERAL("[a-zA-Z]", 21),
	PROGRAM("PROGRAM", 22),
	CONST("CONST", 23),
	VAR("VAR", 24),
	PROCEDURE("PROCEDURE", 25),
	BEGIN("BEGIN", 26),
	END("END", 27),
	INTEGER("INTEGER", 28),
	OF("OF", 29),
	CALL("CALL", 30),
	IF("IF", 31),
	THEN("THEN", 32),
	ELSE("ELSE", 33),
	WHILE("WHILE", 34),
	DO("DO", 35),
	REPEAT("REPEAT", 36),
	UNTIL("UNTIL", 37),
	READLN("READLN", 38),
	WRITELN("WRITELN", 39),
	OR("OR", 40),
	AND("AND", 41),
	NOT("NOT", 42),
	FOR("FOR", 43),
	TO("TO", 44),
	CASE("CASE", 45),
	COMENTARIO("Comentario", 46),
	ERROR("Caracter não identificado", -1); 
	
	private String label;
	private int ordinal;

	private Simbolo(String label, int ordinal) {
		this.label = label;
		this.ordinal = ordinal;
	}

	public String getLabel() {
		return label;
	}

	public int getOrdinal() {
		return ordinal;
	}
}