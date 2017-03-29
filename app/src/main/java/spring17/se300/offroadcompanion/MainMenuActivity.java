package spring17.se300.offroadcompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by James Trafny on 2/28/2017.
 *
 * onCreate comes from android.os.Bundle and is called when the activity is created.
 * navigationButtonClicked gets called when r.id.navigationButton sends a click event.
 * orientationButtonClicked gets called when r.id.orientationButton sends a click event.
 * informationButtonClicked gets called when r.id.informationButton sends a click event.
 */
public class MainMenuActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    // Called when the user clicks the mainMenuButtonNavigation button
    public void navigationButtonClicked(View view)
    {
        // Do something in response to button
        Intent intent = new Intent(MainMenuActivity.this, NavigationActivity.class);
        startActivity(intent);
    }

    // Called when the user clicks the mainMenuButtonOrientation button
    public void orientationButtonClicked(View view)
    {
        // Do something in response to button
        Intent intent = new Intent(MainMenuActivity.this, OrientationActivity.class);
        startActivity(intent);
    }

    // Called when the user clicks the mainMenuButtonInformation button
    public void informationButtonClicked(View view)
    {
        // Do something in response to button
        Intent intent = new Intent(MainMenuActivity.this, InformationMenuActivity.class);
        startActivity(intent);
    }


}
