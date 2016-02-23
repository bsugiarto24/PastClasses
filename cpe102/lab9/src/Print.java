import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JFileChooser;

/*
 * Print class
 * @author Bryan Sugiarto
 * @version lab9
 */

public class Print{
	
	public static void main(String[] args) {
		JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(null);
        File f = jfc.getSelectedFile();
		//File f = new File("out.txt");
		PrintStream writer = null;
		Scanner scan = null;
		try { 
			writer = new PrintStream(f);
			scan = new Scanner(f);
			writer.write(("My candle burns at both ends;\n").getBytes());
			writer.write(("It will not last the night;\n").getBytes());
			writer.write(("But ah, my foes, and oh, my friends -\n").getBytes());
			writer.write(("It gives a lovely light.").getBytes());
			while(scan.hasNextLine())
				System.out.println(scan.nextLine());
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}catch (IOException e) {
			System.out.println("IO Exception");
		}finally{
			try{
				writer.close();
			}catch(Exception e){
				System.out.println("Could not close");
			}
		}
		
		
		

	}

}
