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

    public void etButtonClicked(View view) {
        // Do something in response to button
        int pageId = 0;
        Intent intent = new Intent(InformationMenuActivity.this, InformationPageActivity.class);
        intent.putExtra("page", pageId);
        startActivity(intent);
    }

    public void bdButtonClicked(View view) {
        // Do something in response to button
        int pageId = 1;
        Intent intent = new Intent(InformationMenuActivity.this, InformationPageActivity.class);
        intent.putExtra("page", pageId);
        startActivity(intent);
    }

    public void adButtonClicked(View view) {
        // Do something in response to button
        int pageId = 2;
        Intent intent = new Intent(InformationMenuActivity.this, InformationPageActivity.class);
        intent.putExtra("page", pageId);
        startActivity(intent);
    }

    public void mButtonClicked(View view) {
        // Do something in response to button
        int pageId = 3;
        Intent intent = new Intent(InformationMenuActivity.this, InformationPageActivity.class);
        intent.putExtra("page", pageId);
        startActivity(intent);
    }

    public void rcButtonClicked(View view) {
        // Do something in response to button
        int pageId = 4;
        Intent intent = new Intent(InformationMenuActivity.this, InformationPageActivity.class);
        intent.putExtra("page", pageId);
        startActivity(intent);
    }
    public void siButtonClicked(View view) {
        // Do something in response to button
        int pageId = 5;
        Intent intent = new Intent(InformationMenuActivity.this, InformationPageActivity.class);
        intent.putExtra("page", pageId);
        startActivity(intent);
    }
    public void wButtonClicked(View view) {
        // Do something in response to button
        int pageId = 6;
        Intent intent = new Intent(InformationMenuActivity.this, InformationPageActivity.class);
        intent.putExtra("page", pageId);
        startActivity(intent);
    }
    public void usButtonClicked(View view) {
        // Do something in response to button
        int pageId = 7;
        Intent intent = new Intent(InformationMenuActivity.this, InformationPageActivity.class);
        intent.putExtra("page", pageId);
        startActivity(intent);
    }
    public void wtpButtonClicked(View view) {
        // Do something in response to button
        int pageId = 8;
        Intent intent = new Intent(InformationMenuActivity.this, InformationPageActivity.class);
        intent.putExtra("page", pageId);
        startActivity(intent);
    }
    public void tButtonClicked(View view) {
        // Do something in response to button
        int pageId = 9;
        Intent intent = new Intent(InformationMenuActivity.this, InformationPageActivity.class);
        intent.putExtra("page", pageId);
        startActivity(intent);
    }
    public void bmrButtonClicked(View view) {
        // Do something in response to button
        int pageId = 10;
        Intent intent = new Intent(InformationMenuActivity.this, InformationPageActivity.class);
        intent.putExtra("page", pageId);
        startActivity(intent);
    }
    public void tntcButtonClicked(View view) {
        // Do something in response to button
        int pageId = 11;
        Intent intent = new Intent(InformationMenuActivity.this, InformationPageActivity.class);
        intent.putExtra("page", pageId);
        startActivity(intent);
    }
}