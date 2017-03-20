package spring17.se300.offroadcompanion;
import android.os.Bundle;
import android.view.View;


/**
 * Created by Johnny Nguyen on 3/20/2017.
 * Extends OrientationActivity
 * onCreate comes from android.os.Bundle and is called when the activity is created.
 * orientationLimitResetClicked gets called when r.id.orientationLimitReset sends a click event.
 */
public class LimitOrientation  extends OrientationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.limit_activity_orientation);
    }

    private  float []startOrientationRoll = null;
    private float [] startOrientationPitch = null;

    public void orientationLimitResetClicked(View view) {
        startOrientationRoll = null;
        startOrientationPitch = null;
    }



}