package spring17.se300.offroadcompanion;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by James Trafny on 2/28/2017.
 *
 * This Class file generates a 3.5 second splash screen for use in advertising our logo and company.
 * onCreate comes from android.os.Bundle and is called when the activity is created.
 *
 */
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Remove Notification Bar from top of screen.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        // Fade in logo
        ImageView splashScreenImage = (ImageView)findViewById(R.id.splashScreenImage);
        ObjectAnimator.ofFloat(splashScreenImage, splashScreenImage.ALPHA, 0.2f, 1.0f).setDuration(3000).start();

        // Switch to Main Activity
        Thread myThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3500);
                    Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}
