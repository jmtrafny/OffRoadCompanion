package spring17.se300.offroadcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by jmtra on 2/20/2017.
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
//Patrick Added a comment per the push-pull homework.
//Johny Done Goofed!!