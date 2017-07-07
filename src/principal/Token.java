package principal;

public class Token {

	private String token;
	private Simbolo simbolo;

	public Token(String token, Simbolo simbolo) {
		super();
		this.token = token;
		this.simbolo = simbolo;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Simbolo getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(Simbolo simbolo) {
		this.simbolo = simbolo;
	}
	public String[] toArray(){
		return new String[]{getSimbolo().ordinal() + "", getToken(), getSimbolo().getDescricao()};
	}
}
