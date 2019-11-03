import java.io.File;
import java.io.IOException;
import java.util.*;

public class Application {
	public static void main(String args[]) throws IOException   { 
		File myFile = new File("problem1.txt");
		File outFile = new File("unique_words.txt");
		
		DuplicateRemover duplicateRemover = new DuplicateRemover();
		
		try {
			if (outFile.createNewFile()) {
				System.out.println("File created: " + outFile.getName());
			}
		} catch (IOException e) {	
			System.out.println("An error occurred.");
		}
		
    	try {
    		duplicateRemover.remove(myFile);
			duplicateRemover.write(outFile);
    	} catch(IOException e) {
    		System.out.println(e);
    	}
    } 
}
