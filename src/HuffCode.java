
public class HuffCode {

	private char symbol;
	private String code;
	
	HuffCode(char s, String c){
		symbol = s;
		code = c;
	}
	
	public char getCode() {
		return symbol;
	}
	
	public void printHuffCode(){
		System.out.println(symbol + " :\t" + code);
	}
}
