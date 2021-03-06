/**
  *BasicArrayListTest
  *@author Bryan Sugiarto
  *@version Program2a
  */
public class BasicArrayListTest {
	
	 public static void testAll(){
		 testConstructor1();
		 testConstructor1();
		 testAddIndex();
		 testAdd();
		 testCapacity();
		 testClear();
		 testContains();
		 testGet();
		 testIndexOf();
		 testRemove();
		 testSet();
		 testTrimToSize();
	 }
	 
	 //1.BasicArrayList(): 1 test (2 calls to SUnit methods, 
	 //one to verify the size of the list and one to verify the capacity of the list).
	 public static void testConstructor1(){
		 BasicArrayList list = new BasicArrayList();
		 SUnit.assertEquals(list.size(), 0);
		 SUnit.assertEquals(list.capacity(), BasicArrayList.DEFAULT_CAPACITY);
	 }
	 
	 //2.BasicArrayList(int capacity): 3 tests (6 calls to SUnit methods 
	 //- see details in default constructor).
	 public static void testConstructor2(){
		 BasicArrayList list = new BasicArrayList(425);
		 SUnit.assertEquals(list.size(), 0);
		 SUnit.assertEquals(list.capacity(),425);
		 
		 BasicArrayList list2 = new BasicArrayList(43);
		 SUnit.assertEquals(list2.size(), 0);
		 SUnit.assertEquals(list2.capacity(), 43);
		 
		 BasicArrayList list3 = new BasicArrayList(65);
		 SUnit.assertEquals(list3.size(), 0);
		 SUnit.assertEquals(list3.capacity(), 65);
		 
	 }
	 
	 //3.add(int index, Object o): 5 tests (8 calls to SUnit,
     //2 for exceptions, 6 for successful adds (get and size) at 3 well thoughtout locations).
	 public static void testAddIndex(){
		 BasicArrayList list = new BasicArrayList();
		 for(int i = 0; i <10; i++)
			 list.add(i);
		 
		 
		 
		 list.add(4,4);
		 SUnit.assertEquals(list.size(), 11);
		 SUnit.assertEqualsObject(list.get(4),4);
		
		 list.add(0,"df");
		 SUnit.assertEquals(list.size(), 12);
		 SUnit.assertEqualsObject(list.get(0),"df");
		 
		 list.add(9,true);
		 SUnit.assertEquals(list.size(), 13);
		 SUnit.assertEqualsObject(list.get(9),true);
		 
		 
		 
		 try{
			 list.add(14,10);
			 test(false, "Did not throw out of bounds exception");
	     }catch(Exception e){}
		 
		 try{
			 list.add(-1,10);
			 test(false, "Did not throw out of bounds exception");
	     }catch(Exception e){}
		 
	 }

	 //4.add(Object o): 3 tests (6 calls to SUnit,
     //get and size after each add).
	 public static void testAdd(){
		 BasicArrayList list = new BasicArrayList();
		 
	     list.add(0);
		 SUnit.assertEquals(list.size(), 1);
		 SUnit.assertEqualsObject(list.get(0),0);
		 
		 list.add(4);
		 SUnit.assertEquals(list.size(), 2);
		 SUnit.assertEqualsObject(list.get(1),4);
		 
		 list.add("df");
		 SUnit.assertEquals(list.size(), 3);
		 SUnit.assertEqualsObject(list.get(2),"df");
		 
		 
		 list.add(true);
		 SUnit.assertEquals(list.size(), 4);
		 SUnit.assertEqualsObject(list.get(3),true);
	 }

	 //5.capacity(): 2 tests (4 calls to SUnit, the capacity 
	 //just before and just after at least two growth points).
	 public static void testCapacity(){
		 BasicArrayList list = new BasicArrayList();
		 for(int i = 0; i <10; i++)
			 list.add(i);
		 SUnit.assertEquals(list.size(), 10);
		 SUnit.assertEquals(list.capacity(), 10);
		 list.add(1);
		 SUnit.assertEquals(list.size(), 11);
		 SUnit.assertEquals(list.capacity(), 20);
		 for(int i = 0; i <9; i++)
			 list.add(i);
		 SUnit.assertEquals(list.size(), 20);
		 SUnit.assertEquals(list.capacity(), 20);
		 list.add(1);
		 SUnit.assertEquals(list.size(), 21);
		 SUnit.assertEquals(list.capacity(), 40);
	 }

	 //6.clear(): 2 tests (4 calls to SUnit, 
	 //the size and capacity in two different scenarios).
	 public static void testClear(){
		 BasicArrayList list = new BasicArrayList();
		 for(int i = 0; i <10; i++)
			 list.add(i);
		 SUnit.assertEquals(list.size(), 10);
		 SUnit.assertEquals(list.capacity(), 10);
		 list.clear();
		 SUnit.assertEquals(list.size(), 0);
		 SUnit.assertEquals(list.capacity(), 10);
	 }

	 //7.contains(Object o): 2 tests (2 calls to SUnit,
     //a true and a false case).
	 public static void testContains(){
		 BasicArrayList list = new BasicArrayList();
		 for(int i = 0; i <10; i++)
			 list.add(i);
		 SUnit.assertTrue(list.contains(3));
		 SUnit.assertFalse(list.contains(-2));
	 }

	 //8.get(int index): 3 tests (5 calls to SUnit, 
     //2 for exceptions, 3 for successful gets).
	 public static void testGet(){
		 BasicArrayList list = new BasicArrayList();
		 for(int i = 0; i <10; i++)
			 list.add(i);
		 list.add("342");
		 SUnit.assertEqualsObject(list.get(0),0);
		 SUnit.assertEqualsObject(list.get(5),5);
		 SUnit.assertEqualsObject(list.get(10),"342");
		 
		 try{
			 list.get(77);
			 test(false, "Did not throw out of bounds exception");
	     }catch(Exception e){}
		 
		 try{
			 list.get(-1);
			 test(false, "Did not throw out of bounds exception");
	     }catch(Exception e){}
	 }
	 //9.indexOf(Object o): 2 tests (2 calls to SUnit, 
	 //1 for an exception, 1 for a successful find).
	 public static void testIndexOf(){
		 BasicArrayList list = new BasicArrayList();
		 for(int i = 0; i <10; i++)
			 list.add(i);
		 SUnit.assertEquals(list.indexOf(4), 4);
		 try{
			 list.indexOf(10);
			 test(false, "Did not throw out of bounds exception");
	     }catch(Exception e){}
		 
	 }

	 //10.remove(int index): 5 tests (8 calls to SUnit, 2 for exceptions, 
	 //		 6 for successful removes (get and size) at 3 well thoughtout locations).
	 public static void testRemove(){
		 BasicArrayList list = new BasicArrayList();
		 for(int i = 0; i <10; i++){
			 list.add(i);
		 }
		 SUnit.assertEqualsObject(list.remove(0),0);
		 SUnit.assertEquals(list.size(), 9);
		 SUnit.assertEqualsObject(list.remove(5),6);
		 SUnit.assertEquals(list.size(), 8);
		 SUnit.assertEqualsObject(list.remove(7),9);
		 SUnit.assertEquals(list.size(), 7);
		 
		 try{
			 list.remove(10);
			 test(false, "Did not throw out of bounds exception");
	     }catch(Exception e){}
		 
		 try{
			 list.remove(-1);
			 test(false, "Did not throw out of bounds exception");
	     }catch(Exception e){}
	 }
	 
	 //11.set(int index): 3 tests (8 calls to SUnit, 2 for exceptions, 
	 //6 for successful sets (get and size) at 3 well thoughtout locations).
	 public static void testSet(){
		 BasicArrayList list = new BasicArrayList();
		 for(int i = 0; i <10; i++)
			 list.add(i);
		 list.set(0,43);
		 SUnit.assertEqualsObject(list.get(0),43);
		 SUnit.assertEquals(list.size(), 10);
		 list.set(5,433);
		 SUnit.assertEqualsObject(list.get(5),433);
		 SUnit.assertEquals(list.size(), 10);
		 list.set(9,1.2);
		 SUnit.assertEqualsObject(list.get(9),1.2);
		 SUnit.assertEquals(list.size(), 10);
		 
		 try{
			 list.set(10,32);
			 test(false, "Did not throw out of bounds exception");
	     }catch(Exception e){}
		 
		 try{
			 list.set(-1,32);
			 test(false, "Did not throw out of bounds exception");
	     }catch(Exception e){}
		 
	 }

	 
	 //(4 calls to SUnit, size and capacity in two different scenarios).
	 public static void testTrimToSize(){
		 BasicArrayList list = new BasicArrayList();
		 list.add("D");
		 list.add("asdf");
		 list.add("sdf");
		 list.trimToSize();	
		 SUnit.assertEquals(list.size(), 3);
		 SUnit.assertEquals(list.capacity(), 3);
		 
		 BasicArrayList list2 = new BasicArrayList();
		 list2.add("D");
		 list2.add(3);
		 list2.add("sdf");
		 list2.add(true);
		 list2.add(4.45);
		 list2.add("sdf");
		 list2.trimToSize();	
		 SUnit.assertEquals(list2.size(), 6);
		 SUnit.assertEquals(list2.capacity(), 6);
	 }
	 
	 private static boolean test(boolean pass, String msg)
	 {
	      if(!pass)
	      {
	         (new Throwable(msg)).printStackTrace();
	      }
	      return pass;
	 }


	public static void main(String[] args) {
		testAll();
		System.out.println("SUnit: "
                + SUnit.testsRun() + " tests run, "
                + SUnit.testsFailed() + " tests failed");

	}

}
