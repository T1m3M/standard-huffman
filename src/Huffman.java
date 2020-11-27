import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

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
		System.out.println("\nSymbols' Probabilities: ");
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
	}
	
	// Customizing a comparing of nodes for easier use
	class CompareNodes implements Comparator<TreeNode> { 
		public int compare(TreeNode x, TreeNode y) {
			
			// because comparator's return must be an integer
			if(x.data - y.data > 0)
				return 1;
			
			return -1;
		} 
	} 
	
	public void compress() {
		
		calcProb(); // calculate the probabilities
		printAllProbs(); // print the probabilities
		
		// make a priority queue of TreeNode's type objects
		PriorityQueue<TreeNode> tree = new PriorityQueue<TreeNode>(allProbs.size(), new CompareNodes());
		
		// adding nodes to the tree
		for (int i = 0; i < allProbs.size(); i++) {
			TreeNode node = new TreeNode(); 
  
			node.c = allProbs.get(i).getSym(); // adding node symbol
			node.data = allProbs.get(i).getProb(); // adding symbol's probability
  
			node.left = null; // child nodes
			node.right = null; 
 
			tree.add(node); // append to the tree
		} 
		
	}
}
