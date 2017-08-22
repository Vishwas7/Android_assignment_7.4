package com.vishwas.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // declaring variables
    private static EditText userName;
    private static EditText password;
    private static Button loginBtn;
    /**creating an attempts counter, maximum attempts will be 5
     * if user will enter 5 time wrong user name or password login button will be disable...
     * */
    private static TextView attempts;
    int attempts_counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // calling LoginButton()
        LoginButton();
    }

    /**
     * creating button click event LoginButton
     */
    private void LoginButton() {
        // in here casting all the variables
        userName = (EditText) findViewById(R.id.editText3);
        password = (EditText) findViewById(R.id.editText4);
        attempts = (TextView) findViewById(R.id.textView9);
        loginBtn = (Button) findViewById(R.id.button);

        attempts.setText(Integer.toString(attempts_counter));
        /**
         * in here in login button setting onClickListener
         * and
         */
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * getting text from userName and password field and converting into String than check
                 * with pre-define name and password is equals?
                 * in here giving a condition for login... to login in this page i've set
                 * user name must be vishwas and password must be bike..
                 * if both are correct then i've passed an intent to visit one activity two another activity..
                 * */
                if (userName.getText().toString().equals("vishwas") &&
                        password.getText().toString().equals("bike")) {
                    /**
                     * creating intent and in intent constructor passing MainActivity(go from mainActivity)
                     * and User.class(to visit this class)
                     */

                    Intent intent = new Intent(MainActivity.this, User.class);
                    /**
                     * passing data one activity to another activity by using putExtra method..
                     * so in intent using putExtra method and in the constructor User name..
                     * and fetch the user name...so whatever user name will be enter it will be pass in next activity.
                     */
                    intent.putExtra("UserName",userName.getText().toString());
                    startActivity(intent);
                    /**
                     * if user name or password are not correct then show
                     * pop-Up toast ("User and password is not correct") and then
                     * reducing attempts_counter -1 and if attempts_counter=0 then loginBtn will be disable;
                     */
                } else {
                    Toast.makeText(MainActivity.this, "User and password is not correct",
                            Toast.LENGTH_SHORT).show();
                    attempts_counter--;
                    attempts.setText(Integer.toString(attempts_counter));
                    if (attempts_counter == 0) {
                        Toast.makeText(MainActivity.this, "you've lost your maximum attempts,please try some time later",
                                Toast.LENGTH_LONG).show();
                        loginBtn.setEnabled(false);
                    }

                }

            }
        });
    }
}
