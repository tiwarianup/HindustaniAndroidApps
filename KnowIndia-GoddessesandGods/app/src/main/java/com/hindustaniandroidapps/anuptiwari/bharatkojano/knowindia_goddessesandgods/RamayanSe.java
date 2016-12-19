package com.hindustaniandroidapps.anuptiwari.bharatkojano.knowindia_goddessesandgods;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static com.hindustaniandroidapps.anuptiwari.bharatkojano.knowindia_goddessesandgods.R.id.answer1;
import static com.hindustaniandroidapps.anuptiwari.bharatkojano.knowindia_goddessesandgods.R.id.answer2;
import static com.hindustaniandroidapps.anuptiwari.bharatkojano.knowindia_goddessesandgods.R.id.answer3;
import static com.hindustaniandroidapps.anuptiwari.bharatkojano.knowindia_goddessesandgods.R.id.answer4;

/**
 * Created by anuptiwari on 11/30/2016.
 */

public class RamayanSe extends AppCompatActivity {
    private int mFinPos;
    private ArrayList<QuestionAnswers> mQuestionAnswerses;
    private int mRetPos;
    private String mAnswer;
    private LinearLayout mLinearLayout;
    private AdView mAdView;
    private GestureDetector gesturedetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        String devta_ques_ans = getResources().getString(R.string.ramayan_ques_ans_string);
        String[] pairsText = devta_ques_ans.split("_");
        final ArrayList<QuestionAnswers> questionAnswerses = new ArrayList<QuestionAnswers>();
        for (int i = 0; i < pairsText.length; i++) {
            String ques_ans = pairsText[i];
            String[] split = ques_ans.split("[+]");
            String shortText = ques_ans.substring(0, 10) + " ...";
            String question = split[0];
            String[] questionSplit = question.split("[:]");
            String quizQues = questionSplit[1];
            String answer = split[1];
            String[] answerSplit = answer.split("[:]");
            String quizAnswer = answerSplit[1];
            Log.v("MainActivity", "Short Text: " + shortText);
            Log.v("MainActivity", "Question Text: " + question);
            Log.v("MainActivity", "Answer Text: " + answer);
            questionAnswerses.add(new QuestionAnswers(shortText, quizQues, quizAnswer));
        }
        this.mQuestionAnswerses = questionAnswerses;
        this.mRetPos = this.generatePage(questionAnswerses);
        final TextView answerStatus = (TextView) findViewById(R.id.answserStatusText);
        final TextView answerTextView1 = (TextView) findViewById(answer1);
        final TextView answerTextView2 = (TextView) findViewById(answer2);
        final TextView answerTextView3 = (TextView) findViewById(answer3);
        final TextView answerTextView4 = (TextView) findViewById(answer4);

        this.mLinearLayout = (LinearLayout) findViewById(R.id.for_screenshot);

        mLinearLayout.setOnTouchListener(new OnTouchSwipeTistener(RamayanSe.this){

            public void onSwipeRight() {
                mRetPos = generatePage(questionAnswerses);
                answerStatus.setText("");
                answerStatus.setBackgroundColor(getResources().getColor(R.color.backColor));
                final Toast toast = Toast.makeText(RamayanSe.this, "New MCQ", Toast.LENGTH_SHORT);
                toast.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 1000);
            }
            public void onSwipeLeft() {
                mRetPos = generatePage(questionAnswerses);
                answerStatus.setText("");
                answerStatus.setBackgroundColor(getResources().getColor(R.color.backColor));
                final Toast toast = Toast.makeText(RamayanSe.this, "New MCQ", Toast.LENGTH_SHORT);
                toast.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 1000);
            }
        });

        this.mAnswer = "";

        answerTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionAnswers questionAnswers = mQuestionAnswerses.get(mRetPos);
                mAnswer = questionAnswers.getAnswerText();
                TextView answer1 = (TextView) findViewById(R.id.answer1);
                TextView answer2 = (TextView) findViewById(R.id.answer2);
                TextView answer3 = (TextView) findViewById(R.id.answer3);
                TextView answer4 = (TextView) findViewById(R.id.answer4);
                Log.v("RamayanSe:Click1", mAnswer);
                if (answerTextView1.getText() == mAnswer) {
                    answerStatus.setText("Correct answer! Move forward to the next MCQ!");
                    answerStatus.setBackgroundColor(getResources().getColor(R.color.successColor));
                    answer1.setBackgroundColor(getResources().getColor(R.color.successColor));
                    answer2.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer3.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer4.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                } else {
                    answerStatus.setText("Sorry! Wrong Answer! Try again!");
                    answerStatus.setBackgroundColor(getResources().getColor(R.color.errorColor));
                    answer1.setBackgroundColor(getResources().getColor(R.color.errorColor));
                    answer2.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer3.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer4.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                }
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRetPos = generatePage(questionAnswerses);
                        answerStatus.setBackgroundColor(getResources().getColor(R.color.backColor));
                    }
                }, 800);
            }
        });

        answerTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionAnswers questionAnswers = mQuestionAnswerses.get(mRetPos);
                mAnswer = questionAnswers.getAnswerText();
                TextView answer1 = (TextView) findViewById(R.id.answer1);
                TextView answer2 = (TextView) findViewById(R.id.answer2);
                TextView answer3 = (TextView) findViewById(R.id.answer3);
                TextView answer4 = (TextView) findViewById(R.id.answer4);
                Log.v("RamayanSe:Click2", mAnswer);
                if (answerTextView2.getText() == mAnswer) {
                    answerStatus.setText("Correct answer! Move forward to the next MCQ!");
                    answerStatus.setBackgroundColor(getResources().getColor(R.color.successColor));
                    answer1.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer2.setBackgroundColor(getResources().getColor(R.color.successColor));
                    answer3.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer4.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                } else {
                    answerStatus.setText("Sorry! Wrong Answer! Try again!");
                    answerStatus.setBackgroundColor(getResources().getColor(R.color.errorColor));
                    answer1.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer2.setBackgroundColor(getResources().getColor(R.color.errorColor));
                    answer3.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer4.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                }
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRetPos = generatePage(questionAnswerses);
                        answerStatus.setBackgroundColor(getResources().getColor(R.color.backColor));
                    }
                }, 800);
            }
        });

        answerTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionAnswers questionAnswers = mQuestionAnswerses.get(mRetPos);
                mAnswer = questionAnswers.getAnswerText();
                TextView answer1 = (TextView) findViewById(R.id.answer1);
                TextView answer2 = (TextView) findViewById(R.id.answer2);
                TextView answer3 = (TextView) findViewById(R.id.answer3);
                TextView answer4 = (TextView) findViewById(R.id.answer4);
                Log.v("RamayanSe:Click3", mAnswer);
                if (answerTextView3.getText() == mAnswer) {
                    answerStatus.setText("Correct answer! Move forward to the next MCQ!");
                    answerStatus.setBackgroundColor(getResources().getColor(R.color.successColor));
                    answer1.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer2.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer3.setBackgroundColor(getResources().getColor(R.color.successColor));
                    answer4.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                } else {
                    answerStatus.setText("Sorry! Wrong Answer! Try again!");
                    answerStatus.setBackgroundColor(getResources().getColor(R.color.errorColor));
                    answer1.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer2.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer3.setBackgroundColor(getResources().getColor(R.color.errorColor));
                    answer4.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                }
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRetPos = generatePage(questionAnswerses);
                        answerStatus.setBackgroundColor(getResources().getColor(R.color.backColor));
                    }
                }, 800);
            }
        });

        answerTextView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionAnswers questionAnswers = mQuestionAnswerses.get(mRetPos);
                mAnswer = questionAnswers.getAnswerText();
                TextView answer1 = (TextView) findViewById(R.id.answer1);
                TextView answer2 = (TextView) findViewById(R.id.answer2);
                TextView answer3 = (TextView) findViewById(R.id.answer3);
                TextView answer4 = (TextView) findViewById(R.id.answer4);
                Log.v("RamayanSe:Click4", mAnswer);
                if (answerTextView4.getText() == mAnswer) {
                    answerStatus.setText("Correct answer! Move forward to the next MCQ!");
                    answerStatus.setBackgroundColor(getResources().getColor(R.color.successColor));
                    answer1.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer2.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer3.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer4.setBackgroundColor(getResources().getColor(R.color.successColor));
                } else {
                    answerStatus.setText("Sorry! Wrong Answer! Try again!");
                    answerStatus.setBackgroundColor(getResources().getColor(R.color.errorColor));
                    answer1.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer2.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer3.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
                    answer4.setBackgroundColor(getResources().getColor(R.color.errorColor));
                }
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRetPos = generatePage(questionAnswerses);
                        answerStatus.setBackgroundColor(getResources().getColor(R.color.backColor));
                    }
                }, 800);
            }
        });

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    public void shuffule(View view) {
        this.mRetPos = this.generatePage(mQuestionAnswerses);
        TextView answerStatus = (TextView) findViewById(R.id.answserStatusText);
        answerStatus.setText("");
        answerStatus.setBackgroundColor(getResources().getColor(R.color.backColor));
    }

    public void share(View view){
        Bitmap bitmap = takeScreenshot();
        saveBitmap(bitmap);
    }

    public int generatePage(ArrayList<QuestionAnswers> questionAnswerses) {
        this.mQuestionAnswerses = questionAnswerses;
        long seed = System.nanoTime();
        Collections.shuffle(mQuestionAnswerses, new Random(seed));
        Random rand = new Random();
        ArrayList<Integer> generated = new ArrayList<Integer>();
        while (generated.size() < 4) {
            int next = rand.nextInt(mQuestionAnswerses.size());
            generated.add(next);
        }

        TextView questionTextView = (TextView) findViewById(R.id.question_textView);
        questionTextView.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
        //questionTextView.setText("Random Number Selected: " + randomNo);

        QuestionAnswers questionAnswers = mQuestionAnswerses.get(generated.get(0));
        String question = questionAnswers.getQuestionText();
        String answer = questionAnswers.getAnswerText();

        QuestionAnswers questionAnswers1 = mQuestionAnswerses.get(generated.get(1));
        String answer1 = questionAnswers1.getAnswerText();

        QuestionAnswers questionAnswers2 = mQuestionAnswerses.get(generated.get(2));
        String answer2 = questionAnswers2.getAnswerText();

        QuestionAnswers questionAnswers3 = mQuestionAnswerses.get(generated.get(3));
        String answer3 = questionAnswers3.getAnswerText();

        ArrayList<String> answerStrings = new ArrayList<String>();
        answerStrings.add(answer);
        answerStrings.add(answer1);
        answerStrings.add(answer2);
        answerStrings.add(answer3);

        long seed1 = System.nanoTime();
        Collections.shuffle(answerStrings, new Random(seed1));
        questionTextView.setText(question);
        Log.v("RamayanSe", "" + answerStrings);

        TextView answerTextView1 = (TextView) findViewById(R.id.answer1);
        answerTextView1.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
        answerTextView1.setText(answerStrings.get(0));


        TextView answerTextView2 = (TextView) findViewById(R.id.answer2);
        answerTextView2.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
        answerTextView2.setText(answerStrings.get(1));

        TextView answerTextView3 = (TextView) findViewById(R.id.answer3);
        answerTextView3.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
        answerTextView3.setText(answerStrings.get(2));

        TextView answerTextView4 = (TextView) findViewById(R.id.answer4);
        answerTextView4.setBackgroundColor(getResources().getColor(R.color.ramayanaTheme));
        answerTextView4.setText(answerStrings.get(3));

        return generated.get(0);
    }

    public Bitmap takeScreenshot() {
        View rootView = findViewById(android.R.id.content).getRootView();
        rootView.setDrawingCacheEnabled(true);
        return rootView.getDrawingCache();
    }

    public void saveBitmap(Bitmap bitmap) {
        File imagePath = new File(Environment.getExternalStorageDirectory() + "/screenshot.png");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }
}
