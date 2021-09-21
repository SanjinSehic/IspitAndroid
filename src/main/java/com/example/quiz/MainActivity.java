package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button playGame;
    private EditText edit;
    private String username;

    public static final String KEY = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playGame = (Button) findViewById(R.id.play_game);
        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit = (EditText) findViewById(R.id.editText);
                username = edit.getText().toString();

                if(username.trim().length() == 0) {
                    Toast.makeText(MainActivity.this, "Username required!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), game.class);
                    intent.putExtra(KEY, username);

                    startActivity(intent);
                }
            }
        });
    }
}
