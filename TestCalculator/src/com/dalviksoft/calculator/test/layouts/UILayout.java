package com.dalviksoft.calculator.test.layouts;

import java.util.ArrayList;

import android.app.Instrumentation;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.GridView;
import android.widget.TextView;

import com.robotium.solo.Solo;

 public class UILayout {
	
	public static Solo solo;
	public static Instrumentation instr;
	
	//clears the textbox and enter the text given
	public static void clearAndEnterText(String text, int index)
   	{
   		solo.clearEditText(index);
		solo.enterText(index, text);
   	}
	public static void waitForMain()
   	{
   		solo.waitForActivity("MainActivity", 1000);
   	}
	//returns the item in the index given in the current list
	public static View getViewAtIndex(final ListView listElement, final int indexInList, Instrumentation instrumentation) {
   	    ListView parent = listElement;
   	    if (parent != null) {
   	        if (indexInList <= parent.getAdapter().getCount()) {
   	            scrollListTo(parent, indexInList, instrumentation);
   	            int indexToUse = indexInList - parent.getFirstVisiblePosition();
   	            return parent.getChildAt(indexToUse);
   	        }
   	    }
   	    return null;
   	}

	public static View getViewOfGridListAtIndex(final GridView listElement, final int indexInList, Instrumentation instrumentation) {
		GridView parent = listElement;
   	    if (parent != null) {
   	        if (indexInList <= parent.getAdapter().getCount()) {
   	            scrollListTo(parent, indexInList, instrumentation);
   	            int indexToUse = indexInList - parent.getFirstVisiblePosition();
   	            return parent.getChildAt(indexToUse);
   	        }
   	    }
   	    return null;
   	}
	
   	public static <T extends AbsListView> void scrollListTo(final T listView,
   	        final int index, Instrumentation instrumentation) {
   	    instrumentation.runOnMainSync(new Runnable() {
   	        @Override
   	        public void run() {
   	            listView.setSelection(index);
   	        }
   	    });
   	    instrumentation.waitForIdleSync();
   	}

   	//returns all the list titles in the current listview
   	public static ArrayList<String> getListTitles(int textpos)
   	{
   		ArrayList <String> titles= new ArrayList<String>();
   		ListView list = getListView();
   		for(int i=0; i < list.getAdapter().getCount(); i++){
   		    View item=getViewAtIndex(list, i, instr);
   		    ArrayList <TextView> textList=solo.getCurrentViews(TextView.class,item);
			titles.add((String) textList.get(textpos).getText());
   		}
   		return titles;
   	}
   	//returns the listview size
   	public static int getListsize()
   	{
   		ListView list = getListView();
   		return list.getAdapter().getCount();
   	}
   	//returns the listview 
   	public static ListView getListView()
   	{
   		int count=0;
   		while (solo.getCurrentViews(ListView.class).size()==0)
   		{
   			count+=1;
   			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
   		}
   		ListView list = solo.getCurrentViews(ListView.class).get(0);
   		return list;
   	}
   	
	public static GridView getGridView()
   	{
   		int count=0;
   		while (solo.getCurrentViews(GridView.class).size()==0)
   		{
   			count+=1;
   			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
   		}
   		GridView list = solo.getCurrentViews(GridView.class).get(0);
   		return list;
   	}
   	public static void selectFromList(int start,int end)
   	{
   		for (int i=start ; i<end ; i++)
		{
   			ListView list = getListView();
   		    View item=getViewAtIndex(list, i, instr);
   		    solo.clickOnView(item);
		}
   	}
   	
  	public static boolean waitForToast(String text)
   	{
   		return solo.waitForText(text);
   	}
 
  	public static void back()
  	{
  		solo.goBack();
  	}

}
