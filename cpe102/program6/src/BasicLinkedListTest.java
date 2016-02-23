import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * BasicLinkedList class
 * @author Bryan Sugiarto
 * @version program6
 */
public class BasicLinkedListTest
{
 
   public static void testAll()
   {
      testConstructor();
      testAdd();
      testSet();
      testGet();
      testClear();
      testAddIndex();
      testRemove();
      testIndexOf();
      testContains();
      
      testItHasNext();
      testItNext();
      testItRemove();
      testBasicItHasNext();
      testBasicItNext();
      testBasicItRemove();
      testBasicItHasPrev();
      testBasicItPrev();
   }

   public static void testConstructor()
   {
      BasicLinkedList<String> a = new BasicLinkedList<String>();
      SUnit.assertEquals(0,a.size());
   }
   
   public static void testAdd()
   {
      BasicLinkedList<String> a = new BasicLinkedList<String>();
      a.add("D");
      SUnit.assertEquals(1,a.size());
      SUnit.assertEqualsObject("D",a.get(0));
      a.add("asdfs");
      SUnit.assertEquals(2,a.size());
      SUnit.assertEqualsObject("asdfs",a.get(1));
      SUnit.assertEqualsObject("D",a.get(0));
      a.add("done");
      SUnit.assertEquals(3,a.size());
      SUnit.assertEqualsObject("D",a.get(0));
      SUnit.assertEqualsObject("asdfs",a.get(1));
      SUnit.assertEqualsObject("done",a.get(2));
   }
   
   public static void testAddIndex()
   {
      BasicLinkedList<String> a = new BasicLinkedList<String>();
      a.add(0,"did");
      SUnit.assertEquals(1,a.size());
      SUnit.assertEqualsObject("did",a.get(0));
      a.add(0,"I");
      SUnit.assertEquals(2,a.size());
      SUnit.assertEqualsObject("did",a.get(1));
      SUnit.assertEqualsObject("I",a.get(0));
      a.add(2,"it");
      SUnit.assertEquals(3,a.size());
      SUnit.assertEqualsObject("I",a.get(0));
      SUnit.assertEqualsObject("did",a.get(1));
      SUnit.assertEqualsObject("it",a.get(2));
      try{
    	  a.add(4,"error");
    	  SUnit.fail();
      }catch(IndexOutOfBoundsException e){
    	  SUnit.assertTrue(true);
      }
      try{
    	  a.add(-1,"error");
    	  SUnit.fail();
      }catch(IndexOutOfBoundsException e){
    	  SUnit.assertTrue(true);
      }
   }
   
   public static void testClear()
   {
      BasicLinkedList<String> a = new BasicLinkedList<String>();
      a.add(0,"did");
      a.clear();
      SUnit.assertEquals(0,a.size());
      BasicLinkedList<Double> b = new BasicLinkedList<Double>();
      b.add(4.435);
      b.add(4.34);
      b.add(-234.35);
      b.add(423.0);
      b.clear();
      SUnit.assertEquals(0,b.size());
   }
   
   public static void testContains()
   {
      BasicLinkedList<Double> b = new BasicLinkedList<Double>();
      b.add(4.435);
      b.add(4.34);
      b.add(-234.35);
      b.add(423.0);
      SUnit.assertTrue(b.contains(4.435));
      SUnit.assertFalse(b.contains(43.35));
   }
   
   public static void testGet()
   {
      BasicLinkedList<Double> b = new BasicLinkedList<Double>();
      b.add(4.435);
      b.add(4.34);
      b.add(0,-234.35);
      b.add(423.0);
      SUnit.assertEqualsObject(4.34,b.get(2));
      SUnit.assertEqualsObject(423.0,b.get(3));
      SUnit.assertEqualsObject(-234.35,b.get(0));
      try{
    	  b.get(-1);
    	  SUnit.fail();
      }catch(IndexOutOfBoundsException e){
    	  SUnit.assertTrue(true);
      }
      try{
    	  b.get(4);
    	  SUnit.fail();
      }catch(IndexOutOfBoundsException e){
    	  SUnit.assertTrue(true);
      }
   }
   
   public static void testIndexOf()
   {
      BasicLinkedList<Double> b = new BasicLinkedList<Double>();
      b.add(4.435);
      b.add(4.2);
      b.add(0,-234.35);
      b.add(423.0);
      SUnit.assertEquals(2,b.indexOf(4.2));
      try{
    	  b.indexOf(2.3);
    	  SUnit.fail();
      }catch(NoSuchElementException e){
    	  SUnit.assertTrue(true);
      }
   }
   
   public static void testRemove()
   {
      BasicLinkedList<Double> b = new BasicLinkedList<Double>();
      b.add(4.435);
      b.add(4.34);
      b.add(0,-234.35);
      b.add(423.0);
      
      SUnit.assertEqualsObject(423.0,b.remove(3));
      SUnit.assertEquals(3,b.size());
      try{
    	  b.remove(3);
    	  SUnit.fail();
      }catch(IndexOutOfBoundsException e){
    	  SUnit.assertTrue(true);
      }
      try{
    	  b.remove(-1);
    	  SUnit.fail();
      }catch(IndexOutOfBoundsException e){
    	  SUnit.assertTrue(true);
      }
      SUnit.assertEqualsObject(-234.35,b.remove(0));
      SUnit.assertEquals(2,b.size());
      SUnit.assertEqualsObject(4.34,b.remove(1));
      SUnit.assertEquals(1,b.size());
   }
   
   public static void testSet()
   {
      BasicLinkedList<Double> b = new BasicLinkedList<Double>();
      b.add(4.435);
      b.add(4.34);
      b.add(0,-234.35);
      b.add(423.0);
      
      SUnit.assertEqualsObject(423.0,b.set(3,434.3));
      SUnit.assertEquals(4,b.size());
      SUnit.assertEqualsObject(434.3,b.get(3));
      
      SUnit.assertEqualsObject(-234.35,b.set(0,.123));
      SUnit.assertEquals(4,b.size());
      SUnit.assertEqualsObject(.123,b.get(0));
      
      SUnit.assertEqualsObject(4.34,b.set(2,.23));
      SUnit.assertEquals(4,b.size());
      SUnit.assertEqualsObject(.23,b.get(2));
      
      try{
    	  b.set(5,23.2);
    	  SUnit.fail();
      }catch(IndexOutOfBoundsException e){
    	  SUnit.assertTrue(true);
      }
      try{
    	  b.set(-1,4.34);
    	  SUnit.fail();
      }catch(IndexOutOfBoundsException e){
    	  SUnit.assertTrue(true);
      }
   }
   
   public static void testItHasNext(){
	   BasicLinkedList<String> b = new BasicLinkedList<String>();
	   SUnit.assertFalse(b.iterator().hasNext());
	   b.add("Testing");
	   SUnit.assertTrue(b.iterator().hasNext());
	   Iterator<String> t = b.iterator();
	   t.next();
	   SUnit.assertFalse(t.hasNext());
   }
   
   public static void testItNext(){
	   BasicLinkedList<String> b = new BasicLinkedList<String>();
	   try{
		   b.iterator().next();
		   SUnit.fail();
	   }catch(NoSuchElementException e){
		   SUnit.assertTrue(true);
	   }
	   b.add("Testing");
	   b.add("is");
	   b.add("good");
	   Iterator <String> it = b.iterator();
	   SUnit.assertEqualsObject("Testing",it.next());
	   SUnit.assertEqualsObject("is",it.next());
	   SUnit.assertEqualsObject("good",it.next());
	   
   }
   
   public static void testItRemove(){
	   BasicLinkedList<String> b = new BasicLinkedList<String>();
	   b.add("DS");
	   b.add("SD");
	   try{
		   b.iterator().remove();
		   SUnit.fail();
	   }catch(UnsupportedOperationException e){
		   SUnit.assertTrue(true);
	   } 
   }
   
   public static void testBasicItHasNext(){
	   BasicLinkedList<String> b = new BasicLinkedList<String>();
	   SUnit.assertFalse(b.basicListIterator().hasNext());
	   b.add("Testing");
	   SUnit.assertTrue(b.basicListIterator().hasNext());
	   BasicListIterator<String> t = b.basicListIterator();
	   t.next();
	   SUnit.assertFalse(t.hasNext());
   }
   
   public static void testBasicItNext(){
	   BasicLinkedList<String> b = new BasicLinkedList<String>();
	   try{
		   b.iterator().next();
		   SUnit.fail();
	   }catch(NoSuchElementException e){
		   SUnit.assertTrue(true);
	   }
	   b.add("Testing");
	   b.add("is");
	   b.add("good");
	   BasicListIterator<String> t = b.basicListIterator();
	   SUnit.assertEqualsObject("Testing",t.next());
	   SUnit.assertEqualsObject("is",t.next());
	   SUnit.assertEqualsObject("good",t.next());
	   
	   try{
		   t.next();
		   SUnit.fail();
	   }catch(NoSuchElementException e){
		   SUnit.assertTrue(true);
	   }
   }
   
   public static void testBasicItRemove(){
	   BasicLinkedList<String> b = new BasicLinkedList<String>();
	   b.add("DS");
	   b.add("SD");
	   try{
		   b.basicListIterator().remove();
		   SUnit.fail();
	   }catch(UnsupportedOperationException e){
		   SUnit.assertTrue(true);
	   } 
   }
  
   public static void testBasicItHasPrev(){
	   BasicLinkedList<String> b = new BasicLinkedList<String>();
	   SUnit.assertFalse(b.basicListIterator().hasPrevious());
	   b.add("Testing");
	   BasicListIterator<String> t = b.basicListIterator();
	   t.next();
	   SUnit.assertTrue(t.hasPrevious());
	   t.previous();
	   SUnit.assertFalse(t.hasPrevious());
   }
   
   public static void testBasicItPrev(){
	   BasicLinkedList<String> b = new BasicLinkedList<String>();
	   try{
		   b.basicListIterator().previous();
		   SUnit.fail();
	   }catch(NoSuchElementException e){
		   SUnit.assertTrue(true);
	   }
	   b.add("Testing");
	   b.add("is");
	   b.add("good");
	   BasicListIterator<String> t = b.basicListIterator();
	   t.next();t.next();t.next();

	   SUnit.assertEqualsObject("good",t.previous());
	   SUnit.assertEqualsObject("is",t.previous());
	   SUnit.assertEqualsObject("Testing",t.previous());
	   try{
		   b.basicListIterator().previous();
		   SUnit.fail();
	   }catch(NoSuchElementException e){
		   SUnit.assertTrue(true);
	   }
   }
   
   public static void main(String[] args)
   {
      // Run all the tests...
      testAll();

      // Display number of tests run and how many failed...
      System.out.println("SUnit: "
                       + SUnit.testsRun() + " tests run, "
                       + SUnit.testsFailed() + " tests failed");
   }
}