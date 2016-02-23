

/*
 * Dictionary Exception class
 * @author Bryan Sugiarto
 * @version program5
 */
public class DictionaryException extends Exception {

	public DictionaryException(){
		super("Dictionary Exception");
		printStackTrace();
	}
	public DictionaryException(String msg){
		super(msg);
		printStackTrace();
	}

}
