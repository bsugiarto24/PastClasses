import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*
 * Dictionary class
 * @author Bryan Sugiarto
 * @version program5
 */
public class Dictionary implements Iterable<String> {

	private ArrayList<String> arr = new ArrayList<String>();
	
	public Dictionary(java.lang.String fileName, boolean sort)throws DictionaryException{
		File f = new File(fileName);
		Scanner scan = null;
		try{ 
			scan = new Scanner(f);
			while(scan.hasNext()){
				arr.add(scan.next());
			}
			if(sort)
				sort(arr);
		}catch (FileNotFoundException e) {
			throw new DictionaryException();
		}finally{
			try{
				scan.close();
			}catch(Exception e){
				System.out.println("Could not close");
			}
		}
	}
	
	public Iterator<String> iterator(){
		return arr.iterator();
	}
	
	public boolean lookUp(java.lang.String word){
         int lo = 0;
         int hi = arr.size() - 1;
         while (lo <= hi){
        	 int mid = (lo + hi) / 2;
             if (word.compareTo(arr.get(mid))<0){
                 hi = mid - 1;
             }else if (word.compareTo(arr.get(mid))>0){
                 lo = mid + 1;
             }else{
                 return true;
             }
         }
         return false;
     }
	
	public void write(String fileName)throws DictionaryException{
		File f = new File(fileName);
		PrintStream writer = null;
		try{ 
			writer = new PrintStream(f);
			for(String s: arr){
				writer.write((s+"\n").getBytes());
			}
		}catch (FileNotFoundException e) {
			throw new DictionaryException();
		}catch (IOException e) {
			throw new DictionaryException();
		}finally{
			try{
				writer.close();
			}catch(Exception e){
				System.out.println("Could not close");
			}
		}
	}
	
	private void sort(ArrayList<String> arr){
        for (int i = 0; i < arr.size() - 1; i++){
           int minPos = minimumPosition(i,arr);
           swap(minPos, i,arr);
        }
     }

     private int minimumPosition(int from,ArrayList<String> arr){
    	 int minPos = from;
    	 for (int i = from + 1; i < arr.size(); i++){
    		 if (arr.get(i).compareTo( arr.get(minPos))<0){
    			 minPos = i;
    		 }
    	 }
        return minPos;
     }

     private void swap(int i, int j,ArrayList<String> arr){
        String temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
     }
}
