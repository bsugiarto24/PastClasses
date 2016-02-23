package TestTool.Model.QuestionBank;
import java.util.*;

/**
* Stores all the sorting information for the questions in questionBank
* so that the most relevant questions are on top.
*/

public class BankOptions{
	private int difficulty;
	private String subject;
	private String course;
	private String questionLenType;
	private int questionLength;
	private String searchBox;


	/**
	 * Sets the searchBox value to specified value
	 pre:
	 a != null;
	 post:
	 searchBox == a;
	 */
	public void setSearch(String a) {
		searchBox = a;
		System.out.println("Search: " + searchBox);
	}

	/**
	* Sets the difficulty to specified value
	 pre:
	 	a != null;
	 post:
	 	difficulty == a;
	*/
	public void setDiff(int a) {
		difficulty = a;
		System.out.println("Difficulty: " + difficulty);
	}

	/**
	* Sets the subject to specified value
	 pre:
	 	a != null;
	 post:
	 	subject.equals(a);
	*/
	public void setSubj(String a) {
		subject = a;
		System.out.println("Subject: " + subject);
	}

	/**
	* Sets the course to specified value
	 pre:
	 	a != null;
	 post:
	 	course.equals(a);
	*/
	public void setCourse(String a) {
		course = a;
		System.out.println("Course: " + course);
	}

	/**
	* Sets the question type to specified value
	 pre:
	 	a != null;
	 post:
	 	questionType.equals(a);
	*/
	public void setQuesLenType(String a) {

		questionLenType = a;
		System.out.println("QuestionLen: " + questionLenType);
	}

	/**
	* Sets the question length to specified value
	 pre:
	 	a != null;
	 post:
	 	questionLength.equals(a);
	*/
	public void setQuesLength(int a) {
		questionLength = a;
		System.out.println("Question Length: " + questionLength);
	}

	/**
	* Gets the difficulty to specified value
	 pre:
	 	difficulty != null;
	*/
	public int getDiff() {
		return this.difficulty;
	}

	/**
	* Gets the subject to specified value
	 pre:
	 	subject != null;
	*/
	public String getSubj() {
		return this.subject;
	}

	/**
	* Gets the course to specified value
	 pre:
	 	course != null;
	*/
	public String getCourse() {
		return this.course;
	}

	/**
	* Gets the question type to specified value
	 pre:
	 	questionType != null;
	*/
	public String getQuesType() {
		return this.questionLenType;
	}

	/**
	* Gets the question length to specified value
	 pre:
	 	questionLength != null;
	*/
	public int getQuesLength() {
		return this.questionLength;
	}

	/**
	* Gets the Search Box Value
	 pre:
	 	searchBox != null;
	*/
	public String getSearchBox() {
		return this.searchBox;
	}

}
