package com.example.android.testse;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input;

    public static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public boolean isOnlyLetters(String str) {
        return str.matches("[a-zA-Z]+");
    }

    //Retrieves entered value
    public String stringtocheck() {
        return input.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input);
    }

    //Displays toast messageeeeeeeee
    private void displayToast(String toastText) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, toastText, duration);
        toast.show();
    }

    //Displays the result as a toast with appropriate message
    public void displayResults(View view) {
        if (stringtocheck().isEmpty()) {
            displayToast(getString(R.string.emptyString));
        } else if (!isOnlyLetters(stringtocheck())) {
            displayToast(getString(R.string.isStringError));
        } else if (stringtocheck().length() < 5) {
            displayToast(getString(R.string.lengthError));
        } else if (isPalindrome(stringtocheck())) {
            displayToast(getString(R.string.isPalindromTrue));
        } else {
            displayToast(getString(R.string.isPalindromFalse));
        }
    }
}
