/*
 * This is an example test project created in Eclipse to test NotePad which is a sample 
 * project located in AndroidSDK/samples/android-11/NotePad
 * 
 * 
 * You can run these test cases either on the emulator or on device. Right click
 * the test project and select Run As --> Run As Android JUnit Test
 * 
 * @author Renas Reda, renas.reda@robotium.com
 * 
 */

package com.thoughtworks.marchant_guide.ui;

import android.support.v4.view.ViewPager;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.robotium.solo.Solo;
import com.thoughtworks.marchant_guide.R;

public class RobotiumAutomationTest extends
		ActivityInstrumentationTestCase2<SplashActivity> {

	private Solo solo;

	public RobotiumAutomationTest() {
		super(SplashActivity.class);

	}

	@Override
	public void setUp() throws Exception {
		// setUp() is run before a test case is started.
		// This is where the solo object is created.
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@Override
	public void tearDown() throws Exception {
		// tearDown() is run after a test case has finished.
		// finishOpenedActivities() will finish all the activities that have
		// been opened during the test execution.
		solo.finishOpenedActivities();
	}

	public void testPishTegjGlobGlob() throws Exception {

		Thread.sleep(4000);

		solo.unlockScreen();

		View view1 = solo.getView(Spinner.class, 0);
		solo.clickOnView(view1);
		solo.scrollToTop();

		solo.clickOnView(solo.getView(TextView.class, 1));

		solo.clickOnText("Milky Way");

		solo.drag(300, 0, 100, 100, 1);

		solo.clickOnButton("Select");

		solo.clickOnText("pish");

		solo.clickOnText("tegj");

		solo.clickOnText("glob");

		solo.clickOnText("glob");

		TextView text = (TextView) solo.getView(R.id.credits_output);

		assertEquals("42.0", text.getText());

	}

	public void testGlobProkGold() throws Exception {

		Thread.sleep(4000);

		solo.unlockScreen();

		View view1 = solo.getView(Spinner.class, 0);
		solo.clickOnView(view1);
		solo.scrollToTop();

		solo.clickOnView(solo.getView(TextView.class, 4));

		solo.clickOnText("Milky Way");

		ViewPager pager = (ViewPager) solo.getView(R.id.galaxy_pager);

		solo.drag(300, 0, 100, 100, 1);

		solo.clickOnButton("Select");

		solo.clickOnText("glob");

		solo.clickOnText("prok");

		TextView text = (TextView) solo.getView(R.id.credits_output);

		assertEquals("57800.0", text.getText());

	}

	public void testGlobProkSilver() throws Exception {

		Thread.sleep(4000);

		solo.unlockScreen();

		View view1 = solo.getView(Spinner.class, 0);
		solo.clickOnView(view1);
		solo.scrollToTop();

		solo.clickOnView(solo.getView(TextView.class, 3));

		solo.clickOnText("Milky Way");

		solo.drag(300, 0, 100, 100, 1);

		solo.clickOnButton("Select");

		solo.clickOnText("glob");

		solo.clickOnText("prok");

		TextView text = (TextView) solo.getView(R.id.credits_output);

		assertEquals("68.0", text.getText());

	}

	public void testGlobProkIron() throws Exception {

		Thread.sleep(4000);

		solo.unlockScreen();

		View view1 = solo.getView(Spinner.class, 0);
		solo.clickOnView(view1);
		solo.scrollToTop();

		solo.clickOnView(solo.getView(TextView.class, 2));

		solo.clickOnText("Milky Way");

		solo.drag(300, 0, 100, 100, 1);

		solo.clickOnButton("Select");

		solo.clickOnText("glob");

		solo.clickOnText("prok");

		TextView text = (TextView) solo.getView(R.id.credits_output);

		assertEquals("782.0", text.getText());

	}

	// public void testAddNote() throws Exception {
	// // Unlock the lock screen
	// solo.unlockScreen();
	// solo.clickOnMenuItem("Add note");
	// // Assert that NoteEditor activity is opened
	// solo.assertCurrentActivity("Expected NoteEditor activity",
	// "HomeActivity");
	// // In text field 0, enter Note 1
	// solo.enterText(0, "Note 1");
	// solo.goBack();
	// // Clicks on menu item
	// solo.clickOnMenuItem("Add note");
	// // In text field 0, type Note 2
	// solo.typeText(0, "Note 2");
	// // Go back to first activity
	// solo.goBack();
	// // Takes a screenshot and saves it in "/sdcard/Robotium-Screenshots/".
	// solo.takeScreenshot();
	// boolean notesFound = solo.searchText("Note 1")
	// && solo.searchText("Note 2");
	// // Assert that Note 1 & Note 2 are found
	// assertTrue("Note 1 and/or Note 2 are not found", notesFound);
	// }
	//
	// public void testEditNote() throws Exception {
	// // Click on the second list line
	// solo.clickLongInList(2);
	// solo.clickOnText("Edit title");
	// // Change orientation of activity
	// solo.setActivityOrientation(Solo.LANDSCAPE);
	// // In first text field (0), add test
	// solo.enterText(0, " test");
	// // solo.goBack();
	// solo.setActivityOrientation(Solo.PORTRAIT);
	// // (Regexp) case insensitive
	// boolean noteFound = solo.waitForText("(?i).*?note 1 test");
	// // Assert that Note 1 test is found
	// assertTrue("Note 1 test is not found", noteFound);
	// }
	//
	// public void testRemoveNote() throws Exception {
	// // (Regexp) case insensitive/text that contains "test"
	// solo.clickOnText("(?i).*?test.*");
	// // Delete Note 1 test
	// solo.clickOnMenuItem("Delete");
	// // Note 1 test should not be found
	// boolean noteFound = solo.searchText("Note 1 test");
	// // Assert that Note 1 test is not found
	// assertFalse("Note 1 Test is found", noteFound);
	// solo.clickLongOnText("Note 2");
	// // Clicks on Delete in the context menu
	// solo.clickOnText("Delete");
	// // Will wait 100 milliseconds for the text: "Note 2"
	// noteFound = solo.waitForText("Note 2", 1, 100);
	// // Assert that Note 2 is not found
	// assertFalse("Note 2 is found", noteFound);
	// }
}
