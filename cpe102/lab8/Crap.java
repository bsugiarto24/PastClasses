/*
 *Lab8 Crap Class
 *@author Bryan
 *@version lab8
 */
 
 public class Crap{
 
 
 public void nullException(){
    String s = null;
    System.out.println(s.charAt(0));
 }
 
 public void classCastException(){
    Object c = new Object();
    String x =(String)c;
 }
 
 public void outOfBounds(){
    int arr[] = {4,3,2};
    System.out.println(arr[4]);
 }
 
 public void run(int i) throws CheckedException{
   if(i==1)
      nullException();
   else if(i==2)
      classCastException();
   else if(i==3)
	      outOfBounds(); 
   else if(i==4)
	      throwChecked(); 
   else if(i==5)
	      outOfBounds(); 
 }
 
 public void throwChecked() throws CheckedException{
	 throw new CheckedException();
 }
 
 public void throwUnchecked(){
	 throw new UncheckedException();
 }
 
 }