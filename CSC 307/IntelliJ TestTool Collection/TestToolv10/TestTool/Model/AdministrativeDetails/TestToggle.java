package TestTool.Model.AdministrativeDetails;
/**
 * This Class reprsents the test toggles to turn on and off a test
 * @author bsugiarto
 *
 */
public abstract class TestToggle {
	boolean TestOnOFF;

	/**
	 * This function turns the test on
	 */
	public abstract void turnTestOn();
	
	/**
	 * This function turns the test off
	 */
	public abstract void turnTestOFF();
}