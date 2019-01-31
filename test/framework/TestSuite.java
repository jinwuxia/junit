
package test.framework;

import java.util.Vector;
import java.util.Enumeration;

/**
 * A <code>TestSuite</code> is a <code>Composite</code> of Tests.
 * It runs a collection of test cases. Here is an example using
 * the dynamic test definition.
 * <pre>
 * TestSuite suite= new TestSuite();
 * suite.addTest(new MathTest("testAdd"));
 * suite.addTest(new MathTest("testDivideByZero"));
 * </pre>
 * @see Test
 */
public class TestSuite {

	private Vector fTests= new Vector(10);

    /**
     * Runs the tests and collects their result in a TestResult.
     */
	public void run(TestResult result) {
		for (Enumeration e= fTests.elements(); e.hasMoreElements(); ) {
      		if (result.shouldStop() )
      			break;
			TestCase test= (TestCase) e.nextElement();
			test.run(result);
		}
	}

    /**
     * Adds a test to the suite.
     */
	public void addTest(TestCase test) {
		fTests.addElement(test);
	}

    /**
     * Counts the number of test cases that will be run by this test.
     */
	public int countTestCases() {
		int count= 0;
		for (Enumeration e= fTests.elements(); e.hasMoreElements(); ) {
			TestCase test= (TestCase) e.nextElement();
			count= count + test.countTestCases();
		}
		return count;
	}

    /**
     * Returns a string representation of the test suite
     */
	public String toString() {
	    return fTests.toString();
	}
}