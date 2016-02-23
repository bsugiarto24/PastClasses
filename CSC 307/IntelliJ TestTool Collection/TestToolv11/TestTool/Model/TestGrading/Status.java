package TestTool.Model.TestGrading;

import java.io.Serializable;

/**
 * Enumerates the Statuses for grading purposes. Used for setting the status of a StudentTest.
 *
 * Created by Michael Golahi (mgolahi@calpoly.edu) on 11/28/15.
 */
public enum Status implements Serializable {
    /*Status when a StudentTest has not been graded manually*/
    NOT_STARTED("Not Started"),
    /*Status when a StudentTest has been partially graded*/
    IN_PROGRESS("In Progress"),
    /*Status when a StudentTest is completely graded*/
    COMPLETE("Complete");

    /**
     * Holds the String for the status
     */
    private final String status;

    /**
     * Instantiates a Status enumeration.
     * @param status The String status corresponding to the enumerated constant
     */
    Status(final String status) {
        this.status = status;
    }

    /**
     * Implemented so that Status type can be used for TableColumns in JavaFX.
     * @return The String that represents the enumerated constant
     */
    @Override
    public String toString() {
        return status;
    }
}
