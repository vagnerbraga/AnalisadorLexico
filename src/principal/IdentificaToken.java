package principal;

public class IdentificaToken {

	public Simbolo identifica(String str){
		
		if(str.trim().equalsIgnoreCase(Simbolo.VAZIO.getLabel()))
			return Simbolo.VAZIO;
		
		if(str.trim().equalsIgnoreCase(Simbolo.$.getLabel()))
			return Simbolo.$;
		
		if(str.trim().equalsIgnoreCase(Simbolo.OPERADO_SOMA.getLabel()))
			return Simbolo.OPERADO_SOMA;
		
		if(str.trim().equalsIgnoreCase(Simbolo.OPERADO_SUBTRACAO.getLabel()))
			return Simbolo.OPERADO_SUBTRACAO;
		
		if(str.trim().equalsIgnoreCase(Simbolo.OPERADO_MULTIPLICACAO.getLabel()))
			return Simbolo.OPERADO_MULTIPLICACAO;
		 
		if(str.trim().equalsIgnoreCase(Simbolo.OPERADO_DIVISAO.getLabel()))
			return Simbolo.OPERADO_DIVISAO;
		
		if(str.trim().equalsIgnoreCase(Simbolo.OPERADO_IGUALDADE.getLabel()))
			return Simbolo.OPERADO_IGUALDADE;
		
		if(str.trim().equalsIgnoreCase(Simbolo.MAIOR_QUE.getLabel()))
			return Simbolo.MAIOR_QUE;
		
		if(str.trim().equalsIgnoreCase(Simbolo.MAIOR_IGUAL.getLabel()))
			return Simbolo.MAIOR_IGUAL;
		
		if(str.trim().equalsIgnoreCase(Simbolo.MENOR_QUE.getLabel()))
			return Simbolo.MENOR_QUE;
		
		if(str.trim().equalsIgnoreCase(Simbolo.MENOR_IGUAL.getLabel()))
			return Simbolo.MENOR_IGUAL;
		
		if(str.trim().equalsIgnoreCase(Simbolo.DIFERENTE.getLabel()))
			return Simbolo.DIFERENTE;
		
		if(str.trim().equalsIgnoreCase(Simbolo.ATRIBUICAO.getLabel()))
			return Simbolo.ATRIBUICAO;
		
		if(str.trim().equalsIgnoreCase(Simbolo.DOIS_PONTOS.getLabel()))
			return Simbolo.DOIS_PONTOS;
		
		if(str.trim().equalsIgnoreCase(Simbolo.PONTO_VIRGULA.getLabel()))
			return Simbolo.PONTO_VIRGULA;
		
		if(str.trim().equalsIgnoreCase(Simbolo.VIRGULA.getLabel()))
			return Simbolo.VIRGULA;
		
		if(str.trim().equalsIgnoreCase(Simbolo.PONTO.getLabel()))
			return Simbolo.PONTO;
		
		if(str.trim().equalsIgnoreCase(Simbolo.ABRE_PARENTESE.getLabel()))
			return Simbolo.ABRE_PARENTESE;
		
		if(str.trim().equalsIgnoreCase(Simbolo.FECHA_PARENTESE.getLabel()))
			return Simbolo.FECHA_PARENTESE;
		
		if(str.matches("^[(*].*.[*)]$"))
			return Simbolo.COMENTARIO;
		
		
		//trata o valor inteiro
		if(str.matches("\\d{1,5}")){
			if (Math.abs(Integer.parseInt(str)) <= 32767)
				return Simbolo.INTEIRO;
			
			return Simbolo.ERROR;
		}
		
		if(str.matches("^\".*\"$")){
			if(str.length() < 256)
				return Simbolo.LITERAL;
			return Simbolo.ERROR;
		}
			
		
		if(str.trim().equalsIgnoreCase(Simbolo.LITERAL.getLabel()))
			return Simbolo.LITERAL;
		
		if(str.trim().equalsIgnoreCase(Simbolo.PROGRAM.getLabel()))
			return Simbolo.PROGRAM;
		
		if(str.trim().equalsIgnoreCase(Simbolo.CONST.getLabel()))
			return Simbolo.CONST;
		
		if(str.trim().equalsIgnoreCase(Simbolo.VAR.getLabel()))
			return Simbolo.VAR;
		
		if(str.trim().equalsIgnoreCase(Simbolo.PROCEDURE.getLabel()))
			return Simbolo.PROCEDURE;
		
		if(str.trim().equalsIgnoreCase(Simbolo.BEGIN.getLabel()))
			return Simbolo.BEGIN;
		
		if(str.trim().equalsIgnoreCase(Simbolo.END.getLabel()))
			return Simbolo.END;
		
		if(str.trim().equalsIgnoreCase(Simbolo.INTEGER.getLabel()))
			return Simbolo.INTEGER;
		
		if(str.trim().equalsIgnoreCase(Simbolo.OF.getLabel()))
			return Simbolo.OF;
		
		if(str.trim().equalsIgnoreCase(Simbolo.CALL.getLabel()))
			return Simbolo.CALL;
		
		if(str.trim().equalsIgnoreCase(Simbolo.IF.getLabel()))
			return Simbolo.IF;
		
		if(str.trim().equalsIgnoreCase(Simbolo.THEN.getLabel()))
			return Simbolo.THEN;
		
		if(str.trim().equalsIgnoreCase(Simbolo.ELSE.getLabel()))
			return Simbolo.ELSE;
		
		if(str.trim().equalsIgnoreCase(Simbolo.WHILE.getLabel()))
			return Simbolo.WHILE;
		
		if(str.trim().equalsIgnoreCase(Simbolo.DO.getLabel()))
			return Simbolo.DO;
		
		if(str.trim().equalsIgnoreCase(Simbolo.REPEAT.getLabel()))
			return Simbolo.REPEAT;
		
		if(str.trim().equalsIgnoreCase(Simbolo.UNTIL.getLabel()))
			return Simbolo.UNTIL;
		
		if(str.trim().equalsIgnoreCase(Simbolo.READLN.getLabel()))
			return Simbolo.READLN;
		
		if(str.trim().equalsIgnoreCase(Simbolo.WRITELN.getLabel()))
			return Simbolo.WRITELN;
		
		if(str.trim().equalsIgnoreCase(Simbolo.OR.getLabel()))
			return Simbolo.OR;
		
		if(str.trim().equalsIgnoreCase(Simbolo.AND.getLabel()))
			return Simbolo.AND;
		
		if(str.trim().equalsIgnoreCase(Simbolo.NOT.getLabel()))
			return Simbolo.NOT;
		
		if(str.trim().equalsIgnoreCase(Simbolo.FOR.getLabel()))
			return Simbolo.FOR;
		
		if(str.trim().equalsIgnoreCase(Simbolo.TO.getLabel()))
			return Simbolo.TO;
		
		if(str.trim().equalsIgnoreCase(Simbolo.CASE.getLabel()))
			return Simbolo.CASE;

		//[\\w]{1,30} = começa com letra e permite no min 1 e max 30
		//[^\\s] = não pode conter caracter em branco
		//[\\d]* = verifica se tem a existencia de 0 ou mais caracters 
		if(str.matches("^[a-zA-Z][^\\s][^\"]$|^[a-zA-Z]+[\\d]*[^\\s][^\"]$")){
			if(str.length()<30)
				return Simbolo.IDENTIFICADOR;
			else
				return Simbolo.ERROR;
		}
		
		return Simbolo.ERROR;
		
		
	}
	
}
