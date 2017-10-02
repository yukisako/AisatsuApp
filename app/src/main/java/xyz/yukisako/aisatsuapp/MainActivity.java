package xyz.yukisako.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.mytext);
        Button button = (Button) findViewById(R.id.pickbtn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.pickbtn){
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay >= 2 && hourOfDay < 10) {
                            mTextView.setText("おはよう");
                        } else if (hourOfDay >= 10 && hourOfDay < 18){
                            mTextView.setText("こんにちは");
                        } else {
                            mTextView.setText("こんばんは");
                        }

                    }
                }
                ,13,0,true
        );
        timePickerDialog.show();
    }
}
