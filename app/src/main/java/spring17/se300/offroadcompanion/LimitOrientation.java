package spring17.se300.offroadcompanion;
import android.os.Bundle;
import android.view.View;

public class LimitOrientation  extends OrientationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.limit_activity_orientation);
    }

    private  float []startOrientationRoll = null;
    private float [] startOrientationPitch =null;

    public void orientationLimitResetClicked(View view) {
        startOrientationRoll = null;
        startOrientationPitch =null;
    }



}