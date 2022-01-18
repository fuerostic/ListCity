package com.example.simpleparadox.listycity;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import android.app.Activity;
import android.widget.EditText;
import android.widget.ListView;
import com.robotium.solo.Solo;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Test class for MainActivity. All the UI tests are written here. Robotium test framework is used
 */
@RunWith(AndroidJUnit4.class)
public class ShowAcitivityTest {
    private Solo solo;

    @Rule
    public ActivityTestRule<MainActivity> rule =
            new ActivityTestRule<>(MainActivity.class, true, true);
    /**
     * Runs before all tests and creates solo instance.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception{

        solo = new Solo(InstrumentationRegistry.getInstrumentation(),rule.getActivity());
    }
    /**
     * Gets the Activity
     * @throws Exception
     */
    @Test
    public void start() throws Exception{
        Activity activity = rule.getActivity();
    }
    /**
     * Add a city to the listview and check the city name using assertTrue
     * Clear all the cities from the listview and check again with assertFalse
     */
    @Test
    public void checkSwitch(){
        // Asserts that the current activity is the MainActivity. Otherwise, show “Wrong Activity”
        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);

        solo.clickOnButton("ADD CITY"); //Click ADD CITY Button

        //Get view for EditText and enter a city name
        solo.enterText((EditText) solo.getView(R.id.editText_name), "Edmonton");
        solo.clickOnView(solo.getView(R.id.button_confirm)); //Select CONFIRM Button
        solo.clearEditText((EditText) solo.getView(R.id.editText_name)); //Clear the EditText

        /* True if there is any text: Edmonton on the screen, wait at least 2 seconds and
        find minimum one match. */
        assertTrue(solo.waitForText("Edmonton", 1, 2000));

        solo.clickOnText("Edmonton");

        solo.assertCurrentActivity("Wrong Activity",ShowActivity.class);


    }

    /**
     * Check item taken from the listview
     */
    @Test
    public void checkCiyName(){

        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);

        solo.clickOnButton("ADD CITY"); //Click ADD CITY Button

        //Get view for EditText and enter a city name
        solo.enterText((EditText) solo.getView(R.id.editText_name), "Edmonton");
        solo.clickOnView(solo.getView(R.id.button_confirm)); //Select CONFIRM Button
        solo.clearEditText((EditText) solo.getView(R.id.editText_name)); //Clear the EditText

        /* True if there is any text: Edmonton on the screen, wait at least 2 seconds and
        find minimum one match. */
        assertTrue(solo.waitForText("Edmonton", 1, 2000));

        solo.clickOnText("Edmonton");
        solo.waitForActivity("ShowActivity");
        solo.assertCurrentActivity("Wrong Activity", ShowActivity.class);

        solo.waitForText("Edmonton", 1, 2000);

    }

    @Test
    public void checkBackButton(){

        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);

        solo.clickOnButton("ADD CITY"); //Click ADD CITY Button

        //Get view for EditText and enter a city name
        solo.enterText((EditText) solo.getView(R.id.editText_name), "Edmonton");
        solo.clickOnView(solo.getView(R.id.button_confirm));  //Select CONFIRM Button
        solo.clearEditText((EditText) solo.getView(R.id.editText_name)); //Clear the EditText

        /* True if there is any text: Edmonton on the screen, wait at least 2 seconds and
        find minimum one match. */
        assertTrue(solo.waitForText("Edmonton", 1, 2000));

        solo.clickOnText("Edmonton");

        solo.assertCurrentActivity("Wrong Activity", ShowActivity.class);
// testing back button
        solo.clickOnView(solo.getView(R.id.btn_back));

        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);

    }

    /**
     * Close activity after each test
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}
