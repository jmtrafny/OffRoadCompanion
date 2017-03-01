package spring17.se300.offroadcompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_menu);
    }

    // Called when the user clicks the mainMenuButtonNavigation button
    public void navigationButtonClicked(View view) {
        // Do something in response to button
        Intent intent = new Intent(MainMenuActivity.this, NavigationMenuActivity.class);
        startActivity(intent);
    }

    // Called when the user clicks the mainMenuButtonOrientation button
    public void orientationButtonClicked(View view) {
        // Do something in response to button
        Intent intent = new Intent(MainMenuActivity.this, OrientationActivity.class);
        startActivity(intent);
    }

    // Called when the user clicks the mainMenuButtonInformation button
    public void informationButtonClicked(View view) {
        // Do something in response to button
        Intent intent = new Intent(MainMenuActivity.this, InformationMenuActivity.class);
        startActivity(intent);
    }

}
