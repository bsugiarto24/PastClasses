/**
  * BasicList
  * @author Bryan Sugiarto
  * @version lab4
  */


import java.util.*;

public class ComboList {

	private ArrayList<String> string;
	private ArrayList<Integer> integer;
	private ArrayList<Boolean> bool;
	private ArrayList<Double> dble;
	
	public ComboList(){
		string = new ArrayList<String>();
		integer = new ArrayList<Integer>();
		bool = new ArrayList<Boolean>();
		dble = new ArrayList<Double>();
	}
	
	public void add(String s){
		string.add(s);
	}
	public void add(int s){
		integer.add(s);
	}
	public void add(boolean b){
		bool.add(b);
	}
	public void add(double d){
		dble.add(d);
	}
	public int minimumInt(){
		if(integer.isEmpty())
			return 0;
		else{
			int low = integer.get(0);
			for(Integer i:integer){
				if(i<low)
					low=i;
			}
			return low;
		}
	}
	
	public double averageDouble(){
		if(dble.isEmpty())
			return 0;
		else{
			double sum =0;
			for(Double i:dble){
				sum+=i;
			}
			return sum/dble.size();
		}
	}
	
	public int numberOfTrues(){
		int num =0;
		for(Boolean i:bool){
			if(i)
				num++;
		}
		return num;
	}
	
	public int numberOfStrings(){
		return string.size();
	}
	
}
