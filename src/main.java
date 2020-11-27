
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		int input;
		Scanner _sc;
		String data;
		Huffman huff;
		
		System.out.println("Welcome to Standard Huffman World!");
		
		System.out.print("\nOriginal Data  : ");
		_sc = new Scanner(System.in);
		data = _sc.nextLine();
		
		// Example: abaacaadaa
		huff = new Huffman(data);
		huff.compress();
		
	}
}
