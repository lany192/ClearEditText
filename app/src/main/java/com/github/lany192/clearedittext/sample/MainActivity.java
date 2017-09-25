package com.github.lany192.clearedittext.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.lany192.edittext.ClearEditText;

public class MainActivity extends AppCompatActivity {
    private ClearEditText mClearEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mClearEditText = (ClearEditText) findViewById(R.id.edittext);
        // mClearEditText.setClearDrawable(R.drawable.delete_gray);

        mClearEditText.setText("hello");
    }
}
