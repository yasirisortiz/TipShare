package yasirisortiz.com.tipshare;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private EditText billAmount;
    private TextView totalTipAmount;
    private TextView totalAmount;
    private TextView totalTipPerPerson;
    private final DecimalFormat df = new DecimalFormat("0.00");



    Button tv_minus;
    Button tv_plus;
    Button tip_10;
    Button tip_15;
    Button tip_20;
    int counter = 1; //Counter for the # of people starting at 1
    TextView showValue;
    ImageButton settingsButton;
    ImageButton backButton;




    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        billAmount = (EditText) findViewById(R.id.billAmount);
        tv_minus = (Button) findViewById(R.id.tv_minus);
        tv_plus = (Button) findViewById(R.id.tv_plus);
        totalTipAmount = (TextView) findViewById(R.id.totalTipAmount);
        totalAmount = (TextView) findViewById(R.id.totalAmount);
        totalTipPerPerson = (TextView) findViewById(R.id.totalTipPerPerson);
        tip_10 = findViewById(R.id.tip_10);
        tip_15 = findViewById(R.id.tip_15);
        tip_20 = findViewById(R.id.tip_20);
        showValue = (TextView) findViewById(R.id.totalPeople);
        settingsButton = findViewById(R.id.settingsButton);
        backButton= findViewById(R.id.backButton);
        buttonTipColor();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
//        return super.onCreateOptionsMenu(menu);
    }

    public void mainActivity3(View v) {
        Intent i = new Intent(this, MainActivity3.class);
        startActivity(i);
    }


    public void countDownPeople(View view) {
        if (counter > 1) {
            counter--;
            showValue.setText(Integer.toString(counter));
        }
        tv_minus.setBackgroundColor(Color.parseColor("#D4F47B"));

        (new Handler()).postDelayed(this::buttonPlusMinusColor,150);
        // get the value from the split function and divide that by the total
        tipsyPerson = totalValue / counter;
        totalTipPerPerson.setText(df.format(tipsyPerson));

    }

    private void buttonPlusMinusColor()
    {
        tv_minus.setBackgroundColor(Color.parseColor("#C5BDF6"));
        tv_plus.setBackgroundColor(Color.parseColor("#C5BDF6"));
    }

    private void buttonTipColor()
    {
        tip_10.setBackgroundColor(Color.parseColor("#EBEBEB"));
        tip_15.setBackgroundColor(Color.parseColor("#EBEBEB"));
        tip_20.setBackgroundColor(Color.parseColor("#EBEBEB"));
    }

    public void countUpPeople(View view) {

        if (counter < 6)
        {
            counter++;
            showValue.setText(Integer.toString(counter));
        }

        try
        {
            tv_plus.setBackgroundColor(Color.parseColor("#D4F47B"));
        } catch (Exception e)
        {

        }

        (new Handler()).postDelayed(this::buttonPlusMinusColor,150);
        tipsyPerson = totalValue / counter;
        totalTipPerPerson.setText(df.format(tipsyPerson));

    }

    double totalValue;
    double tipsyPerson;
    public void tipBtnClicked(View v) {

        try {

            double tipPercent = Double.parseDouble(v.getTag().toString());
            String dollarSign = "$";

            if(tipPercent == 0.10)
            {
                tip_10.setBackgroundColor(Color.parseColor("#D4F47B"));
            } else if(tipPercent == 0.15)
            {
                tip_15.setBackgroundColor(Color.parseColor("#D4F47B"));
            } else if(tipPercent == 0.20)
            {
                tip_20.setBackgroundColor(Color.parseColor("#D4F47B"));
            }
            (new Handler()).postDelayed(this::buttonTipColor,150);

            double billValue = Double.parseDouble(billAmount.getText().toString());
            billAmount.setText(df.format(billValue));

            // calculate & reformat the tip & the total
            double tipValue = billValue * tipPercent;
            totalTipAmount.setText(df.format(tipValue));

            totalValue = billValue + tipValue;
            totalAmount.setText(df.format(totalValue));

            // get the value from the split function and divide that by the total
            tipsyPerson = totalValue / counter;
            totalTipPerPerson.setText(df.format(tipsyPerson));

        }
        catch (Exception e)
        {
            // Something went wrong
        }

    }

    // Snippet to hide the keyBoard by clicking outside
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(MainActivity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}