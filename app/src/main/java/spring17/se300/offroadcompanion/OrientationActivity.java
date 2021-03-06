package spring17.se300.offroadcompanion;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import static java.lang.Math.*;


/**
 * Created by James Trafny on 2/28/2017.
 *
 * onCreate comes from android.os.Bundle and is called when the activity is created.
 * The OrientationActivity class handles both calculating and displaying the current roll
 *      and pitch of the device.
 * onCreate, onResume, onPause comes from android.os.Bundle and is called when the
 *      activity is created, paused, or resumed.
 * getOrientation returns orientation.
 * getStartOrientation returns the start orientation.
 * zeroButtonClicked gets called when r.id.zeroButton sends a click event.
 * limitOrientationClicked gets called when r.id.limitOrientation sends a click event.
 * onAccuracyChanged gets called when SensorEventListener detects a change in accuracy.
 * onSensorChanged gets called when SensorEventLister sends a sensor event.
 */
public class OrientationActivity extends Activity implements SensorEventListener {

    double limitedRoll = 720;
    double limitedPitch = 720;
    double warningRoll = 360;
    double warningPitch= 360;
    double roll;
    double pitch;

    private long startTime;

    TextView orientationReadoutRoll;
    TextView orientationReadoutPitch;
    ImageView rollImg;
    ImageView pitchImg;

    private SensorManager manager;
    private Sensor accelerometer;
    private Sensor magnometer;
    private float[] accelOutput;
    private float[] magOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startTime = System.currentTimeMillis();

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_orientation);

        orientationReadoutRoll = (TextView)findViewById(R.id.orientationReadoutRoll);
        orientationReadoutPitch = (TextView)findViewById(R.id.orientationReadoutPitch);
        rollImg = (ImageView)findViewById(R.id.imageViewCircle1);
        pitchImg = (ImageView)findViewById(R.id.imageViewCircle2);

        manager = (SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnometer = manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);


    }

    protected void onResume() {
        startTime = System.currentTimeMillis();
        super.onResume();
        manager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        manager.registerListener(this, magnometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        manager.unregisterListener(this);
    }

    private float[] orientation = new float[3];

    public float[] getOrientation() { return orientation; }

    private float[] startOrientation = null;

    public float[] getStartOrientation() {
        return startOrientation;
    }

    public void zeroButtonClicked(View view) {
        startOrientation = null;
    }

    public void limitOrientationClicked(View view) {
        Intent intent = new Intent(OrientationActivity.this, LimitOrientation.class);
        startActivity(intent);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            accelOutput = event.values;
        else if(event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
            magOutput = event.values;
        if(accelOutput != null && magOutput != null) {
            float[] R = new float[9];
            float[] I = new float[9];
            boolean success = SensorManager.getRotationMatrix(R, I, accelOutput, magOutput);
            if(success) {
                SensorManager.getOrientation(R, orientation);
                if(startOrientation == null) {
                    startOrientation = new float[orientation.length];
                    System.arraycopy(orientation, 0, startOrientation, 0, orientation.length);
                }

                roll = getOrientation()[1] - getStartOrientation()[1];
                pitch = getOrientation()[2] - getStartOrientation()[2];

                // Radians to degrees
                roll = (roll * 180)/Math.PI;
                pitch = (pitch * 180)/Math.PI;

                while ( abs(roll)+ abs(warningRoll) >= abs (limitedRoll) || abs(pitch) + abs(warningPitch)  >= abs(limitedPitch)){
                    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), notification);
                    mp.start();
                    mp.setLooping(true);
                }

                long now = System.currentTimeMillis();
                if(now >= startTime + 5000) {
                    orientationReadoutRoll.setText("Roll: " + (int) roll);
                    orientationReadoutPitch.setText("Pitch: " + (int) pitch * (-1));
                }

                rollImg.setRotation((float)roll*(-1));
                pitchImg.setRotation((float)pitch);

            }
        }
    }
}