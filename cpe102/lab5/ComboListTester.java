/**
  * BasicList
  * @author Bryan Sugiarto
  * @version lab4
  */


import java.util.*;

public class ComboListTester {

	public static void main(String[] args) {
		ComboList combo = new ComboList();
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.print("Enter an input >>> ");
			if(scan.hasNextInt()){
	            combo.add(scan.nextInt());
	        }else if(scan.hasNextDouble()){
	            combo.add(scan.nextDouble());
	        }else if(scan.hasNextBoolean()){
	        	combo.add(scan.nextBoolean());
	        }else{
	        	String i = scan.nextLine();
	            if(i.equals("quit"))
	            	break;
	            else
	            	combo.add(i);
	        }
		}
		System.out.println("\nmin integer  = "+ combo.minimumInt());
		System.out.println("avg double   = "+ combo.averageDouble());
		System.out.println("num of trues = "+ combo.numberOfTrues());
		System.out.println("num strings  = "+ combo.numberOfStrings());
	}

}
