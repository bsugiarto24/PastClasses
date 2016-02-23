import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;


public class WordSort {

	
	public static void main(String[] args) {
        File f = new File("randomWords.txt");
		Scanner scan = null;
		ArrayList <String> a = new ArrayList<String>();
		try { 
			scan = new Scanner(f);
			while(scan.hasNext()){
				a.add(scan.next());
			}
			SelectionSorter sel = new SelectionSorter( a);
			sel.sort();
			BinarySearcher b = new BinarySearcher(a);
			for(String s:a)
				System.out.println(s);
			System.out.println(b.search("MOTHERLY"));
			System.out.println(a.indexOf("MOTHERLY"));
			
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}catch (IOException e) {
			System.out.println("IO Exception");
		}finally{
			try{
				scan.close();
			}catch(Exception e){
				System.out.println("Could not close");
			}
		}
		

	}

}
