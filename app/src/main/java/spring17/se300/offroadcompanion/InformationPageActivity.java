package spring17.se300.offroadcompanion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by William James on 3/19/2017.
 * onCreate comes from android.os.Bundle and is called when the activity is created.
 */

public class InformationPageActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int screen = getIntent().getExtras().getInt("page");
        super.onCreate(savedInstanceState);
        String text = "";
        InputStream is;
        TextView textElement;
        switch (screen){
            case 0:
                setContentView(R.layout.activity_trailetiquette);
                textElement = (TextView) findViewById(R.id.trailText);
                is = getResources().openRawResource(R.raw.ettext);
                text = readFile(is);
                textElement.setText(text);

                break;
            case 1: setContentView(R.layout.activity_basicdriving);
                textElement = (TextView) findViewById(R.id.basicText);
                is = getResources().openRawResource(R.raw.bdtext);
                text = readFile(is);
                textElement.setText(text);
                break;
            case 2: setContentView(R.layout.activity_advanceddriving);
                textElement = (TextView) findViewById(R.id.adText);
                is = getResources().openRawResource(R.raw.adtext);
                text = readFile(is);
                textElement.setText(text);
                break;
            case 3: setContentView(R.layout.activity_muddin);
                textElement = (TextView) findViewById(R.id.mudText);
                is = getResources().openRawResource(R.raw.mudtext);
                text = readFile(is);
                textElement.setText(text);
                break;
            case 4: setContentView(R.layout.activity_rock);
                textElement = (TextView) findViewById(R.id.rText);
                is = getResources().openRawResource(R.raw.rocktext);
                text = readFile(is);
                textElement.setText(text);
                break;
            case 5: setContentView(R.layout.activity_snow);
                textElement = (TextView) findViewById(R.id.snowText);
                is = getResources().openRawResource(R.raw.snowtext);
                text = readFile(is);
                textElement.setText(text);
                break;
            case 6: setContentView(R.layout.activity_whinching);
                textElement = (TextView) findViewById(R.id.basicText);
                is = getResources().openRawResource(R.raw.bdtext);
                text = readFile(is);
                textElement.setText(text);
                break;
            case 7: setContentView(R.layout.activity_you);
                textElement = (TextView) findViewById(R.id.basicText);
                is = getResources().openRawResource(R.raw.bdtext);
                text = readFile(is);
                textElement.setText(text);
                break;
            case 8: setContentView(R.layout.activity_friend);
                textElement = (TextView) findViewById(R.id.basicText);
                is = getResources().openRawResource(R.raw.bdtext);
                text = readFile(is);
                textElement.setText(text);
                break;
            case 9: setContentView(R.layout.activity_responsibility);
                textElement = (TextView) findViewById(R.id.basicText);
                is = getResources().openRawResource(R.raw.bdtext);
                text = readFile(is);
                textElement.setText(text);
                break;
            case 10: setContentView(R.layout.activity_pack);
                textElement = (TextView) findViewById(R.id.basicText);
                is = getResources().openRawResource(R.raw.bdtext);
                text = readFile(is);
                textElement.setText(text);
                break;
            case 11: setContentView(R.layout.activity_tools);
                textElement = (TextView) findViewById(R.id.basicText);
                is = getResources().openRawResource(R.raw.bdtext);
                text = readFile(is);
                textElement.setText(text);
                break;
            case 12: setContentView(R.layout.activity_fix);
                textElement = (TextView) findViewById(R.id.basicText);
                is = getResources().openRawResource(R.raw.bdtext);
                text = readFile(is);
                textElement.setText(text);
                break;
            case 13: setContentView(R.layout.activity_tips);
                textElement = (TextView) findViewById(R.id.basicText);
                is = getResources().openRawResource(R.raw.bdtext);
                text = readFile(is);
                textElement.setText(text);
                break;

        }
    }

    protected String readFile(InputStream io){
        BufferedReader br = new BufferedReader(new InputStreamReader(io));
        String line;
        String entireFile = "";
        try {
            while((line = br.readLine()) != null) {
                entireFile += (line + "\n");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return entireFile;
    }
}