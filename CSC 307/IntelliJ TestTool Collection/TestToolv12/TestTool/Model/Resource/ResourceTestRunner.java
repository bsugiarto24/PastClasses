package TestTool.Model.Resource;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by mgolahi on 12/9/15.
 */
public class ResourceTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ResourceTestSuite.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
