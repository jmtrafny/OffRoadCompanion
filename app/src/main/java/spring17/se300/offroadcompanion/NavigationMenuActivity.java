package spring17.se300.offroadcompanion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by James Trafny on 2/28/2017.
 *
 * onCreate comes from android.os.Bundle and is called when the activity is created.
 *
 */
public class NavigationMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);
    }
}
