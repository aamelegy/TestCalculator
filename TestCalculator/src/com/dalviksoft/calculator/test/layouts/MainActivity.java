package com.dalviksoft.calculator.test.layouts;


import android.widget.TextView;

import com.dalviksoft.calculator.R;

public class MainActivity extends UILayout {

	public MainActivity() {
		super();
		// TODO Auto-generated constructor stub
	}

	//this function writes an integer using the numpad in the calculator
	public static void WriteInteger(int n)
	{
		String num= Integer.toString(n);
		for (int i =0 ; i< num.length(); i++)
		{
			char digit=num.charAt(i);
			clickDigit(digit);
		}
	}
	//this function writes a single digit
	public static void clickDigit(char num) {
		switch (num) {
		case '0':
			solo.clickOnView(solo.getView(R.id.button0));
			break;
		case '1':
			solo.clickOnView(solo.getView(R.id.button1));
			break;
		case '2':
			solo.clickOnView(solo.getView(R.id.button2));
			break;
		case '3':
			solo.clickOnView(solo.getView(R.id.button3));
			break;
		case '4':
			solo.clickOnView(solo.getView(R.id.button4));
			break;
		case '5':
			solo.clickOnView(solo.getView(R.id.button5));
			break;
		case '6':
			solo.clickOnView(solo.getView(R.id.button6));
			break;
		case '7':
			solo.clickOnView(solo.getView(R.id.button7));
			break;
		case '8':
			solo.clickOnView(solo.getView(R.id.button8));
			break;
		case '9':
			solo.clickOnView(solo.getView(R.id.button9));
			break;
		default:
			break;
		}
	}

	//click add button
	public static void clickAdd() {
		solo.clickOnView(solo.getView(R.id.buttonPlus));
	}
	//click divide button
	public static void clickDivide() {
		solo.clickOnView(solo.getView(R.id.buttonDivide));
	}

	//click minus button
	public static void clickMinus() {
		solo.clickOnView(solo.getView(R.id.buttonMinus));
	}
	//click multiply button
	public static void clickMultiply() {
		solo.clickOnView(solo.getView(R.id.buttonMultiply));
	}
	//click point
	public static void clickPoint() {
		solo.clickOnView(solo.getView(R.id.buttonPoint));
	}
	//click equals button
	public static void clickEqual() {
		solo.clickOnView(solo.getView(R.id.buttonEqual));
	}
	//click exit
	public static void clickExit() {
		solo.clickOnView(solo.getView(R.id.buttonExit));
	}
	//click reset
	public static void clickReset() {
		solo.clickOnView(solo.getView(R.id.buttonReset));
	}
	//click del
	public static void clickDel() {
		solo.clickOnView(solo.getView(R.id.button_del));
	}
	//click tan
	public static void clickTan() {
		solo.clickOnView(solo.getView(R.id.button_tan));
	}
	//click cos
	public static void clickCos() {
		solo.clickOnView(solo.getView(R.id.button_cos));
	}
	//click sin
	public static void clickSin() {
		solo.clickOnView(solo.getView(R.id.button_sin));
	}
	//click oct
	public static void clickOct() {
		solo.clickOnView(solo.getView(R.id.button_oct));
	}
	//click hex
	public static void clickHex() {
		solo.clickOnView(solo.getView(R.id.button_hex));
	}
	//click dec
	public static void clickDec() {
		solo.clickOnView(solo.getView(R.id.button_dec));
	}
	//click bin
	public static void clickBin() {
		solo.clickOnView(solo.getView(R.id.button_bin));
	}
	//click pu
	public static void clickPi() {
		solo.clickOnView(solo.getView(R.id.button_pi));
	}
	//click root
	public static void clickRoot() {
		solo.clickOnView(solo.getView(R.id.button_root));
	}	
	//click cube
	public static void clickQube() {
		solo.clickOnView(solo.getView(R.id.button_qube));
	}
	//click squared
	public static void clickSquared() {
		solo.clickOnView(solo.getView(R.id.button_squared_2));
	}
	//get the text in the textbox
	public static String getText()
	{
		TextView t=(TextView) solo.getView(R.id.editText1);
		return t.getText().toString();
	}

}
