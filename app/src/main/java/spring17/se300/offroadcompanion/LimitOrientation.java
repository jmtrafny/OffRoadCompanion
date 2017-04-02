package spring17.se300.offroadcompanion;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;


/**
 * Created by Johnny Nguyen on 3/20/2017.
 * Extends OrientationActivity
 * onCreate comes from android.os.Bundle and is called when the activity is created.
 * orientationLimitResetClicked gets called when r.id.orientationLimitReset sends a click event.
 */
public class LimitOrientation  extends OrientationActivity {

    EditText limitedRollText;
    EditText limitedPitchText;
    EditText warningRollText;
    EditText warningPitchText;
    String outbound = "Value is out of bound";
    String limValue = "Value cannot be the same as limit";
    String warnValue = "Value cannot be the same as warning";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.limit_activity_orientation);
    }

    public void orientationLimitSetClicked (View View){
        limitedRollText =(EditText) findViewById(R.id.editLimitRoll);
        limitedPitchText =(EditText) findViewById(R.id.editLimitPitch);
        limitedRoll = Double.parseDouble(limitedRollText.getText().toString());
        limitedPitch = Double.parseDouble(limitedPitchText.getText().toString());
        warningRollText =(EditText) findViewById(R.id.editwarningRoll);
        warningPitchText =(EditText) findViewById(R.id.editwarningtPitch);
        warningRoll = Double.parseDouble(warningRollText.getText().toString());
        warningPitch = Double.parseDouble(warningPitchText.getText().toString());


       if ( limitedRoll < -90 || limitedRoll > 90){
            limitedRollText.setError(outbound);
       }
       if  ( limitedPitch < -90 || limitedPitch > 90){
            limitedPitchText.setError(outbound);
       }
        if ( warningRoll < -90 || warningRoll > 90){
            warningRollText.setError(outbound);
        }
        if  ( warningRoll < -90 || warningRoll > 90) {
            warningPitchText.setError(outbound);
        }
        if (warningPitch == limitedPitch){
            limitedPitchText.setError(warnValue);
            warningPitchText.setError(limValue);
        }
        if (warningRoll == limitedRoll){
            limitedRollText.setError(warnValue);
            warningRollText.setError(limValue);
        }
            else{
            Intent intent = new Intent(LimitOrientation.this, OrientationActivity.class);
            startActivity(intent);
        }

    }

    public void orientationLimitResetClicked (View View){
        limitedRollText.getText().clear();
        limitedPitchText.getText().clear();
        warningRollText.getText().clear();
        warningPitchText.getText().clear();
        limitedRoll = 720;
        limitedPitch = 720;
        warningRoll = 360;
        warningPitch= 360;
        Intent intent = new Intent(LimitOrientation.this, OrientationActivity.class);
        startActivity(intent);

    }

}