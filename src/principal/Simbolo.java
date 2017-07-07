package principal;

public enum Simbolo {
	
	VAZIO("", "Cadeia vazia"),
	$("$", "Fim do arquivo"),
	OPERADO_SOMA("+", "Soma"),
	OPERADO_SUBTRACAO("-", "Subtração"),
	OPERADO_MULTIPLICACAO("*", "Multiplicação"),
	OPERADO_DIVISAO("/", "Divisão"),
	OPERADO_IGUALDADE("=", "Igualdade"),
	MAIOR_QUE(">", "Maior que"),
	MAIOR_IGUAL(">=", "Maio igual que"),
	MENOR_QUE("<", "Menor que"),
	MENOR_IGUAL("<=", "Menor igual que"),
	DIFERENTE("<>", "Diferente"),
	ATRIBUICAO(":=", "Atribuição"),
	DOIS_PONTOS(":", "Dois pontos"),
	PONTO_VIRGULA(";", "Ponto e vírgula"),
	VIRGULA(",", "Vírgula"),
	PONTO(".", "Ponto"),
	ABRE_PARENTESE("(", "Abre parentese"),
	FECHA_PARENTESE(")", "Fecha parentese"),
	IDENTIFICADOR("", "Identificador"),
	INTEIRO("[0-9]", "Inteiro"),
	LITERAL("[a-zA-Z]", "Literal"),
	PROGRAM("PROGRAM", "Program"),
	CONST("CONST", "Const"),
	VAR("VAR", "Var"),
	PROCEDURE("PROCEDURE", "Procedure"),
	BEGIN("BEGIN", "Begin"),
	END("END", "End"),
	INTEGER("INTEGER", "Integer"),
	OF("OF", "Of"),
	CALL("CALL", "Call"),
	IF("IF", "If"),
	THEN("THEN", "Then"),
	ELSE("ELSE", "Else"),
	WHILE("WHILE", "While"),
	DO("DO", "Do"),
	REPEAT("REPEAT", "Repeat"),
	UNTIL("UNTIL", "Until"),
	READLN("READLN", "Readln"),
	WRITELN("WRITELN", "Writeln"),
	OR("OR", "Or"),
	AND("AND", "And"),
	NOT("NOT", "Not"),
	FOR("FOR", "For"),
	TO("TO", "To"),
	CASE("CASE", "Case"),
	COMENTARIO("Comentario", "Comentario"),
	ERROR("Caracter não identificado", "Erro"); 
	
	private String label;
	private String descricao;

	private Simbolo(String label, String descricao) {
		this.label = label;
		this.descricao = descricao;
	}
	
	public String getLabel() {
		return label;
	}

	public String getDescricao() {
		return descricao;
	}
}