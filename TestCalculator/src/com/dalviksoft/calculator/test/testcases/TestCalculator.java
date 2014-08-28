package com.dalviksoft.calculator.test.testcases;

import junit.framework.Assert;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import com.dalviksoft.calculator.test.layouts.MainActivity;
import com.dalviksoft.calculator.test.layouts.UILayout;
import com.robotium.solo.Solo;

@SuppressWarnings("rawtypes")
public class TestCalculator extends ActivityInstrumentationTestCase2 {
	private Solo solo;
	private Instrumentation instr;

	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.dalviksoft.calculator.Main";
	private static Class<?> launcherActivityClass;
	static {
		try {
			launcherActivityClass = Class
					.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public TestCalculator() throws ClassNotFoundException {
		super(launcherActivityClass);
	}

	public void setUp() throws Exception {
		super.setUp();
		instr = getInstrumentation();
		solo = new Solo(getInstrumentation());
		UILayout.solo = solo;
		UILayout.instr = instr;
		getActivity();
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
		super.tearDown();
	}

	//Test adding two integers
	public void testAddIntegers() {
		MainActivity.WriteInteger(12);
		MainActivity.clickAdd();
		MainActivity.WriteInteger(12);
		MainActivity.clickEqual();
		String result = MainActivity.getText();
		Assert.assertEquals(result, "24.0");
	}
	//Test adding two floats
	public void testAddFloats() {
		MainActivity.WriteInteger(12);
		MainActivity.clickPoint();
		MainActivity.WriteInteger(12);
		MainActivity.clickAdd();
		MainActivity.WriteInteger(12);
		MainActivity.clickPoint();
		MainActivity.WriteInteger(12);
		MainActivity.clickEqual();
		String result = MainActivity.getText();
		Assert.assertEquals(result, "24.24");
	}
	//Test subtraction two floats
	public void testSubtractionFloats() {
		MainActivity.WriteInteger(24);
		MainActivity.clickPoint();
		MainActivity.WriteInteger(24);
		MainActivity.clickMinus();
		MainActivity.WriteInteger(12);
		MainActivity.clickPoint();
		MainActivity.WriteInteger(12);
		MainActivity.clickEqual();
		String result = MainActivity.getText();
		Assert.assertEquals(result, "12.12");
	}
	//Test subtraction two floats where we will have a negative answer
	public void testSubtractionFloatsNegativeAnswer() {
		MainActivity.WriteInteger(12);
		MainActivity.clickPoint();
		MainActivity.WriteInteger(12);
		MainActivity.clickMinus();
		MainActivity.WriteInteger(24);
		MainActivity.clickPoint();
		MainActivity.WriteInteger(24);
		MainActivity.clickEqual();
		String result = MainActivity.getText();
		Assert.assertEquals(result, "-12.12");
	}
	//Test Multiplication of two floats
	public void testMultiplicationFloats() {
		MainActivity.WriteInteger(155);
		MainActivity.clickPoint();
		MainActivity.WriteInteger(1);
		MainActivity.clickMinus();
		MainActivity.WriteInteger(14);
		MainActivity.clickPoint();
		MainActivity.WriteInteger(5);
		MainActivity.clickEqual();
		String result = MainActivity.getText();
		Assert.assertEquals(result, "140.6");
	}
	//Test multiplications of two floats where one of them is negative
	public void testMultiplicationFloatsNegativeAnswer() {
		MainActivity.clickMinus();
		MainActivity.WriteInteger(155);
		MainActivity.clickPoint();
		MainActivity.WriteInteger(1);
		MainActivity.clickMultiply();
		MainActivity.WriteInteger(14);
		MainActivity.clickPoint();
		MainActivity.WriteInteger(5);
		MainActivity.clickEqual();
		String result = MainActivity.getText();
		Assert.assertEquals(result, "-2248.9502");
	}

	//Test division of two floats
	public void testDivisionFloats() {
		MainActivity.clickMinus();
		MainActivity.WriteInteger(155);
		MainActivity.clickPoint();
		MainActivity.WriteInteger(1);
		MainActivity.clickDivide();
		MainActivity.WriteInteger(14);
		MainActivity.clickPoint();
		MainActivity.WriteInteger(5);
		MainActivity.clickEqual();
		String result = MainActivity.getText();
		Assert.assertEquals(result, "-10.696552");
	}
	//Test division by zero
	public void testDivisionByZero() {
		MainActivity.WriteInteger(155);
		MainActivity.clickDivide();
		MainActivity.WriteInteger(0);
		MainActivity.clickEqual();
		String result = MainActivity.getText();
		Assert.assertEquals(result, "Infinity");
	}

	//Test sin function
	public void testSin() {
		MainActivity.WriteInteger(90);
		MainActivity.clickSin();
		String result = MainActivity.getText();
		Assert.assertEquals(result, "1.0");

	}
	//Test cos function
	public void testCos() {
		MainActivity.WriteInteger(180);
		MainActivity.clickCos();
		String result = MainActivity.getText();
		Assert.assertEquals(result, "-1.0");
	}
	//Test Square function
	public void testSquare() {
		MainActivity.WriteInteger(180);
		MainActivity.clickSquared();
		String result = MainActivity.getText();
		Assert.assertEquals(result, "32400.0");
	}
	//Test root function
	public void testRoot() {
		MainActivity.WriteInteger(100);
		MainActivity.clickRoot();
		String result = MainActivity.getText();
		Assert.assertEquals(result, "10.0");
	}

}