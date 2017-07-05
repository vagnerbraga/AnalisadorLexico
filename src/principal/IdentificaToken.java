package principal;

public class IdentificaToken {

	public Simbolo identifica(String str){
		
		if(str.trim().equals(Simbolo.VAZIO.getLabel()))
			return Simbolo.VAZIO;
		
		if(str.trim().equals(Simbolo.$.getLabel()))
			return Simbolo.$;
		
		if(str.trim().equals(Simbolo.OPERADO_SOMA.getLabel()))
			return Simbolo.OPERADO_SOMA;
		
		if(str.trim().equals(Simbolo.OPERADO_SUBTRACAO.getLabel()))
			return Simbolo.OPERADO_SUBTRACAO;
		
		if(str.trim().equals(Simbolo.OPERADO_MULTIPLICACAO.getLabel()))
			return Simbolo.OPERADO_MULTIPLICACAO;
		 
		if(str.trim().equals(Simbolo.OPERADO_DIVISAO.getLabel()))
			return Simbolo.OPERADO_DIVISAO;
		
		if(str.trim().equals(Simbolo.OPERADO_IGUALDADE.getLabel()))
			return Simbolo.OPERADO_IGUALDADE;
		
		if(str.trim().equals(Simbolo.MAIOR_QUE.getLabel()))
			return Simbolo.MAIOR_QUE;
		
		if(str.trim().equals(Simbolo.MAIOR_IGUAL.getLabel()))
			return Simbolo.MAIOR_IGUAL;
		
		if(str.trim().equals(Simbolo.MENOR_QUE.getLabel()))
			return Simbolo.MENOR_QUE;
		
		if(str.trim().equals(Simbolo.MENOR_IGUAL.getLabel()))
			return Simbolo.MENOR_IGUAL;
		
		if(str.trim().equals(Simbolo.DIFERENTE.getLabel()))
			return Simbolo.DIFERENTE;
		
		if(str.trim().equals(Simbolo.ATRIBUICAO.getLabel()))
			return Simbolo.ATRIBUICAO;
		
		if(str.trim().equals(Simbolo.DOIS_PONTOS.getLabel()))
			return Simbolo.DOIS_PONTOS;
		
		if(str.trim().equals(Simbolo.PONTO_VIRGULA.getLabel()))
			return Simbolo.PONTO_VIRGULA;
		
		if(str.trim().equals(Simbolo.VIRGULA.getLabel()))
			return Simbolo.VIRGULA;
		
		if(str.trim().equals(Simbolo.PONTO.getLabel()))
			return Simbolo.PONTO;
		
		if(str.trim().equals(Simbolo.ABRE_PARENTESE.getLabel()))
			return Simbolo.ABRE_PARENTESE;
		
		if(str.trim().equals(Simbolo.FECHA_PARENTESE.getLabel()))
			return Simbolo.FECHA_PARENTESE;
		
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
			
		
		if(str.trim().equals(Simbolo.LITERAL.getLabel()))
			return Simbolo.LITERAL;
		
		if(str.trim().equals(Simbolo.PROGRAM.getLabel()))
			return Simbolo.PROGRAM;
		
		if(str.trim().equals(Simbolo.CONST.getLabel()))
			return Simbolo.CONST;
		
		if(str.trim().equals(Simbolo.VAR.getLabel()))
			return Simbolo.VAR;
		
		if(str.trim().equals(Simbolo.PROCEDURE.getLabel()))
			return Simbolo.PROCEDURE;
		
		if(str.trim().equals(Simbolo.BEGIN.getLabel()))
			return Simbolo.BEGIN;
		
		if(str.trim().equals(Simbolo.END.getLabel()))
			return Simbolo.END;
		
		if(str.trim().equals(Simbolo.INTEGER.getLabel()))
			return Simbolo.INTEGER;
		
		if(str.trim().equals(Simbolo.OF.getLabel()))
			return Simbolo.OF;
		
		if(str.trim().equals(Simbolo.CALL.getLabel()))
			return Simbolo.CALL;
		
		if(str.trim().equals(Simbolo.IF.getLabel()))
			return Simbolo.IF;
		
		if(str.trim().equals(Simbolo.THEN.getLabel()))
			return Simbolo.THEN;
		
		if(str.trim().equals(Simbolo.ELSE.getLabel()))
			return Simbolo.ELSE;
		
		if(str.trim().equals(Simbolo.WHILE.getLabel()))
			return Simbolo.WHILE;
		
		if(str.trim().equals(Simbolo.DO.getLabel()))
			return Simbolo.DO;
		
		if(str.trim().equals(Simbolo.REPEAT.getLabel()))
			return Simbolo.REPEAT;
		
		if(str.trim().equals(Simbolo.UNTIL.getLabel()))
			return Simbolo.UNTIL;
		
		if(str.trim().equals(Simbolo.READLN.getLabel()))
			return Simbolo.READLN;
		
		if(str.trim().equals(Simbolo.WRITELN.getLabel()))
			return Simbolo.WRITELN;
		
		if(str.trim().equals(Simbolo.OR.getLabel()))
			return Simbolo.OR;
		
		if(str.trim().equals(Simbolo.AND.getLabel()))
			return Simbolo.AND;
		
		if(str.trim().equals(Simbolo.NOT.getLabel()))
			return Simbolo.NOT;
		
		if(str.trim().equals(Simbolo.FOR.getLabel()))
			return Simbolo.FOR;
		
		if(str.trim().equals(Simbolo.TO.getLabel()))
			return Simbolo.TO;
		
		if(str.trim().equals(Simbolo.CASE.getLabel()))
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
