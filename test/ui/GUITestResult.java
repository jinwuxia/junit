
package test.ui;


import test.framework.Test;
import test.framework.TestCase;
import test.framework.TestResult;

public class GUITestResult extends TestResult {
	private UniTestGui fRunner;

	GUITestResult(UniTestGui runner) {
		fRunner= runner;
	}

	public synchronized void addError(Test test, Throwable t) {
		super.addError((TestCase) test, t);
		fRunner.addError(this, test, t);
	}

	public synchronized void addFailure(Test test, Throwable t) {
		super.addFailure((TestCase)test, t);
		fRunner.addFailure(this, test, t);
	}

	public synchronized void endTest(Test test) {
		super.endTest((TestCase)test);
		fRunner.endTest(this, test);
	}
}