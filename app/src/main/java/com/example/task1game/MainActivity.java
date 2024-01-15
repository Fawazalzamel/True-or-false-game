package com.example.task1game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView, correctAnswerDisplay, wrongAnswerDisplay;

    private Button trueButton, falseButton, nextQuestionButton;

    private static int currentQuestionIndex = 0;

    private ArrayList<String> questions = new ArrayList<>();
    private ArrayList<Boolean> answers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        questionsAndAnswers();
        displayQuestions();

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerChecker(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerChecker(false);
            }
        });

        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNextQuestion();
            }
        });
    }

    private void initializeViews() {
        questionTextView = findViewById(R.id.questionTextView);
        correctAnswerDisplay = findViewById(R.id.correctAnswerDisplay);
        wrongAnswerDisplay = findViewById(R.id.wrongAnswerDisplay);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        nextQuestionButton = findViewById(R.id.nextQuestionButton);
    }

    private void questionsAndAnswers() {
        questions.add("The sky is black");
        answers.add(Boolean.FALSE);

        questions.add("Football is a sport");
        answers.add(Boolean.TRUE);

        questions.add("Water boils at 100 degrees");
        answers.add(Boolean.TRUE);

        questions.add("The sea is blue");
        answers.add(Boolean.TRUE);
    }

    private void correctAnswerSettings() {
        correctAnswerDisplay.setVisibility(View.VISIBLE);
        nextQuestionButton.setVisibility(View.VISIBLE);
        trueButton.setVisibility(View.INVISIBLE);
        falseButton.setVisibility(View.INVISIBLE);
        wrongAnswerDisplay.setVisibility(View.INVISIBLE);
    }

    private void wrongAnswerSettings() {
        correctAnswerDisplay.setVisibility(View.INVISIBLE);
        nextQuestionButton.setVisibility(View.INVISIBLE);
        trueButton.setVisibility(View.VISIBLE);
        falseButton.setVisibility(View.VISIBLE);
        wrongAnswerDisplay.setVisibility(View.VISIBLE);
    }

    private void answerChecker(boolean answer) {
        boolean currentAnswer = answers.get(currentQuestionIndex);
        if (currentAnswer == answer) {
            correctAnswerSettings();
        } else {
            wrongAnswerSettings();
        }
    }

    private void displayQuestions() {
        String currentQuestion = questions.get(currentQuestionIndex);
        questionTextView.setText(currentQuestion);
    }

    private void displayNextQuestion() {
        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex++;
        } else {
            currentQuestionIndex = 0;
        }

        displayQuestions();
        correctAnswerDisplay.setVisibility(View.INVISIBLE);
        nextQuestionButton.setVisibility(View.INVISIBLE);
        trueButton.setVisibility(View.VISIBLE);
        falseButton.setVisibility(View.VISIBLE);
    }
}
