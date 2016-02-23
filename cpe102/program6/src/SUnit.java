/**
  *SUnit
  *@author Bryan Sugiarto
  *@version Program1a
  */
  
  
public class SUnit
{
   private static int testCount =0;
   private static int fails =0;

   public static int testsRun(){
      return testCount;
   }
   
   public static int testsFailed(){
      return fails;
   }
   
   public static void assertTrue(boolean actual){
      testCount++;
      if(!actual){
         fails++;
         Throwable throwable = 
         new Throwable("Error: Expected true, found false");
         throwable.printStackTrace();
      }
   }
   
   public static void assertFalse(boolean actual){
      testCount++;
      if(actual){
         fails++;
         Throwable throwable = 
         new Throwable("Error: Expected false, found true");
         throwable.printStackTrace();
      }
   }
   
   public static void assertEquals(long expect,
                long actual)
   {
      testCount++;
      if(expect!=actual){
         fails++;
         Throwable throwable = 
         new Throwable("Error: Expected "+expect+", found "+actual);
         throwable.printStackTrace();
      }
   }
   
   public static void assertEquals(double expect,
                double actual,
                double epsilon)
   {
      testCount++;
      if(Math.abs(expect-actual)>epsilon){
         fails++;
         Throwable throwable = 
         new Throwable("Error: Expected "+expect+" +/-"+epsilon+
                       ", found "+actual);
         throwable.printStackTrace();
      }
   }
   
   public static void assertEqualsObject(java.lang.Object expect,
                      java.lang.Object actual)
   {
      testCount++;
      if(!expect.equals(actual)){
         fails++;
         Throwable throwable = 
         new Throwable("Error: Expected object equality, found inequality");
         throwable.printStackTrace();
      }
   }         
   
   public static void assertEqualsReference(java.lang.Object expect,
                                            java.lang.Object actual)
   {
      testCount++;
      if(expect!=actual){
         fails++;
         Throwable throwable = 
         new Throwable("Error: Expected reference equality, found inequality");
         throwable.printStackTrace();
      }
   
   }          
   
   public static void assertNull(java.lang.Object actual){
      testCount++;
      if(actual!=null){
         fails++;
         Throwable throwable = 
         new Throwable("Error: Expected null, found non-null");
         throwable.printStackTrace();
      }
   }
   
   public static void assertNotNull(java.lang.Object actual){
      testCount++;
      if(actual==null){
         fails++;
         Throwable throwable = 
         new Throwable("Error: Expected non-null, found null");
         throwable.printStackTrace();
      }
   }
   
   public static void fail(){
      testCount++; 
	   Throwable throwable = 
         new Throwable("Error: Explicit failure");
      throwable.printStackTrace();
      fails++;
   } 
   
}