package com.kennedy.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.munala.twoactivities.R;


public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.kennedy.twoactivities.extra.MESSAGE";
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyHeadTextView = findViewById(R.id.text_message_reply);
    }
        public void onActivityResult(int requestCode,int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == TEXT_REQUEST){
                if (resultCode == RESULT_OK) {
                    String reply = data.getStringExtra(com.kennedy.twoactivities.SecondActivity.EXTRA_REPLY);
                    mReplyHeadTextView.setVisibility(View.VISIBLE);
                    mReplyHeadTextView.setText(reply);
                    mReplyHeadTextView.setVisibility(View.VISIBLE);
                }
            }
        }


    public void LaunchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked");
        Intent intent = new Intent(this, com.kennedy.twoactivities.SecondActivity.class);
        startActivity(intent);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);

    }
}