package easy;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Test {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestRun.class);
        System.out.println(result.getRunCount());
    }
}
