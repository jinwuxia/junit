
package test.ui;


import test.framework.*;

public class GUITestResult extends TestResult {
	private UniTestGui fRunner;

	GUITestResult(UniTestGui runner) {
		fRunner= runner;
	}

	public synchronized void addError(Test test, Throwable t) {
		super.addError(test, t);
		fRunner.addError(this, test, t);
	}

	public synchronized void addFailure(Test test, Throwable t) {
		super.addFailure(test, t);
		fRunner.addFailure(this, test, t);
	}

	public synchronized void endTest(Test test) {
		super.endTest(test);
		fRunner.endTest(this, test);
	}
}