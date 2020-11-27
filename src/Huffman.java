import java.util.ArrayList;

public class Huffman {
	private static String data;
	private static String unique = "";
	private static Prob prob;
	private static ArrayList<Prob> allProbs = new ArrayList<Prob>();
	
	Huffman(String d){
		data = d;
	}
	
	private void onlyUnique() {
		
	    // only get the unique characters from the data
	    for (int i = 0; i < data.length(); i++){
	        if ( !unique.contains(String.valueOf(data.charAt(i))) ){
	        	unique += data.charAt(i);
	        }
	    }
	}
	
	private void printAllProbs() {
		for(int i=0; i < allProbs.size(); i++) {
			System.out.println( allProbs.get(i).getSym() + " = "
					+ String.valueOf(allProbs.get(i).getProb()) );
		}
	}
	
	private void calcProb() {
		
		char symbol;
		double probability;
		
		onlyUnique(); // extract only unique symbols

		// calculate the probability of each symbol and store in allProbs
		for(int i=0; i < unique.length(); i++) {
			
			probability = 0; // reset
			
			for(int j=0; j < data.length(); j++) {
				
				if(data.charAt(j) == unique.charAt(i))
					probability += 1;
			}
			
			probability /= data.length();
			prob = new Prob(unique.charAt(i), probability);
			allProbs.add(prob);
		}
		
		printAllProbs();
	}
	
	public void compress() {
		calcProb();
		
	}
}
