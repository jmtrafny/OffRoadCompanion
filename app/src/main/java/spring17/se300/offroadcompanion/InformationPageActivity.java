package spring17.se300.offroadcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by William James on 3/19/2017.
 * onCreate comes from android.os.Bundle and is called when the activity is created.
 */

public class InformationPageActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page);
    }


}