package yasirisortiz.com.tipshare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Button;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class MainActivity3 extends AppCompatActivity {

    LinearLayout aboutLayout;
    ExpandableRelativeLayout about;
    LinearLayout learningLayout;
    ExpandableRelativeLayout learning;
    LinearLayout policyLayout;
    ExpandableRelativeLayout policy;
    ImageButton backButton;
    Button buttonAbout, buttonLearning, buttonPrivacy;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        aboutLayout = findViewById(R.id.aboutLayout);
        about = (ExpandableRelativeLayout) findViewById(R.id.about);
        learningLayout = findViewById(R.id.learningLayout);
        learning = (ExpandableRelativeLayout) findViewById(R.id.learning);
        policyLayout = findViewById(R.id.policyLayout);
        policy = (ExpandableRelativeLayout) findViewById(R.id.policy);

        //Buttons: View Details
        buttonAbout = (findViewById(R.id.buttonAbout));
        buttonLearning = (findViewById(R.id.buttonLearning));
        buttonPrivacy = (findViewById(R.id.buttonPrivacy));

        about.collapse();
        learning.collapse();
        policy.collapse();

        aboutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAbout();
            }
        });

        learningLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLearning();
            }
        });

        policyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPolicy();
            }
        });

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void showAbout()
    {
        about.collapse();
        learning.toggle();
        policy.collapse();
    }

    public void showLearning()
    {
        learning.collapse();
        about.toggle();
        policy.collapse();
    }

    public void showPolicy()
    {
        about.collapse();
        learning.collapse();
        policy.toggle();
    }

    public void showInformationAbout(View view) {
        about = (ExpandableRelativeLayout) findViewById(R.id.about);
        about.toggle();
    }
    public void showInformationLearning(View view) {
        learning = (ExpandableRelativeLayout) findViewById(R.id.learning);
        learning.toggle();
    }
    public void showInformationPrivacy(View view) {
        policy = (ExpandableRelativeLayout) findViewById(R.id.policy);
        policy.toggle();
    }

}