import java.io.File;
import java.util.*;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class DuplicateRemover { 
	
	Set<String> uniqueWords = new HashSet<String>();

	public void remove (File dataFile) throws IOException {
		
		FileInputStream fileIn = new FileInputStream(dataFile);
		Scanner inFS = new Scanner(fileIn);
		String currWord = null;
		
		while(inFS.hasNext()) {
			currWord = inFS.next().toLowerCase();
			if (!uniqueWords.contains(currWord)) {
				uniqueWords.add(currWord);
			}
		}
		
		inFS.close();
		fileIn.close();
	}

	public void write (File outputFile) throws IOException {
		
		FileOutputStream fileOut = new FileOutputStream(outputFile);
		PrintWriter outFS = new PrintWriter(fileOut); 
		
		for(String s : uniqueWords) {
			outFS.print(s + " ");
		}
		
		outFS.close();
		fileOut.close();
	}
	
} 