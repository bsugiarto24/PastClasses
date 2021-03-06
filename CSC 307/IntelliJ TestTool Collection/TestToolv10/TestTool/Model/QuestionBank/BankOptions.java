package TestTool.Model.QuestionBank;
import java.util.*;
import TestTool.Model.Resource.*;
import java.time.LocalDate;

/**
* Stores all the sorting information for the questions in questionBank
* so that the most relevant questions are on top.
*
* Created by JonathanTan (jtan14@calpoly.edu) on 11/20/15.
*
*/

public class BankOptions{

    /* The difficulty option for the question */
	private int difficulty;

    /* The subject option for the question */
    private Subject subject;

    /* The course option for the question */
	private Course course;

    /* The type of question option for the question */
    private String questionType;

    /* The the search box text to find the question */
	private String searchBox;

	/* The start date option for the question. */
	private LocalDate start;

	/* The end date option for the question. */
	private LocalDate end;


    /**
     * Sets the searchBox value to specified value
     pre:
     a != null;
     post:
     searchBox == a;
     */
    public void setQuestionType(String a) {
        questionType = a;
        System.out.println("QuestionType: " + questionType);
    }

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
	public void setSubj(Subject a) {
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
	public void setCourse(Course a) {
		course = a;
		System.out.println("Course: " + course);
	}

	/**
	 * Sets the start date to the specified value
	  post:
	 	start.equals(a);
	 */
	public void setStart(LocalDate a) {
		start = a;
		System.out.println("Start Date: " + start);
	}

	/**
	 * Sets the end date to the specified value
	 post:
	 start.equals(a);
	 */
	public void setEnd(LocalDate a) {
		end = a;
		System.out.println("End Date: " + end);
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
	public Subject getSubj() {
		return this.subject;
	}

	/**
	* Gets the course to specified value
	 pre:
	 	course != null;
	*/
	public Course getCourse() {
		return this.course;
	}

	/**
	* Gets the Search Box Value
	 pre:
	 	searchBox != null;
	*/
	public String getSearchBox() {
		return this.searchBox;
	}

    /**
     * Gets the Search Box Value
     pre:
        questionType != null;
     */
    public String getQuestionType() {
        return this.questionType;
    }

	/**
	 * Gets the start time value
     */
	public LocalDate getStart() { return this.start; }

	/**
	 * Gets the end time value
	 */
	public LocalDate getEnd() { return this.end; }
}
