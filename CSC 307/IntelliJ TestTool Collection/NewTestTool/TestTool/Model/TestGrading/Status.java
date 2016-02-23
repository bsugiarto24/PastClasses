package TestTool.Model.TestGrading;

/**
 * Created by mgolahi on 11/29/15.
 */
public enum Status {
    NOT_STARTED("Not Started"),
    IN_PROGRESS("In Progress"),
    COMPLETE("Complete")
    ;

    private final String status;

    Status(final String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
