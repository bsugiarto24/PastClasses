/**
  * BasicList
  * @author Bryan Sugiarto
  * @version lab4
  */


import java.util.*;

public class ComboList {

	private ArrayList<Object> list;

	public ComboList(){
		list = new ArrayList<Object>();
	}
	public void add(String s){
		list.add(s);
	}
	public void add(int s){
		list.add(s);
	}
	public void add(boolean b){
		list.add(b);
	}
	public void add(double d){
		list.add(d);
	}
	public int minimumInt(){
		if(list.isEmpty())
			return 0;
		else{
			int low = Integer.MAX_VALUE;
			for(Object i:list){
				if(i instanceof Integer &&(int)i<low)
					low= (int)i;
			}
			if(low==Integer.MAX_VALUE)
				return 0;
			return low;
		}
	}
	public double averageDouble(){
		if(list.isEmpty())
			return 0;
		else{
			double sum =0;
			int count = 0;
			for(Object i:list){
				if(i instanceof Double){
					sum+=(double)i;
					count++;
				}
			}
			if(count==0)
				return 0;
			return sum/count;
		}
	}
	public int numberOfTrues(){
		int num =0;
		for(Object i:list){
			if(i instanceof Boolean && (boolean)i)
				num++;
		}
		return num;
	}
	public int numberOfStrings(){
		int num =0;
		for(Object i:list){
			if(i instanceof String )
				num++;
		}
		return num;
	}
}
