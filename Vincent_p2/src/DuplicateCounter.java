import java.io.File;
import java.util.*;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class DuplicateCounter {
	
	HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();
	
	public void count (File dataFile) throws IOException  {
		
		FileInputStream fileIn = new FileInputStream(dataFile);
		Scanner inFS = new Scanner(fileIn);
		String currWord = null;
		
		while(inFS.hasNext()) {
			currWord = inFS.next().toLowerCase();
			if (!wordCounter.containsKey(currWord)) {
				wordCounter.put(currWord, 1);
			} else {
				wordCounter.put(currWord, wordCounter.get(currWord) + 1);
			}
		}
		
		inFS.close();
		fileIn.close();
	}
	
	public void write (File outputFile) throws IOException  {

		FileOutputStream fileOut = new FileOutputStream(outputFile);
		PrintWriter outFS = new PrintWriter(fileOut); 
		
		for(String key : wordCounter.keySet()) {
			outFS.println(key + " " + wordCounter.get(key));
		}
		
		outFS.close();
		fileOut.close();
	}
}
