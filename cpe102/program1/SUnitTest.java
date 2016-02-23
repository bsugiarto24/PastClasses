
/**
  *SUnit Test class
  *@author Bryan Sugiarto
  *@version Program1a
  */

public class SUnitTest {

	public static void main(String[] args) {
		SUnit.assertEquals(1, 1);
		SUnit.assertEquals(2.3, 2.3, .01);
		SUnit.assertFalse(false);
		SUnit.assertTrue(true);
		SUnit.assertNull(null);
		SUnit.assertNotNull(" ");
		SUnit.assertEqualsObject("sup", "sup");
		SUnit.assertEquals(0, SUnit.testsFailed());
		SUnit.assertEquals(9, SUnit.testsRun());
		
	}

}
