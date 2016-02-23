package TestTool.Model.QuestionBank;

/**
* Stores all the sorting information for the questions in questionBank
* so that the most relevant questions are on top.
*/

public abstract class bankOptions{
	int difficulty;
	String subject;
	String course;
	String questionType;
	String questionLength;

	/**
	* Sets the difficulty to specified value
	*/
	public abstract void setDiff(int a);

	/**
	* Sets the subject to specified value
	*/
	public abstract void setSubj(String a);

	/**
	* Sets the course to specified value
	*/
	public abstract void setCourse(String a);

	/**
	* Sets the question type to specified value
	*/
	public abstract void setQuesType(String a);

	/**
	* Sets the question length to specified value
	*/
	public abstract void setQuesLength(String a);

	/**
	* Gets the difficulty to specified value
	*/
	public abstract void getDiff(int a);

	/**
	* Gets the subject to specified value
	*/
	public abstract void getSubj(String a);

	/**
	* Gets the course to specified value
	*/
	public abstract void getCourse(String a);

	/**
	* Gets the question type to specified value
	*/
	public abstract void getQuesType(String a);

	/**
	* Gets the question length to specified value
	*/
	public abstract void getQuesLength(String a);




}