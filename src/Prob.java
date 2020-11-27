
public class Prob {
	private char s;
	private double p;
	
	Prob(char symbol, double prob){
		s = symbol;
		p = prob;
	}
	
	public char getSym() {
		return s;
	}
	
	public double getProb() {
		return p;
	}
}
