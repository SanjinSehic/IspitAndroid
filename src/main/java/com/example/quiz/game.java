package com.example.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class game extends AppCompatActivity {

    private TextView question;
    private TextView textView;
    private TextView current;
    private Button true_button;
    private Button false_button;
    private int current_question;
    private int correct_questions;
    private Button back_to_menu;

    /*private Question[] questions = {
           // new Question("There are 11 players on each team in football match.",true),
            new Question("The interior angles of a triangle always add up to 180 degrees.", true),
           // new Question("NBA game lasts 4 quarters of 12 minutes.",true),
            new Question("Denmark and Japan have same colors on their flags.",true),
           // new Question("Olympic swimming pool is 100 meters long.",false),
           // new Question("Robert De Niro plays role of Michael Coreleone in Godfather.",false),
           // new Question("Titanic got 11 Oscars.",true),
            new Question("Louvre is the largest art museum in the world.",true),
           // new Question("Leonardo DiCaprio got his Oscar for lead role in the movie Inception.",false),
            new Question("Neil Armstrong was the first man in space.",false),
            new Question("Freddie Mercury was lead singer of the rock band Queen.",true),
            new Question("John Lennon was lead singer of the rock band Metallica.",false),
            new Question("Germany shares borders with Belgium.",true),
            new Question("Penguins are birds", false),
            new Question("There are 50 states in the USA.",true),
            new Question("Mount Everest is 9000 meters tall.",false),
            new Question("Marie Curie was the first woman to win a Nobel Prize.",true),
            new Question("WWII started 1939.",true),
            new Question("Bill Gates is the founder of Google.",false),
            new Question("Two atomic bombs were dropped over Japan in the winter of 1945.",false)
    }; */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        current_question = 0;
        correct_questions = 0;
        current = (TextView) findViewById(R.id.current);

        if(savedInstanceState != null) {
            current_question = savedInstanceState.getInt("currentQuestion");
            correct_questions = savedInstanceState.getInt("correctQuestions");
            current.setText("Question " + (current_question + 1) + "/" + questions.length);

        }




        textView = (TextView) findViewById(R.id.textView5);

        Intent intent = getIntent();
        String user = intent.getStringExtra(MainActivity.KEY);

        textView.setText("Username: " + user);




        back_to_menu = (Button) findViewById(R.id.button4);
        back_to_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        true_button = (Button) findViewById(R.id.button2);
        false_button = (Button) findViewById(R.id.button3);

        question = (TextView) findViewById(R.id.textView);
        question.setText(questions[current_question].getQuestion());
        current.setText("Question " + (current_question + 1) + "/" + questions.length);

        true_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = current_question;
                boolean check = questions[current_question].isAnswer();

                if(check == true) {
                    correct_questions++;
                    Toast.makeText(game.this, "correct answer", Toast.LENGTH_SHORT).show();

                    current_question = (current_question + 1) % questions.length;
                    question.setText(questions[current_question].getQuestion());
                }
                else{
                    Toast.makeText(game.this,"incorrect answer",Toast.LENGTH_SHORT).show();

                    current_question = (current_question + 1) % questions.length;
                    question.setText(questions[current_question].getQuestion());
                }

                if(temp + 1 == questions.length) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(game.this);
                    builder.setMessage("You answer" + correct_questions + "/" + questions.length + " questions")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();

                                }
                            })
                            .setTitle("Game finished").show();
                }
                current.setText("Question " + (current_question + 1) + "/" + questions.length);
            }
        });

        false_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = current_question;
                boolean check = questions[current_question].isAnswer();
                if(check == false) {
                    correct_questions++;
                    Toast.makeText(game.this, "correct answer", Toast.LENGTH_SHORT).show();
                    current_question = (current_question + 1) % questions.length;
                    question.setText(questions[current_question].getQuestion());
                }
                else{
                    Toast.makeText(game.this,"incorrect answer",Toast.LENGTH_SHORT).show();

                    current_question = (current_question + 1) % questions.length;
                    question.setText(questions[current_question].getQuestion());
                }

                if(temp + 1 == questions.length) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(game.this);
                    builder.setMessage("You answer" + correct_questions + "/" + questions.length + " questions")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            })
                            .setTitle("Game finished").show();
                }
                current.setText("Question " + (current_question + 1) + "/" + questions.length);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("currentQuestion", current_question);
        savedInstanceState.putInt("correctQuestions", correct_questions);

    }
}
