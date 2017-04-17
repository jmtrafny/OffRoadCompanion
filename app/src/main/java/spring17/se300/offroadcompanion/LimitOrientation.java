package spring17.se300.offroadcompanion;
import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


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
        limitedRollText = (EditText) findViewById(R.id.editLimitRoll);
        limitedPitchText = (EditText) findViewById(R.id.editLimitPitch);
        warningRollText = (EditText) findViewById(R.id.editwarningRoll);
        warningPitchText = (EditText) findViewById(R.id.editwarningtPitch);


        if (TextUtils.isEmpty(limitedRollText.getText().toString())) {
            Toast.makeText(this, "Please fill in the blank", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            limitedRoll = Double.parseDouble(limitedRollText.getText().toString());
            if (limitedRoll < -90 || limitedRoll > 90) {
                limitedRollText.setError(outbound);
            }
        }


        if (limitedPitchText.getText().length() == 0) {
            Toast.makeText(this, "Please fill in the blank", Toast.LENGTH_SHORT).show();
            return;
        } else {
            limitedPitch = Double.parseDouble(limitedPitchText.getText().toString());
            if (limitedPitch < -90 || limitedPitch > 90) {
                limitedPitchText.setError(outbound);
            }
        }

        if (warningRollText.getText().length() == 0) {
            Toast.makeText(this, "Please fill in the blank", Toast.LENGTH_SHORT).show();
            return;
        } else {
            warningRoll = Double.parseDouble(warningRollText.getText().toString());
            if (warningRoll < -90 || warningRoll > 90) {
                warningRollText.setError(outbound);
            }
        }


        if (warningPitchText.getText().length() == 0) {
            Toast.makeText(this, "Please fill in the blank", Toast.LENGTH_SHORT).show();
            return;
        } else {
            warningPitch = Double.parseDouble(warningPitchText.getText().toString());
            if (warningPitch < -90 || warningPitch > 90) {
                warningPitchText.setError(outbound);
            }
        }

        if (warningPitch == limitedPitch) {
            limitedPitchText.setError(warnValue);
            warningPitchText.setError(limValue);
        }
        if (warningRoll == limitedRoll) {
            limitedRollText.setError(warnValue);
            warningRollText.setError(limValue);

            Intent intent = new Intent(LimitOrientation.this, OrientationActivity.class);
            startActivity(intent);

        }
    }


    public void orientationLimitResetClicked (View View){
        limitedRoll = 720;
        limitedPitch = 720;
        warningRoll = 360;
        warningPitch= 360;
        Intent intent = new Intent(LimitOrientation.this, OrientationActivity.class);
        startActivity(intent);

    }



}