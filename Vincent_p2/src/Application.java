import java.io.File;
import java.io.IOException;
import java.util.*;

public class Application {
	public static void main(String args[]) throws IOException   { 
		File myFile = new File("problem2.txt");
		File outFile = new File("unique_words_count.txt");
		
		DuplicateCounter duplicateCounter = new DuplicateCounter();
		
		try {
			if (outFile.createNewFile()) {
				System.out.println("File created: " + outFile.getName());
			}
		} catch (IOException e) {	
			System.out.println("An error occurred.");
		}
		
    	try {
    		duplicateCounter.count(myFile);
    		duplicateCounter.write(outFile);
    	} catch(IOException e) {
    		System.out.println(e);
    	}
    } 
}
