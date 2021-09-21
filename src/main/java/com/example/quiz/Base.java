package com.example.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Base extends SQLiteOpenHelper {

    private static final String dbName = "baza.db";

    private static final String query = "Create table Question(id integer primary key autoincrement, category varchar , question varchar, answer boolean)";

    public Base(Context context)
    {
        super(context, dbName, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
        addQuestions();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void add(String category, String question, Boolean answer)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues newQuestion = new ContentValues();
        newQuestion.put("category", category);
        newQuestion.put("question", question);
        newQuestion.put("answer", answer);

        long result = db.insert("Predmet",null,newQuestion);


    }

    public  void addQuestions()
    {
        add("movie", "Titanic got 11 Oscars.", true);
        add("movie", "Robert De Niro plays role of Michael Coreleone in Godfather.", false);
        add("movie", "Leonardo DiCaprio got his Oscar for lead role in the movie Inception.", false);
        add("movie", "Joe Pesci has an Oscar.", true);
        add("movie", "Christoph Waltz plays Hans Landa in Inglorius bastards.", true);
        add("movie", "Tom Hardy plays Batman.", false );
        add("movie", "Marlon Brando plays Vito Corleone in Godfather.", true);
        add("movie", "Quentin Tarantino directed movie Pulp Fiction.", true);
        add("movie", "Christopher Nolan directed movie Titanic.", false);
        add("movie", "Adrien Brody plays lead actor in movie Pianist", true);

        add("sport", "There are 11 players on each team in football match.", true);
        add("sport", "NBA game lasts 4 quarters of 12 minutes.", true);
        add("sport", "Olympic swimming pool is 100 meters long.", false);
        add("sport", "Italy won World cup in 2018", false);
        add("sport", "Roger Federer has won most grand slams in the history", true);
        add("sport", "Barcelona has won most champions league trophies ever", false);
        add("sport", "Mixed martial arts(MMA) are Olympic sport", false);
        add("sport", "France won World cup in 2018", true);
        add("sport", "Nadal has won more than 10 grand slams", true);
        add("sport", "Yugoslavia was world champion in basketball", true);

        add("other", "Louvre is the largest art museum in the world.", true);
        add("other", "Denmark and Japan have same colors on their flags.", true);
        add("other", "Neil Armstrong was the first man in space.", false);
        add("other", "Freddie Mercury was lead singer of the rock band Queen.",true);
        add("other", "John Lennon was lead singer of the rock band Metallica.", false);
        add("other", "Penguins are birds.", true);
        add("other", "There are 50 states in the USA.", true);
        add("other", "Marie Curie was the first woman to win a Nobel Prize.", true);
        add("other", "Bill Gates is the founder of Google.", false);
        add("other", "Two atomic bombs were dropped over Japan in the winter of 1945.", false);



    }

    public Cursor categories() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor categories = db.rawQuery("select  * from Question", null);
        return categories;
    }

    public Cursor questionsByCategories(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor questions = db.rawQuery("select * from Question where category = ?", new String[]{name});
        return questions;
    }





}
