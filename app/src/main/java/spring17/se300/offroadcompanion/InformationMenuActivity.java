package spring17.se300.offroadcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by James Trafny on 2/20/2017.
 * Extending AppCompatActivity allows for backwards compatibility between APKs
 * onCreate comes from android.os.Bundle and is called when the activity is created.
 * trailButtonClicked gets called when r.id.trailButton sends a click event.
 */
public class InformationMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_menu);
    }

    public void trailButtonClicked(View view) {
        // Do something in response to button
        Intent intent = new Intent(InformationMenuActivity.this, InformationPageActivity.class);
        startActivity(intent);
    }

}
